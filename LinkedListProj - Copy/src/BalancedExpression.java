public class BalancedExpression<T> {

    public static boolean checkBalance(String expression){
        Stack<Character> stack = new Stack<Character>();
        boolean isBalanced = true;

        char nextChar, openDelimeter;

        while (isBalanced && expression.length() > 0) {
            nextChar = expression.charAt(0);
            switch(nextChar){
                case '(':
                case '[':
                case '{':{
                    stack.push(nextChar);
                    break;
                }

                case ')':
                case ']':
                case '}':{
                    if(stack.isEmpty()){
                        isBalanced = false;
                    } else{
                        openDelimeter = stack.pop();
                        if(openDelimeter == '(' && nextChar != ')' ||
                                openDelimeter == '[' && nextChar != ']' ||
                                openDelimeter == '{' && nextChar != '}') {
                            isBalanced = false;
                        }
                    }
                    break;
                }
            }
            if(expression.length() > 1) expression = expression.substring(1);
            else expression = "";

        }

        if (!stack.isEmpty()) isBalanced = false;
        return isBalanced;
    }

    public static void main(String[] args){
        String expression = "()";
        System.out.println(expression);
        System.out.println("Balanced?: " + checkBalance(expression));
    }

}
