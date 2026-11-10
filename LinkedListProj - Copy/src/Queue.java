public class Queue <T> implements QueueInterface<T>{

    private MyNode<T> front;
    private MyNode<T> rear;


    public Queue(){
       front = null;
       rear = null;
    }

    public void enqueue(T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if(front == null){
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

    }

    public T dequeue(){
        if(front == null) return null;
        else{
            T valueToReturn = front.getData();
            front = front.getNext();
            if(front == null) rear = null;
            return valueToReturn;
        }
    }

    public T getFront(){
        if(front == null) return null;
        else{
            return front.getData();
        }
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void clear(){
        front = null;
        rear = null;
    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        queue.enqueue("Jim");
        queue.enqueue("Joe");
        queue.enqueue("Johnathan");

        for(int i =0; i < 4; i++){
            System.out.println(queue.dequeue());
        };

        queue.clear();
        for(int i =0; i < 4; i++){
            System.out.println(queue.dequeue());
        };
        System.out.println(queue.isEmpty());


    }



}
