class Solution{
	int ans = 0;
	List<List<Integer> > map = new ArrayList<>();
	boolean[] vis = new boolean[20];
	public void init(int N){
		for(int i = 1; i <= N; i++){
			List<Integer> temp = new ArrayList<>();
			for(int j = N; j >=1; j--){
				if(i % j == 0 || j % i == 0){
					temp.add(j);
				}
			}
			map.add(temp);
		}
	}
	public void count(int cur, int N){
		if(cur == 0){
			ans++;
			return;
		}
		for(int i = map.get(cur - 1).size() - 1; i >= 0; i--){
			int temp = map.get(cur - 1).get(i);
			if(!vis[temp]){
				vis[temp] = true;
				count(cur - 1, N);
				vis[temp] = false;
			}
		}
	}
	public int countArrangement(int N) {
		init(N);
		count(N, N);
		return ans;
	}
}
