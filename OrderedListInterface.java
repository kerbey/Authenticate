package Interface;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public interface OrderedListInterface<T> {
    //Ordered List add, remove, contains, isEmpty, size, get, toString, reset, getNext, hasNext
    void add(T element);
    //T get(int index);
    boolean remove(T element) ;//throws EmptyListException;
    boolean contains(T element);
    boolean isEmpty();
    int size();
    T get(T element);
    String toString();
    void reset();
    T getNext(T element);
    boolean hasNext(T element);
}
