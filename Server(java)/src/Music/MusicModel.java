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

	public void Test(String algorithm,double asr, double assr, double asnsr, double can
			,String viCCo) {
		Instances testDataset;
		try {
			//알고리즘 별로 if문 추가 해줘야 
			testDataset = musicSource.getDataSet();
			testDataset.setClassIndex(testDataset.numAttributes() - 1);
			/*String outlook = sc.next();
			String temperature = sc.next();
			String humidity = sc.next();
			String windy = sc.next();*/
			double dviCCo;
			if(viCCo.equals("No")) {
				dviCCo = 0.0;
			}
			else {
				dviCCo = 1.0;
			}
			/*if(outlook.equals("sunny")) {
				o = 0.0;
			}
			else if(outlook.equals("overcast")) {
				o = 1.0;
			}
			else {
				o = 2.0;
			}
			if(temperature.equals("hot")) {
				t = 0.0;
			}
			else if(temperature.equals("mild")) {
				t = 1.0;
			}
			else {
				t = 2.0;
			}
			if(humidity.equals("high")) {
				h = 0.0;
			}
			else {
				h = 1.0;
			}
			if(windy.equals("true")) {
				w = 0.0;
			}
			else {
				w = 1.0;
			}*/
			/*double actualClass = testDataset.instance(i).classValue();
			System.out.println("actual class = " + actualClass);
			String actual = testDataset.classAttribute().value((int) actualClass);
			System.out.println("actual = " + actual);
			Instance newInst = testDataset.instance(i);*/
			
			Instance newInst = testDataset.instance(2);
			double actualClass = testDataset.instance(2).classValue();
			/*System.out.println("actual class = " + actualClass);
			String actual = testDataset.classAttribute().value((int) actualClass);
			System.out.println("actual = " + actual);*/
			newInst.setValue(0,asr);
			newInst.setValue(1,assr);
			newInst.setValue(2,asnsr);
			newInst.setValue(3,can);
			newInst.setValue(4,dviCCo);
//				newInst.setValue(0, 0.0d); 기존 Instance로 세팅하고, setValue를 통해 newInstance로 바꿔준다 + for문 안써도 돼
			System.out.println("newInst = " + newInst);
			double predNB;
			if(algorithm.equals("OneR")) {
				predNB = musicOneR.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
				SendData.getSendData().Send(predString + "~" + musicOneR + "~" + musicOneREval.toSummaryString() + "~");
			}
			else if(algorithm.equals("NaiveBayesian")) {
				predNB = musicNaiveBayes.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
				SendData.getSendData().Send(predString + "~" + musicNaiveBayes + "~" + musicNaiveEval.toSummaryString() + "~");
			}
			else {
				predNB = musicTree.classifyInstance(newInst);
				predString = testDataset.classAttribute().value((int) predNB);
				SendData.getSendData().Send(predString + "~" + musicTree + "~" + musicTreeEval.toSummaryString() + "~");
			}
			System.out.println("Predict = " + predString);

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
