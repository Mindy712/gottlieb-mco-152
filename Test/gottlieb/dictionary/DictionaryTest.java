package gottlieb.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class DictionaryTest
{
    @Test
    public void isWord() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String pizza = "pizza";

        //when
        boolean word = dictionary.isWord(pizza);

        //then
        assertTrue(word);
    }

    @Test
    public void isNotWord() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String notWord = "jhfdjm";

        //when
        boolean word = dictionary.isWord(notWord);

        //then
        assertFalse(word);
    }

    @Test
    public void caseSensitivity() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        String upper = "CASTLE";

        //when
        boolean word = dictionary.isWord(upper);

        //then
        assertTrue(word);
    }
}