import java.util.Random;

import weka.associations.Apriori;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;

public class weatherDomain {
	private Instances weatherInstance;
	private OneR weatherOneR;
	private NaiveBayes weatherNaiveBayes;
	private J48 weatherTree;
	private Apriori weatherApriori;
	private Evaluation weatherOneREval;
	private Evaluation weatherNaiveEval;
	private Evaluation weatherTreeEval;
	private Evaluation weatherAprioriEval;
	private DataSource weatherSource;
	private static weatherDomain wD = new weatherDomain();

	private weatherDomain() { // 생성자로 3가지의 알고리즘(OneR, NaiveBayes, Tree) 세팅!
		try {
			// B의 2번 지식베이스 구축!
			this.weatherSource = new DataSource("weather.arff"); // 데이터 읽어오는 부분
			this.weatherInstance = weatherSource.getDataSet(); // Instances 에  읽어 온 weather Instances를 넣는 부분
			this.weatherInstance.setClassIndex(weatherInstance.numAttributes() - 1); // weather의 클래스 설정 부분
			this.weatherOneR = new OneR(); // OneR 생성
			this.weatherNaiveBayes = new NaiveBayes(); // NaiveBayes 생성
			this.weatherTree = new J48(); // Tree 생성
			this.weatherOneR.buildClassifier(weatherInstance); // weather의 Instance로 OneR 빌드!
			this.weatherOneREval = new Evaluation(weatherInstance); // weather OneR 평가
			this.weatherOneREval.crossValidateModel(weatherOneR, weatherInstance, 10, new Random(1)); // OneR weather 10-fold

			this.weatherNaiveBayes.buildClassifier(weatherInstance); // weather1의 Instance로 NaiveBayes 빌드!
			this.weatherNaiveEval = new Evaluation(weatherInstance); // weather1 NaiveBayes 평가
			this.weatherNaiveEval.crossValidateModel(weatherNaiveBayes, weatherInstance, 10, new Random(1)); // NaiveBayes weather 10-fold

			this.weatherTree.buildClassifier(weatherInstance); // weather1의 Instance로 Tree(J48) 빌드!
			this.weatherTreeEval = new Evaluation(weatherInstance); // weather1의 Tree(J48) 평가
			this.weatherTreeEval.crossValidateModel(weatherTree, weatherInstance, 10, new Random(1)); // Tree weather 10-fold
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static weatherDomain Instance() {
		return wD;
	}

	public void Predict(String Algorithm, String Outlook, double Temperature, double Humidity, String Windy) {
		System.out.println("\n선택한 알고리즘 : " + Algorithm); // 입력 받은 알고리즘 출력 부분
		System.out.println("\n입력 받은 데이터 : " + Outlook + ", " + Temperature + ", " + Humidity + ", " + Windy); // 입력 받은 데이터 출력 부분
		System.out.println();
		double outlook;
		double windy;
		// new Instance에 값을 넣어 주기 위해 double로 받은 입력 처리
		if (Outlook.equals("Sunny")) {
			outlook = 0.0;
		} else if (Outlook.equals("Overcast")) {
			outlook = 1.0;
		} else {
			outlook = 2.0;
		}
		if (Windy.equals("True")) {
			windy = 0.0;
		} else {
			windy = 1.0;
		}
		double predictNum;
		String predict;
		Instance newInst = weatherInstance.get(0); // new Instance 생성!
		// 변환 해준 뒤에 새로운 Instance의 attribute value 넣어주기!
		newInst.setValue(0, outlook);
		newInst.setValue(1, Temperature);
		newInst.setValue(2, Humidity);
		newInst.setValue(3, windy);
		try {
			predictNum = weatherOneR.classifyInstance(newInst);
			predict = weatherInstance.classAttribute().value((int) predictNum);
			if (Algorithm.equals("OneR")) {
				// OneR를 이용해 newInstance의 결과값 계산
				System.out.println("\nOneR 지식 베이스 구축 결과 \n\n" + weatherOneR);
				System.out.println("\nOneR 분류 정확도\n\n" + weatherOneREval.toSummaryString()); // OneR 분류 정확도
				System.out.println("OneR recommendation is = " + predict); // OneR 결과값 출력 (B의 3번)
				System.out.println("--------------------------------------");
			} else if (Algorithm.equals("Naive Bayesian")) {
				// Naive Bayesian 을 이용해 newInstance의 결과 값 계산
				predictNum = weatherNaiveBayes.classifyInstance(newInst);
				predict = weatherInstance.classAttribute().value((int) predictNum);
				System.out.println("\nNaive Bayesian 지식 베이스 구축 결과 \n\n " + weatherNaiveBayes);
				System.out.println("\nNaive Bayesian 분류 정확도\n\n" + weatherNaiveEval.toSummaryString()); // Naive Bayesian 분류 정확도																							
				System.out.println("Naive Bayesian recommendation is = " + predict); // Naive Bayesian 결과값 출력 (B의 3번)
				System.out.println("--------------------------------------");
			} else {
				// Tree(J48)을 이용해 newInstance의 결과 값 계산
				predictNum = weatherTree.classifyInstance(newInst);
				predict = weatherInstance.classAttribute().value((int) predictNum);
				System.out.println("\nTree(J48) 지식 베이스 구축 결과 \n\n" + weatherTree);
				System.out.println("\nTree(J48) 분류 정확도\n\n" + weatherTreeEval.toSummaryString()); // Tree 분류 정확도
				System.out.println("Tree(J48) recommendation is = " + predict); // Tree(J48) 결과값 출력 (B의 3번)
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
