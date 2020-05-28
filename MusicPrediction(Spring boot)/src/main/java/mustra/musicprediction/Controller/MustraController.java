package mustra.musicprediction.Controller;

import mustra.musicprediction.Model.Feed;
import mustra.musicprediction.Model.Music;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MustraController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
        Music music = new Music("알고리즘","가수 검색 수"
                ,"가수+노래 검색 수","가수+노래 기사 검색 수",1,true);
        Feed feed = new Feed("Rank","가수 이름","노래 이름","코멘트(익명)");

        String str = "Music Model = " + music.toString();
        str+="\n\n\n Feed Model = " + feed.toString();
        return str;
    }
}
