class Solution {
    public String maskPII(String S) {
        if(null == S || S.length() == 0) return S;
        int pos = S.indexOf('@');
        StringBuilder sb = new StringBuilder();
        //邮件还是电话号码
        if(pos > 0){
            String str = S.toLowerCase();
            sb.append(str.charAt(0));
            sb.append("*****");
            sb.append(str.charAt(pos - 1));
            sb.append(str.substring(pos));
        } else{
            //先替换再处理
            String str = S.replaceAll("[() +-]","");
            if(str.length() > 10){
                sb.append("+");
                for(int i = 10; i < str.length(); i++){
                    sb.append('*');
                }
                sb.append("-***-***-");
            } else{
                sb.append("***-***-");
            }
            sb.append(str.substring(str.length() - 4));
        }
        return sb.toString();
    }
}