import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import weka.core.Instances;
import weka.associations.Apriori;
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

public class contactLens {
	private static contactLens cL = new contactLens();
	private Instances contactLensInstance;
	private OneR contactLensOneR;
	private NaiveBayes contactLensNaiveBayes;
	private J48 contactLensTree;
	private Apriori contactLensApriori = new Apriori();
	private Evaluation contactLensOneREval;
	private Evaluation contactLensNaiveEval;
	private Evaluation contactLensTreeEval;
	private Evaluation contactLensAprioriEval;
	private DataSource contactLensSource;

	private contactLens() { // 생성자로 3가지의 알고리즘(OneR, NaiveBayes, Tree) 세팅! 
		try {
			// B의 2번 지식베이스 구축!
			this.contactLensSource = new DataSource("contact-lenses.arff"); // 데이터 읽어오는 부분
			this.contactLensInstance = contactLensSource.getDataSet(); // Instances 에 읽어 온 contactLens Instances를 넣는 부분
			this.contactLensInstance.setClassIndex(contactLensInstance.numAttributes() - 1); // contactLens의 클래스 설정 부분
			this.contactLensOneR = new OneR(); // OneR 생성
			this.contactLensNaiveBayes = new NaiveBayes(); // NaiveBayes 생성
			this.contactLensTree = new J48(); // Tree 생성
			this.contactLensOneR.buildClassifier(contactLensInstance); // contactLens의 Instance로 OneR 빌드!
			this.contactLensOneREval = new Evaluation(contactLensInstance); // contactLens OneR 평가
			this.contactLensOneREval.crossValidateModel(contactLensOneR, contactLensInstance, 10, new Random(1)); // OneR contactLens 10-fold
			this.contactLensNaiveBayes.buildClassifier(contactLensInstance); // contactLens의 Instance로 NaiveBayes 빌드!
			this.contactLensNaiveEval = new Evaluation(contactLensInstance); // contactLens NaiveBayes 평가
			this.contactLensNaiveEval.crossValidateModel(contactLensNaiveBayes, contactLensInstance, 10, new Random(1)); // NaiveBayes contactLens 10-fold													
			this.contactLensTree.buildClassifier(contactLensInstance); // contactLens의 Instance로 Tree(J48) 빌드!
			this.contactLensTreeEval = new Evaluation(contactLensInstance); // contactLens의 Tree(J48) 평가
			this.contactLensTreeEval.crossValidateModel(contactLensTree, contactLensInstance, 10, new Random(1)); // Tree contactLens 10-fold
			this.contactLensApriori.buildAssociations(contactLensInstance); //contactLens의 Instance로 Apriori 빌드!
			this.contactLensAprioriEval = new Evaluation(contactLensInstance); //contactLens의 Apriori 평가
			this.contactLensAprioriEval.crossValidateModel(contactLensTree, contactLensInstance, 10, new Random(1)); // Tree contactLens 10-fold
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static contactLens Instance() {
		return cL;
	}

	public void Predict(String Algorithm, String Age, String Sp, String Astigmatism, String Tpr) {
		System.out.println("\n선택한 알고리즘 : " + Algorithm); // 선택한 알고리즘 출력
		System.out.println("\n입력 받은 데이터 : " + Age + ", " + Sp + ", " + Astigmatism + ", " + Tpr); // 입력 받은 데이터 출력
		System.out.println();
		double predictNum;
		String predict = null;
		Instance newInst = contactLensInstance.get(0); // new Instance 생성!
		// new Instance에 값을 넣어 주기 위해 double로 받은 입력 처리
		double age;
		double sp;
		double astig;
		double tpr;
		if (Age.equals("young")) {
			age = 0.0;
		} else if (Age.equals("pre-presbyopic")) {
			age = 1.0;
		} else {
			age = 2.0;
		}
		if (Age.equals("myope")) {
			sp = 0.0;
		} else {
			sp = 1.0;
		}
		if (Astigmatism.equals("yes")) { // Astigmatism attribute 1번째 값 : no, 2번째 값 : yes
			astig = 1.0;
		} else {
			astig = 0.0;
		}
		if (Tpr.equals("reduced")) {
			tpr = 0.0;
		} else {
			tpr = 1.0;
		}
		// 변환 해준 뒤에 새로운 Instance의 attribute value 넣어주기!
		newInst.setValue(0, age);
		newInst.setValue(1, sp);
		newInst.setValue(2, astig);
		newInst.setValue(3, tpr);
		try {
			// OneR를 이용해 newInstance의 결과 값 계산
			if (Algorithm.equals("OneR")) {
				predictNum = contactLensOneR.classifyInstance(newInst);
				predict = contactLensInstance.classAttribute().value((int) predictNum);
				System.out.println("\nOneR 지식 베이스 구축 결과\n\n" + contactLensOneR);
				System.out.println("\nOneR 분류 정확도\n\n" + contactLensOneREval.toSummaryString()); // OneR 분류 정확도
				System.out.println("OneR recommendation is = " + predict); // OneR 결과값 출력 (B의 3번)
				System.out.println("--------------------------------------");
			}
			// Naive Bayesian을 이용해 newInstance의 결과 값 계산
			else if (Algorithm.equals("Naive Bayesian")) {
				predictNum = contactLensNaiveBayes.classifyInstance(newInst);
				predict = contactLensInstance.classAttribute().value((int) predictNum);
				System.out.println("\nNaive Bayesian 지식 베이스 구축 결과\n\n" + contactLensNaiveBayes);
				System.out.println("\nNaive Bayesian 분류 정확도\n\n" + contactLensNaiveEval.toSummaryString()); // Naive Bayesian 분류 정확도																						
				System.out.println("Naive Bayesian recommendation is = " + predict); // Naive Bayesian 결과값 출력 (B의 3번)
				System.out.println("--------------------------------------");
			}
			// Tree(J48)을 이용해 newInstance의 결과 값 계산
			else if (Algorithm.contentEquals("Tree")) {
				predictNum = contactLensTree.classifyInstance(newInst);
				predict = contactLensInstance.classAttribute().value((int) predictNum);
				System.out.println("\nTree(J48) 지식 베이스 구축 결과\n\n" + contactLensTree);
				System.out.println("\nTree(J48) 분류 정확도\n\n" + contactLensTreeEval.toSummaryString()); // Tree 분류 정확도
				System.out.println("Tree(J48) recommendation is = " + predict); // Tree(J48) 결과값 출력 (B의 3번)
			} else {
				System.out.println("Association Rule(Apriori algorithm) 지식 베이스 구축 결과\n\n" + contactLensApriori);
				System.out.println("\nAssociation Rule(Apriori algorithm) 분류 정확도\n\n" + contactLensAprioriEval.toSummaryString());
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
