// Aaron Montoya
// Contains visit() which goes through the anagram list and writes them to the BufferedWriter
// Date last modified: 2/24/19

import java.io.BufferedWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class AnaData implements Visitable<AnaData>
{
    private String key;
    private GList<String> list; // Anagram list
    private BufferedWriter bw; // Visit will write output

    public AnaData(BufferedWriter bw)
    {
        this.bw = bw;
        this.list = new GList<>();
    }

    public void visit()
    {
        int wordCount = 0;
        this.list.startTraversal();
        while (this.list.hasNext())
        {
            wordCount++;
            this.list.getNext();
        }
        if(wordCount > 1)
        {
            try
            {
                this.list.startTraversal();
                if (!this.list.hasNext())
                    return;
                while (this.list.hasNext())
                {
                    String currentNode = this.list.getNext();
                    System.out.print(currentNode + " ");
                    bw.write(currentNode + " ");
                }
                System.out.println("");
                bw.newLine();
            } catch (IOException e)
            {}
        }
    }

    public void setKey(String k)
    {
        this.key = k;
    }

    public void addToList(GNode<String> node)
    {
        if(this.list.contains(node.data))
            return;
        this.list.addFirst(node.data);
    }

    public int compareTo(AnaData value)
    {
        return key.compareTo(value.key);
    }
}