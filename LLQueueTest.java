package Test;
import DataStructure.LLQueue;
import Exceptions.QueueUnderflowException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/10/16.
 */
public class LLQueueTest {
    LLQueue<String> list= new LLQueue<String>();
    @Test
    public void dequeue() throws Exception, QueueUnderflowException {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        //list.enqueue("d");
        System.out.println("list is "+list.toString());
        list.dequeue();
        Assert.assertEquals("expected b a ","b a ",list.toString());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals("expected "+true,true,list.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("b");
        list.enqueue("c");
        //list.enqueue("d");
        System.out.print("list is "+list.toString());
        Assert.assertEquals("expected c b a ","c b a ",list.toString());
    }

    @Test
    public void ToString() throws Exception {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        //list.enqueue("d");
        System.out.print("list is "+list.toString());
        Assert.assertEquals("expected c b a ","c b a ",list.toString());
    }

    @Test
    public void size() throws Exception {
        list.enqueue("a");
        list.enqueue("b");
        list.enqueue("c");
        System.out.print("list is "+list.toString());
        Assert.assertEquals("expected "+3,3,list.size());
    }

}