import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Stack;

public class Graphs {
    // to visualise graphs
    //i) Adjacency matrix : in terms of 2d array when vertices<10000

    //ii) Adjacency list : array of arraylist (arraylist are of edges of graph)

    // Bipartite Graph
    // if it is possible to divide vertices into 2 mutually exclusive and
    // exhaustive sets such that all edges are across sets.
    // Graphs which are either acyclic or if cyclic length is even then the 
    // graph is bipartite.

    // Dijkstra Algorithm

    // Minimum Spanning tree (MST) / Prim's Algorithm
    // i) it's a subgraph
    // ii) it's a type of tree (connected acyclic graph)
    // iii) spanning (contains all vertices)
    // iv) now the above will form a spanning tree, MST will be that whose
    // sum of edges wt is minimum

    // Topological Sort: A permutation of vertices for a directed acyclic graph
    // is called topological sort if for directed edges uv, u appears before v
    // in the graph
    // used where there is a dependency of work
    // Order of work is reverse of topological sort

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    //Note: the below pair is for BFS in graphs
    //For BFS remember remove-mark*-work-add*
    static class pair{
        int v;
        String psf;

        pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static class BPair{
        int v; 
        String psf;
        int level;

        BPair(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    // static class Pair implements Comparable<Pair>{
    //     int wsf;
    //     String psf;

    //     Pair(int wsf, String psf){
    //         this.wsf = wsf;
    //         this.psf = psf;
    //     }

    //     public int compareTo(Pair o){
    //         return this.wsf - o.wsf;
    //     }
    // }

    public static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());

        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        
        int dest = Integer.parseInt(br.readLine());

        // boolean[] visited = new boolean[vtces];
        // boolean path = hasPath(graph, src, dest, visited);

        // ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        // boolean[] visited = new boolean[vtces];
        // for(int v =0; v<vtces; v++){
        //     if(visited[v] == false){
        //         ArrayList<Integer> comp = new ArrayList<>();
        //         drawTree(graph, v, comp, visited);
        //         comps.add(comp);
        //     }
        // }

        //System.out.println(comps);

        // if we need to find the whole graph is connected or not we need to check the
        // length of comps, if it is 1 the whole graph is connected

       // System.out.println(comps.size() == 1);

    //    boolean[][] visited = new boolean[arr.length][arr[0].length];
    //    int count=0;

    //    for(int i=0; i<arr.length; i++){
    //     for(int j=0; j<arr[0].length; j++){
    //         drawTreeForComponent(arr, i, j, visited);
    //         count++;
    //     }
    //    }
        // HashSet<Integer> visited = new HashSet<>();
        // hamiltonian(graph, src, visited, src + "", 0);

        // For BFS
        // ArrayDeque<pair> queue = new ArrayDeque<>();
        // queue.add(new pair(src, src+""));
        // boolean[] visited = new boolean[vtces];

        // while(queue.size()>0){
        //     // r m* w a*
        //     pair rem = queue.removeFirst();
        //     if(visited[rem.v] == true){
        //         continue;
        //     }
        //     visited[rem.v] = true;
            
        //     System.out.println(rem.v + "@" + rem.psf);

        //     for(Edge e: graph[rem.v]){
        //         if(visited[e.nbr] == false){
        //             queue.add(new pair(e.nbr, rem.psf+e.nbr));
        //         }
        //     }
        // }

        // boolean[] visited = new boolean[vtces];
        // for(int v = 0; v<vtces; v++){
        //     if(visited[v] == false){
        //         boolean cycle = IsCyclic(graph, src, visited);
        //         if(cycle == true){
        //             System.out.println(true);
        //             return;
        //         }
        //     }
        // }

        // System.out.println(false);

        // int[] visited = new int[vtces];
        // Arrays.fill(visited, -1);
        // for(int v = 0; v<vtces; v++){
        //     if(visited[v] == -1){
        //         boolean isCompBipartite = checkComponentForBipartiteness(graph, v, visited);
        //         if(isCompBipartite== false){
        //             System.out.println(false);
        //             return;
        //         }
        //     }
        // }
        // System.out.println(true);

        // boolean[] visited = new boolean[vtces];

        // String path = ShortestPathInWeights(graph, src, dest, visited);

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for(int v=0; v < vtces; v++){
            if(visited[v] == false){
                topologicalSort(graph, v, visited, st);
            }
        }

        while (st.size()>0) {
            System.out.println(st.pop());
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src==dest){
            return true;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if(hasNbrPath == true){
                    return true;
                }
            }
        }

        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {

        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }

