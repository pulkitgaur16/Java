import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graphs {
    // to visualise graphs
    //i) Adjacency matrix : in terms of 2d array when vertices<10000

    //ii) Adjacency list : array of arraylist (arraylist are of edges of graph)

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

    static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
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

        // int src = Integer.parseInt(br.readLine());
        // int dest = Integer.parseInt(br.readLine());

        // boolean[] visited = new boolean[vtces];
        // boolean path = hasPath(graph, src, dest, visited);

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        for(int v =0; v<vtces; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        //System.out.println(comps);

        // if we need to find the whole graph is connected or not we need to check the
        // length of comps, if it is 1 the whole graph is connected

        System.out.println(comps.size() == 1);
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src==dest){
            return true;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest);
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

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf){
        if(src==dest){
            if(wsf<spathwt){
                spathwt= wsf;
                spath= psf;
            }
            if(wsf>lpathwt){
                lpathwt= wsf;
                lpath= psf;
            }

            if(wsf > criteria && wsf < cpathwt){
                cpathwt = wsf;
                cpath = psf;
            }

            if(wsf < criteria && wsf > fpathwt){
                fpathwt = wsf;
                fpath = psf;
            }
            
            if(pq.size()<k){
                pq.add(new Pair(wsf, psf));
            }
            else{
                if(wsf > pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }

        visited[src] = true;
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr , wsf + e.wt);
            }
        }
        visited[src]=false;
    }

    public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                drawTree(graph, e.nbr, comp, visited);
            }
        }
    }
     
}
