/**
 * 简单dfs，因为是关系是一个树结构，
 * 不用判重
 */

//class Employee {
//    public int id;
//    public int importance;
//    public List<Integer> subordinates;
//}

class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    private int dfs(int id){
        int ans = 0;
        Employee employee = map.get(id);
        ans += employee.importance;
        for(int ordinate : employee.subordinates){
            ans += dfs(ordinate);
        }
        return ans;
    }
    public int getImportance(List<Employee> employees, int id) {
        if(null == employees|| employees.isEmpty()) return 0;
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
}