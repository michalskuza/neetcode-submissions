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
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode curr = root;
            TreeNode parent = null;

            // 1. ZNAJDŹ WĘZEŁ (Iteracyjnie)
            while (curr != null && curr.val != key) {
                parent = curr;
                if (key < curr.val) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            // Jeśli nie znaleziono węzła
            if (curr == null) return root;

            // 2. PRZYPADEK C: DWOJE DZIECI
            // Strategia: Znajdź następnika, podmień wartość, a potem
            // zredukuj problem do usunięcia następnika (który ma 0 lub 1 dziecko).
            if (curr.left != null && curr.right != null) {
                TreeNode successor = curr.right;
                TreeNode successorParent = curr;

                // Idź maksymalnie w lewo w prawym poddrzewie
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }

                // Podmień wartość usuwanego węzła na wartość następnika
                curr.val = successor.val;

                // Teraz musimy usunąć 'successor'.
                // Przesuwamy wskaźniki 'curr' i 'parent' na następnika,
                // aby kod poniżej (obsługujący 0/1 dziecka) go usunął.
                curr = successor;
                parent = successorParent;
            }

            // 3. PRZYPADEK A i B: 0 lub 1 DZIECKO
            // (Tutaj trafiamy od razu lub po redukcji przypadku z dwojgiem dzieci)

            // Wybieramy jedyne dziecko (lub null, jeśli brak dzieci)
            TreeNode child;
            if (curr.left != null) {
                child = curr.left;
            } else {
                child = curr.right;
            }

            // Fizyczne usunięcie węzła (przepięcie wskaźników)
            if (parent == null) {
                // Usuwamy korzeń (root)
                return child;
            } else if (curr == parent.left) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            return root;
        }
}