/**
 * 注意 /.. /.和/
 */

class Solution {
    public String simplifyPath(String path) {
        List<String> subPathList = new ArrayList<>();
        Set<String> specialPathSet = new HashSet<>(Arrays.asList("..", ".", ""));
        String[] subPaths = path.split("/");
        for (String subPath : subPaths) {
            if (subPath.equals("..") && subPathList.size() > 0) {
                subPathList.remove(subPathList.size() - 1);
            } else if (!specialPathSet.contains(subPath)) {
                subPathList.add(subPath);
            }
        }
        return  "/" + String.join("/", subPathList);
    }
}