public class Model {
    private Viewer viewer;
    private StringBuilder expression;
    private ReversePolishNotation reversePolishNotation;
    private char[] symbols = {'G','%','F','$','X','#','Y','@','D','!'};
    public Model(Viewer viewer) {
        this.viewer = viewer;
        expression = new StringBuilder();
        reversePolishNotation = new ReversePolishNotation(this);
    }

    public void doAction(String command) {
            switch (command){
                case "C":
                    nullify();
                    break;
                case "+":
                    doOperation();
                    break;
                case "=":
                    process();
                    break;
                default:
                    continueExpression(command);
            }
    }

    private void process() {
        reversePolishNotation.infixToPostfix(expression.toString());
    }

    private void doOperation() {
        if (expression.length() != 0 && expression.charAt(expression.length()-1) != '+') {
            expression.append('+');
            transform();
        }
    }

    private void continueExpression(String command) {
        if (expression.length() != 0) {
            if (expression.charAt(0) == '0' && expression.length() == 1) {
                expression.setLength(0);
            }
        }
        expression.append(command);
        transform();
    }

    private void transform() {
        StringBuilder transformedString = new StringBuilder();
        for (char c : expression.toString().toCharArray()) {
            transformedString.append(c == '+' ? '+' : symbols[Character.getNumericValue(c)]);
        }
        viewer.setTextField(transformedString.toString());
    }

    private void nullify() {
        expression.setLength(0);
        viewer.setTextField("");
    }

    public void setResult(Double result) {
        expression.setLength(0);
        expression.append(roundDouble(result));
        transform();
    }

    private String roundDouble(double result) {
        return Math.round(result) == result ? String.valueOf((int) result) : String.valueOf(result);
    }
}
