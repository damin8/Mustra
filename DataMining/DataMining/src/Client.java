import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// B의 1번. 입력 받는 부분.
		// contactLens Attribute 입력 받기(클래스 제외)!
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Press q to quit or Press s to Start"); // 사용자가 나가고 싶을 때 나가기 위한 Press q 버튼
			String quit = input.next();
			if(quit.equals("q")) {
				break;
			}
			System.out.println("\n\nContact Lens \n");
			int tAge;
			int tSp;
			int tAstigmatism;
			int tTpr;
			int tAlgorithm;
			String Age;
			String Sp;
			String Astigmatism;
			String Tpr;
			String Algorithm;

			System.out.println( // 사용자에게 알고리즘 입력 받기
					"\nAlgorithm -> 1. OneR, 2. Naive Bayesian, 3. Decision Tree(J48), 4. Association Rule(Apriori algorithm) ");
			System.out.print("\nAlgorithm (1 or 2 or 3 or 4) : ");
			tAlgorithm = input.nextInt();
			// 입력 받은 값 매칭!
			if (tAlgorithm == 1) {
				Algorithm = "OneR";
			} else if (tAlgorithm == 2) {
				Algorithm = "Naive Bayesian";
			} else if (tAlgorithm == 3) {
				Algorithm = "Decision Tree";
			} else {
				Algorithm = "Association Rule";
			}
			System.out.println("\nAge -> 1. Young, 2. Pre-presbyopic, 3. Presbyopic"); // 사용자에게 nominal 범주 주기
			System.out.print("\nAge (1 or 2 or 3) : ");
			tAge = input.nextInt();
			// 입력 받은 값 매칭!
			if (tAge == 1) {
				Age = "young";
			} else if (tAge == 2) {
				Age = "pre-presbyopic";
			} else {
				Age = "presbyopic";
			}
			System.out.println("\nSpectacle prescription -> 1. Myope, 2. Hypermetrope"); // 사용자에게 nominal 범주 주기
			System.out.print("\nSpectacle prescription (1 or 2) : ");
			tSp = input.nextInt();
			// 입력 받은 값 매칭!
			if (tSp == 1) {
				Sp = "myope";
			} else {
				Sp = "hypermetrope";
			}
			System.out.println("\nAstigmatism -> 1. Yes, 2. No"); // 사용자에게 nominal 범주 주기
			System.out.print("\nAstigmatism (1 or 2) : ");
			tAstigmatism = input.nextInt();
			// 입력 받은 값 매칭!
			if (tAstigmatism == 1) {
				Astigmatism = "yes";
			} else {
				Astigmatism = "no";
			}
			System.out.println("\nTear production rate -> 1. Normal, 2. Reduced"); // 사용자에게 nominal 범주 주기
			System.out.print("\nTear production rate (1 or 2) : ");
			tTpr = input.nextInt();
			// 입력 받은 값 매칭!
			if (tTpr == 1) {
				Tpr = "normal";
			} else {
				Tpr = "reduced";
			}
			contactLens.Instance().Predict(Algorithm, Age, Sp, Astigmatism, Tpr); // 예측 시작!!
			
			// weather Attribute 입력 받기(클래스 제외)!
			int tOutlook;
			String Outlook;
			double Temperature;
			double Humidity;
			int tWindy;
			String Windy;
			System.out.println("\nWeather Domain"); 
			System.out.println("\nAlgorithm -> 1. OneR, 2. Naive Bayesian, 3. Decision Tree(J48) ");
			System.out.print("\nAlgorithm (1 or 2 or 3) : ");
			tAlgorithm = input.nextInt();
			// 입력 받은 값 매칭!
			if (tAlgorithm == 1) {
				Algorithm = "OneR";
			} else if (tAlgorithm == 2) {
				Algorithm = "Naive Bayesian";
			} else {
				Algorithm = "Decision Tree";
			}
			System.out.println("\nOutlook -> 1. Sunny, 2. Overcast, 3. Rainy"); // 사용자에게 nominal 범주 주기
			System.out.print("\nOutlook (1 or 2 or 3) : ");
			tOutlook = input.nextInt();
			// 입력 받은 값 매칭!
			if (tOutlook == 1) {
				Outlook = "Sunny";
			} else if (tOutlook == 2) {
				Outlook = "Overcast";
			} else {
				Outlook = "Rainy";
			}
			System.out.println("\nTemperature Range -> (64 ~ 85)"); // 사용자에게 numeric 범주 주기
			System.out.print("\nTemperature : ");
			Temperature = input.nextDouble();
			System.out.println("\nHumidity Range -> (70 ~ 96)"); // 사용자에게 numeric 범주 주기
			System.out.print("\nHumidity : ");
			Humidity = input.nextDouble();
			System.out.println("\nWindy -> 1. True, 2.False"); // 사용자에게 nominal 범주 주기
			System.out.print("\nWindy : ");
			tWindy = input.nextInt();
			// 입력 받은 값 매칭!
			if (tWindy == 1) {
				Windy = "True";
			} else {
				Windy = "False";
			}
			weatherDomain.Instance().Predict(Algorithm, Outlook, Temperature, Humidity, Windy); // 예측 시작!!
		}
	}

}
