package Interface;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public interface IndexedListInterface<T> {
    //Indexed List add, set, remove, IndexOf, contains, isEmpty, size, get, toString, reset, getNext, hasNext
    void add(int index, T element);
    void set(int index,T element);
    T remove(int index);
    T get(int index);
    int IndexOf(T element);
    boolean contains(T element);
    boolean isEmpty();
    int size();
    String toString();
    T reset();
    T getNext(T element);
    boolean hasNext(T element);
}