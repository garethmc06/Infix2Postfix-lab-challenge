import java.util.*;

public class Pqueue <T extends Comparable <T>> implements PQueueInterface<T>{

    private MyNode<T> front;

    public Pqueue(){
        front = null;
    }


    public void enqueue (T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if(front == null) front = newNode;
        else if(front.getData().compareTo(newEntry) < 0){
            newNode.setNext(front);
            front = newNode;
        }else{
            MyNode<T> currentNode = front;
            while(currentNode.getNext() != null && currentNode.getNext().getData().compareTo(newEntry) > 0){
                currentNode = currentNode.getNext();
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
        }

    }

    public T dequeue(){
        if(front == null) return null;
        else{
            T valueToReturn = front.getData();
            front = front.getNext();
            return valueToReturn;
        }
    }

    public T getFront() {
        if(front == null) return null;
        else{
            return front.getData();
        }
    }

    public boolean isEmpty(){
        return(front == null);
    }


    public void clear(){
        front = null;
    }

    public static void main(String [] args){
        Pqueue<Integer> nums = new Pqueue<>();
        Random random = new Random();
        Integer[] randomValues = new Integer[10];
        for(int i = 0; i < randomValues.length; i++){
            randomValues[i] = random.nextInt(1000);
            nums.enqueue(randomValues[i]);
        }
        System.out.println("Random array is " + Arrays.toString(randomValues));

        while(!nums.isEmpty()){
            System.out.println("Removing value" + nums.dequeue());
        }

    }
}
