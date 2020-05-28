package mustra.musicprediction.Module;

import mustra.musicprediction.Model.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

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

        //SeleniumCrawler selTest = new SeleniumCrawler();
        //ArrayList<String> resultArray = selTest.getSearchResult(artistName, songName);

        //String artistFindCount = resultArray.get(0);
        //String artistSongFindCount = resultArray.get(1);
        //String artistSongNewsFindCount = resultArray.get(2);

        //newInst.setValue(0,artistFindCount);
        //newInst.setValue(1,artistSongFindCount);
        //newInst.setValue(2,artistSongNewsFindCount);
        //newInst.setValue(3,music.getFanNum());
        //newInst.setValue(4,music.getVideo());

        //logger.info("newInstance = " + newInst.toString());

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
