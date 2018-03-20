import javafx.util.Pair;

class Solution {
    private Pair<Integer, Integer> strToNum(String str){
        int pos = str.indexOf('+');
        int k = Integer.valueOf(str.substring(0, pos));
        int v = Integer.valueOf(str.substring(pos + 1, str.length() - 1));
        return new Pair<>(k, v);
    }
    private String numToStr(Pair<Integer, Integer> pairA,
                                            Pair<Integer, Integer> pairB){
        int k = pairA.getKey() * pairB.getKey() - pairA.getValue() * pairB.getValue();
        int v = pairA.getKey() * pairB.getValue() + pairA.getValue() * pairB.getKey();
        return String.valueOf(k) + "+" + String.valueOf(v) + "i";
    }
    public String complexNumberMultiply(String a, String b) {
        Pair<Integer, Integer> pairA = strToNum(a);
        Pair<Integer, Integer> pairB = strToNum(b);
        return numToStr(pairA, pairB);
    }
}