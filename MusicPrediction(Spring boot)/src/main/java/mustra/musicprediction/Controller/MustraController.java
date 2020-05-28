package mustra.musicprediction.Controller;

import com.google.gson.Gson;
import mustra.musicprediction.Model.Feed;
import mustra.musicprediction.Model.Music;
import mustra.musicprediction.Module.Sequence;
import mustra.musicprediction.Repository.FeedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mustra/*")
public class MustraController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedRepository feedRepository;
    @Autowired
    private Sequence sequence;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
        int _id = sequence.makeSequence("feeds");
        Music music = new Music("알고리즘","가수 검색 수"
                ,"가수+노래 검색 수","가수+노래 기사 검색 수",1,true);
        Feed feed = new Feed(_id,"Rank","가수 이름","노래 이름","코멘트(익명)");

        String str = "Music Model = " + music.toString();
        str+="\n\n\n Feed Model = " + feed.toString();
        return str;
    }

    @RequestMapping(value = "/find/rank")
    public String findRank(@RequestBody Music music){
        return "HI";
    }

    @RequestMapping(value = "/feed/create", method = RequestMethod.POST)
    public String createFeed(@RequestBody Feed feed){
        Feed temp = feedRepository.insert(feed);
        Gson gson = new Gson();
        String json = gson.toJson(temp);
        logger.info("=====createFeed=====");
        logger.info("Request = " + feed.toString());
        logger.info("Response = " + json);
        return json;
    }

    @RequestMapping(value = "/feed/findAll", method = RequestMethod.GET)
    public List<Feed> fildAllFeed(){
        List<Feed> feedList = feedRepository.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(feedList);
        logger.info("=====findAllFeed=====");
        logger.info("Response = " + json);
        return feedList;
    }
}
