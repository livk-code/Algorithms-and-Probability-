import java.util.*; 
class Graph {

    private int n; // nbr of vertices
    private ArrayList<ArrayList<Integer>> adjList; // holds all vertices connected to vertex n_i

    // Constructor

    public Graph (int n){ 
        this.n = n; 
        adjList = new ArrayList<>();

        for (int i = 0; i < n ; i++){
            adjList.add(newArrayList<>()); // builds an empty list for each vertex to later hold its neighbors
        } 
    }

    // add edges between u and v
    public void addEdge(int u, int v){ // make u and v neighbors
        adjList.get(u).add(v); 
        adjList.get(v).add(u);
    }

    // actual BFS
    public void BFS(int v /* starting vertex*/){
        boolean[] active = new boolean[n]; // holds which vertices are in Queue
        boolean[] visited = new boolean[n]; // holds which vertices have been visited

        // 1.
        Queue<Integer> Q = new LinkedList<>(); // create new empty Queue

        // 2.
        active[v] = true;

        //3.
        Q.add(v); // add vertex to Queue -> Enqueue(Q,v)

        // 4.
        while (!Q.isEmpty()){
            
            // 5.
            int w = Q.remove(); // remove vertex from Queue -> Dequeue(Q,w)

            // 6.
            visited[w] = true; // w marked as visited
            System.out.println("Besucht: " + w)

            // 7.
            for (int x : adjList.get(w)){ // look at all neighbors of w

                // 8.
                if (!active[x] && !visited[x]){ // check whether neightbor is not active nor visited
                    active[x] = true;
                    Q.add(x); // add vertex to Queue -> Enqueue(Q,x)
                }
            }
        }
    }
}


public class BFSVisitIterative{
    public static void main(String[] args){
        Graph G = new Graph(4); // build new graph

        // build set of edges
        
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(1,2);
        G.addEdge(2,0);
        G.addEdge(2,3);
        G.addEdge(3,3);

        G.BFS(0); // start BFS at vertex 0
    }
}
