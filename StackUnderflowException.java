package Exceptions;

/**
 * Created by kerbeychevalier on 10/1/16.
 */
public class StackUnderflowException extends Exception
{
    public StackUnderflowException()
    {super();}
    public StackUnderflowException(String s)
    {System.out.println("string s says "+s);
    }
}