package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static task3.Application.getResult;

public class ApplicationTest {

    @Test(dataProvider = "dataForAddition")
    public void additionTest(double firstDigit, double secondDigit, double result) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(getResult("+", firstDigit, secondDigit), result, "Addition method failed");
    }

    @Test(dependsOnMethods = "multiplicationTest")
    public void subtractionTest() throws InterruptedException {
        Thread.sleep(1000);
        double firstDigit = 10;
        double secondDigit = 4;
        double result = 6;
        Assert.assertEquals(getResult("-", firstDigit, secondDigit), result, "Subtraction method failed");
    }

    @Test(dependsOnMethods = "divisionTest")
    public void multiplicationTest() throws InterruptedException {
        Thread.sleep(1000);
        double firstDigit = 10;
        double secondDigit = 4;
        double result = 40;
        Assert.assertEquals(getResult("*", firstDigit, secondDigit), result, "Multiplication method failed");
    }

    @Test(dataProvider = "dataForDivision")
    public void divisionTest(double firstDigit, double secondDigit, double result) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(getResult("/", firstDigit, secondDigit), result, "Division method failed");
    }

    @DataProvider(name = "dataForAddition")
    public Object[][] dataProviderForAdditionTest() {
        return new Object[][]{
                {1, 2, 3},
                {10, 20, 30},
                {5, 10, 15}
        };
    }

    @DataProvider(name = "dataForDivision", parallel = true)
    public Object[][] dataProviderForDivisionTest() {
        return new Object[][]{
                {4, 2, 2},
                {200, 20, 10},
                {50, 10, 5}
        };
    }
}
