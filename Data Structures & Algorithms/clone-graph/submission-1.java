/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;

            Map<Node, Node> visited = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();

            // Clone the first node and put it into the visited map
            Node cloneNode = new Node(node.val);
            visited.put(node, cloneNode);
            queue.add(node);

            // BFS traversal
            while (!queue.isEmpty()) {
                Node current = queue.poll();

                // Iterate through current node's neighbors
                for (Node neighbor : current.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        // Clone neighbor
                        Node neighborClone = new Node(neighbor.val);
                        visited.put(neighbor, neighborClone);
                        queue.add(neighbor);
                    }
                    // Add the neighbor clone to the current clone node's neighbor list
                    visited.get(current).neighbors.add(visited.get(neighbor));
                }
            }

            return cloneNode;
        }
}