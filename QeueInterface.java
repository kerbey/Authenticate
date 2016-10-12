package Interface;

import Exceptions.QueueOverflowException;
import Exceptions.QueueUnderflowException;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public interface QeueInterface<T> {
    T dequeue() throws QueueUnderflowException;
    // Throws QueueUnderflowException if this queue is empty,
    // otherwise removes front element from this queue and returns it.
    boolean isEmpty();
    // Returns true if this queue is empty, otherwise returns false.
    void enqueue(T element) throws QueueOverflowException;// throws QueueOverflowException;
    // Throws QueueOverflowException if this queue is full,
    // otherwise adds element to the rear of this queue.
    //boolean isFull();
    // Returns true if this queue is full, otherwise returns false.
    String toString();
    int size();
}
