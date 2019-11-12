package Music;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import SocketServer.*;
import selenium.SeleniumCrawler;

public class MusicModel {
	private static MusicModel WM = new MusicModel();
	private String predString;

	private MusicModel() {
		try {
			// this.musicSource = new
			// DataSource("C:\\Users\\damin\\eclipse-workspace\\WekaTest\\bin\\music.arff");
			this.musicSource = new
			DataSource("C:\\Users\\damin\\eclipse-workspace\\MusicPrediction\\weka_source\\MusicPredict.arff");
			this.musicInstance = this.musicSource.getDataSet();
			//int num = musicInstance.numInstances() / 10;
			//Instances[] tenInstance = new Instances[num+1];
			//System.out.println("Num : " + num);
			this.musicInstance.setClassIndex(musicInstance.numAttributes() - 1);
			// 10개씩 묶는 작업
			/*int count = 0;
			for (int i = num; i < musicInstance.numInstances(); i+=num) {
				tenInstance[count] = 
						new weka.core.Instances(musicInstance,0,i-1);
				count++;
			}*/
			this.musicOneR = new OneR();
			this.musicNaiveBayes = new NaiveBayes();
			this.musicTree = new J48();
			/*double[] accuracy = new double[count];
			for (int i = 0; i < count; i++) {
				musicOneR.buildClassifier(tenInstance[i]);
				musicOneREval = new Evaluation(tenInstance[i]);
				musicOneREval.crossValidateModel(musicOneR, tenInstance[i], 10, new Random(1));
				accuracy[i] = musicOneREval.pctCorrect();
			}
			String str = "[";
			for (int i = 0; i < count; i++) {
				// System.out.println("OneR " + i+1 +" 번째 정확도 : " + accuracy[i]);
				if (i == (count - 1))
					str += (accuracy[i] + " ]");
				else
					str += (accuracy[i] + ", ");
			}
			System.out.println("OneR = " + str);*/
			this.musicOneR.buildClassifier(musicInstance);
			this.musicOneREval = new Evaluation(musicInstance);
			this.musicOneREval.crossValidateModel(musicOneR, musicInstance, 10, new Random(1));
			// System.out.println(musicOneREval.toSummaryString());
			// double accuracy = musicOneREval.pctCorrect(); 정확도 추출
			// System.out.println(accuracy);
			/*for (int i = 0; i < count; i++) {
				musicNaiveBayes.buildClassifier(tenInstance[i]);
				musicNaiveEval = new Evaluation(tenInstance[i]);
				musicNaiveEval.crossValidateModel(musicNaiveBayes, tenInstance[i], 10, new Random(1));
				accuracy[i] = musicNaiveEval.pctCorrect();
			}
			str = "[";
			for (int i = 0; i < count; i++) {
				// System.out.println("NaiveBayesian " + i+1 +" 번째 정확도 : " + accuracy[i]);
				if (i == (count - 1))
					str += (accuracy[i] + " ]");
				else
					str += (accuracy[i] + ", ");
			}
			System.out.println("NaiveBayesian = " + str);*/
			this.musicNaiveBayes.buildClassifier(musicInstance);
			// Evaluation on Training Set
			// Movie NaiveBayes Cross-Validation
			this.musicNaiveEval = new Evaluation(musicInstance);
			this.musicNaiveEval.crossValidateModel(musicNaiveBayes, musicInstance, 10, new Random(1));

			// Movie J48 Training
			/*for (int i = 0; i < count; i++) {
				musicTree.buildClassifier(tenInstance[i]);
				musicTreeEval = new Evaluation(tenInstance[i]);
				musicTreeEval.crossValidateModel(musicTree, tenInstance[i], 10, new Random(1));
				accuracy[i] = musicTreeEval.pctCorrect();
			}
			str = "[";
			for (int i = 0; i < count; i++) {
				//System.out.println("Tree " + i + 1 + " 번째 정확도 : " + accuracy[i]);
				if (i == (count - 1))
					str += (accuracy[i] + " ]");
				else
					str += (accuracy[i] + ", ");
			}
			System.out.println("Decision tree : " + str);*/
			this.musicTree.buildClassifier(musicInstance);
			// Evaluation on Training Set
			// Movie J48 Cross-Validation
			this.musicTreeEval = new Evaluation(musicInstance);
			this.musicTreeEval.crossValidateModel(musicTree, musicInstance, 10, new Random(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DataSource musicSource;

	public static MusicModel getMusicModel() {
		return WM;
	}

	public void Test(String algorithm,String artN, String songN, double fanNum, String videoChk) {
		Instances testDataset;
		try {
			testDataset = musicSource.getDataSet();
			testDataset.setClassIndex(testDataset.numAttributes() - 1);
			double VideoChk;
			if(videoChk.equals("no")) { // arff파일에 no가 첫 번째
				VideoChk = 0.0;
			}
			else {
				VideoChk = 1.0;
			}
			SeleniumCrawler selTest = new SeleniumCrawler();
			ArrayList<String> testArray = selTest.getSearchResult(artN,songN);
			Instance newInst = testDataset.instance(2);
			String tasr = testArray.get(0);
			String tassr = testArray.get(1);
			String tasnsr = testArray.get(2);
			double asr = Double.parseDouble(tasr);
			double assr = Double.parseDouble(tassr);
			double asnsr = Double.parseDouble(tasnsr);
			newInst.setValue(0, asr);
			newInst.setValue(1, assr);
			newInst.setValue(2,asnsr); 
			newInst.setValue(3,fanNum);
			newInst.setValue(4,VideoChk);
			
			double predNB;
			if(algorithm.equals("OneR")) {
				predNB = musicOneR.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
			}
			else if(algorithm.equals("NaiveBayesian")) {
				predNB = musicNaiveBayes.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
			}
			else {
				predNB = musicTree.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
			}
			SendData.getSendData().Send(predString+"~"+tasr+"~"+tassr+"~"+tasnsr+"~"+fanNum+"~"+videoChk+"~"); // 웹에서 따온 asr, assr, asnsr 넣어야 함 + videoChk ~로 구분
			System.out.println("Predict = " + predString);
			System.out.println(predString+", " + tasr + ", " + tassr + ", " + tasnsr + ", " + fanNum + ", " + videoChk);
			/*double actualClass = testDataset.instance(i).classValue();
			System.out.println("actual class = " + actualClass);
			String actual = testDataset.classAttribute().value((int) actualClass);
			System.out.println("actual = " + actual);
			Instance newInst = testDataset.instance(i);*/
			
			/*System.out.println("actual class = " + actualClass);
			String actual = testDataset.classAttribute().value((int) actualClass);
			System.out.println("actual = " + actual);*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	public String getResult() {
		return predString;
	}

	public DataSource getmusicSource() {
		return musicSource;
	}

	public Instances getmusicInstance() {
		return musicInstance;
	}

	public OneR getmusicOneR() {
		return musicOneR;
	}

	public NaiveBayes getmusicNaiveBayes() {
		return musicNaiveBayes;
	}

	public J48 getmusicTree() {
		return musicTree;
	}

	public String getmusicOneREval() {
		return musicOneR.toString();
	}

	public String getmusicNaiveEval() {
		return musicNaiveBayes.toString();
	}

	public String getmusicTreeEval() {
		return musicTree.toString();
	}

	public String musicOneRCrossValidation() {
		return musicOneREval.toSummaryString();
	}

	public String movieNaiveBayesCrossValidation() {
		return musicNaiveEval.toSummaryString();
	}

	public String movieTreeCrossValidation() {
		return musicTreeEval.toSummaryString();
	}

	private Instances musicInstance;
	private OneR musicOneR;
	private NaiveBayes musicNaiveBayes;
	private J48 musicTree;
	private Evaluation musicOneREval;
	private Evaluation musicNaiveEval;
	private Evaluation musicTreeEval;

	public ArrayList<Attribute> movieInstanceAttributes() {
		Attribute A1 = new Attribute("outlook");
		Attribute A2 = new Attribute("temperature");
		Attribute A3 = new Attribute("humidity");
		Attribute A4 = new Attribute("windy");
		List<String> Cls = new ArrayList<String>(2);
		Cls.add("yes");
		Cls.add("no");
		Attribute ACls = new Attribute("class", Cls);
		ArrayList<Attribute> musicInstanceAttributes = new ArrayList<Attribute>(2);
		musicInstanceAttributes.add(A1);
		musicInstanceAttributes.add(A2);
		musicInstanceAttributes.add(A3);
		musicInstanceAttributes.add(A4);
		musicInstanceAttributes.add(ACls);
		return musicInstanceAttributes;
	}
}
