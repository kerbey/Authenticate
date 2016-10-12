package Test;
import DataStructure.ArrayStack;
import Exceptions.StackOverflowException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/8/16.
 */
public class ArrayStackTest {
    ArrayStack<String> list= new ArrayStack<String>(2);
    @Test
    public void push() throws Exception, StackOverflowException {
        list.Push("j");
        list.Push("j");
        list.Push("a");
        list.Push("s");
        list.Push("d");
        System.out.println(list);
        Assert.assertEquals("expected j a s d ","j a s d ",list.toString());
    }

    @Test
    public void pop() throws Exception, StackOverflowException {
        list.Push("j");
        list.Push("a");
        list.Push("s");
        list.Push("d");
        Assert.assertEquals("expected j a s d ","j a s d ",list.toString());
        list.pop();
        Assert.assertEquals("expected j a s ","j a s ",list.toString());
    }

    @Test
    public void top() throws Exception, StackOverflowException {
        list.Push("j");
        list.Push("a");
        list.Push("s");
        list.Push("d");
        //list.top();
        Assert.assertEquals("expected d","d",list.top());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals("expected "+true,true,list.isEmpty());
    }

    @Test
    public void size() throws Exception, StackOverflowException {
        list.Push("j");
        list.Push("a");
        list.Push("s");
        list.Push("d");
        //list.top();
        Assert.assertEquals("expected "+4,4,list.size());
    }

}