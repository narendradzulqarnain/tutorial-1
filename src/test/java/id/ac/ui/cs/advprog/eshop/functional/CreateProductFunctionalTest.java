package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testCreateProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");

        // click add product
        WebElement addProductButton = driver.findElement(By.id("create_product_btn"));
        addProductButton.click();

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        String nameInput = "Makanan";
        productNameInput.sendKeys(nameInput);

        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        int quantityInput = 15;
        productQuantityInput.sendKeys(Integer.toString(quantityInput));

        WebElement submitButton = driver.findElement(By.id("submit_btn"));
        submitButton.click();

        List<WebElement> tableBody = driver.findElements(By.tagName("td"));

        String createdProductName = tableBody.getFirst().getText(); // Kolom pertama adalah nama
        String createdProductQuantity = tableBody.getLast().getText(); // Kolom kedua adalah quantity

        assertEquals(createdProductName, nameInput);
        assertEquals(Integer.parseInt(createdProductQuantity), quantityInput);
    }
}
