// Aaron Montoya
// Contains information for the nodes in the BST
// Date last modified: 2/24/19

@SuppressWarnings("unchecked")
public class GNode<T>
{
    T data;
    GNode<T> next,left,right;

    /* Constructor:
     * This is the only place where you do not use "<T>"
     * BUT use it when calling the constructor: T val = new GNode<T>(T val);
     */
    public GNode (T t)
    {
        data = t;
    }

    public void setLeft(GNode<T> n)
    {
        this.left = n;
    }

    public GNode<T> getLeft()
    {
        return this.left;
    }

    public void setRight(GNode<T> n)
    {
        this.right = n;
    }

    public GNode<T> getRight()
    {
        return this.right;
    }
}
