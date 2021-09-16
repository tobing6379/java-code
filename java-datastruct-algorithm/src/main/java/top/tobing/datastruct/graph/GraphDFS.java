package top.tobing.datastruct.graph;


import java.util.ArrayList;

/**
 * @author tobing
 * @date 2021/9/16 16:09
 * @description 图的深度优先遍历
 */
public class GraphDFS {

    private Graph graph;
    /**
     * 记录顶点是否被访问
     */
    private boolean[] visited;
    /**
     * 先序遍历序列
     */
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        // 为了避免存在多个连通分量的情况，需要办理
        for (int i = 0; i < graph.E(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        post.add(v);
    }
}
