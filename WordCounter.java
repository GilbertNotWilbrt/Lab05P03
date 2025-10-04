import java.util.HashMap;
import java.util.HashSet;

/**
 * Keep a record of how many times each word was entered by users.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */
public class WordCounter
{
    // Associate each word with a count.
    private final HashMap<String, Integer> counts;

    /**
     * Create a WordCounter with an empty word count map
     */
    public WordCounter()
    {
        counts = new HashMap<>();
    }
    
    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }
    
    /**
     * Print all words not recognized by REponder's response map
     * @param responseMap the Responder's map of recognized keywords and responses
     */
    
    public void printUnmappedWordCounts(HashMap<String, String> responseMap)
    {
        for (String word : counts.keySet()) {
            if (!responseMap.containsKey(word)) {
                System.out.println(word + ": " + counts.get(word));
        }
    }   
    }
    
    /**
     * Print the final usage count of all words.
     * Should be called after goodbye message has been printed
     */
    
    public void printFinalWordCounts()
    {        
        System.out.println("Here are the final word counts:");
        
        for (String word : counts.keySet()) {
            System.out.println(word + ": " + counts.get(word));
        }
    }
    
}
