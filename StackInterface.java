package Interface;

import Exceptions.*;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public interface StackInterface<T> {
    //Stack:
    void Push(T element) throws Exceptions.StackOverflowException;
    void  pop() throws StackUnderflowException;
    T top() throws StackUnderflowException;
    boolean isEmpty();
    int size();
    String toString();
}
