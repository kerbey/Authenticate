package DataStructure;

/**
 * Created by kerbeychevalier on 9/28/16.
 */
public class LLNode<T>
{
    private T element;

    public T getIndex() {
        return index;
    }

    public void setIndex(T index) {
        this.index = index;
    }

    private T index;
    protected LLNode<T> link;
    protected LLNode<T> previous;
    public LLNode()
    {
    }
    public LLNode(T info)
    {
        element = info;
        link = null;
        previous = null;
    }
    public void setElement(T element)
    {
        this.element = element;
    }
    public T getElement()
    {
        return element;
    }
    public LLNode<T> getLink() {
        return link;
    }
    public void setLink(LLNode<T> link) {
        this.link = link;
    }
    //check rears
    public LLNode<T> getPrevious() {
        return previous;
    }
    public void setPrevious(LLNode<T> previous) {
        this.previous = previous;
    }
}
