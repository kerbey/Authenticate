package Exceptions;

/**
 * Created by kerbeychevalier on 10/5/16.
 */
public class StackOverflowException extends Throwable {
    public StackOverflowException()
    {super();}
    public StackOverflowException(String s)
    {System.out.println("string s says "+s);
    }
}
