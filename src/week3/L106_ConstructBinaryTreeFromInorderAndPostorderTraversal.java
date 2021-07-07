package week3;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new L106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(map, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        public TreeNode build(Map<Integer, Integer> inorderIndex, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }
            final TreeNode treeNode = new TreeNode(postorder[postEnd]);
            final Integer midIndex = inorderIndex.get(postorder[postEnd]);
            int leftLen = midIndex - inStart;

            treeNode.left = build(inorderIndex, inStart, inStart + leftLen - 1,
                    postorder, postStart, postStart + leftLen - 1);

            treeNode.right = build(inorderIndex, inStart + leftLen + 1, inEnd,
                    postorder, postStart + leftLen, postEnd - 1);
            return treeNode;
        }


    }

}