package DataStructure;

import Interface.ListInterface;

/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class ArrayIndexedList<T> implements ListInterface<T>
{
    protected final int DEFCAP = 100; // default capacity
    protected T[] ArrayIndex;
    protected int numElements = -1;

    public ArrayIndexedList()
    {
        ArrayIndex = (T[]) new Object[DEFCAP];
    }
    public ArrayIndexedList(int maxSize)
    {
        ArrayIndex = (T[]) new Object[maxSize];
    }

    @Override
    public void add(T element) {
        System.out.println("enqueue method");
        for(int i=0;i<ArrayIndex.length;i++)
        {
            if(element==ArrayIndex[i])
                return;
        }
        numElements++;
        //if full goes to enlarge method to increase size
        if (isFull()) {
            System.out.println(ArrayIndex.length+"=queuelength ,numElements="+numElements);
            enlarge();
            System.out.println("is not full and will be adding "+element);
            ArrayIndex[numElements] = element;
        }
        //if not full just add to array
        else
        {
            System.out.println("is not full and will be adding "+element);
            ArrayIndex[numElements] = element;
        }
    }
    public void enlarge()
    {
        T[] larger = (T[]) new Object[ArrayIndex.length + DEFCAP];
        // copy the contents from the smaller array into the larger array

        for (int i = 0; i < numElements; i++)
        {
            ArrayIndex[i]=larger[i];
        }
        // update instance variables by making new array = old one
        ArrayIndex = larger;
    }
    @Override
    public T remove(T element)
    {
        for(int i=0;i<ArrayIndex.length;i++)
        {//for loop goes through array until it sees element and deletes it
            if(ArrayIndex[i]==(element))
            {
                //list +=ArrayIndex[i]+" ";
                ArrayIndex[i]=null;
                return ArrayIndex[i];
            }
        }
        return (T) "nothing to remove";
    }

    @Override
    public T get(T element)
    {
        for(int i=0;i<ArrayIndex.length;i++)
        {//for loop goes through array until it sees element and returns it
            if(ArrayIndex[i]==element)
            {
                //list +=ArrayIndex[i]+" ";
                return ArrayIndex[i];
            }
        }
        return null;
    }


    @Override
    public boolean contains(T element)
    {
        for(int i=0;i<ArrayIndex.length;i++)
        {//for loop goes through array until it sees element and returns true if found
            if(ArrayIndex[i]==(element))
            {
                //list +=ArrayIndex[i]+" ";
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        if(numElements==-1)
            return true;
        else
            return false;
        //return numElements==-1;
    }

    public boolean isFull() {
        return numElements==ArrayIndex.length-1;
    }
    @Override
    public String toString() {
        String list="";
        for(int i=0;i<ArrayIndex.length;i++)
        {
            if(ArrayIndex[i]!=null)
            {
                list +=ArrayIndex[i]+" ";
            }
        }
        return list;
    }
    @Override
    public int size() {
        return numElements+1;
    }

    @Override
    public void reset() {
        ArrayIndex[0]=ArrayIndex[numElements];
        for(int i=1;i<ArrayIndex.length;i++)
        {
            ArrayIndex[i]=null;
        }
    }

    @Override
    public T getNext(T element) {
        for(int i=0;i<ArrayIndex.length;i++)
        {
            if(ArrayIndex[i]==element)
            {
                if(hasNext(ArrayIndex[i])==true)
                    return ArrayIndex[i+1];
            }
        }
        return null;
    }

    @Override
    public boolean hasNext(T element) {
        for(int i=0;i<ArrayIndex.length;i++)
        {
            if(ArrayIndex[i]==element)
            {
                if(ArrayIndex[i+1]!=null)
                    return true;//ArrayIndex[i+1]!=null;
            }
        }
        return false;
    }
}