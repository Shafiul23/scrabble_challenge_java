import java.util.HashMap;

public class Scrabble {

    private String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean isDouble;
    private boolean isTriple;
    private static final HashMap<Character, Integer> scrabbleHash = new HashMap<>();

    public Scrabble(String word) {
        setScrabbleHash();
        if(word != null){
            this.word = word.toUpperCase();
        }
    } // First constructor covers first 7 tests

    public Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean isDouble, boolean isTriple) {
        setScrabbleHash();
        if(word != null) {
            this.word = word.toUpperCase();
        }
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.isDouble = isDouble;
        this.isTriple = isTriple;
    }
    // Second constructor covers the rest of the tests

    public int score() {
        int res = 0;
        if (this.word == null) return 0;
        char[] wordArray = this.word.toCharArray();
        for (char c : wordArray) {
            res += scrabbleHash.get(c);
        }
        if(isDouble) res *= 2;
        if(isTriple) res *= 3;
        if(doubleLetters != null){
            res += calculateDoubleLetter();
        }
        if(tripleLetters != null){
            res += calculateTripleLetter();
        }
        return res;
    };

    public int calculateDoubleLetter(){
        int point = 0;
        if(doubleLetters == null) return 0;
        for(char d : doubleLetters){
            point += scrabbleHash.get(d);
        }
        return point;
    }

    public int calculateTripleLetter(){
        int point = 0;
        if(tripleLetters == null) return 0;
        for(char t : tripleLetters){
            point += scrabbleHash.get(t) * 2;
        }
        return point;
    };

    private void setScrabbleHash() {

        scrabbleHash.put('A', 1);
        scrabbleHash.put('E', 1);
        scrabbleHash.put('I', 1);
        scrabbleHash.put('O', 1);
        scrabbleHash.put('U', 1);
        scrabbleHash.put('L', 1);
        scrabbleHash.put('N', 1);
        scrabbleHash.put('R', 1);
        scrabbleHash.put('S', 1);
        scrabbleHash.put('T', 1);
        scrabbleHash.put('D', 2);
        scrabbleHash.put('G', 2);
        scrabbleHash.put('B', 3);
        scrabbleHash.put('C', 3);
        scrabbleHash.put('M', 3);
        scrabbleHash.put('P', 3);
        scrabbleHash.put('F', 4);
        scrabbleHash.put('H', 4);
        scrabbleHash.put('V', 4);
        scrabbleHash.put('W', 4);
        scrabbleHash.put('Y', 4);
        scrabbleHash.put('K', 5);
        scrabbleHash.put('J', 8);
        scrabbleHash.put('X', 8);
        scrabbleHash.put('Q', 10);
        scrabbleHash.put('Z', 10);

    }
}
