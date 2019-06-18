package huisu;

public class HasPath {

/**
 * @Description:
 * Created by shanzhihong on 2019/06/18-21:03.
 * @version 1.0
 */

    private int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        char[][] m = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = matrix[idx++];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(m, rows, cols, str, new boolean[rows][cols], 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] m, int rows, int cols, char[] str, boolean[][] used, int path, int r, int c) {
        if (path == str.length) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if (m[r][c] != str[path]) return false;
        if (used[r][c]) return false;
        used[r][c] = true;
        for (int i = 0; i < next.length; i++) {
            if (backtrack(m, rows, cols, str, used, path + 1, r + next[i][0], c + next[i][1])) return true;
        }
        used[r][c] = false;
        return false;
    }

    public static void main(String args[]){
        HasPath hasPath = new HasPath();
        char mix[] = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char path[] = {'a','b','f','b'};
        System.out.println(hasPath.hasPath(mix,3,4,path));
    }
}
