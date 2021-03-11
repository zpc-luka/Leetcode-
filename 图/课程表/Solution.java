package 图.课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS 使用邻接表


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];             // 入度
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();       // 用队列保存度为 0 的 节点

        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites) {
            indegree[cp[0]] ++;                // 后修的课程 入度 + 1
            adjacency.get(cp[1]).add(cp[0]);   // 先修的课程 构建 邻接表
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)             // 入度为 0 的 进 队列
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int pre = queue.poll();             // 目的是 入度为 0 的节点 将它删除
            numCourses--;                      // 删除之后 课程 -1

            for(int cur : adjacency.get(pre)) {           // 遍历此节点的 邻接表
                indegree[cur] --;                         // 每个 相邻点 的 入度 - 1
                if(indegree[cur]== 0) {                   //  如果 这个节点的入度为0 ， 添加到队列
                    queue.add(cur);
                }
            }
        }

        return numCourses == 0;
    }
}
