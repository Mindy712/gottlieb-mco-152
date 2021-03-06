package gottlieb.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary
{
    ArrayList<String> words = new ArrayList<String>();
    public boolean isWord(String word) throws FileNotFoundException {
        if (words.isEmpty())
        {
            loadFile("dictionary.txt");
        }
        if (words.contains(word.toUpperCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void loadFile(String filepath) throws FileNotFoundException
    {
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext())
        {
            words.add(scanner.next());
            scanner.nextLine();
        }
    }
}