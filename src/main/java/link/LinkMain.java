package link;

import java.util.Scanner;

/**
 * link.LinkMain
 *
 * @author Created by WXG on 2018/10/31 031 18:32.
 * @version V1.0
 */

public class LinkMain {

    public static void main(String[] args) {
//        testOneWayLink();
//        testBothWayLink();
        testOpt();
    }

    private static void testOpt() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
//        int leftCount = scanner.nextInt();
//        int rightCount = scanner.nextInt();
//
//        int totalCount = rightCount - leftCount;
//        if (totalCount < 0) {
//            totalCount = -totalCount;
//        }

        CircularLinkedList<Character> linkedList = new CircularLinkedList<>();

        for (char c : str.toCharArray()) {
            linkedList.add(c);
        }

        Node<Character> head = linkedList.getHead();
        Node<Character> node = head;
        StringBuilder stringBuilder = new StringBuilder(str.length());

        while (!node.nextNode.equals(head)) {
            stringBuilder.append(node.nextNode.value);
            node = node.nextNode;
        }

        System.out.println(stringBuilder.toString());

        linkedList.setHead(1);

        head = linkedList.getHead();
        node = head;
        stringBuilder = new StringBuilder(str.length());

        while (!node.nextNode.equals(head)) {
            stringBuilder.append(node.nextNode.value);
            node = node.nextNode;
        }

        System.out.println(stringBuilder.toString());
    }

    private static void testOneWayLink() {
        OneWayLinkedList<Integer> linkedList = new OneWayLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(2);
        System.out.println("linkedList.remove(2)");
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(5);
        System.out.println("linkedList.remove(5)");
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(1);
        System.out.println("linkedList.remove(1)");
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(4);
        System.out.println("linkedList.remove(4)");
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        int size = linkedList.getSize();

        for (int i = 0; i < size; i++) {
            System.out.println("linkedList.getValue() : " + linkedList.getValue(i));
        }
    }

    private static void testBothWayLink() {

        BothWayLinkedList<Integer> linkedList = new BothWayLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        testRemove(linkedList);
        testLoopList(linkedList);
    }

    private static void testLoopList(BothWayLinkedList<Integer> linkedList) {
        int size = linkedList.getSize();

        for (int i = 0; i < size; i++) {
            System.out.println("linkedList.getValue() : " + linkedList.getValue(i));
        }
    }

    private static void testRemove(BothWayLinkedList<Integer> linkedList) {
        linkedList.remove(2);
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(5);
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(1);
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
        System.out.println("----------------------------------------------");

        linkedList.remove(3);
        System.out.println("linkedList.getSize() : " + linkedList.getSize());
        System.out.println("linkedList.getHead() : " + linkedList.getHead());
        System.out.println("linkedList.getLast() : " + linkedList.getLast());
    }

}
