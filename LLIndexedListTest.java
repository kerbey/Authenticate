package Test;
import DataStructure.LLIndexedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kerbeychevalier on 10/8/16.
 */
public class LLIndexedListTest {
    LLIndexedList<String> list = new LLIndexedList<String>();
    @Test
    public void add() throws Exception {
        list.add(0, "sd");
        list.add(0, "sd");
        list.add(1, "sd");
        list.add(1, "f");
        list.add(2, "ggg");
        Assert.assertEquals("expected ggg f sd ","ggg f sd ",list.toString());
        System.out.println(list.toString());
        System.out.println("");
    }

    @Test
    public void set() throws Exception {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected ggg f sd ","ggg f sd ",list.toString());
        System.out.println("list before change "+list.toString());
        list.set(1,"sdfadf");
        Assert.assertEquals("expected ggg sdfadf sd ","ggg sdfadf sd ",list.toString());
        System.out.println("list after change "+list.toString());
    }

    @Test
    public void remove() throws Exception
    {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected ggg f sd ","ggg f sd ",list.toString());
        System.out.println("list before change "+list.toString());
        System.out.println();
        Assert.assertEquals("expected ggg","ggg",list.remove(2));
        System.out.println("list after change "+list.toString());
        Assert.assertEquals("expected String doesn't exist","String doesn't exist",list.remove(6));
        System.out.println("list after second change "+list.toString());
    }

    @Test
    public void get() throws Exception {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected ggg","ggg",list.get(2));
        Assert.assertEquals("expected f","f",list.get(1));
        Assert.assertEquals("expected sd","sd",list.get(0));
        //System.out.println(list.toString());
    }

    @Test
    public void indexOf() throws Exception
    {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected "+2,2,list.IndexOf("ggg"));
        Assert.assertEquals("expected "+1,1,list.IndexOf("f"));
        Assert.assertEquals("expected "+0,0,list.IndexOf("sd"));
        Assert.assertEquals("expected "+(-1),-1,list.IndexOf("aaaaa"));
    }

    @Test
    public void contains() throws Exception
    {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected "+true,true,list.contains("ggg"));
        Assert.assertEquals("expected "+true,true,list.contains("f"));
        Assert.assertEquals("expected "+true,true,list.contains("sd"));
        Assert.assertEquals("expected "+false,false,list.contains("asjdfks;kds"));
    }

    @Test
    public void isEmpty() throws Exception
    {
        Assert.assertEquals("expected "+true,true,list.isEmpty());
        System.out.print("list ="+list.toString());
    }

    @Test
    public void size() throws Exception {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected "+3,3,list.size());
    }

    @Test
    public void reset() throws Exception
    {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        System.out.println("list before reset is =="+list.toString());
        Assert.assertEquals("expected ggg","ggg",list.reset());
        System.out.println("list after reset is =="+list.toString());

    }

    @Test
    public void getNext() throws Exception {
        list.add(0,"sd");
        list.add(1,"f");
        list.add(2,"ggg");
        Assert.assertEquals("expected "+null,null,list.getNext("ggg"));
    }

    @Test
    public void hasNext() throws Exception {
        list.add(0, "sd");
        list.add(1, "f");
        list.add(2, "ggg");
        System.out.println(list);
        Assert.assertEquals("expected " + false, false, list.hasNext("ggg"));
    }

}
