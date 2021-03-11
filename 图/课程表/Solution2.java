/**
 *  dfs
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites) {               
            adjacency.get(cp[1]).add(cp[0]);   // 先修的课程 构建 邻接表
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency, flags, i));
        }

        return true;
    }
}

private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
    if(flags[i] == 1) return false;
    if(flags[j] == -1) return true;

    flags[i] = 1;

    for(Integer j: adjacency.get(i)) {
        if(!dfs(adjacency, flags, j)) return false;

        flags[i] = -1;
        return true;
    }
}
