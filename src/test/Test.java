package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Test {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int j = 1, count = 1;
        for(int i = 1; i<size; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path1 = new LinkedList();
        LinkedList<TreeNode> path2 = new LinkedList();
        findPath(root, p, path1);
        findPath(root, q, path2);
        int size1 = path1.size();
        int size2 = path2.size();
        int index = 0;
        while (index < size1 && index < size2){
            if(path1.get(index) != path2.get(index)){
                break;
            }
            index++;
        }
        return path1.get(index -1);
    }

    private void findPath(TreeNode root, TreeNode givenNode, LinkedList<TreeNode> path){
        if(root == null)
            return;
        path.add(root);
        findPath(root.left, givenNode, path);
        findPath(root.right, givenNode, path);
        if(path.peekLast().val != givenNode.val)
            path.pollLast();
    }


    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int size = nums.length;
        if(size % k != 0)
            return false;
        for(int i=0; i<size; i++){
            if(treeMap.containsKey(nums[i])){
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            }else{
                treeMap.put(nums[i], 1);
            }
        }
        while (!treeMap.isEmpty()){
            Map.Entry<Integer, Integer> entrySet = treeMap.firstEntry();
            int number = entrySet.getKey();
            for(int consecutive = number; consecutive<=k; consecutive++){
                if(treeMap.containsKey(consecutive)){
                    int frq = treeMap.get(consecutive);
                    if(frq == 1){
                        treeMap.remove(consecutive);
                    }else{
                        treeMap.put(consecutive, treeMap.get(consecutive) - 1);
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }


}
