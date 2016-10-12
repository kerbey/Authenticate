package DataStructure;

import Exceptions.QueueUnderflowException;
import Interface.QeueInterface;

/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class LLQueue<T> implements QeueInterface<T>
{//rear may be type LLNode
    LLNode<T> front ,rear, newNode, LLpointers;
    int numElements=0, size;
    public LLQueue()
    {
    }
    @Override
    public T dequeue() throws QueueUnderflowException {
        String list="";
        if(isEmpty()) {
            throw new QueueUnderflowException("LLQueue is empty");
            //front=newNode;
            //rear=front;
            //System.out.println("rear=front="+rear.getElement());
        }
        else {
            LLNode<T> current = rear;
            //while (current != null) {
                list += current.getElement() + " ";
            rear = rear.getLink();
            System.out.println("removed list="+list);
            //}
            numElements--;
        }
        return (T) list;
    }

    @Override
    public boolean isEmpty()
    {
        return numElements==0;
    }

    @Override
    public void enqueue(T element)
    {
        for(int i=0;i<numElements;i++)
        {
            if(element==newNode.getElement())
                return;
            newNode=newNode.getLink();
        }
        newNode = new LLNode<T>(element);
        if(isEmpty()) {
            front=newNode;
            rear=front;
            System.out.println("rear=front="+rear.getElement());
        }
        else {
        newNode.setLink(rear);
        rear = newNode;
            System.out.println("rear="+rear.getElement());
        }
        numElements++;
    }
    @Override
    public String toString()
    {
        String list="";
        LLNode<T> current=rear;
        while (current!=null)
        {
            list+=current.getElement()+" ";
            current=current.getLink();
        }
        return list;
    }
    @Override
    public int size()
    {
        return numElements;
    }
}
