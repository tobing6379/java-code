package top.tobing.datastruct.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author tobing
 * @date 2021/9/16 18:40
 * @description 图的单源路径
 */
public class SingleSourcePath {

    /**
     * 储存节点的访问情况
     */
    private boolean[] visited;
    /**
     * 运行单源路径的图
     */
    private Graph graph;
    /**
     * 储存每个节点的前一个节点
     */
    private int[] pre;
    /**
     * 到s的路径
     */
    private int s;

    public SingleSourcePath(Graph graph, int s) {

        graph.validateVertex(s);

        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        pre = new int[graph.V()];

        dfs(s, s);
    }

    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            }
        }
    }

    public boolean isConnected(int t) {
        graph.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnected(t)) {
            return res;
        }

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        final String filename = AdjMatrix.class.getClassLoader().getResource("g.txt").getFile();
        Graph graph = new Graph(filename);
        SingleSourcePath ssp = new SingleSourcePath(graph, 0);
        System.out.println("0 -> 6 : " + ssp.path(6));
        System.out.println("0 -> 5 : " + ssp.path(5));
    }


}
