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


public class Test {
	private Instances musicInstance;
	private OneR musicOneR;
	private NaiveBayes musicNaiveBayes;
	private J48 musicTree;
	private Evaluation musicOneREval;
	private Evaluation musicNaiveEval;
	private Evaluation musicTreeEval;
	private DataSource musicSource;
	public Test() {
		
		try {
			this.musicSource = new DataSource("MusicPredict.arff");
			this.musicInstance = this.musicSource.getDataSet();
			this.musicInstance.setClassIndex(musicInstance.numAttributes() - 1);
			int num = musicInstance.numInstances();
			/*Instances[] tenInstance = new Instances[num + 1];
			int count = 0;
			for (int i = num; i < musicInstance.numInstances(); i++) {
				tenInstance[count] = new weka.core.Instances(musicInstance, 0, i - 1);
				count++;
			}*/
			Instances[] tenInstance = new Instances[10];
			int count = 0;
			for(int i = 403;i<413;i++) {
				tenInstance[count] = new weka.core.Instances(musicInstance, 0, i);
				count++;
			}
			
			this.musicOneR = new OneR();
			this.musicNaiveBayes = new NaiveBayes();
			this.musicTree = new J48();
			double[] accuracy = new double[count];
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
			System.out.println("OneR = " + str);
			for (int i = 0; i < count; i++) {
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
			System.out.println("NaiveBayesian = " + str);
			for (int i = 0; i < count; i++) {
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
			System.out.println("Decision tree : " + str);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
