package top.tobing.datastruct.graph;

/**
 * @author tobing
 * @date 2021/9/16 21:06
 * @description 图的环检测
 */
public class CycleDetection {
    private Graph graph;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                if (dfs(i, i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hashCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        final String path1 = CycleDetection.class.getClassLoader().getResource("g.txt").getPath();
        final String path2 = CycleDetection.class.getClassLoader().getResource("g2.txt").getPath();
        Graph graph1 = new Graph(path1);
        CycleDetection cycleDetection1 = new CycleDetection(graph1);
        System.out.println(cycleDetection1.hasCycle);
        Graph graph2 = new Graph(path2);
        CycleDetection cycleDetection2 = new CycleDetection(graph2);
        System.out.println(cycleDetection2.hasCycle);
    }
}
