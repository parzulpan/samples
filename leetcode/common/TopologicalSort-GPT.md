Q：详细介绍一下拓扑排序算法，并给出 Java 代码示例。

A：拓扑排序是针对有向无环图（DAG，Directed Acyclic Graph）的一种排序算法，它会将图中的所有顶点排成一个线性序列，满足以下条件：

- 对于图中的每一条有向边 \( U \rightarrow V \)，顶点 \( U \) 都在顶点 \( V \) 的前面。

拓扑排序不是唯一的，因为可能存在多个节点都没有前驱节点，它们的相对顺序并不影响拓扑排序的要求。拓扑排序的一个常见应用是任务调度，其中任务之间存在依赖关系。

拓扑排序的一个常用算法是基于入度的算法。入度是指一个顶点的入边数量。算法步骤如下：

1. 计算图中所有顶点的入度。
2. 将所有入度为0的顶点放入队列中。
3. 当队列非空时，执行以下操作：
   - 从队列中移除一个顶点 \( N \)。
   - 将 \( N \) 放入结果序列中。
   - 对于 \( N \) 的每个邻接点，减少其入度。如果某个邻接点的入度变为0，则将其加入队列中。
4. 如果结果序列中顶点的数量与图中顶点的总数相同，则图存在拓扑排序，否则图中存在环，没有拓扑排序。

下面是一个使用 Java 实现拓扑排序的示例代码：

```java
import java.util.*;

public class TopologicalSort {
    private int vertices; // 图中顶点的数量
    private ArrayList<ArrayList<Integer>> adj; // 邻接表

    public TopologicalSort(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<ArrayList<Integer>>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    // 添加边
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // 执行拓扑排序
    public ArrayList<Integer> topologicalSort() {
        int[] inDegree = new int[vertices];
        ArrayList<Integer> topOrder = new ArrayList<Integer>(vertices);

        // 计算所有顶点的入度
        for (int i = 0; i < vertices; i++) {
            for (int node : adj.get(i)) {
                inDegree[node]++;
            }
        }

        // 将所有入度为0的顶点加入队列
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 开始执行拓扑排序
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.add(u);

            // 减少所有邻接点的入度
            for (int node : adj.get(u)) {
                if (--inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        if (topOrder.size() != vertices) {
            throw new IllegalArgumentException("图中存在环，没有拓扑排序。");
        }

        return topOrder;
    }

    public static void main(String[] args) {
        // 创建图的实例
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        // 执行拓扑排序
        ArrayList<Integer> result = g.topologicalSort();
        System.out.println("一个可能的拓扑排序：");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
```

在这个例子中，首先创建了一个有向无环图，然后添加了一些边。`topologicalSort` 方法计算了每个顶点的入度，并根据入度为0的顶点开始进行排序。如果图中没有环，最终会打印出一个可能的拓扑排序。如果图中存在环，则会抛出异常。