/**
 * leetcode想要代码快就怎么麻烦怎么来
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int sep = email.indexOf('@');
            int flag = email.substring(0, sep).indexOf('+');
            set.add(email.substring(0, flag).replace(".", "") + email.substring(sep));
        }
        return set.size();
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        char[] array = new char[105];
        int id = 0;
        for (String email : emails) {
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '.') continue;
                else if(ch == '+') {
                    while(email.charAt(++i) != '@');
                    while(i < email.length()) {
                        array[id++] = email.charAt(i++);
                    }
                }
                else if (ch == '@') {
                    while(i < email.length()) {
                        array[id++] = email.charAt(i++);
                    }
                } else {
                    array[id++] = email.charAt(i);
                }
            }
            set.add(new String(array, 0, id));
            id = 0;
        }
        //System.out.println(set);
        return set.size();
    }
}