public interface PQueueInterface <T> {

    public void enqueue (T newEntry);
    // Adds the entry of the highest priority to the front of the queue

    public T dequeue();
    // Removes and returns the entry of the front of the queue

    public T getFront();
    // Returns the entry at the front of the queue.

    public boolean isEmpty();
    // Returns true if the queue is empty else, false.

    public void clear();
    // Removes all entries within the queue

}
