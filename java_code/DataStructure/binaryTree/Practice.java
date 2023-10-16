package DataStructure.binaryTree;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/10/16
 */
public class Practice {
}


/*二叉树遍历
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(char val){
        this.val = val;
    }
    TreeNode(char val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            TreeNode root = createTree(str);
            inorder(root);
        }
    }

    public static int i = 0;

    public static TreeNode createTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}*/

/*对称二叉树
*
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

class Solution {
    public boolean isSymmetricChild(TreeNode p, TreeNode q){
        if(p == null && q != null || p != null && q == null){
            return false;
        }

        if( p == null && q == null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return isSymmetricChild(p.left, q.right) &&
                isSymmetricChild(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricChild(root.left, root.right);
    }
}
*/


/**平衡二叉树

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


 //这种写法的时间复杂度太大了
 class Solution {
 public int getHeight(TreeNode root){
 if (root == null) return 0;
 int leftLeaf = getHeight(root.left);
 int rightLeaf = getHeight(root.right);
 return leftLeaf > rightLeaf
 ? leftLeaf+1
 : rightLeaf+1;
 }
 public boolean isBalanced(TreeNode root) {
 if(root == null) return true;

 int leftHeight = getHeight(root.left);
 int rightHeight = getHeight(root.right);

 return Math.abs(leftHeight-rightHeight) <= 1
 && isBalanced(root.left)
 && isBalanced(root.right);
 }
 }

//第二种思路：在求高度的过程中，就判断树是否平衡
class Solution {
    public int getHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight >= 0 && rightHeight >= 0
                && Math.abs(leftHeight - rightHeight) <= 1){
            return Math.max(leftHeight, rightHeight) + 1;
        }else{
            return -1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return getHeight(root) >= 0;
    }
}

 */

/*翻转二叉树
*
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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

*/


/*相同的树
*
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

//时间复杂度：O1
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        //两个都为空
        if(p == null && q == null){
            return true;
        }
        //这里一定是两个 引用 都不为空  两个不为空
        if(p.val != q.val){
            return false;
        }
        //这里证明 p q 都不为空 同时根节点相同
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
 */

/*另一棵树的子树


*
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


 1.根节点和subRoot是不是相同的
 2.subRoot是不是root.left的子树

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        //两个都为空
        if(p == null && q == null){
            return true;
        }
        //这里一定是两个 引用 都不为空  两个不为空
        if(p.val != q.val){
            return false;
        }
        //这里证明 p q 都不为空 同时根节点相同
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)){
            return true;
        }

        if(isSubtree(root.left, subRoot)){
            return true;
        }

        if(isSubtree(root.right, subRoot)){
            return true;
        }

        return false;
    }
}

*/
