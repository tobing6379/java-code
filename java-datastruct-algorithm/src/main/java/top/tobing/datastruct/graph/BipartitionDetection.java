package top.tobing.datastruct.graph;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/16 21:13
 * @description 二分图
 */
public class BipartitionDetection {

    private Graph graph;
    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public BipartitionDetection(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        colors = new int[graph.V()];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) {
        String filename1 = BipartitionDetection.class.getClassLoader().getResource("g.txt").getPath();
        Graph graph1 = new Graph(filename1);
        System.out.println(graph1.toString());
        BipartitionDetection bipartitionDetection1 = new BipartitionDetection(graph1);
        System.out.println(bipartitionDetection1.isBipartite);

        String filename2 = BipartitionDetection.class.getClassLoader().getResource("g2.txt").getPath();
        Graph graph2 = new Graph(filename2);
        System.out.println(graph2.toString());
        BipartitionDetection bipartitionDetection2 = new BipartitionDetection(graph2);
        System.out.println(bipartitionDetection2.isBipartite);

        String filename3 = BipartitionDetection.class.getClassLoader().getResource("g3.txt").getPath();
        Graph graph3 = new Graph(filename3);
        System.out.println(graph3.toString());
        BipartitionDetection bipartitionDetection3 = new BipartitionDetection(graph3);
        System.out.println(bipartitionDetection3.isBipartite);

    }

}
