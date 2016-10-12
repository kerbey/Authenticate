package Test;

import DataStructure.ArrayOrderedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/10/16.
 */
public class ArrayOrderedListTest {
    ArrayOrderedList<String> list= new ArrayOrderedList<String>();
    @Test
    public void add() throws Exception {
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("b");
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        System.out.println(list);
    }
    @Test
    public void isFull() throws Exception {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected "+false,false,list.isFull());
    }

    @Test
    public void remove() throws Exception {
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        Assert.assertEquals("expected "+null,null,list.remove("sa"));
        System.out.println(list);
    }

    @Test
    public void contains() throws Exception {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        Assert.assertEquals("expected "+true,true,list.contains("a"));
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals("expected "+true,true,list.isEmpty());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals("expected "+0,0,list.size());
    }

    @Test
    public void get() throws Exception {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        Assert.assertEquals("expected a","a",list.get("a"));
    }
    @Test
    public void reset() {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected a b c ","a b c ",list.toString());
        list.reset();
        Assert.assertEquals("expected c ","c ",list.toString());
    }
    @Test
    public void getNext()
    {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected "+null,null,list.getNext("c"));
    }

    @Test
    public void hasNext()
    {
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals("expected "+false,false,list.hasNext("c"));
    }
}
