package Exceptions;

/**
 * Created by kerbeychevalier on 9/26/16.
 */
public class QueueUnderflowException extends Throwable {
    public QueueUnderflowException()
    {super();}
    public QueueUnderflowException(String s)
    {System.out.println("string s says "+s);
    }
}
