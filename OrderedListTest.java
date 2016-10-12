package Test;

import DataStructure.OrderedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/2/16.
 */
public class OrderedListTest {
    OrderedList<String> list= new OrderedList<String>(2);
    @Test
    public void ToString() throws Exception {
        System.out.println("To String test");
        list.add("45");
        list.add("42");
        list.add("46");
        Assert.assertEquals("expected 42 45 46 ","42 45 46 ",list.toString());
        //spaces at the end are needed or will crash
        System.out.println("list="+list);//list prints with or without tostring
    }

    @Test
    public void add() throws Exception {
        System.out.println("add test");
        list.add("45");
        list.add("45");
        list.add("42");
        list.add("46");
        Assert.assertEquals("expected 42 45 46 ","42 45 46 ",list.toString());
        System.out.println("list="+list);//list prints with or without tostring
    }

    @Test
    public void remove() throws Exception {
        System.out.println("remove test");
        list.add("45");
        list.add("42");
        list.add("46");
        Assert.assertEquals("expected 42 45 46 ","42 45 46 ",list.toString());

        System.out.println("list before remove="+list);//list prints with or without tostring

        list.remove("45");
        list.remove("42");
        Assert.assertEquals("expected 46 ","46 ",list.toString());

        System.out.println("list after remove="+list);//list prints with or without tostring
    }

    @Test
    public void contains() throws Exception {
        System.out.println("contains test");
        list.add("45");
        list.add("42");
        list.add("46");
        Assert.assertEquals("expected "+true,true,list.contains("46"));
        Assert.assertEquals("expected "+true,true,list.contains("42"));
        Assert.assertEquals("expected "+true,true,list.contains("45"));
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println("isEmpty test");
        list.add("67");
        list.add("64");
        list.add("23");
        Boolean answer= list.isEmpty();
        Assert.assertEquals("expected"+false,false,answer);
        System.out.println("empty method says "+answer);//list prints with or without tostring
    }

    @Test
    public void size() throws Exception {
        System.out.println("size test");
        list.add("67");
        list.add("64");
        list.add("23");
        //Assert.assertFalse(list.size());//this fails unless queue isnt empty
        Assert.assertEquals("expected "+3, 3,list.size());
        System.out.println("size method says "+list.size());
    }

    @Test
    public void get() throws Exception {
        System.out.println("get test");
        //check this and reset method
        list.add("67");
        list.add("64");
        list.add("23");
        //Assert.assertFalse(list.size());//this fails unless queue isnt empty
        Assert.assertEquals("expected 67", "67",list.get("67"));
        System.out.println("after get method "+list.get("67"));
    }

    @Test
    public void reset() throws Exception {
        System.out.println("reset test");
        //set in numeerical order and current element should be first
        //choose clas to create list of usernames
        list.add("67");
        list.add("64");
        list.add("23");
        System.out.println(list.toString());
        list.reset();
        Assert.assertEquals("expected 67 ","67 ",list.toString());
        System.out.println(list.toString());
    }

    @Test
    public void getNext() throws Exception
    {
        System.out.println("getNext test");
        list.add("67");
        list.add("64");
        list.add("23");
        System.out.println(list.toString());
        //String s = list.getNext("23");
        Assert.assertEquals("expected 64","64",list.getNext("23"));
       // System.out.println("returning "+s);
    }

    @Test
    public void hasNext() throws Exception {
        System.out.println("hasnext test");
        list.add("67");
        list.add("64");
        list.add("23");
        Boolean s = list.hasNext("23");
        System.out.println("returning "+list);
        Assert.assertEquals("expected "+true,true,s);

    }
}