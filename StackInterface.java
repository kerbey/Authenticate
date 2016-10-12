package Interface;

import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public interface StackInterface<T> {
    //Stack:
    void Push(T element) throws StackOverflowException;
    void  pop() throws StackUnderflowException;
    T top() throws StackUnderflowException;
    boolean isEmpty();
    int size();
    String toString();
}