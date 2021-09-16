package top.tobing.datastruct.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author tobing
 * @date 2021/9/16 20:54
 * @description 求任意两点的路径
 */
public class Path {
    /**
     * 所在图
     */
    private Graph graph;
    /**
     * 起点
     */
    private int s;
    /**
     * 末尾节点
     */
    private int t;
    /**
     * 浏览过的节点
     */
    private boolean[] visited;

    /**
     * 当前节点的前一个节点
     */
    private int[] pre;

    public Path(Graph graph, int s, int t) {

        graph.validateVertex(s);
        graph.validateVertex(t);

        this.graph = graph;
        this.s = s;
        this.t = t;

        visited = new boolean[graph.V()];
        pre = new int[graph.V()];
        // 将pre初始化为-1
        Arrays.fill(pre, -1);

        dfs(s, s);
        for (boolean e : visited) {
            System.out.print(e + " ");
        }
        System.out.println();

    }


    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;

        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isConnected() {
        return visited[t];
    }

    public Iterable<Integer> path() {
        ArrayList<Integer> res = new ArrayList<>();
        // 判断两点十分相连接
        if (!isConnected()) {
            return res;
        }
        // 获取s->t的路径
        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        // 将结果反序
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        final String path = Path.class.getClassLoader().getResource("g.txt").getPath();
        Graph graph = new Graph(path);
        final Path path1 = new Path(graph, 0, 6);
        System.out.println("0 -> 6 : " + path1.path());
        final Path path2 = new Path(graph, 0, 5);
        System.out.println("0 -> 5 : " + path2.path());
        final Path path3 = new Path(graph, 0, 1);
        System.out.println("0 -> 1 : " + path3.path());
    }
}
