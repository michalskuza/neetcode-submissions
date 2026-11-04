/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
                    var list = new ArrayList<List<Integer>>();

            if (root == null) {
                return list;
            }

            // NAJWAŻNIEJSZA ZMIANA:
            // Typ zmiennej to Queue (interfejs), ale implementacja to ArrayDeque (szybkość)
            Queue<TreeNode> queue = new ArrayDeque<>();

            queue.offer(root); // Używamy offer zamiast add

            int level = 0;
            while (!queue.isEmpty()) {
                int levelLength = queue.size();

                var nodes = new ArrayList<Integer>();
                
                for (int i = 0; i < levelLength; i++) {
                    TreeNode curr = queue.poll(); // Używamy poll zamiast removeFirst

                    nodes.add(curr.val);

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
                
                list.add(nodes);
                
                level++;
            }
            
            return list;
    }
}
