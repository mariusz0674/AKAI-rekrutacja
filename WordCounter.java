import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCounter {

    private static String[] sentences = {
            "Taki mamy klimat",
            "Wszędzie dobrze ale w domu najlepiej",
            "Wyskoczył jak Filip z konopii",
            "Gdzie kucharek sześć tam nie ma co jeść",
            "Nie ma to jak w domu",
            "Konduktorze łaskawy zabierz nas do Warszawy",
            "Jeżeli nie zjesz obiadu to nie dostaniesz deseru",
            "Bez pracy nie ma kołaczy",
            "Kto sieje wiatr ten zbiera burzę",
            "Być szybkim jak wiatr",
            "Kopać pod kimś dołki",
            "Gdzie raki zimują",
            "Gdzie pieprz rośnie",
            "Swoją drogą to gdzie rośnie pieprz?",
            "Mam nadzieję, że poradzisz sobie z tym zadaniem bez problemu",
            "Nie powinno sprawić żadnego problemu, bo Google jest dozwolony"
    };

    public static void main(String[] args) {
                /* TODO Twoim zadaniem jest wypisanie na konsoli trzech najczęściej występujących słów
                w tablicy 'sentences' wraz z ilością ich wystąpień..
                Przykładowy wynik:
                1. "mam" - 12
                2. "tak" - 5
                3. "z" - 2
        */

        // Cast String array to hash map with count
        Map<String, Integer> wordCounter = new HashMap<>();
        for(String i : sentences){
            i = i.toLowerCase();
            String[] tempStringArr = i.split(" ");
            for(String tempString : tempStringArr){
                if(wordCounter.containsKey(tempString)){
                    wordCounter.put(tempString, wordCounter.get(tempString)+1);
                }else{
                    wordCounter.put(tempString, 1);
                }
            }
        }
        // New Linked map to rewrite in correct order
        Map<String, Integer> sortedWordCount = new LinkedHashMap<String, Integer>();
        Integer maxValue = 0;

        // Find max value
        for(Map.Entry<String, Integer> wordSet: wordCounter.entrySet()){
            if(maxValue < wordSet.getValue()) maxValue = wordSet.getValue();
        }
        //Rewrite to new Map in correct order
        for(int i = maxValue; i>0; i--){
            for(Map.Entry<String, Integer> wordSet: wordCounter.entrySet()){
                if(i == wordSet.getValue()) sortedWordCount.put(wordSet.getKey(), wordSet.getValue());
            }
        }
        // Print result
        int counter = 3;
        for(Map.Entry<String, Integer> wordSet: sortedWordCount.entrySet()){
            System.out.println('"'+wordSet.getKey()+ '"'+" - " + wordSet.getValue());
            if(counter-- == 1) break;
        }
    }
}
