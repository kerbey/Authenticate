package Test;

import Exceptions.QueueOverflowException;
import Exceptions.QueueUnderflowException;
import DataStructure.queue;
import org.junit.Assert;

/**
 * Created by kerbeychevalier on 10/1/16.
 */
public class queueTest {
    queue<String> list= new queue<String>();
    @org.junit.Test
    public void dequeue() throws Exception, QueueUnderflowException, QueueOverflowException {
        System.out.println("dequeue test");
        list.enqueue("67");
        list.enqueue("64");
        list.enqueue("23");
        Assert.assertEquals("expected 67 64 23 ","67 64 23 ",list.toString());
        //spaces at the end are needed or will crash
        System.out.println("list before removal="+list);//list prints with or without tostring
        list.dequeue();
        Assert.assertEquals("expected 64 23 ","64 23 ",list.toString());
        System.out.println("list after removal="+list);
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        System.out.println("isEmpty test");
        //Assert.assertFalse(list.isEmpty());//this fails unless queue isnt empty
        Boolean answer=list.isEmpty();
        Assert.assertEquals("expected "+true ,true ,answer);
        System.out.println("empty method says "+answer);
    }

    @org.junit.Test
    public void enqueue() throws Exception, QueueOverflowException {
        System.out.println("enqueue test");
        list.enqueue("67");
        list.enqueue("67");
        list.enqueue("64");
        list.enqueue("23");
        Assert.assertEquals("expected 67 64 23 ","67 64 23 ",list.toString());
        //spaces at the end are needed or will crash
        System.out.println(list);//list prints with or without tostring
    }

    @org.junit.Test
    public void size() throws Exception, QueueOverflowException {
        System.out.println("size test");
        list.enqueue("67");
        list.enqueue("64");
        list.enqueue("23");
        //Assert.assertFalse(list.size());//this fails unless queue isnt empty
        Assert.assertEquals("expected "+3,3,list.size());
        System.out.println("size method says "+list.size());
    }

    @org.junit.Test
    public void isFull() throws Exception, QueueOverflowException {
        System.out.println("full test");
        list.enqueue("67");
        list.enqueue("64");
        list.enqueue("23");
        list.isFull();
        Assert.assertEquals("expected 67 64 23 ","67 64 23 ",list.toString());
        System.out.println("isFull method's answer is "+list.isFull());
    }

    @org.junit.Test
    public void ToString() throws QueueOverflowException// throws Exception
    {
        System.out.println("ToString test");
        list.enqueue("67");
        list.enqueue("64");
        list.enqueue("23");
        Assert.assertEquals("expected 67 64 23 ","67 64 23 ",list.toString());
        System.out.println("toString method's answer is "+list.toString());
    }
}