        visited[src] = false;
    }

    // static String spath;
    // static Integer spathwt = Integer.MAX_VALUE;
    // static String lpath;
    // static Integer lpathwt = Integer.MIN_VALUE;
    // static String cpath;
    // static Integer cpathwt = Integer.MAX_VALUE;
    // static String fpath;
    // static Integer fpathwt = Integer.MIN_VALUE;
    // static PriorityQueue<Pair> pq = new PriorityQueue<>();
    // public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf){
    //     if(src==dest){
    //         if(wsf<spathwt){
    //             spathwt= wsf;
    //             spath= psf;
    //         }
    //         if(wsf>lpathwt){
    //             lpathwt= wsf;
    //             lpath= psf;
    //         }

    //         if(wsf > criteria && wsf < cpathwt){
    //             cpathwt = wsf;
    //             cpath = psf;
    //         }

    //         if(wsf < criteria && wsf > fpathwt){
    //             fpathwt = wsf;
    //             fpath = psf;
    //         }
            
    //         if(pq.size()<k){
    //             pq.add(new Pair(wsf, psf));
    //         }
    //         else{
    //             if(wsf > pq.peek().wsf){
    //                 pq.remove();
    //                 pq.add(new Pair(wsf, psf));
    //             }
    //         }
    //         return;
    //     }

    //     visited[src] = true;
    //     for(Edge e: graph[src]){
    //         if(visited[e.nbr] == false){
    //             multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr , wsf + e.wt);
    //         }
    //     }
    //     visited[src]=false;
    // }

    public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                drawTree(graph, e.nbr, comp, visited);
            }
        }
    }

    public static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || visited[i][j] == true){
            return;
        }
        visited[i][j] = true;

        drawTreeForComponent(arr, i-1, j, visited);
        drawTreeForComponent(arr, i, j+1, visited);
        drawTreeForComponent(arr, i, j-1, visited);
        drawTreeForComponent(arr, i+1, j, visited);
    }

    public static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc){

        if(visited.size() == graph.length-1){
            System.out.println(psf);
            boolean closingEdgeFound = false;
            for(Edge e: graph[src]){
                if(e.nbr == osrc){
                    closingEdgeFound = true;
                    break;
                }
            }

            if(closingEdgeFound){
                System.out.println("*");
            }
            else{
                System.out.println(".");
            }
            return;
        }
        visited.add(src);
        for(Edge e : graph[src]){
            if(visited.contains(e.nbr) ==  false){
                hamiltonian(graph, e.nbr, visited, psf+e.nbr, osrc);
            }
        }
        visited.remove(src);
    } 
     
    public static boolean IsCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){
        ArrayDeque<pair> q  = new ArrayDeque<>();
        q.add(new pair(src, src+""));

        while(q.size()>0){
            pair rem = q.removeFirst();

            if(visited[rem.v] == true){
                return true;
            }
            visited[rem.v] = true;

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    q.add(new pair(e.nbr, rem.psf+e.nbr));
                }
            }
        }

        return false;
    }

    public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited){
        ArrayDeque<BPair> q  = new ArrayDeque<>();
        q.add(new BPair(src, src+"", 0));

        while(q.size()>0){
            BPair rem = q.removeFirst();

            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]){
                    return false;
                }
            }
            else{
                visited[rem.v] = rem.level;
            }

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == -1){
                    q.add(new BPair(e.nbr, rem.psf+e.nbr, rem.level + 1));
                }
            }
        }

        return true;
    }

    public static String ShortestPathInWeights(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src+"", 0));

        while(pq.size()>0){
            
            Pair rem = pq.remove();

            if(rem.v == dest){
  
                return rem.psf;
            }

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wsf+e.wt));
                }
            }
        }

        return "";
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
        visited[src] = true;
        for(Edge e:graph[src]){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }
}
