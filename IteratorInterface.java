package Interface;

/**
 * Created by kerbeychevalier on 10/11/16.
 */
public interface IteratorInterface<T>{
    void reset();
    T getNext(T element);
    boolean hasNext(T element);
}
