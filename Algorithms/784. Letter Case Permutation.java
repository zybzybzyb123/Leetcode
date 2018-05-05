class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if(S == null){
            return list;
        }
        //这个坑爹测试点
        if(S.length() == 0){
            list.add(S);
            return list;
        }
        char[] source = S.toCharArray();
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if(source[i] > '9'){
	            //记录每个字母的位置
                posList.add(i);
            }
        }
        int cnt = 1 << (posList.size());
        for(int i = 0; i < cnt; i++){
            int temp = i;
            for(int j = 0; j < posList.size(); j++){
	            //1把字母转为大写，0转为小写
                if((temp & 1) == 1){
                    source[posList.get(j)] = Character.toUpperCase(source[posList.get(j)]);
                } else{
                    source[posList.get(j)] = Character.toLowerCase(source[posList.get(j)]);
                }
                temp >>= 1;
            }
            //通过char[]直接转换为String
            list.add(String.valueOf(source));
        }
        return list;
    }
}