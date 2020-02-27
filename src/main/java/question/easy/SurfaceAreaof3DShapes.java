package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-27 16:34
 * @version V1.0
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 *
 *  
 *
 * Example 1:
 *
 * Input: [[2]]
 * Output: 10
 * Example 2:
 *
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 *
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 *
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 *
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *  
 *
 * Note:
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 */
public class SurfaceAreaof3DShapes {

    public static void main(String[] args) {

    }

    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }

        return ans;
    }

}
