import java.util.EmptyStackException;

public class Stack <T> implements StackInterface<T>{

    private MyNode<T> topNode;

    public Stack(){
        topNode = null;
    }

    public void push(T newEntry){
        MyNode <T> newNode = new MyNode<T>(newEntry);
        newNode.setNext(topNode);
        topNode = newNode;


    }

    public T pop(){
        T dataToReturn = peek();
        topNode = topNode.getNext();
        return dataToReturn;
    }



    public T peek(){
        if(topNode == null) throw new EmptyStackException();
        else return topNode.getData();
    }



    public boolean isEmpty(){
        return topNode == null;
    }



    public void clear(){
        topNode = null;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());


        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.isEmpty());
        stack.clear();
        System.out.println(stack.isEmpty());


    }



}
