package DataStructure;

import Interface.IndexedListInterface;

/**
 * Created by kerbeychevalier on 10/1/16.
 */
public class indexedList<T> implements IndexedListInterface<T>
{
    protected int maxSize=0;
    protected T[] indexList;
    protected int numElements = 0;
    int place=0;

    public indexedList(int size)
    {
        maxSize=size;
        indexList = (T[]) new Object[maxSize];
    }
    @Override
    public void add(int index, T element) {
        for(int i=0;i<indexList.length;i++)
        {
            if(element==indexList[i])
                return;
        }
        if(numElements<indexList.length || index<indexList.length) {
            numElements++;
            indexList[index] = element;
            System.out.println("number of elements in array="+numElements);
            System.out.println("now adding==" + indexList[index]);
        }
        else if(numElements>=indexList.length || index>=indexList.length)
        {}
    }
    @Override
    public String toString()
    {
        String list="";
        for(int i=0;i<indexList.length;i++)
        {
            if(indexList[i]!=null)
            {
                list+=indexList[i]+" ";
            }
        }
        return list;
    }
    @Override
    public void set(int index, T element)
    {
        indexList[index]=element;
        System.out.println("now setting ="+indexList[index]);
    }

    @Override
    public T remove(int index)
    {
        if(!isEmpty())//if something is there then it can be removed
        {
            indexList[index] = null;
            numElements--;
            System.out.println("now removing =" + indexList[index]);
        }
        return indexList[index];
    }

    @Override
    public T get(int index)
    {
        return indexList[index];
    }

    @Override
    public int IndexOf(T element)
    {
        for(int i=0;i<indexList.length;i++)
            if(indexList[i]==element)
                return i;

        return -1;
    }
//above methods are different posssibly
    @Override
    public boolean contains(T element)
    {
        System.out.println("contains method");
        for(int i=0;i<indexList.length;i++)
        {
            if(indexList[i]==element)
            {
                return true;
            }
        }
        return false;
//        current=LLpinters;
//        while(current!=null)
//        {
//            System.out.println("current="+current.getElement());
//            if(element.equals(current.getElement()))
//            {
//                System.out.println(element+"=current="+current.getElement());
//                found=true;
//                break;
//            }
//            current=current.getLink();
//        }
//        return found;
    }

    @Override
    public boolean isEmpty()
    {
        for(int i=0;i<indexList.length;i++)
        {
            if(indexList[i]==null)//if nothing is found in array it's empty
            {}//and will return true at the end
            else if(indexList[i]!=null)
            {//if it finds at least one element return false
                return false;
            }
        }
       return true;//(numElements==0);
    }

    @Override
    public int size()
    {
        return maxSize;
    }

    @Override
    public T reset() {
        indexList[0]=indexList[maxSize-1];
        for(int i=1;i<indexList.length;i++)
        {
            indexList[i]=null;
        }
        return (indexList[0]);
    }

    @Override
    public T getNext(T element) {
//return returnElement;
        //System.out.println("getLink==="+(T) LLpointers.getLink());
//        System.out.println("getNext method newNode=="+newNode.getElement());
//        if(hasNext(element)==true)
//            return (T) LLpointers.getLink();
//        else

        for(int i=0;i<indexList.length;i++)
        {
            if(element==indexList[i])
            {
                place=i;
                i=indexList.length;
            }
        }
        //System.out.println("getNext method element "+indexList[place]);
        if(hasNext(indexList[place])==true)
            return indexList[place+1];
        else
            return null;
    }

    @Override
    public boolean hasNext(T element) {
//        System.out.println("hasNext method");
//        if(newNode.getLink()==null) {
//            System.out.println("there's no next element");
//            return false;}
        System.out.println("hasNext ");
        if((indexList[place+1])==null)
            return false;
        else
            return true;
    }
}