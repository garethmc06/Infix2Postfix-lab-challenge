import java.util.Scanner;

public class infix2postfix {

    private static int precedence(char operand){
        switch (operand){
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return -1;
        }
    }


    public static String infix2postfix(String expression){
        String postfix = "";
        Stack<Character> operand = new Stack<Character>();

        for(int i = 0; i < expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                postfix+=expression.charAt(i);
            }else if(expression.charAt(i) == '^' || expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/' || expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-'){
                char currentOperator = expression.charAt(i);

                while(!operand.isEmpty() && (precedence(operand.peek()) > precedence(currentOperator) || (precedence(operand.peek()) == precedence(currentOperator) && currentOperator != '^'))){
                    postfix += operand.pop();
                }
                operand.push(currentOperator);
            }

            }
        while(!operand.isEmpty()){
            postfix+= operand.pop();
        }
        return postfix;
    }

    public static int calcPostfix(String postfix){
        Stack<Integer> stack = new Stack<Integer>();

        for(int i =0; i < postfix.length(); i++){
            char nextChar = postfix.charAt(i);

            if(Character.isDigit(nextChar)){
                stack.push(nextChar - '0');
            }
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(nextChar){
                    case '+': stack.push(val2 + val1);
                    break;
                    case'-': stack.push(val2 - val1);
                    break;
                    case '/': stack.push(val2 / val1);
                    break;
                    case '*': stack.push(val2 * val1);
                    break;
                    case '^': stack.push((int) Math.pow(val2, val1));
                    break;

                }
            }
        }
        return stack.pop();

    }

    public static void main(String [] args){
        String expression;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an Infix expression: ");
        expression = scan.nextLine();
        String result = infix2postfix(expression);
        System.out.println(result);
        System.out.println(calcPostfix(result));
    }
}
