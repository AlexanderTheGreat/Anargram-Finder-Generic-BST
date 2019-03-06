// Aaron Montoya
// Includes methods that involve traversal of the BST
// Date last modified: 2/24/19

@SuppressWarnings("unchecked")
public class GList <T extends Comparable<T>>
{
    private GNode<T> head;
    private GNode<T> cursor; // States where you are

    public void addFirst(T t)
    {
        GNode<T> p = new GNode<T>(t);
        p.next = head;
        head = p;
    }

    public void startTraversal()
    {
        cursor = head; // Start at the beginning of list
    }

    public boolean hasNext()
    {
        return cursor != null;
    }

    // requires hasNext() is true
    public T getNext()
    {
        T retVal = cursor.data;
        cursor = cursor.next;
        return retVal;
    }

    public boolean contains(T target)
    {
        if(head == null)
            return false;

        boolean find = false;

        startTraversal();

        while ((cursor != null) && !find)
        {
            if (target.equals(cursor.data))
                find = true;
            else
            {
                getNext();
            }
        }
        return find;
    }
}
