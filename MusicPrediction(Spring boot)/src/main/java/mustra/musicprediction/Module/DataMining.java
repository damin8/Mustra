package mustra.musicprediction.Module;

import mustra.musicprediction.Model.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.rules.OneR;
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
    private OneR oneR;
    private NaiveBayes naiveBayes;

    public DataMining(){
        try{
            this.musicSource = new DataSource("MusicPredict.arff");
            this.musicInstances = musicSource.getDataSet();
            this.musicInstances.setClassIndex(musicInstances.numAttributes() - 1);
            this.newInst = musicInstances.instance(2);
            logger.info("newInstance = " + newInst.toString());
            this.j48 = new J48();
            this.j48.buildClassifier(musicInstances);
            this.oneR = new OneR();
            this.oneR.buildClassifier(musicInstances);
            this.naiveBayes = new NaiveBayes();
            this.naiveBayes.buildClassifier(musicInstances);
        } catch (Exception e) {
            logger.info("arff파일 찾기 실패");
            e.printStackTrace();
        }
    }

    public String executeAlgorithm(Music music){
        String predString = null;
        try{
            double predNB = 0;
            String algorithm = music.getAlgorithm();

            if(algorithm.equals("j48"))
                predNB = j48.classifyInstance(newInst);

            else if(algorithm.equals("oneR"))
                predNB = oneR.classifyInstance(newInst);

            else
                predNB = naiveBayes.classifyInstance(newInst);

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
