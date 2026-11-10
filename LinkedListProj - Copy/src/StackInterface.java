public interface StackInterface<T> {

    public void push(T newEntry);

    //Adds a new entry to the top of the stack

    public T pop();

    // Removes an entry from the top of the stack and displays;

    public T peek();

    // Views the top entry on the stack without removing it

    public boolean isEmpty();

    // returns true if the stack is empty, false if not

    public void clear();

    //removes all data entries from the stack;

}
