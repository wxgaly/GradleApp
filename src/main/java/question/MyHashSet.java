package question;

/**
 * question.MyHashSet
 *
 * @author Created by WXG on 2019/3/8 008 14:36.
 * @version V1.0
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 * <p>
 * Example:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */

public class MyHashSet {

    private static final int MAX_SIZE = 1000000;
    private int[] array = new int[16];

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }

    public void add(int key) {
        int index = calHashCode(key);
        if (index >= array.length) {
            int newSize = index * 2;
            int[] copy = new int[newSize];
            System.arraycopy(array, 0, copy, 0, array.length);
            array = copy;
        }
        array[index] = key;
    }

    public void remove(int key) {
        int index = calHashCode(key);
        if (index < array.length) {
            array[index] = -1;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = calHashCode(key);
        if (index >= array.length) {
            return false;
        }
        return array[index] != -1 && array[index] == key;
    }

    public int calHashCode(int value) {
        return (31 * value) % MAX_SIZE;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
//        hashSet.add(1);
//        hashSet.add(2);
//        System.out.println(hashSet.contains(1));    // returns true
//        System.out.println(hashSet.contains(3));    // returns false (not found)
//        hashSet.add(2);
//        System.out.println(hashSet.contains(2));    // returns true
//        hashSet.remove(2);
//        System.out.println(hashSet.contains(2));    // returns false (already removed)
        hashSet.add(0);
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
