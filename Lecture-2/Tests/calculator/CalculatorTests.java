package calculator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task3.Calculator;
import task3.Operator;

public class CalculatorTests {

    private Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator();
        System.out.println("Calculator is created");
    }

    @DataProvider(name = "dataForAddition", parallel = true)
    public Object[][] dataProviderForAdditionTest() {
        return new Object[][]{
                {1, 2, 3},
                {-5, -3, -8},
                {1.3, -0.8, 0.5}
        };
    }

    @Test(dataProvider = "dataForAddition")
    public void additionTest(double firstOperand, double secondOperand, double expectedResult) {
        Assert.assertEquals(calculator.getResult(Operator.PLUS, firstOperand, secondOperand), expectedResult, "Addition method failed");
    }

    @DataProvider(name = "dataForSubtraction", parallel = true)
    public Object[][] dataProviderForSubtractionTest() {
        return new Object[][]{
                {1, 2, -1},
                {-5, -3, -2},
                {1.3, -0.8, 2.1}
        };
    }

    @Test(dataProvider = "dataForSubtraction")
    public void subtractionTest(double firstOperand, double secondOperand, double expectedResult){
        Assert.assertEquals(calculator.getResult(Operator.MINUS, firstOperand, secondOperand), expectedResult, "Subtraction method failed");
    }

    @DataProvider(name = "dataForMultiplication", parallel = true)
    public Object[][] dataProviderForMultiplicationTest() {
        return new Object[][]{
                {1, 2, 2},
                {-5, -3, 15},
                {1.3, -0.2, -0.26}
        };
    }

    @Test(dataProvider = "dataForMultiplication")
    public void multiplicationTest(double firstOperand, double secondOperand, double expectedResult){
        Assert.assertEquals(calculator.getResult(Operator.MULTIPLY, firstOperand, secondOperand), expectedResult, "Multiplication method failed");
    }

    @DataProvider(name = "dataForDivision", parallel = true)
    public Object[][] dataProviderForDivisionTest() {
        return new Object[][]{
                {4, 2, 2},
                {200, -20, -10},
                {5.5, 0.1, 55}
        };
    }

    @Test(dataProvider = "dataForDivision")
    public void divisionTest(double firstDigit, double secondDigit, double expectedResult){
        Assert.assertEquals(calculator.getResult(Operator.DIVIDE, firstDigit, secondDigit), expectedResult, "Division method failed");
    }
}
