package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-11 16:05
 * @version V1.0
 *
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
 * return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
 *
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j,
 * or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row,
 * that is, always ones may appear first and then zeros.
 *
 *  
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 *  
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 *
 *
 */
public class TheKWeakestRowsinaMatrix {

    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            map.put(i, count);
        }
        List<Integer> indexList = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            indexList.add(i);
        }
        indexList.sort(Comparator.comparingInt(map::get));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = indexList.get(i);
        }
        return res;
    }

    public int[] kWeakestRows1(int[][] mat, int k) {
        int[][] tmp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                tmp[i][0] = i;
                if (mat[i][j] == 1) tmp[i][1] += 1;
            }
        }
        Arrays.sort(tmp, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tmp[i][0];
        }
        return res;
    }

}
