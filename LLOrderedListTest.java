package Test;

import DataStructure.LLOrderedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/9/16.
 */
public class LLOrderedListTest
{
    LLOrderedList<String> list= new LLOrderedList<String>();
    @Test
    public void add() throws Exception {
        list.add("sd");
        list.add("sd");
        list.add( "f");
        list.add( "ggg");
        Assert.assertEquals("expected f ggg sd ","f ggg sd ",list.toString());
        System.out.println(list.toString());
        System.out.println("");
    }
    @Test
    public void ToString() throws Exception {
        System.out.println("To String test");
        list.add("45");
        list.add("42");
        list.add("46");
        Assert.assertEquals("expected 42 45 46 ","42 45 46 ",list.toString());
        //Assert.assertEquals("expected 46 42 45 ","46 42 45 ",list.toString());
        System.out.println("list="+list);//list prints with or without tostring
    }
    @Test
    public void remove() throws Exception {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected f ggg sd ","f ggg sd ",list.toString());
        System.out.println("list before change "+list.toString());
        System.out.println();
        Assert.assertEquals("expected ggg","ggg",list.remove("ggg"));
        System.out.println("list after change "+list.toString());
        Assert.assertEquals("expected String doesn't exist","String doesn't exist",list.remove("gtyfd"));
        System.out.println("list after second change "+list.toString());
    }

    @Test
    public void contains() throws Exception {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        System.out.println();
        Assert.assertEquals("expected "+true,true,list.contains("ggg"));
        Assert.assertEquals("expected "+true,true,list.contains("f"));
        Assert.assertEquals("expected "+true,true,list.contains("sd"));
        Assert.assertEquals("expected "+false,false,list.contains("asjdfks;kds"));
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals("expected "+true,true,list.isEmpty());
        System.out.print("list ="+list.toString());
    }

    @Test
    public void size() throws Exception {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected "+3,3,list.size());
    }

    @Test
    public void get() throws Exception {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected ggg","ggg",list.get("ggg"));
        Assert.assertEquals("expected f","f",list.get("f"));
        Assert.assertEquals("expected sd","sd",list.get("sd"));
        System.out.println(list.toString());
    }
    @Test
    public void reset()
    {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected f ggg sd ","f ggg sd ",list.toString());
        list.reset();
        Assert.assertEquals("expected f","f",list.toString());
    }

    @Test
    public void getNext()
    {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected f ggg sd ","f ggg sd ",list.toString());
        //System.out.println(list.toString());
        list.getNext("f");
        Assert.assertEquals("expected "+true,true,list.hasNext("f"));
    }

    @Test
    public void hasNext()
    {
        list.add("sd");
        list.add("f");
        list.add("ggg");
        Assert.assertEquals("expected f ggg sd ","f ggg sd ",list.toString());
        System.out.print(list.toString());
        list.hasNext("f");
        Assert.assertEquals("expected "+ true,true,list.hasNext("f"));
    }
}