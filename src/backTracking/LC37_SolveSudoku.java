package backTracking;

import java.util.ArrayList;
import java.util.List;

/*
    题目：解数独
    难度：hard
    编写一个程序，通过填充空格来解决数独问题。
    数独的解法需 遵循如下规则：
        数字1-9在每一行只能出现一次。
        数字1-9在每一列只能出现一次。
        数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
    数独部分空格内已填入了数字，空白格用'.'表示。
    链接：https://leetcode-cn.com/problems/sudoku-solver
 */
/*
    直接回溯＋判断
 */
public class LC37_SolveSudoku {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
