/**
 * OOPSBannerApp UC7 Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class to encapsulate
 * character-to-pattern mappings. The application retrieves and displays the "OOPS"
 * banner using these mappings. This approach enhances code organization and modularity.
 *
 * @author Developer
 * @version 7.0
 */
public class OOPSBannerApp {

    /**
     * Inner class for storing character-to-pattern mappings.
     * Encapsulates a single character and its corresponding ASCII art pattern.
     */
    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Creates and initializes CharacterPatternMap array for predefined characters.
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];
        
        charMaps[0] = new CharacterPatternMap('O', new String[] {
            "  *** ", " ** ** ", "** **", "** **", "** **", " ** ** ", "  *** "
        });
        charMaps[1] = new CharacterPatternMap('P', new String[] {
            "****** ", "** **", "** **", "****** ", "** ", "** ", "** "
        });
        charMaps[2] = new CharacterPatternMap('S', new String[] {
            " ***** ", "** ", "** ", " ***** ", "     **", "     **", " ***** "
        });
        charMaps[3] = new CharacterPatternMap(' ', new String[] {
            "   ", "   ", "   ", "   ", "   ", "   ", "   "
        });
        
        return charMaps;
    }

    /**
     * Retrieves the ASCII pattern for a given character.
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        // Fallback to space if character isn't found
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ' ') return map.getPattern();
        }
        return new String[7]; 
    }

    /**
     * Prints a message as a banner using ASCII art patterns and StringBuilder.
     */
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        // Loop through each of the 7 lines
        for (int i = 0; i < 7; i++) {
            StringBuilder lineBuilder = new StringBuilder();
            
            // Loop through each character in the message string
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                lineBuilder.append(pattern[i]).append("   ");
            }
            System.out.println(lineBuilder.toString());
        }
    }

    /**
     * Main method Entry point
     */
    public static void main(String[] args) {
        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        
        // Define the message to be displayed
        String message = "OOPS";
        
        // Print the banner message
        printMessage(message, charMaps);
    }
}