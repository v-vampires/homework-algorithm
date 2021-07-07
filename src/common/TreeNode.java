package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yifanl
 * @Date 2020/3/3 8:12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode of(Integer... data){
        return TreeNode.of(Arrays.asList(data));
    }

    public static TreeNode createOf(List<Integer> data){
        if(data == null || data.size() == 0){
            return null;
        }
        Integer node = data.remove(0);
        TreeNode r = new TreeNode(node);
        if(node!= null){
            r.left = createOf(data);
            r.right = createOf(data);
        }
        return r;
    }

    public static TreeNode of(List<Integer> data) {
        if (data == null || data.size() == 0) {
            return null;
        }
        //[3,9,20,null,null,15,7]
        //[1,null,2,3]
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        q.add(root);
        int index = 1;
        while (index < data.size()) {
            TreeNode rt = q.poll();
            TreeNode l = data.get(index) != null ? new TreeNode(data.get(index)) : null;
            q.add(l);
            TreeNode r = null;
            if(index +1 < data.size()){
                r = data.get(index + 1) != null ? new TreeNode(data.get(index + 1)) : null;
                q.add(r);
            }
            index = index + 2;
            if(rt == null){
                continue;
            }
            rt.left = l;
            rt.right = r;

        }
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.of(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(node);
    }
}
