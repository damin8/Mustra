package mustra.musicprediction.Module;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class SeleniumCrawler {

    private WebDriver driver;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/usr/bin/chromedriver";
    //public static final String WEB_DRIVER_PATH = "C:\\Selenium\\selenium-java-3.141.59\\chromedriver.exe";

    private String base_url;

    public SeleniumCrawler() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        base_url = "http://www.google.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--allow-insecure-localhost");
        driver = new ChromeDriver(options); // Driver 생성
    }

    public ArrayList<String> getSearchResult(String singerName, String songName) {
        driver.get(base_url);
        ArrayList<String> res = new ArrayList<String>();

        WebElement searchBar = driver.findElement(By.name("q"));

        searchBar.clear();
        searchBar.sendKeys("가수 " + singerName);
        searchBar.submit();

        try {
            String xPathStr = "//*[@id=\"result-stats\"]";
            WebElement singerResultWeb = driver.findElement(By.xpath(xPathStr));
            String singerResult = singerResultWeb.getText();
            singerResult = singerResult.split(" ")[2];
            singerResult = singerResult.replace(",", "");
            singerResult = singerResult.substring(0, singerResult.length()-1);
            res.add(singerResult);
            //System.out.println(singerResult);
        } catch (Exception e) {
            res.add("?");
            // TODO: handle exception
        }

        searchBar = driver.findElement(By.name("q"));
        searchBar.clear();
        searchBar.sendKeys("가수 " + singerName + " " + songName);
        searchBar.submit();

        try {
            String xPathStr = "//*[@id=\"result-stats\"]";
            WebElement songResultWeb = driver.findElement(By.xpath(xPathStr));
            String songResult = songResultWeb.getText();
            songResult = songResult.split(" ")[2];
            songResult = songResult.replace(",", "");
            songResult = songResult.substring(0, songResult.length()-1);
            res.add(songResult);
            //System.out.println(songResult);

        } catch (Exception e) {
            res.add("?");
            // TODO: handle exception
        }

        try {
            for(int i=2; i<=5; i++) {
                String idx = Integer.toString(i);
                String sStr = "//*[@id=\"hdtb-msb-vis\"]/div["+idx+"]/a";
                WebElement webFind = driver.findElement(By.xpath(sStr));
                String rawStr = webFind.getAttribute("href");
                if(rawStr.matches(".*&tbm=nws.*")) {
                    webFind.click();
                    break;
                }
                else {
                    continue;
                }
            }
            String sStr = "//*[@id=\"result-stats\"]";
            WebElement webFind = driver.findElement(By.xpath(sStr));
            String newRes = webFind.getText();
            newRes = newRes.split(" ")[2];
            newRes = newRes.replace(",", "");
            newRes = newRes.substring(0, newRes.length()-1);
            System.out.println(newRes);
            if(newRes.charAt(0) == '(') {
                res.add("?");
            }
            else {
                res.add(newRes);
            }


        } catch (Exception e) {
            res.add("?");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return res;
    }
}
