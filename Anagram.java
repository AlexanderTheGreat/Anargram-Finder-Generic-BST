// Aaron Montoya
// Main class of the project, cleans the strings and takes the input and creates the output
// Date last modified: 2/24/19

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Anagram
{
    public static String cleanString(String s) // Cleans a string, removing punctuation & makes lower case
    {
        String lString = s.toLowerCase(); // Makes string lowercase
        char[] list = lString.toCharArray(); // Changes string to char array
        int newSize = 0;

        for (int i = 0; i < list.length; i++) // Finds appropriate size for char array, so it only holds letters
        {
            if (Character.isLetter(list[i]))
                newSize++;
        }

        char[] newList = new char[newSize];
        int offset = 0;

        for (int i = 0; i < list.length; i++)
        {
            if (Character.isLetter(list[i]))
                newList[i - offset] = list[i];
            else
                offset++;
        }

        String cleanedString = String.valueOf(newList);
        return cleanedString;
    }

    public static String createKey(String s)
    {
        char[] keyList = s.toCharArray();
        Arrays.sort(keyList);
        return String.valueOf(keyList);
    }

    public static void main(String[] args)
    {
        if (args.length == 2)
        {
            String inputFileName = args[0];
            String outputFileName = args[1];
            Scanner input = null;
            File inputFile = new File(System.getProperty("user.dir") + "/" + inputFileName);
            File outputFile = new File(System.getProperty("user.dir") + "/" + outputFileName);

            try
            {
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw);
                input = new Scanner(br);

                BinTree<AnaData> tree = new BinTree();

                String thisLine = "";

                //Building the tree
                while ((thisLine = br.readLine()) != null) //reading through the input file line by line
                {
                    String[] splitted = thisLine.split("\\s+");
                    for (int i = 0; i < splitted.length; i++) //cleaning the sentence one word at a time.
                    {
                        String cleanedString = cleanString(splitted[i]);

                        if (!cleanedString.isEmpty())
                        {
                            AnaData ana = new AnaData(bw);
                            String key = createKey(cleanedString);
                            ana.setKey(key);
                            GNode<String> cleanedStringNode = new GNode(cleanedString);
                            ana.addToList(cleanedStringNode);
                            if (tree.search(ana) == null || tree.search(ana).equals(ana)) // if the node isnt in the tree
                            {
                                tree.insert(ana); // put it in the tree
                            }
                            else // if the node is in the tree
                            {
                                tree.search(ana).addToList(cleanedStringNode);//find where it is
                                //add the cleaned string to the node that's in the tree's list
                            }
                        }
                    }
                }

                tree.traverse(tree.getRoot());

                input.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
