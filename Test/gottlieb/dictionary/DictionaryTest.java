package gottlieb.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class DictionaryTest
{
    @Test
    public void isWord() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String pizza = "pizza";

        //when
        boolean word = dictionary.isWord(pizza, "/Users/mindy 1/Documents/Touro/2020 - Spring/Gottlieb-MCO152/dictionary.txt");

        //then
        assertEquals(true, word);
    }

    @Test
    public void isNotWord() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String notWord = "jhfdjm";

        //when
        boolean word = dictionary.isWord(notWord, "/Users/mindy 1/Documents/Touro/2020 - Spring/Gottlieb-MCO152/dictionary.txt");

        //then
        assertEquals(false, word);
    }

    @Test
    public void caseSensitivity() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String upper = "CASTLE";

        //when
        boolean word = dictionary.isWord(upper, "/Users/mindy 1/Documents/Touro/2020 - Spring/Gottlieb-MCO152/dictionary.txt");

        //then
        assertEquals(true, word);
    }
}