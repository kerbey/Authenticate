package DataStructure;

import Exceptions.QueueUnderflowException;
import Interface.QeueInterface;
/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class ArrayQueue<T> implements QeueInterface<T> {

    protected final int DEFCAP = 100; // default capacity
    protected T[] queue;
    protected int numElements = -1;
    
    public ArrayQueue()
    //array that holds queue elements number of elements in the queue index of front of queue index of rear of queue
    {
        queue = (T[]) new Object[DEFCAP];
        //rear =  DEFCAP - 1;
    }
    public ArrayQueue(int maxSize)
    {
        queue = (T[]) new Object[maxSize];
        //rear =  maxSize - 1;
    }

    @Override
    public T dequeue() throws QueueUnderflowException
    // Throws QueueUnderflowException if this queue is empty,
// otherwise removes front element from this queue and returns it.
    {
        if (isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        else
        {
            T toReturn = queue[numElements];
            queue[numElements] = null;
            //front = (front + 1) % queue.length;
            numElements--;
            return toReturn;
        }
    }

    @Override
    public boolean isEmpty()
    // Returns true if this queue is empty, otherwise returns false
    {
        return (numElements == -1);
    }
    @Override
    public void enqueue(T element) //throws QueueOverflowException
    // Throws QueueOverflowException if this queue is full,
// otherwise adds element to the rear of this queue.
    {
        System.out.println("enqueue method");
        for(int i=0;i<queue.length;i++)
        {
            if(element==queue[i])
                return;
        }
        numElements++;
        if (isFull()){

            System.out.println(queue.length+"=queuelength ,numElements="+numElements);
                enlarge();
            System.out.println("is not full and will be adding "+element);
            queue[numElements] = element;
        }
        //throw new QueueOverflowException("Enqueue attempted on a full queue.");
        else
        {
            System.out.println("is not full and will be adding "+element);
            queue[numElements] = element;
        }
    }
    public void enlarge()
    {
        T[] larger = (T[]) new Object[queue.length + DEFCAP];
        // copy the contents from the smaller array into the larger array

        for (int i = 0; i < numElements; i++)
        {
             queue[i]=larger[i];
        }
        // update instance variables
        queue = larger;
    }
    @Override
    public int size() {
        return numElements;
    }
    public boolean isFull()
    // Returns true if this queue is full, otherwise returns false.
    {
        return (numElements == queue.length-1);
    }

    @Override
    public String toString() {
        String list="";
        for(int i=0;i<queue.length;i++)
        {
            if(queue[i]!=null)
            {
                list +=queue[i]+" ";
            }
        }
        return list;
    }
}
