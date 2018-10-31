package link;

/**
 * link.LinkMain
 *
 * @author Created by WXG on 2018/10/31 031 18:32.
 * @version V1.0
 */

public class LinkMain {

    public static void main(String[] args) {
        testOneWayLink();
//        testBothWayLink();
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

//        linkedList.remove(2);
//        System.out.println("linkedList.remove(2)");
//        System.out.println("linkedList.getSize() : " + linkedList.getSize());
//        System.out.println("linkedList.getHead() : " + linkedList.getHead());
//        System.out.println("linkedList.getLast() : " + linkedList.getLast());
//        System.out.println("----------------------------------------------");

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

        testLoopList(linkedList);
//        testRemove(linkedList);
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
    }

}
