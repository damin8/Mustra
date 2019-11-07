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
			this.weatherSource = new DataSource("C:\\Users\\damin\\eclipse-workspace\\WekaTest\\bin\\weather.arff");
			this.weatherInstance = this.weatherSource.getDataSet();
			this.weatherInstance.setClassIndex(weatherInstance.numAttributes() - 1);
			this.weatherOneR = new OneR();
			this.weatherNaiveBayes = new NaiveBayes();
			this.weatherTree = new J48();
			this.weatherOneR.buildClassifier(weatherInstance);
			this.weatherOneREval = new Evaluation(weatherInstance);
			this.weatherOneREval.crossValidateModel(weatherOneR, weatherInstance, 10, new Random(1));

			this.weatherNaiveBayes.buildClassifier(weatherInstance);
			// Evaluation on Training Set
			// Movie NaiveBayes Cross-Validation
			this.weatherNaiveEval = new Evaluation(weatherInstance);
			this.weatherNaiveEval.crossValidateModel(weatherNaiveBayes, weatherInstance, 10, new Random(1));

			// Movie J48 Training
			this.weatherTree.buildClassifier(weatherInstance);
			// Evaluation on Training Set
			// Movie J48 Cross-Validation
			this.weatherTreeEval = new Evaluation(weatherInstance);
			this.weatherTreeEval.crossValidateModel(weatherTree, weatherInstance, 10, new Random(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DataSource weatherSource;
	
	public static MusicModel getMusicModel() {
		return WM;
	}
	
	public void Test(String outlook, String temperature, String humidity, String windy) {
		Instances testDataset;
		try {
			testDataset = weatherSource.getDataSet();
			testDataset.setClassIndex(testDataset.numAttributes() - 1);
			/*String outlook = sc.next();
			String temperature = sc.next();
			String humidity = sc.next();
			String windy = sc.next();*/
			double o;
			double t;
			double h;
			double w;
			if(outlook.equals("sunny")) {
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
			}
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
			newInst.setValue(0,o);
			newInst.setValue(1,t);
			newInst.setValue(2,h);
			newInst.setValue(3,w);
//				newInst.setValue(0, 0.0d); 기존 Instance로 세팅하고, setValue를 통해 newInstance로 바꿔준다 + for문 안써도 돼
			for (int j = 0; j < newInst.numAttributes()-1; j++) {
				System.out.println(j + " : " + newInst.value(j));
			}
			System.out.println("newInst = " + newInst);

			double predNB = weatherOneR.classifyInstance(newInst);
			predString = testDataset.classAttribute().value((int) predNB);
			System.out.println("Predict = " + predString);
			SendData.getSendData().Send(predString);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getResult() {
		return predString;
	}

	public DataSource getWeatherSource() {
		return weatherSource;
	}

	public Instances getWeatherInstance() {
		return weatherInstance;
	}

	public OneR getWeatherOneR() {
		return weatherOneR;
	}

	public NaiveBayes getWeatherNaiveBayes() {
		return weatherNaiveBayes;
	}

	public J48 getWeatherTree() {
		return weatherTree;
	}

	public String getWeatherOneREval() {
		return weatherOneR.toString();
	}

	public String getWeatherNaiveEval() {
		return weatherNaiveBayes.toString();
	}

	public String getWeatherTreeEval() {
		return weatherTree.toString();
	}

	public String weatherOneRCrossValidation() {
		return weatherOneREval.toSummaryString();
	}

	public String movieNaiveBayesCrossValidation() {
		return weatherNaiveEval.toSummaryString();
	}

	public String movieTreeCrossValidation() {
		return weatherTreeEval.toSummaryString();
	}

	private Instances weatherInstance;
	private OneR weatherOneR;
	private NaiveBayes weatherNaiveBayes;
	private J48 weatherTree;
	private Evaluation weatherOneREval;
	private Evaluation weatherNaiveEval;
	private Evaluation weatherTreeEval;

	public ArrayList<Attribute> movieInstanceAttributes() {
		Attribute A1 = new Attribute("outlook");
		Attribute A2 = new Attribute("temperature");
		Attribute A3 = new Attribute("humidity");
		Attribute A4 = new Attribute("windy");
		List<String> Cls = new ArrayList<String>(2);
		Cls.add("yes");
		Cls.add("no");
		Attribute ACls = new Attribute("class", Cls);
		ArrayList<Attribute> weatherInstanceAttributes = new ArrayList<Attribute>(2);
		weatherInstanceAttributes.add(A1);
		weatherInstanceAttributes.add(A2);
		weatherInstanceAttributes.add(A3);
		weatherInstanceAttributes.add(A4);
		weatherInstanceAttributes.add(ACls);
		return weatherInstanceAttributes;
	}
}
