package DataStructure.binaryTree;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2023/10/13
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println("===");

        binaryTree.preOrder(root);
        System.out.println();

        binaryTree.inOrder(root);
        System.out.println();

        binaryTree.postOrder(root);
        System.out.println();

        System.out.println("=====================================");
        List<BinaryTree.TreeNode> ret =  binaryTree.preOrder2(root);
        for (BinaryTree.TreeNode x : ret){
            System.out.print(x.val+" ");
        }
        System.out.println("=============");
        binaryTree.nodeSize(root);
        System.out.println("节点的个数："+binaryTree.size);
        System.out.println("============================");
        System.out.println("节点的个数："+binaryTree.nodeSize2(root));
        System.out.println("=============================");
        binaryTree.getLeafSize(root);
        System.out.println("叶子节点的个数："+binaryTree.leafSize);
        System.out.println("===============================");

        //这里写 blog 的时候 debug 一下
        boolean flg = binaryTree.find(root,'E');
        if (flg == true){
            System.out.println("找到这个节点");
        }else{
            System.out.println("找不到！");
        }
    }
}
