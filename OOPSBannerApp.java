import java.util.HashMap;

/**
 * OOPSBannerApp UC8 Use Map for Character Patterns and Render via Function
 *
 * This use case extends UC7 by utilizing advanced Object-Oriented Programming concepts
 * such as the Collections Framework to manage character patterns in a more flexible
 * and efficient manner. The application retrieves and displays the "OOPS" banner
 * using a HashMap thereby enhancing code organization and modularity.
 *
 * @author Developer
 * @version 8.0
 */
public class OOPSBannerApp {

    /**
     * Creates a HashMap containing ASCII art patterns for supported characters.
     */
    public static HashMap<Character, String[]> createCharacterMap() {
        HashMap<Character, String[]> charMap = new HashMap<>();
        
        charMap.put('O', new String[] {
            "  *** ", " ** ** ", "** **", "** **", "** **", " ** ** ", "  *** "
        });
        charMap.put('P', new String[] {
            "****** ", "** **", "** **", "****** ", "** ", "** ", "** "
        });
        charMap.put('S', new String[] {
            " ***** ", "** ", "** ", " ***** ", "     **", "     **", " ***** "
        });
        charMap.put(' ', new String[] {
            "   ", "   ", "   ", "   ", "   ", "   ", "   "
        });
        
        return charMap;
    }

    /**
     * Displays a banner message using the provided character map.
     */
    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {
        // Getting pattern height. Assuming all patterns have the same height.
        int patternHeight = charMap.get('O').length;

        // Loop through each line of the pattern height and build the banner line
        for (int line = 0; line < patternHeight; line++) {
            StringBuilder sb = new StringBuilder();
            
            for (char ch : message.toCharArray()) {
                // Fetch the pattern from the HashMap. Default to space if not found.
                String[] pattern = charMap.getOrDefault(ch, charMap.get(' '));
                sb.append(pattern[line]).append("   "); 
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * Main entry point of the application.
     */
    public static void main(String[] args) {
        HashMap<Character, String[]> charMap = createCharacterMap();
        String message = "OOPS";
        displayBanner(message, charMap);
    }
}