import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LispInterpreter {
    public void interpretar(String filePath) {
        FileParser fileParser = new FileParser(filePath);
        String fileContents = fileParser.parse();

        Tokenizer tokenizer = new Tokenizer();
        List<String> tokens = tokenizer.tokenize(fileContents);

        LispInterpreter interpreter = new LispInterpreter();
        interpreter.evaluate(tokens);
    }
    
    public void evaluate(List<String> tokens) {
        Stack<Object> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("(")) {
                stack.push(new ArrayList<>());
            } else if (token.equals(")")) {
                Object expr = stack.pop();
                if (stack.isEmpty()) {
                  
                    Object result = evalExpression(expr);
                    System.out.println(result);
                } else {
                    @SuppressWarnings("unchecked")
                    List<Object> list = (List<Object>) stack.peek();
                    list.add(expr);
                }
            } else {
  
                if (!stack.isEmpty()) {
                    @SuppressWarnings("unchecked")
                    List<Object> list = (List<Object>) stack.peek();
                    list.add(token);
                }
            }
        }
    }

    private Object evalExpression(Object expr) {
        if (expr instanceof List<?>) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) expr;
            if (list.isEmpty()) {
                return null;
            }
            String operator = (String) list.get(0);
            switch (operator) {
                case "+":
                    return evaluateAddition(list.subList(1, list.size()));
                case "-":
                    return evaluateRest(list.subList(1, list.size()));
                   
                case "*":
                    return evaluateMult(list.subList(1,list.size()));
            
                default:
           
                    break;
            }
        }

        return expr;
    }

    private int evaluateAddition(List<Object> operands) {
        int result = 0;
        for (Object operand : operands) {
            if (operand instanceof String) {
                try {
                    result += Integer.parseInt((String) operand);
                } catch (NumberFormatException e) {
                    // Manejar error si no se puede convertir a entero
                }
            }
        }
        return result;
    }

    private int evaluateRest(List<Object> operands) {
        int result = 0;
        for (Object operand : operands) {
            if (operand instanceof String) {
                try {
                    result -= Integer.parseInt((String) operand);
                } catch (NumberFormatException e) {
                    // Manejar error si no se puede convertir a entero
                }
            }
        }
        return result;
    }

    private int evaluateMult(List<Object> operands) {
        int result = 0;
        for (Object operand : operands) {
            if (operand instanceof String) {
                try {
                    result *= Integer.parseInt((String) operand);
                } catch (NumberFormatException e) {
                    // Manejar error si no se puede convertir a entero
                }
            }
        }
        return result;
    }
}
        