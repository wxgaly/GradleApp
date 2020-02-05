package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-04 17:40
 * @version V1.0
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y. 
 * The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *  
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *  
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 *
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int x = 5;
        System.out.println(x);
        System.out.println(~x & 0xff);
    }

    public int lastStoneWeight(int[] stones) {
        int index = stones.length-1;
        while(index > 0){
            int max = 0;
            for(int j=0;j<2;j++){
                max = 0;
                for(int i=1;i<=index-j;i++){
                    if(stones[i]>stones[max]){
                        max = i;
                    }
                }
                if(max < index-j){
                    int temp = stones[max];
                    stones[max] = stones[index-j];
                    stones[index-j] = temp;
                }
            }
            stones[index-1] = stones[index] - stones[index-1];
            index--;
            if(stones[index] == 0){
                index--;
            }
        }
        return index;
    }
}

