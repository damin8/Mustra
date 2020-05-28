package mustra.musicprediction.Module;

import mustra.musicprediction.Model.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;

@Component
public class DataMining {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private DataSource musicSource;
    private Instances musicInstances;
    private Instance newInst;
    private J48 j48;

    public DataMining(){
        try{
            this.musicSource = new DataSource("MusicPredict.arff");
            this.musicInstances = musicSource.getDataSet();
            this.musicInstances.setClassIndex(musicInstances.numAttributes() - 1);
            this.newInst = musicInstances.instance(2);
            logger.info("newInstance = " + newInst.toString());
            this.j48 = new J48();
            this.j48.buildClassifier(musicInstances);
        } catch (Exception e) {
            logger.info("arff파일 찾기 실패");
            e.printStackTrace();
        }
    }

    public String executeAlgorithm(Music music){

        String predString = null;

        String artistName = music.getArtistName();
        String songName = music.getSongName();

        String videoCheck = music.getVideo();
        double video = 0.0;
        if (videoCheck.equals("No")) { // arff파일에 no가 첫 번째
            video = 0.0;
        } else {
            video = 1.0;
        }

        SeleniumCrawler selTest = new SeleniumCrawler();
        ArrayList<String> resultArray = selTest.getSearchResult(artistName, songName);

        String artistFindCount = resultArray.get(0);
        String artistSongFindCount = resultArray.get(1);
        String artistSongNewsFindCount = resultArray.get(2);

        double asr = Double.parseDouble(artistFindCount);
        double assr = Double.parseDouble(artistSongFindCount);
        double asnsr = Double.parseDouble(artistSongNewsFindCount);

        String tempFanNum = music.getFanNum();

        if(tempFanNum.equals("?"))
            newInst.isMissing(3);
        else
            newInst.setValue(3,Double.parseDouble(tempFanNum));

        newInst.setValue(0,asr);
        newInst.setValue(1,assr);
        newInst.setValue(2,asnsr);
        newInst.setValue(4,video);


        logger.info("newInstance = " + newInst.toString());


        try{
            double predNB = 0;

            predNB = j48.classifyInstance(newInst);

            logger.info("predNB = " + predNB);
            predString = musicInstances.classAttribute().value((int) predNB);
            logger.info("predString = " + predString);

        } catch (Exception e) {
            logger.info("데이터 받아오기 실패");
            e.printStackTrace();
        }
        return predString;
    }
}
