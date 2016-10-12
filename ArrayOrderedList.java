package DataStructure;

import Interface.ListInterface;

/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class ArrayOrderedList<T extends Comparable> implements ListInterface<T> {
    protected final int DEFCAP = 100; // default capacity
    protected String[] ArrayOrderIndex;
    protected int numElements = -1;

    public ArrayOrderedList()
    //array that holds queue elements number of elements in the queue index of front of queue index of rear of queue
    {
        ArrayOrderIndex =  new String[DEFCAP];
    }
    public ArrayOrderedList(int maxSize)
    {
        ArrayOrderIndex = new String[maxSize];
    }
    @Override
    public void add(T element) {
        System.out.println("add method");
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(element==ArrayOrderIndex[i])
                return;
        }
        numElements++;
        if (isFull()) {
            //System.out.println(ArrayOrderIndex.length+"=queuelength ,numElements="+numElements);
            enlarge();
            //System.out.println("is not full and will be adding "+element);
            ArrayOrderIndex[numElements] = (String) element;
        }
        else
        {
            //System.out.println("is not full and will be adding "+element);
            ArrayOrderIndex[numElements] = (String) element;
        }
        //nested forloop to arrage order
            for (int i = 0; i < ArrayOrderIndex.length; i++) {
                if (i == numElements)
                    break;
                for (int x = 0; x < ArrayOrderIndex.length; x++) {
                    if (x == numElements)
                        break;
                    System.out.println(i+"=i x="+x);
                    if (ArrayOrderIndex[i].compareTo(ArrayOrderIndex[x + 1]) >0) {
                        //if positive then order is incorrect and should be switched, negative order is wrong
                        //System.out.println(ArrayOrderIndex[i] + "=i  i+1=" + ArrayOrderIndex[i + 1]);
                        String change = ArrayOrderIndex[i];
                        ArrayOrderIndex[i] = ArrayOrderIndex[x + 1];
                        ArrayOrderIndex[x + 1] = change;
                        //System.out.println(ArrayOrderIndex[i] + "=i  i+1=" + ArrayOrderIndex[i + 1]);
                    }
                }
            }
    }
    public void enlarge()
    {
        String[] larger =  new String [ArrayOrderIndex.length + DEFCAP];
        // copy the contents from the smaller array into the larger array

        for (int i = 0; i < numElements; i++)
        {
            ArrayOrderIndex[i]=larger[i];
        }
        // update instance variables
        ArrayOrderIndex = larger;
    }
    public boolean isFull() {
        return numElements==ArrayOrderIndex.length-1;
    }
    @Override
    public T remove(T element) {
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]==(element))
            {
                //list +=ArrayIndex[i]+" ";
                String list=ArrayOrderIndex[i];
                System.out.println("list=="+list);
                ArrayOrderIndex[i]=null;
                return (T) list;
            }
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]==(element))
            {
                //list +=ArrayIndex[i]+" ";
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numElements==-1;
    }

    @Override
    public int size() {
        return numElements+1;
    }

    @Override
    public T get(T element) {
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]==element)
            {//list +=ArrayIndex[i]+" ";
                return (T) ArrayOrderIndex[i];
            }
        }
        return null;
    }
    public String toString() {
        String list="";
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]!=null)
            {
                list +=ArrayOrderIndex[i]+" ";
            }
        }
        return list;
    }

    @Override
    public void reset() {
        System.out.println("reset method");
        ArrayOrderIndex[0]=ArrayOrderIndex[numElements];
        for(int i=1;i<ArrayOrderIndex.length;i++)
        {
            ArrayOrderIndex[i]=null;
        }
    }

    @Override
    public T getNext(T element) {
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]==element)
            {
                if(hasNext((T) ArrayOrderIndex[i])==true)
                    return (T) ArrayOrderIndex[i+1];
            }
        }
        return null;
    }

    @Override
    public boolean hasNext(T element) {
        for(int i=0;i<ArrayOrderIndex.length;i++)
        {
            if(ArrayOrderIndex[i]==element)
            {
                if(ArrayOrderIndex[i+1]!=null)
                    return true;
            }
        }
        return false;
    }
}
