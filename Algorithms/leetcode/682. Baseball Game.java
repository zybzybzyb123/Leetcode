class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0, val = 0, val1 = 0, val2 = 0;
        for(String op : ops){
            switch (op){
                case "C": {
                    stack.pop();
                } break;
                case "D": {
                    val = stack.peek();
                    stack.push(val * 2);
                } break;
                case "+": {
                    val1 = stack.pop();
                    val2 = stack.peek();
                    val = val1 + val2;
                    stack.push(val1);
                    stack.push(val);
                } break;
                default: {
                    val = Integer.valueOf(op);
                    stack.push(val);
                }
            }
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}