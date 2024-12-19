package org.dsa.graphs.concepts;

import java.util.*;

public class CheapestFlightsWithKStops {

    public static int findCheapestPrice(ArrayList<EdgeWeight>[] graph, int n, int src, int dst, int k) {
        // Priority queue to store {cost, currentNode, stopsUsed}
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, 0)); // Start with src, cost = 0, stops = 0

        // Distance array to store the minimum cost to reach each node with a specific number of stops
        int[][] dist = new int[n][k + 2]; // Track min costs up to (k+1) stops (stops range 0 to k+1)
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0; // Cost to reach the source node with 0 stops is 0

        // Visited array to track if we’ve visited a node with a given number of stops
        boolean[][] visited = new boolean[n][k + 2];

        // BFS using priority queue
        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            int node = current.node, cost = current.cost, stops = current.stops;

            // If destination is reached, return the cost
            if (node == dst) return cost;

            // If we have used more than k stops, skip further processing
            if (stops > k) continue;

            // Mark the node as visited for the current number of stops
            visited[node][stops] = true;

            // Explore all neighbors of the current node
            for (EdgeWeight edge : graph[node]) {
                int neighbor = edge.destination;
                int newCost = cost + edge.weight;

                // Only process the neighbor if it offers a cheaper cost with stops+1 or it hasn't been visited
                if (newCost < dist[neighbor][stops + 1] && !visited[neighbor][stops + 1]) {
                    dist[neighbor][stops + 1] = newCost;
                    pq.add(new Pair(neighbor, newCost, stops + 1));
                }
            }
        }

        // If we exhaust the queue without finding the destination, return -1
        return -1;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    // Helper class to store edges with weights
    public static class EdgeWeight {
        int source, destination, weight;

        public EdgeWeight(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Helper class to store elements in the priority queue
    public static class Pair implements Comparable<Pair> {
        int node, cost, stops;

        public Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Pair other) {
            return this.cost - other.cost; // Min-heap based on cost
        }
    }

    public static void main(String[] args) {
        // Number of nodes (cities)
        int n = 4;

        // Initialize graph as adjacency list
        ArrayList<EdgeWeight>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Add flights: (from, to, price)
        graph[0].add(new EdgeWeight(0, 1, 100));
        graph[1].add(new EdgeWeight(1, 2, 100));
        graph[2].add(new EdgeWeight(2, 0, 100));
        graph[1].add(new EdgeWeight(1, 3, 600));
        graph[2].add(new EdgeWeight(2, 3, 200));

        // Define source, destination, and max allowed stops
        int src = 0, dst = 3, k = 1;

        // Find the cheapest price
        int result = findCheapestPrice(graph, n, src, dst, k);

        // Print the result
        System.out.println("Cheapest Price: " + result); // Output: 700
    }
}
