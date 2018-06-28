package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Scanner;

public class Start {
    public static String OTVETY;

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] ptext = "ОТВЕТЫ".getBytes("windows-1251");
        OTVETY = new String(ptext);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\explo\\untitled3\\src\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://213.108.248.155/WebDelta/listeners/listenersEntryUser.aspx");

        Scanner sc = new Scanner(System.in);

        while (sc.nextInt() != 1) {
            System.out.println("введите 1");
        }


        webDriver.findElement(By.cssSelector("input[type='button']")).click();

        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
            // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        int i = 0;
        while (true) {
            i++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String winHandle : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(winHandle);


                // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }
            // вызываем некст   id CanBut  name NextQuestBut name id ShowRemQuest
            webDriver.findElement(By.name("NextQuestBut")).click();
            // получаем номер вопроса
            String number = null;
            WebElement showRemQuest = webDriver.findElement(By.id("ShowRemQuest"));
            number = showRemQuest.getText();
            System.out.println(number);
            // открыли ответы
            webDriver.findElement(By.linkText(OTVETY)).click();

            for (String winHandle : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(winHandle);
//dddd

                // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }


            // копируем
            String pageSource = webDriver.getPageSource();

            saveSource(pageSource, number);
            // возвращаемся

            webDriver.findElement(By.id("CanBut")).click();
        }


    }

    private static void saveSource(String pageSource, String nunber) {
        StringBuilder stringBuilder = new StringBuilder("<div class='quest'>");
        stringBuilder.append(pageSource);
        stringBuilder.append("</div>");
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(nunber + ".html"), "utf-8"));
            writer.write(stringBuilder.toString());
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }
}
