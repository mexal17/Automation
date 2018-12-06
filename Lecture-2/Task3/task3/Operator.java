package task3;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    public static Operator getOperatorByString(String type){
        switch (type){
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("Invalid operator type");
        }
    }
}
