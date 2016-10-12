package Exceptions;

/**
 * Created by kerbeychevalier on 9/30/16.
 */
public class EmptyListException extends Throwable// Exception
{
    public EmptyListException()
    {super();}
    public EmptyListException(String s)
    {System.out.println("string s says "+s);
    }
}

