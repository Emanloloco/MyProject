package graphtraversal;

import java.util.*;

public class GraphTraversal {

    // BFS algorithm (lowest to highest order)
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            traversalOrder.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    // DFS algorithm (lowest to highest order)
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                traversalOrder.add(node);

                // Add neighbors in reverse order to maintain ascending visit
                List<Integer> neighbors = graph.get(node);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return traversalOrder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Number of Nodes: ");
        int numNodes = scanner.nextInt();

        System.out.print("Number of Edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (one pair per line, e.g., '3 4'):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected edge
        }

        // Sort adjacency lists to ensure lowest-to-highest traversal
        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }

        scanner.nextLine(); // clear newline

        System.out.print("Traversal Method (BFS or DFS): ");
        String method = scanner.nextLine().trim().toUpperCase();

        System.out.print("Starting Node: ");
        int startNode = scanner.nextInt();

        if (!graph.containsKey(startNode)) {
            System.out.println("Starting node does not exist in the graph.");
            return;
        }

        List<Integer> result;
        if (method.equals("BFS")) {
            result = bfs(graph, startNode);
        } else if (method.equals("DFS")) {
            result = dfs(graph, startNode);
        } else {
            System.out.println("Invalid traversal method.");
            return;
        }

        System.out.println("\nTraversal Order:");
        for (int node : result) {
            System.out.print(node + " ");
        }
        System.out.println(); // new line after traversal output
    }
}
