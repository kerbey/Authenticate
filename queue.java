package DataStructure;

import Exceptions.QueueOverflowException;
import Exceptions.QueueUnderflowException;
import Interface.QeueInterface;

/**
 * Created by kerbeychevalier on 9/26/16.
 */
public class queue<T> implements QeueInterface<T>
{
    protected final int DEFCAP = 100; // default capacity
    protected T[] queue;
    protected int numElements = 0;
    protected int front = 0;
    protected int rear;
    public queue()
    //array that holds queue elements number of elements in the queue index of front of queue index of rear of queue
    {
        queue = (T[]) new Object[DEFCAP];
        rear =  DEFCAP - 1;
    }
    public queue(int maxSize)
    {
        queue = (T[]) new Object[maxSize];
        rear =  maxSize - 1;
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
            T toReturn = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            numElements = numElements - 1;
            return toReturn;
        }
    }

    @Override
    public boolean isEmpty()
    // Returns true if this queue is empty, otherwise returns false
    {
        return (numElements == 0);
    }
    @Override
    public void enqueue(T element) throws QueueOverflowException
    // Throws QueueOverflowException if this queue is full,
// otherwise adds element to the rear of this queue.
    {
        for(int i=0;i<queue.length;i++)
        {
            if(element==queue[i])
                return;
        }
        System.out.println("enqueue method");
        if (isFull())//{}
            throw new QueueOverflowException("Enqueue attempted on a full queue.");
        else
        {
            System.out.println("is not full and will be adding "+element);
            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            numElements = numElements + 1;
        }
    }
    @Override
    public int size() {
        return numElements;
    }
    public boolean isFull()
// Returns true if this queue is full, otherwise returns false.
    {
        return (numElements == queue.length);
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