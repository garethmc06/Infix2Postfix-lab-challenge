public class MyNode<T>{
    private T data;
    private MyNode<T> next;

    public MyNode(T dataValue){
        data = dataValue;
        next = null;
    }

    public T getData(){
        return data;
    }

    public void setData(T dataValue){
        data = dataValue;

    }

    public MyNode<T> getNext(){
        return next;

    }

    public void setNext(MyNode<T> nextNode){
        next = nextNode;

    }

    public static void main(String[] args){
        MyNode<String> node1 = new MyNode<>("A");
        MyNode<String> node2 = new MyNode<>("B");
        MyNode<String> node3 = new MyNode<>("C");

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(node1.getData());
        System.out.println(node1.getNext().getData());
        System.out.println(node1.getNext().getNext().getData());


    }


}