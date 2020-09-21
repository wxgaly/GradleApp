package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-16 16:01
 * @version V1.0
 *
 * Given an?integer array?sorted in non-decreasing order,
 * there is exactly one integer in the array that occurs more than 25% of the time.
 *
 * Return that integer.
 *
 * ?
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * ?
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 *
 */
public class ElementAppearingMoreThan25InSortedArray {

    public static void main(String[] args) {
        ElementAppearingMoreThan25InSortedArray elementAppearingMoreThan25InSortedArray = new ElementAppearingMoreThan25InSortedArray();
        System.out.println(elementAppearingMoreThan25InSortedArray.findSpecialInteger(new int[]{
                1, 2, 2, 6, 6, 6, 6, 7, 10
        }));
    }

    public int findSpecialInteger1(int[] arr) {
        int len = arr.length;
        int maxCount = 1;
        int temp = arr[0];
        int count = 0;

        for (int i = 1; i < len; i++) {
            if (temp != arr[i]) {
                temp = arr[i];
                if (count > maxCount) {
                    maxCount = count;
                    count = 0;
                    if ((float) maxCount / len > 0.25) {
                        temp = arr[i - 1];
                        break;
                    }
                }
            } else {
                count++;
            }
        }

        return temp;
    }

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int tag = len / 4 + 1;
        int tagV;
        int tagIndex;
        for (int i = 0; i < len - tag + 1; i++) {
            tagV = arr[i];
            tagIndex = i + tag - 1;
            if (tagV == arr[tagIndex]) {
                return tagV;
            } else {
                // 当前元素不满足情况则找出arr[tagIndex]对应的值的起始位置,二分查找
                // 查找过程复杂度为log(n)小于遍历O(n)
                int tmp = find(arr, arr[tagIndex], i + 1, tagIndex);
//                i = tmp != -1 ? tmp - 1 : i;
                i = tmp - 1;
            }
        }
        return 0;
    }

    public int find(int[] arr, int value, int start, int end) {
        int index = end;
        if (start <= end) {
            int middle = (start + end) / 2;
            // 说明起始值在middle + 1 ～ end之间
            if (arr[middle] < value) {
                index = find(arr, value, middle + 1, end);
            } else if (start == end) {
                return index;
            } else {
                // 说明起始值在start～middle之间
                index = find(arr, value, start, middle);
            }
        }
        return index;
    }


}
