package stack;

/**
 * stack.StackMain
 *
 * @author Created by WXG on 2018/11/1 001 10:24.
 * @version V1.0
 */

public class StackMain {

    public static void main(String[] args) {
//        testArrayStack();
        testLinkedStack();
    }

    private static void testLinkedStack() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);

        testLooplinkedStack(linkedStack);
        System.out.println(linkedStack.pop());
        testLooplinkedStack(linkedStack);
        System.out.println(linkedStack.pop());
        testLooplinkedStack(linkedStack);
        System.out.println(linkedStack.pop());
        testLooplinkedStack(linkedStack);
        System.out.println(linkedStack.pop());
        testLooplinkedStack(linkedStack);
        System.out.println(linkedStack.pop());
        testLooplinkedStack(linkedStack);
    }

    private static void testLooplinkedStack(LinkedStack<Integer> linkedStack) {
        for (int i = 0; i < linkedStack.getSize(); i++) {
            System.out.println("arrayStack.getValue : " + linkedStack.getValue(i));
        }
        System.out.println("----------------------------------------------");
    }

    private static void testArrayStack() {

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        testLoopArrayStack(arrayStack);
        System.out.println(arrayStack.pop());
        testLoopArrayStack(arrayStack);
        System.out.println(arrayStack.pop());
        testLoopArrayStack(arrayStack);
        System.out.println(arrayStack.pop());
        testLoopArrayStack(arrayStack);
        System.out.println(arrayStack.pop());
        testLoopArrayStack(arrayStack);
        System.out.println(arrayStack.pop());
        testLoopArrayStack(arrayStack);
    }

    private static void testLoopArrayStack(ArrayStack<Integer> arrayStack) {
        for (int i = 0; i < arrayStack.getSize(); i++) {
            System.out.println("arrayStack.getValue : " + arrayStack.getValue(i));
        }
        System.out.println("----------------------------------------------");
    }

}
