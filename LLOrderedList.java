package DataStructure;

import Interface.ListInterface;
//Use this class to connect to assingment 1
/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class LLOrderedList<T extends Comparable> implements ListInterface<T> {
    LLNode<T>  newNode, LLpointers, current, previous;
    int numElements=0;
    public LLOrderedList()
    {
        LLpointers=null;
    }
    @Override
    public void add(T element) {
        for(int i=0;i<numElements;i++)
        {
            if(element==newNode.getElement())
                return;
            newNode=newNode.getLink();
        }
        newNode = new LLNode<T>(element);
        newNode.setIndex((T) ("" + numElements));
        //System.out.println("new node, "+newNode.getElement()+" now has the new element");
        if(isEmpty()==true)
        {
            LLpointers=newNode;
            //System.out.println("first added LLPointers=="+LLpointers.getElement());
        }
        else
        {
            //System.out.println("not empty pointer is "+LLpointers.getElement());
            current=LLpointers;
            previous=LLpointers;
            while(current!=null)
            {//while loop to go through list
                //System.out.println("current=="+current.getElement());
                if(element.compareTo(current.getElement())<0)
                {//checks to see if passed in element is less than current
                    //System.out.println(element+" element < current "+current.getElement());
                    if(LLpointers.equals(current))
                    {//pointer and current are equal so the newest element is placed in front
                        //System.out.println(LLpointers.getElement()+" pointer == current "+current.getElement());
                        //System.out.println("newnode, "+newNode.getElement()+", will now be set to a pointer");
                        LLpointers=newNode;
                        //System.out.println(LLpointers.getElement()+" pointer == newNode "+newNode.getElement());
                    }
                    else
                    {
                        //System.out.println(LLpointers.getElement()+" pointer notequals current "+current.getElement());
                        previous.setLink(newNode);
                        //System.out.println("pointer gets new node "+previous.getElement());
                    }
                    newNode.setLink(current);
                    break;
                }
                previous=current;
                current=current.getLink();
            }
            if(current==null)
            {//if newest element isn't less than anything on the list its moved to the back
                //System.out.println("current has nothing");
                //System.out.println("adds new node, "+newNode.getElement()+" to previous");
                previous.setLink(newNode);
                //System.out.println("previous=="+previous.getElement());
            }
        }
        numElements++;
//
    }
    @Override
    public String toString()
    {
        LLNode<T> current=LLpointers;
        String list="";
        //for(int i=numElements;i>=1;i--)
        for(int i=0;i<numElements;i++)
        {
            System.out.println("list="+list);
            list+=current.getElement()+" ";
            current=current.getLink();
        }
        return list;
    }
    @Override
    public T remove(T element) {
        System.out.println("remove method");
        LLNode<T> current=LLpointers;
        while (current!=null)
        {//while loop for current to look at element and its number
            int s=Integer.parseInt((String) current.getIndex());
            //System.out.println("current =="+current.getElement());
            //System.out.println("and its index =="+current.getIndex());
            if (element==current.getElement())//index)
            {
                numElements--;
                System.out.println("found "+current.getElement());
                LLpointers=LLpointers.getLink();
                System.out.println("changing it to "+current.getElement());
                return current.getElement();
            }
            current=current.getLink();
        }
        return (T)"String doesn't exist";
    }

    @Override
    public boolean contains(T element)
    {
        System.out.println("IndexOf method");
        LLNode<T> current=LLpointers;
        while (current!=null)
        {//while loop for current to look at element and its number
            if (current.getElement()==element)//when element is found return its number
            {
                System.out.println(current.getElement()+"="+element);
                return true;
            }
            current=current.getLink();
        }
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return numElements==0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public T get(T elmement) {
        System.out.println("get method");
        LLNode<T> current=LLpointers;
        while (current!=null)
        {//while loop for current to look at element and its number
            int s=Integer.parseInt((String) current.getIndex());
            System.out.println("current =="+current.getElement());
            System.out.println("and its index =="+current.getIndex());
            if (elmement==current.getElement())//index)
            {
                System.out.println("found "+current.getElement()+"==");
                return current.getElement();
            }
            current=current.getLink();
        }
        return null;
    }

    @Override
    public void reset()
    {
        LLNode<T> current=LLpointers;
        T top= (T) current.getElement();//store recenet element to be put back into list
        for(int i=1;i<=numElements;i++)
        {//while loop for current to get erased
            current=current.getLink();
            numElements--;
        }
        current.setElement(top);
    }

    @Override
    public T getNext(T element)
    {
        LLNode<T> current=LLpointers;
        for(int i=0;i<numElements;i++)
        {
            if(current.getElement()==element)
            {
                if(hasNext(current.getElement())==true)
                {
                    return current.getLink().getElement();
                }
            }
            current=current.getLink();
        }
        return null;
    }

    @Override
    public boolean hasNext(T element)
    {
        LLNode<T> current=LLpointers;
        for(int i=0;i<numElements;i++)
        {
            if(current.getElement()==element)
            {
                if(current.getLink().getElement()!=null)
                {
                    return true;
                }
            }
            current=current.getLink();
        }
        return false;
    }
}