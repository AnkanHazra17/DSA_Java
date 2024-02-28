import java.util.ArrayList;

class AdjacencyMatrix {
    int vertexCount;
    int[][] matrix;

    AdjacencyMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new int[vertexCount][vertexCount];
    }

    // Add edge from source to destination
    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    // Delete edge from graph
    public void deleteEdge(int source, int destination) {
        matrix[source][destination] = 0;
        matrix[destination][source] = 0;
    }

    // print a Graph
    public void printGraph() {
        System.out.println("Representation of graph using Adjacency matrix:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < vertexCount; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < vertexCount; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }
}

class AdjacencyList {
    int vertexCount;
    ArrayList<Integer>[] arr;

    AdjacencyList(int vertexCount) {
        this.vertexCount = vertexCount;
        arr = new ArrayList[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        arr[src].add(dest);
        arr[dest].add(src);
    }

    public void deleteEdge(int src, int dest) {
        arr[src].remove(Integer.valueOf(dest));
        arr[dest].remove(Integer.valueOf(src));
    }

    public void printGraph() {
        System.out.println("Printing Adjacency List: ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < arr[i].size(); j++) {
                System.out.print(arr[i].get(j) + " ");
            }
            System.out.println();
        }
    }

}

public class Graph {

    public static void main(String[] args) {
        // AdjacencyMatrix grp1 = new AdjacencyMatrix(3);
        // grp1.addEdge(0, 1);
        // grp1.addEdge(0, 2);
        // grp1.addEdge(1, 2);

        // grp1.printGraph();
        // grp1.deleteEdge(1, 2);
        // grp1.printGraph();

        AdjacencyList grp2 = new AdjacencyList(5);
        grp2.addEdge(0, 1);
        grp2.addEdge(0, 4);
        grp2.addEdge(1, 2);
        grp2.addEdge(1, 3);
        grp2.addEdge(2, 3);
        grp2.addEdge(3, 4);

        grp2.printGraph();
        grp2.deleteEdge(1, 2);
        grp2.printGraph();
    }
}