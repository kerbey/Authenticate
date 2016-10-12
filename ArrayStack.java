package DataStructure;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;
import Interface.StackInterface;

/**
 * Created by kerbeychevalier on 10/7/16.
 */
public class ArrayStack<T> implements StackInterface<T> {

    public ArrayStack()
    {
        stack = (T[]) new Object[defCap];
    }
    public ArrayStack(int maxSize)
    {
        stack = (T[]) new Object[maxSize];
    }
    protected final int defCap = 100;
    protected T[] stack;
    int size=-1;

    @Override
    public void Push(T element) throws StackOverflowException {
        for(int i=0;i<stack.length;i++)
        {
            if(element==stack[i])
                return;
        }
        System.out.println(size+"=size stacklength-1 ="+(stack.length-1));
        if(isFull())
        {
            enlarge();
            size++;
            stack[size] = element;
        }
        else {
            size++;
            stack[size] = element;
        }
        System.out.println("stack now has added "+stack[size]);
    }

    @Override
    public void pop() throws StackUnderflowException {
        if(isEmpty())
        {
            throw new StackUnderflowException("empty stack");
        }
        else {
            stack[size] = null;
            size--;
        }
    }

    @Override
    public T top() throws StackUnderflowException {
        System.out.println("top method");
        T topOfStack = null;
        if(!isEmpty())
            topOfStack= stack[size];
        else
            throw new StackUnderflowException("empty stack");
        return topOfStack;
    }

    @Override
    public boolean isEmpty()
    {
        return size==-1;
    }

    @Override
    public int size()
    {
        return size+1;
    }
    private boolean isFull()
    {
        return size==stack.length-1;
    }
    private void enlarge()
    {
        System.out.println("enlarge");
        // create the larger array
        T[] larger = (T[]) new Object[stack.length +100];
        // copy the contents from the smaller array into the larger array
        for (int i = 0; i < stack.length; i++)
        {
            larger[i] = stack[i];
        }
        // update instance variables
        stack = larger;
    }
    @Override
    public String toString()
    {
        //System.out.println("toString method");
        String list="";
        for(int i=0;i<stack.length;i++)
        {
            if(stack[i]!=null)
            {
                list+= stack[i]+" ";
            }
        }
        return list;
    }
}
