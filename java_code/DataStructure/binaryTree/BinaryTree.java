package DataStructure.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2023/10/13
 */
public class BinaryTree {
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root; //将来这个引用就是根节点

    //穷举法
    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    //前序遍历
    public void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }


    //将前序遍历的结果，存储到 List 中
    /*List<TreeNode> ret = new ArrayList<>();

    public List<TreeNode> preOrder2(TreeNode root){
        if (root == null) return ret;
        ret.add(root);
        postOrder(root.left);
        postOrder(root.right);
        return ret;
    }*/

    //以上的递归并没有很好的利用好返回值

    public List<TreeNode> preOrder2(TreeNode root){
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) return ret;

        ret.add(root);

        List<TreeNode> leftTree = preOrder2(root.left);
        ret.addAll(leftTree);
        List<TreeNode> rightTree = preOrder2(root.right);
        ret.addAll(rightTree);

        return ret;
    }

    //中序遍历
    public List<TreeNode> inOrder2(TreeNode root){
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) return ret;


        List<TreeNode> leftTree = inOrder2(root.left);
        ret.addAll(leftTree);
        ret.add(root);

        List<TreeNode> rightTree = inOrder2(root.right);
        ret.addAll(rightTree);

        return ret;
    }

    //后序遍历
    public List<TreeNode> postOrder2(TreeNode root){
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) return ret;


        List<TreeNode> leftTree = postOrder2(root.left);
        ret.addAll(leftTree);

        List<TreeNode> rightTree = postOrder2(root.right);
        ret.addAll(rightTree);
        ret.add(root);

        return ret;
    }

    /**
     * 二叉树中的基本操作
     */

    //获取树中节点的个数
    public int size = 0;
    public int nodeSize(TreeNode root){
        if (root == null) return 0;
        size++;

        nodeSize(root.left);
        nodeSize(root.right);
        return size;
    }

    public int nodeSize2(TreeNode root){
         if (root == null) return 0;

         return nodeSize2(root.left)+nodeSize2(root.right)+1;
    }


    //获取叶子节点的个数  也就是度为 0 的节点
    public int leafSize = 0;

    public void getLeafSize(TreeNode root){
        if (root == null) return;

        if (root.left == null && root.right == null){
            leafSize++;
        }

        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    public int getLeafSize2(TreeNode root){
        if (root == null) return 0;

        if (root.left == null && root.right == null){
            return 1;
        }

        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }


    //获取第 k 层节点的个数
    public int getKlevelNodeCount(TreeNode root, int k){
        if (root == null) return 0;
        if (k == 1) return 1;

        return getKlevelNodeCount(root.left,k-1)
                + getKlevelNodeCount(root.right,k-1);
    }

    //获取二叉树的高度
    //这种写法时间复杂度太大
    public int getHeight(TreeNode root){
        if (root == null) return 0;
        return getHeight(root.left) > getHeight(root.right)
                ? getHeight(root.left)+1
                : getHeight(root.right)+1;
    }

    public int getHeight2(TreeNode root){
        if (root == null) return 0;
        int leftLeaf = getHeight2(root.left);
        int rightLeaf = getHeight2(root.right);
        return leftLeaf > rightLeaf
                ? leftLeaf+1
                : rightLeaf+1;
    }

    //检测值为 value 的元素是否存在
    public boolean find(TreeNode root, char key){
        if (root == null) return false;
        if (root.val == key) return true;

        boolean leftVal = find(root.left,key);
        if (leftVal == true) return true;

        boolean rightVal = find(root.right,key);
        if (rightVal == true) return true;

        return false;
    }
}























