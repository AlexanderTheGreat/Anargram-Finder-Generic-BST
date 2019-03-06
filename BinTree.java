// Aaron Montoya
// Class for the binary tree
// Date last modified: 2/24/19

@SuppressWarnings("unchecked")
public class BinTree <T extends Visitable<T>>
{
    private GNode<T> root;

    public GNode<T> getRoot()
    {
        return this.root;
    }

    public void traverse(GNode<T> currentNode)
    {
        if(currentNode == null)
            return;
        traverse(currentNode.left);
        currentNode.data.visit();
        traverse(currentNode.right);
    }

    public T search(T target)
    {
        if(root==null)
            return null;
        return search(target, root);
    }

    private T search(T target, GNode<T> p)
    {
        if(p == null)
            return null;
        if(target.compareTo(p.data)==0)
            return p.data; // Found it!
        if(target.compareTo(p.data)<0)
            return search(target, p.left); // search left subtree
        // here we know target.compareTo(p.data)>0
        return search(target,p.right); // search right subtree
    }

    public void insert(T element) // Adds element to this BST. The tree retains its BST property.
    {
        root = recInsert(element, root);
    }

    private GNode<T> recInsert(T element, GNode<T> tree) // Adds element to tree; tree retains its BST property.
    {
        if (tree == null)
            tree = new GNode<T>(element); // Addition place found
        else
            if (element.compareTo(tree.data)<= 0)
                tree.setLeft(recInsert(element, tree.getLeft()));
            else
                tree.setRight(recInsert(element, tree.getRight())); // Add in right subtree
        return tree;
    }
}
