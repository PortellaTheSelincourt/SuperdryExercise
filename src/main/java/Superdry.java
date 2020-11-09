import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Having done a quick look around but with an answer already picked in my head, I've noticed a few ways of dealing with this exercise.
 * We can approach using StringTokenizer, I recall using it once but I can't remember. (https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html#:~:text=StringTokenizer%20is%20a%20legacy%20class,regex%20package%20instead.)
 * using String split() (https://docs.oracle.com/javase/7/docs/api/java/lang/String.html).
 * The comments bellow are my thought process.
 */
public class Superdry {

    public static void main(String[] args) {
        // very simple scanner, there are faults with it like if the user presses space, instead of enter.
        try (Scanner input = new Scanner(System.in)) {
            String sentence;
            System.out.println("Type a sentence or press enter for us to pick one for you instead.");
            if (!(sentence = input.nextLine()).isEmpty()) {
                System.out.println("Sentence is: " + sentence);
            } else {
                sentence = "this is a dog and this is a cat";
            }

            /**
             * We need to split this sentence
             * https://www.baeldung.com/string/split
             */
            String[] splitSentence = sentence.split(" ");

            /**
             * Ok sentenced split, now how to make sure we count the occurrences of each word?
             * hashmap would be a good use here, on my last workplace, I spent a great deal dealing with maps
             * to get certain queries done among other things.
             * After some digging, I've realised that Treemap would be a better fit than Hashmap for its sorting powers.
             * https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html#TreeMap-java.util.Comparator-
             */
            TreeMap<String, Integer> catalogue = new TreeMap<>();
            for (String key : splitSentence) {
                int iteration = catalogue.getOrDefault(key, 0);
                catalogue.put(key, ++iteration);
            }
            ascendingResult(catalogue);
            descendingResult(catalogue);
        }
    }

    /**
     * Decided to add this logic separate from the main body for simpler coding.
     *
     * @param catalogue Original map with split sentence
     */
    private static void ascendingResult(TreeMap<String, Integer> catalogue) {
        System.out.println("\nAscending result");
        for (Map.Entry<String, Integer> ascendingResult : catalogue.entrySet()) {
            System.out.println(ascendingResult.getKey() + ":" + ascendingResult.getValue());
        }
    }

    /**
     * Decided to add this logic separate from the main body for simpler coding.
     *
     * @param catalogue Original map with split sentence
     */
    private static void descendingResult(TreeMap<String, Integer> catalogue) {
        System.out.println("\nDescending result");
        for (String key : catalogue.descendingKeySet()) {
            System.out.println(key + ":" + catalogue.get(key));
        }
    }
}
