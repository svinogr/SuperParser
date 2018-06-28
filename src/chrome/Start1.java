package chrome;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import static javax.swing.text.html.CSS.getAttribute;

public class Start1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\explo\\untitled3\\src\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("file:///C:/Users/explo/Downloads/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0/%D0%A2%D0%B5%D1%81%D1%822.html");

        Scanner sc = new Scanner(System.in);

       /* while (sc.nextInt()!=1){
            System.out.println("введите 1");
        }*/


//        webDriver.findElement(By.linkText("примеры вопросов")).click();
        String pageSource = webDriver.getPageSource();
        Document document = Jsoup.parse(pageSource);
        Elements select = document.select("img");


        for (Element e : select) {
            if (e.hasAttr("style")) {
                String src = e.attr("src");
                System.out.println(src);
                URL url = null;
                try {
                    url = new URL("http://213.108.248.155/WebDelta/media/MediaEngener/T23.jpg");
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
                InputStream in = null;
                try {
                    in = new BufferedInputStream(url.openStream());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                try {
                    while (-1!=(n=in.read(buf)))
                    {
                        out.write(buf, 0, n);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    out.close();
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                byte[] response = out.toByteArray();


                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream("C://db//borrowed_image.jpg");
                    fos.write(response);
                    fos.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
            System.out.println(e.attr("style"));

        }


//        webDriver.findElement(By.tagName("img style"))
        // List<WebElement> src = webDriver.findElements(By.cssSelector("img"));
        // WebElement element = webDriver.findElement(By.cssSelector("cursor:hand;"));
     /*   WebElement element = null;
        for (WebElement webElement : src) {
            element = webDriver.findElement(By.cssSelector("style=cursor:hand;"));
        }

        System.out.println(element.getAttribute("src"));*/
       /* String tit = webDriver.findElement(By.className("tit")).getText();
        System.out.println(tit);
        webDriver.findElement(By.linkText("КОММЕНТАРИЙ")).click();
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);

            // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        String span = webDriver.findElement(By.tagName("span")).getText();
        System.out.println(span);
        webDriver.close();*/
       /* System.out.println(windowHandle);
        String span = webDriver.findElement(By.tagName("span")).getText();
        System.out.println(span);*/
      /*  for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String tit = webDriver.findElement(By.className("tit")).getText();
            System.out.println(tit);
            webDriver.findElement(By.className("but")).click();
            String span = webDriver.findElement(By.tagName("span")).getText();
            System.out.println(span);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            webDriver.findElement(By.id("NextQuestBut")).click();
        }*/
    }
}
