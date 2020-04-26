package gottlieb.dictionary;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame
{

    private final JTextField wordField;
    private final JLabel answerLabel;

    public ScrabbleFrame()
    {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 40));
        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        add(wordField);
        add(checkButton);
        add(answerLabel);

    }

    public void checkWord()
    {
        Dictionary dictionary = new Dictionary();
        try {
            boolean isInDictionary = dictionary.isWord(wordField.getText());
            answerLabel.setText(String.valueOf(isInDictionary));
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScrabbleFrame scrabbleFrame = new ScrabbleFrame();
        scrabbleFrame.setVisible(true);
    }
}
