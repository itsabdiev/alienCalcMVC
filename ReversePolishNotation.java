public class ReversePolishNotation {
    private Model model;

    public ReversePolishNotation(Model model) {
        this.model = model;
    }

    public void infixToPostfix(String str) {
        StringBuilder postfix = new StringBuilder();
        CustomStack<Character> stack = new CustomStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    number.append(str.charAt(i));
                    i++;
                }
                postfix.append(number).append(' ');
                i--;
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        calculatePostfix(postfix.toString());
    }


    public void calculatePostfix(String str) {
        CustomStack<Double> stack = new CustomStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    number.append(str.charAt(i));
                    i++;
                }
                stack.push(Double.parseDouble(number.toString()));
                i--;
            } else {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(a + b);
            }
        }
        model.setResult(stack.pop());
    }
}

