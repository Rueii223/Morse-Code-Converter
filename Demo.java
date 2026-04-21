import javax.swing.*;
import java.awt.*;
/**
 * Class Demo - The given code demonstrates a GUI-based Morse code converter.
 * It allows the user to choose between converting characters to Morse code or Morse code to characters
 * For character-to-Morse code conversion, the user enters a string and receives the Morse code output.
 * For Morse code-to-character conversion, the user can input Morse code using buttons for dots, dashes, 
 * and spaces, and then press a convert button to display the resulting characters.
 * The program utilizes the MorseCodes class to handle the conversion logic.
 * @author Tsai Ming-Ruei 01081014
 * @version 2023.05
 */
public class Demo 
{
    private static String morseCode = "";
    private static String output = "";
    private static String convertToMorseCode(String input)
    // method to convert input string to Morse code
    {
        StringBuilder sb = new StringBuilder();
        // loop through each character in the input string
        for (char c : input.toCharArray()) 
        // get Morse code for the character
        {
            String code = MorseCodes.getCode(Character.toUpperCase(c));
            if (code.isEmpty()) 
            {
                sb.append("/ ");
                // if no code for the character, add a slash
            } 
            else 
            {
                sb.append(code).append("    ");
                // add spaces to separate from character to the next character
            }
        }
        return sb.toString(); 
        // return the Morse code string.
    }
    public static void main(String[] args) 
    {
        String input = JOptionPane.showInputDialog(null, 
                "This is a Morse Converter\n"+
                "Please choose mode: \n"+
                "1. Characters to Morse code\n"+
                "2. Morse code to characters");
        if (input != null && (input.equals("1") || input.equals("2"))) 
        {
        int mode = Integer.parseInt(input);
            if (mode == 1) 
            {
                JOptionPane.showMessageDialog(null, 
                "In this mode, you can enter characters or strings,\n"+
                "and press 'OK' to show the result.");
                input = JOptionPane.showInputDialog(null,"Please enter a string:");
                output = convertToMorseCode(input);
                JOptionPane.showMessageDialog(null, "Morse code: " + output);
            } 
            else if (mode == 2)
            {
                JOptionPane.showMessageDialog(null, 
                "In this mode, you can press button '.' and '-' \n"+
                "to enter the Morse code, and press 'space' to enter the next Morse code,\n"+
                "finally, press 'convert' to show the result of the conversion.");

                JFrame frame = new JFrame("Morse Converter");
                frame.setBounds(350,100,700, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel morseCodeLabel = new JLabel("");
                morseCodeLabel.setBounds(120, 200, 220, 40);
                morseCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
                frame.add(morseCodeLabel);

                JButton shortButton = new JButton(".");
                shortButton.addActionListener(e -> {    
                // Use addActionListener to listen for a button click event,
                // when the button is clicked, the code defined in ' e -> ' will be executed.
                morseCode += ".";
                morseCodeLabel.setText(morseCode);
                });

                JButton longButton = new JButton("-");
                longButton.addActionListener(e -> {
                morseCode += "-";
                morseCodeLabel.setText(morseCode);
                });

                JButton spaceButton = new JButton("Space");
                spaceButton.addActionListener(e -> {
                String character = MorseCodes.getCharacter(morseCode);
                if (character.isEmpty()) {
                    output += " ";
                } else {
                    output += character;
                }
                morseCodeLabel.setText(" ");
                morseCode = "";
                });

                JButton convertButton = new JButton("Convert");
                convertButton.addActionListener(e -> {
                String character = MorseCodes.getCharacter(morseCode);
                // get the character for the entered Morse code
                if (!character.isEmpty()) {
                    output += character;
                } 
                JOptionPane.showMessageDialog(null, "Result: " + output);
                morseCodeLabel.setText("");
                morseCode = "";
                output = "";
                });


                // add the buttons to the frame and set their positions and fonts.
                frame.add(shortButton);
                frame.add(longButton);
                frame.add(spaceButton);
                frame.add(convertButton);
                shortButton.setBounds(120, 100, 70, 70);
                shortButton.setFont(new Font("Arial", Font.PLAIN, 40));
                longButton.setBounds(270, 100, 70, 70);
                longButton.setFont(new Font("Arial", Font.PLAIN, 40));
                spaceButton.setBounds(420, 100, 150, 70);
                spaceButton.setFont(new Font("Arial", Font.PLAIN, 30));
                convertButton.setBounds(220, 250, 200, 80);
                convertButton.setFont(new Font("Arial", Font.PLAIN, 30));
                frame.setLayout(null);
                frame.setVisible(true);
            }
        }
        else 
        {
        	JOptionPane.showMessageDialog(null,"Wrong input !\n"+"Please enter 1 or 2" );
            // Display an error message if the user enters an invalid input
        }
    }
}