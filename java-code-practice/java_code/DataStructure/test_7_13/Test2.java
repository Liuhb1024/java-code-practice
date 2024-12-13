package test_7_13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2023/7/24
 */
public class Test2 {
    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 示例 1:
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * 示例 2:
     * 输入: numRows = 1
     * 输出: [[1]]
     * 提示:
     * 1 <= numRows <= 30
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);
        //这上面相当于第一行已经处理完
        //下面从第二行开始
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);//新的一行的第一个值

            //这里处理中间列
            //上一行
            List<Integer>prevRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {

                //[i][j] = [i-1][j] + [i-1][j-1]
                int x = prevRow.get(j) + prevRow.get(j-1);
                curRow.add(x);
            }

            curRow.add(1);//新的一行的最后一个值

            ret.add(curRow);

        }

        return ret;
    }
}
