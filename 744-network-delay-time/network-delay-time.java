/**
Time complexity: 
O(ElogV)
Space complexity: 
O(V+E)
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>(); //map to store all the possible nodes and its weights
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0])); //min heap

        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            List<int[]> tmp = map.getOrDefault(from, new ArrayList<>());
            tmp.add(new int[] {to, weight});
            map.put(from, tmp);
        }

        pq.offer(new int[] {0, k});
        int res = 0;
        Set<Integer> visited = new HashSet<>();

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int w1 = node[0];
            int n1 = node[1];

            if(visited.contains(n1)) continue;

            visited.add(n1);
            res=w1;

            if(map.containsKey(n1)){
                for(int[] travel : map.get(n1)){
                    if(!visited.contains(travel[0])){
                        pq.offer(new int[] {w1+travel[1], travel[0]});
                    }
                }
            }
        }


        return visited.size()==n?res:-1;
    }
}