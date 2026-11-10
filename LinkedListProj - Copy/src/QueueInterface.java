public interface QueueInterface<T> {


    public void enqueue(T newEntry);
//Adds to the back of the queue
    public T dequeue();
// Removes from the front of the queue
    public T getFront();
// Checks the front of the queue but does not remove it
    public boolean isEmpty();
// Checks if the queue has not entries
    public void clear();
// Clears all entries in the queue

}
