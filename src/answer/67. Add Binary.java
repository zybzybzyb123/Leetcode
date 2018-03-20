import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger numA = new BigInteger(a, 2);
        BigInteger numB = new BigInteger(b, 2);
        return (numA.add(numB)).toString(2);
    }
}