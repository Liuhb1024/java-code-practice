package test_5_17;
import java.util.ArrayList;
import java.util.*;
public class Test5 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 0) return res;

            // 第一行固定为1
            res.add(new ArrayList<>());
            res.get(0).add(1);

            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> preRow = res.get(i - 1);
                // 每行第一个数固定为1
                row.add(1);
                // 根据上一行计算当前行中间的数
                for (int j = 1; j < i; j++) {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
                // 每行最后一个数固定为1
                row.add(1);
                res.add(row);
            }
            return res;
        }
    }
}
