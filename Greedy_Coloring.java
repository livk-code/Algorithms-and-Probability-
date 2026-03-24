public class Greedy_Coloring {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] graph = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };

        int[] result = greedyColoring(graph);
        System.out.println("Vertex : Color");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " : " + result[i]);
        }
    }

    public static int[] greedyColoring(int[][] graph) {
        int V = graph.length;
        int[] result = new int[V];
        boolean[] available = new boolean[V];

        // Initialize all vertices as unassigned
        for (int i = 0; i < V; i++) {
            result[i] = -1;
            available[i] = true;
        }

        // Assign the first color to the first vertex
        result[0] = 0;

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors as unavailable
            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr]) {
                    break;
                }
            }

            result[u] = cr; // Assign the found color

            // Reset the values back to true for the next iteration
            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1 && result[v] != -1) {
                    available[result[v]] = true;
                }
            }
        }

        return result;
    }
}