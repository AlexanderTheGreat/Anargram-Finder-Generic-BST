// Aaron Montoya
// Allows classes that implement Visitable to use visit() and compareTo(T t)
// Date last modified: 2/21/19

@SuppressWarnings("unchecked")
public interface Visitable<T>
{
    void visit();
    int compareTo(T t);
}