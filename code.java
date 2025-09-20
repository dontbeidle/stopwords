import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StopwordFilter {
    public static void main(String[] args) {
        String text = "Men qaraqalpaq tilinde NLP jasayman";
        Set<String> stopwords = loadStopwords("kaa_stopwords_v1.txt");
        StringBuilder filtered = new StringBuilder();
        for (String word : text.split(" ")) {
            if (!stopwords.contains(word.toLowerCase())) {
                filtered.append(word).append(" ");
            }
        }
        System.out.println("Filtered: " + filtered.toString().trim());
    }

    private static Set<String> loadStopwords(String filename) {
        Set<String> stopwords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopwords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopwords;
    }
}
