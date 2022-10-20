package investing.project.service;

import investing.project.dto.ShortFuturesDto;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Slf4j
public class SeleniumService {

    private static final String URL = "https://www.investing.com/indices/indices-futures";

    private WebDriver driver;

    private ChromeOptions options;

    @Value("${chrome.driver}")
    private String driverPath;

    @PostConstruct
    public void start() {
        System.setProperty("webdriver.chrome.driver", driverPath);

        options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    @PreDestroy
    public void stop() {
        driver.quit();
    }

    public ShortFuturesDto load() {
        log.info("Парсим страничку Chrome браузера при помощи Selenium");
        ShortFuturesDto shortFuturesDto = new ShortFuturesDto();
        List<WebElement> elementList = driver.findElements(By.cssSelector(".datatable_body__3EPFZ"));

        List<WebElement> futuresTrs = elementList.get(0).findElements(By.cssSelector("tr"));
        for (int i = 0; i < 5; i++) {
            WebElement tr = futuresTrs.get(i);
            String value = tr.findElements(By.cssSelector("td")).get(3).getText();

            shortFuturesDto.setPosition(i + 1, value);
        }
        log.info("Успешный парсинг страницы Chrome браузера при помощи Selenium");
        return shortFuturesDto;
    }

    public void restart() {
        log.info("Перезапуск Chrome браузера");
        driver.quit();

        driver = new ChromeDriver(options);

        log.info("Попытка входа на страницу investing");
        driver.get(URL);
    }
}
