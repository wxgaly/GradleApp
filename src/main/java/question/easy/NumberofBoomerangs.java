package question.easy;

import java.util.HashMap;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-21 16:30
 * @version V1.0
 *
 *Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points
 * are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 *
 */
public class NumberofBoomerangs {

    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for(int i = 0;i < points.length;i++){
            hashMap.clear();
            for(int j = 0;j < points.length;j++){
                if(i == j){
                    continue;
                }
                int d =  (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                if(hashMap.containsKey(d)){
                    res += hashMap.get(d) * 2;
                    hashMap.put(d, hashMap.get(d) + 1);
                }else{
                    hashMap.put(d,1);
                }
            }
        }
        return res;
    }

}
