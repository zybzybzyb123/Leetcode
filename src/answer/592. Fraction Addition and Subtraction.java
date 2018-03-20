class Solution {
    public int gcd(int num1, int num2){
        if(num1 == 0) return num2;
        return gcd(num2 % num1, num1);
    }
    public String fractionAddition(String expression) {
        StringBuilder sb = new StringBuilder();
        if(expression == null || expression.length() == 0) return sb.toString();
        int flag1 = 1, flag2 = 1;
        char[] array = expression.toCharArray();
        int id = 0;
        if(array[id] == '-'){
            flag1 = -1;
            id++;
        }
        int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        a1 = array[id++] - '0';
        if(array[id] == '0'){
            id++;
            a1 = 10;
        }
        id++;
        b1 = array[id++] - '0';
        if(id < array.length && array[id] == '0'){
            id++;
            b1 = 10;
        }
        int m = 0, n = 0, g = 0;
        while(id < array.length){
            flag2 = array[id++] == '+' ? 1 : -1;
            a2 = array[id++] - '0';
            if(array[id] == '0'){
                id++;
                a2 = 10;
            }
            id++;
            b2 = array[id++] - '0';
            if(id < array.length && array[id] == '0'){
                id++;
                b2 = 10;
            }
            if(flag1 == flag2){
                m = a1 * b2 + a2 * b1;
                n = b1 * b2;
            } else{
                if(flag1 == 1){
                    m = a1 * b2 - a2 * b1;
                } else{
                    m = a2 * b1 - a1 * b2;
                }
                n = b1 * b2;
                if(m < 0){
                    flag1 = -1;
                    m = -m;
                } else{
                    flag1 = 1;
                }
            }
            g = gcd(m, n);
            a1 = m / g;
            b1 = n / g;
        }
        if(flag1 == -1){
            sb.append("-");
        }
        sb.append(a1 + "/" + b1);
        return sb.toString();
    }
}