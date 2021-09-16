package top.tobing.datastruct.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/16 18:25
 * @description 图的应用-联通分量
 */
public class CC {
    private Graph graph;
    private int[] visited;
    private int cccount = 0;

    /**
     * 构造函数
     * 读取配置文件，初始化图
     */
    public CC(Graph graph) {
        this.graph = graph;
        visited = new int[graph.V()];
        // 初始化visited，-1表示从未访问，非-1是
        Arrays.fill(visited, -1);
        // 运算联通分量
        for (int i = 0; i < graph.V(); i++) {
            if (visited[i] == -1) {
                dfs(i, cccount);
                cccount++;
            }
        }
    }

    /**
     * dfs
     */
    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (Integer w : graph.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, ccid);
            }
        }
    }

    /**
     * 获取图的联通分量
     */
    public int count() {
        for (int i : visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        return cccount;
    }

    /**
     * 获取图每个联通分量的具体值
     */
    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++) {
            res[i] = new ArrayList<>();
        }
        for (int v = 0; v < graph.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args) {
        final String filename = AdjMatrix.class.getClassLoader().getResource("g.txt").getFile();
        Graph g = new Graph(filename);
        CC cc = new CC(g);
        System.out.println(cc.count());
    }
}
