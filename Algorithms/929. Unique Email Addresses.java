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