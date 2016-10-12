package DataStructure;
import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;
import Interface.StackInterface;

/**
 * Created by kerbeychevalier on 9/23/16.
 */
public class Stack<T> implements StackInterface<T>
{
    public Stack() {
        stack = (T[]) new Object[defCap];
    }

    public Stack(int maxSize) {
        stack = (T[]) new Object[maxSize];
    }

    protected final int defCap = 100; // default capacity
    protected T[] stack;              // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    @Override
    public void Push(T element) throws StackOverflowException {
        System.out.println("push method");
        for(int i=0;i<stack.length;i++)
        {
            if(element==stack[i])
                return;
        }
        if (!isFull()){
            topIndex++;
            stack[topIndex] = element;
            //System.out.println("adding  " + stack[topIndex]);
        } else //{throw new StackOverflowException("Push attempted on a full stack.");}
            {System.out.println("Push attempted on a full stack.");}

    }
    @Override
    public void pop() throws StackUnderflowException{
        System.out.println("pop method");
        if (!isEmpty()) {
            System.out.println("removing  " + stack[topIndex]);
            stack[topIndex] = null;
            topIndex--;
        }
        else //{System.out.println("Pop attempted on an empty stack.");}
        {throw new StackUnderflowException("Pop attempted on an empty stack.");}
    }
    public boolean isFull()
// Returns true if this stack is full, otherwise returns false.
    {
        //System.out.println("isFUll method");
        if (topIndex == (stack.length - 1))
            return true;
        else
            return false;
    }
    @Override
    public T top() throws StackUnderflowException
// Throws StackUnderflowException if this stack is empty,
// otherwise returns top element from this stack.
    {
        System.out.println("top method");
        T topOfStack = null;
        if (!isEmpty())
            topOfStack = stack[topIndex];
        else//{System.out.println("Top attempted on an empty stack.");}
            throw new StackUnderflowException("Top attempted on an empty stack.");
        return topOfStack;
    }

    @Override
    public boolean isEmpty() {
        System.out.println("isEmpty");
        if (topIndex == -1)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return topIndex+1;
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
        //System.out.println("list=="+list);
       return list;
    }
}
