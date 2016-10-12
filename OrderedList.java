package DataStructure;

import Interface.OrderedListInterface;

/**
 * Created by kerbeychevalier on 9/28/16.
 */
public class OrderedList<T extends Comparable> implements OrderedListInterface<T>, Comparable
{
    int numElements=0;
    public OrderedList() {
        list =new String[defCap];
    }
    public OrderedList(int maxSize) {
            list=new String[maxSize];
    }
    protected int defCap = 100; // default capacity
    public String[] list ;
    //int location = 0;
    protected int topIndex = -1;      // index of top element in stack
    @Override
    public String toString()
    {
        String List="";
        for(int i=0;i<list.length;i++)
        {
            if(list[i]!=null) {
                List += list[i] + " ";
            }
        }
        return List;
    }
    @Override
    public void add(T element) {
        System.out.println();
        //System.out.println(defCap+"==original defCap");
        for(int i=0;i<list.length;i++)
        {
            if(element==list[i])
                return;
        }
        System.out.println("add method ");
            String listElement="";
        int location = 0;
            if (numElements == list.length)
                enlarge();
            while (location < numElements)
            {
                //System.out.println(location+" location<numElements "+numElements);
                listElement = list[location];
                //System.out.println(listElement+" listElement & element are="+element);
                if (listElement!=null &&((Comparable)listElement).compareTo(element) < 0)
                {location++;}
                else
                    break;
            }
           // System.out.println(location+"=location and numElements="+numElements);
        //System.out.println(defCap+"==defCap location="+location);
            for (int index = numElements; index > location; index--)
            {
                list[index] = list[index - 1];
                    System.out.println("LIST FOR LOOP====== " + list[index]);
            }
            //System.out.println("list after for loop "+list[0]+" lenth of list="+list.length);
            list[location] = (String) element;
       // System.out.println(" adding location ="+list[location]);

            numElements++;
    }
    private void enlarge()
    {// create the larger array
        System.out.println("enlarge method ");
        String [] larger = new String[list.length + defCap];
        //System.out.println("new list length="+list.length);
        // copy the contents from the smaller array into the larger array
        int currSmaller = 0;
        for (int currLarger = 0; currLarger < numElements; currLarger++)
        {
            larger[currLarger] = list[currSmaller];
            //System.out.println("large r="+larger[currLarger]);
            currSmaller = (currSmaller + 1) % list.length;
            //System.out.println("currSmaller ="+currSmaller);
        }
        list=larger;
    }

    @Override
    public boolean remove(T element)// throws EmptyListException
    {
        System.out.println("remove method");
        if(isEmpty()){}
            //throw new EmptyListException("empty list");
        else{
        for(int i=0;i<list.length;i++)
        {
            if(element==list[i])
            {
                numElements--;
                list[i]=null;
                //System.out.println("list is now ="+list[i]);
                return true;
            }
        }
        }
        return false;
    }

    @Override
    public boolean contains(T element)
    {
        System.out.println("contains method");
        for(int i=0;i<list.length;i++)
        {
            if(element==list[i])
            {
                //System.out.println("list is now ="+list[i]);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty()
    {
        //System.out.println("is empty method ");
        return (numElements==0);
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public T get(T element) {
        for(int i=0;i<list.length;i++)
        {
            if(element==list[i])
            {
                //System.out.println("list is now ="+list[i]);
                return (T) list[i];
            }
        }
        return null;
    }

    @Override
    public void reset()
    {
        System.out.println("reset method "+numElements);
        {System.out.println("deleting "+list[numElements-1]);}
        for(int i=0;i<list.length;i++)
        {
            if(i==numElements-1)
            {}
            else
            {
                list[i]=null;
            }
        }
    }

    @Override
    public T getNext(T element) {//gets next link in list


//        System.out.println("getNext method newNode=="+newNode.getElement());
//        //System.out.println("after newNode=="+newNode.getLink().getElement());
        int place=0;
        for(int i=0;i<list.length;i++)
        {
            if (element==list[i])
            {
                place=i;
            }
        }
        if(hasNext(element)==true)
            return (T) list[place+1];
        else
            return null;
    }

    @Override
    public boolean hasNext(T element) {//if there is a next node return true if not return false.
        int place=0;
        for(int i=0;i<list.length;i++)
        {
            if(element==list[i])
            {
                place=i;
                break;
            }
        }
        if((list[place+1])==null)
            return false;
        else
            return true;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
