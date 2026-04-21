import java.util.HashMap;
import java.util.Map;
/**
 * Class MorseCodes - a class that contains a mapping of characters to Morse code.
 * @author Tsai Ming-Ruei 01081014
 * @version 2023.05
 */
 
public class MorseCodes {
    private static final Map<String, String> CODES = new HashMap<>();
    
    static {
        // Initialize the CODES map with 
        //character-to-Morse code mappings
        CODES.put("A", ".-");
        CODES.put("B", "-...");
        CODES.put("C", "-.-.");
        CODES.put("D", "-..");
        CODES.put("E", ".");
        CODES.put("F", "..-.");
        CODES.put("G", "--.");
        CODES.put("H", "....");
        CODES.put("I", "..");
        CODES.put("J", ".---");
        CODES.put("K", "-.-");
        CODES.put("L", ".-..");
        CODES.put("M", "--");
        CODES.put("N", "-.");
        CODES.put("O", "---");
        CODES.put("P", ".--.");
        CODES.put("Q", "--.-");
        CODES.put("R", ".-.");
        CODES.put("S", "...");
        CODES.put("T", "-");
        CODES.put("U", "..-");
        CODES.put("V", "...-");
        CODES.put("W", ".--");
        CODES.put("X", "-..-");
        CODES.put("Y", "-.--");
        CODES.put("Z", "--..");
        
        CODES.put("0", "-----");
        CODES.put("1", ".----");
        CODES.put("2", "..---");
        CODES.put("3", "...--");
        CODES.put("4", "....-");
        CODES.put("5", ".....");
        CODES.put("6", "-....");
        CODES.put("7", "--...");
        CODES.put("8", "---..");
        CODES.put("9", "----.");
    }
    public static void main(String[] args) {
    }

    
    // Get the Morse code for a given character
    public static String getCode(char character) {
        String code = CODES.get(Character.toString(character));
        //.toString means turn the code from character to string
        return code != null ? code : " ";
    }
    
    // Get the character for a given Morse code
   public static String getCharacter(String code) {
    String[] keys = CODES.keySet().toArray(new String[CODES.size()]);
    for (int i = 0; i < keys.length; i++) {
        String key = keys[i];
        if (CODES.get(key).equals(code)) {
            return key;
        }
    }
    return "[wrong code]";
}


}
