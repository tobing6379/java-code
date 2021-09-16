package top.tobing.datastruct.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tobing
 * @date 2021/9/16 14:52
 * @description 图-邻接矩阵表示
 */
public class AdjMatrix {

    /**
     * 顶点个数
     */
    private int V;
    /**
     * 边个数
     */
    private int E;
    /**
     * 图的数据
     */
    private int[][] adj;

    /**
     * 构造函数
     * 从一个文件中读取构建图的信息
     */
    public AdjMatrix(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new int[V][V];

            E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("E must be non-negative");
            }
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                // 排除自环边
                if (a == b) {
                    throw new IllegalArgumentException("Self Loop is Detected!");
                }
                // 排除平行边
                if (adj[a][b] == 1) {
                    throw new IllegalArgumentException("Parallel Edges are Detected!");
                }

                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证边是否合法
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + "is invalid");
        }
    }

    /**
     * 顶点个数
     */
    public int V() {
        return V;
    }

    /**
     * 边的条数
     */
    public int E() {
        return E;
    }

    /**
     * 判断图中是否存在v到w相连的边
     */
    public boolean hashEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    /**
     * 获取顶点v所有相邻的顶点
     */
    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 获取顶点v的度
     */
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final String filename = AdjMatrix.class.getClassLoader().getResource("g.txt").getFile();
        AdjMatrix adjMatrix = new AdjMatrix(filename);
        System.out.println(adjMatrix);
    }
}
