package mustra.musicprediction.Controller;

import com.google.gson.Gson;
import mustra.musicprediction.Model.Feed;
import mustra.musicprediction.Model.Music;
import mustra.musicprediction.Module.DataMining;
import mustra.musicprediction.Module.Sequence;
import mustra.musicprediction.Repository.FeedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
@RequestMapping("/mustra/*")
@WebServlet(asyncSupported = true)
public class MustraController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedRepository feedRepository;
    @Autowired
    private Sequence sequence;
    @Autowired
    private DataMining dataMining;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
        Music music = new Music("가수 이름","노래 제목"
                ,"팬의 수","비디오");
        Feed feed = new Feed(1,"Rank","가수 이름","노래 이름","코멘트(익명)","시간",0);

        String str = "Music Model = " + music.toString();
        str+="\"\n\n\n\n\n\n\n\n\" Feed Model = " + feed.toString();
        return str;
    }

    @Async(value="findRankThread")
    @RequestMapping(value = "/find/rank", method = RequestMethod.POST)
    public CompletableFuture<String> findRank(@RequestBody Music music){
        String rank = dataMining.executeAlgorithm(music);
        String artistName = music.getArtistName();
        String songName = music.getSongName();
        Feed feed = new Feed(-1,rank,artistName,songName,null,null,0);
        Gson gson = new Gson();
        String json = gson.toJson(feed);
        logger.info("=====findRank=====");
        logger.info("Request = " + music.toString());
        logger.info("Response = " + json);
        return CompletableFuture.completedFuture(json);
    }

    @Async(value="createFeedThread")
    @RequestMapping(value = "/feed/create", method = RequestMethod.POST)
    public CompletableFuture<String> createFeed(@RequestBody Feed feed){
        int _id = sequence.makeSequence("feeds");
        feed.set_id(_id);
        Feed temp = feedRepository.insert(feed);
        Gson gson = new Gson();
        String json = gson.toJson(temp);
        logger.info("=====createFeed=====");
        logger.info("Request = " + feed.toString());
        logger.info("Response = " + json);
        return CompletableFuture.completedFuture(json);
    }

    @Async(value="findAllFeedThread")
    @RequestMapping(value = "/feed/findAll", method = RequestMethod.GET)
    public CompletableFuture<String> fildAllFeed(){
        List<Feed> feedList = feedRepository.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(feedList);
        logger.info("=====findAllFeed=====");
        logger.info("Response = " + json);
        return CompletableFuture.completedFuture(json);
    }

    @Async(value="likeFeedCountThread")
    @RequestMapping(value ="/feed/likeFeed", method = RequestMethod.POST)
    public CompletableFuture<String> likeFeedCount(@RequestBody Map<String,String> map){
        String _id = map.get("_id");
        String isLike = map.get("isLike");

        Feed temp = feedRepository.findFeedBy_id(_id);
        if(isLike.equals("like"))
            temp.setLikeCount(temp.getLikeCount() + 1);
        else
            temp.setLikeCount(temp.getLikeCount() - 1);
        feedRepository.save(temp);

        Gson gson = new Gson();
        String json = gson.toJson(temp);

        return CompletableFuture.completedFuture(json);
    }
}
