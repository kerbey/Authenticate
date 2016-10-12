package Test;

import DataStructure.ArrayQueue;
import Exceptions.QueueUnderflowException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/10/16.
 */
public class ArrayQueueTest {
    ArrayQueue<String> list= new ArrayQueue<String>(1);
    @Test
    public void dequeue() throws Exception, QueueUnderflowException {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        System.out.println(list);
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        Assert.assertEquals("expected c","c",list.dequeue());
        System.out.println(list);
    }

    @Test
    public void isEmpty() throws Exception {

        Assert.assertEquals("expected "+true,true,list.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        list.enqueue("a");
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        System.out.println(list);
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals("expected "+-1,-1,list.size());
    }

    @Test
    public void isFull() throws Exception {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        Assert.assertEquals("expected "+false,false,list.isFull());
    }

    @Test
    public void ToString() throws Exception {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        System.out.println(list);
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
    }

}