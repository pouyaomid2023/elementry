import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private Set<String> wordset;

    public Main(String[] w) {
        wordset = new HashSet<String>(Arrays.asList(w));
    }

    public List<String> getCorrections(String input) {
        List<String> corrections = new ArrayList<String>();
        if (wordset.contains(input)) {
            corrections.add(input);
            return corrections;
        }
        List<WordDistance> wordDistances = new ArrayList<>();
        for (String w : wordset) {
            int distance = LevenshteinDistance.getDefaultInstance().apply(input, w);
            if (distance < 3) {
                wordDistances.add(new WordDistance(w, distance));
            }
        }
        Collections.sort(wordDistances, new Comparator<WordDistance>() {
            public int compare(WordDistance wd1, WordDistance wd2) {
                return Integer.compare(wd1.distance, wd2.distance);
            }
        });
        for (WordDistance wd : wordDistances) {
            corrections.add(wd.word);
        }
        return corrections;
    }

    private static class WordDistance {
        String word;
        int distance;

        WordDistance(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        try {
            File f = new File("wordlist.txt");
            Scanner fileScanner = new Scanner(f);
            ArrayList<String> file = new ArrayList<String>();
            while (fileScanner.hasNext()) {
                file.add(fileScanner.nextLine().trim());
            }
            fileScanner.close();

            String[] data = file.toArray(new String[0]);
            Main spellChecker = new Main(data);
            Scanner inputScanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter the word (or type 'exit' to quit): ");
                String word = inputScanner.nextLine().trim();
                if (word.equalsIgnoreCase("exit")) {
                    break;
                }
                List<String> corrections = spellChecker.getCorrections(word);
                if (corrections.isEmpty()) {
                    System.out.println("No suggestions found.");
                } else {
                    System.out.println("The most likely answer: " + corrections.get(0));
                    if (corrections.size() > 1) {
                        System.out.println("Other suggestions:");
                        for (int i = 1; i < corrections.size(); i++) {
                            System.out.println(corrections.get(i));
                        }
                    }
                }
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The word list file was not found.");
        }
    }
}
