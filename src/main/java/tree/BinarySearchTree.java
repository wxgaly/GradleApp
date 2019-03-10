package tree;

import java.util.*;

/**
 * tree.BinarySearchTree
 *
 * @author Created by WXG on 2019/2/25 025 10:13.
 * @version V1.0
 */

public class BinarySearchTree {

    private BinaryTreeNode<Integer> rootNode;

    public BinaryTreeNode<Integer> find(int value) {
        BinaryTreeNode<Integer> p = rootNode;

        while (p != null) {
            if (value < p.value) {
                p = p.left;
            } else if (value > p.value) {
                p = p.right;
            } else {
                return p;
            }
        }

        return null;
    }

    public void insert(int value) {

        if (rootNode == null) {
            rootNode = new BinaryTreeNode<>();
            rootNode.value = value;
            return;
        }

        BinaryTreeNode<Integer> p = rootNode;

        while (p != null) {
            if (value > p.value) {
                if (p.right == null) {
                    p.right = new BinaryTreeNode<>();
                    p.right.value = value;
                    return;
                }

                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new BinaryTreeNode<>();
                    p.left.value = value;
                    return;
                }

                p = p.left;
            }
        }
    }

    public void delete(int value) {
        if (rootNode == null) {
            return;
        }

        BinaryTreeNode<Integer> root = rootNode;
        BinaryTreeNode<Integer> temp = rootNode;

        while (root != null) {
            if (value < root.value) {
                temp = root;
                root = root.left;
            } else if (value > root.value) {
                temp = root;
                root = root.right;
            } else {
                if (root.left == null && root.right == null) {
                    if (temp.right == root) {
                        temp.right = null;
                    } else {
                        temp.left = null;
                    }

                } else if (root.left != null && root.right != null) {

                    BinaryTreeNode<Integer> minRootNode;
                    BinaryTreeNode<Integer> minNode = root.right;

                    while (true) {

                        minRootNode = minNode;
                        minNode = minNode.left;

                        if (minNode.left == null) {
                            break;
                        }
                    }

                    root.value = minNode.value;
                    minRootNode.left = null;
                } else {
                    if (temp.right == root) {
                        if (root.left != null) {
                            temp.right = root.left;
                        } else {
                            temp.right = root.right;
                        }
                    } else {
                        if (root.left != null) {
                            temp.left = root.left;
                        } else {
                            temp.left = root.right;
                        }
                    }
                }
                break;
            }
        }

    }

    public void printf() {
        if (rootNode != null) {

            //先序遍历 根左右
//            preOrder(rootNode);
//            preOrderNonRecursive(rootNode);

            //中序遍历 左根右
//            inOrder(rootNode);
//            inOrderNonRecursive(rootNode);

            //后序遍历 根左右
//            lastOrder(rootNode);
            lastOrderNonRecursive(rootNode);

            //层序遍历
//            levelOrder(rootNode);

        } else {
            System.out.println("BinarySearchTree is null");
        }
    }

    /**
     * 先序遍历，递归实现
     *
     * @param root 根节点
     */
    private void preOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 先序遍历，非递归实现
     *
     * @param root 根节点
     */
    private void preOrderNonRecursive(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

        while (true) {
            while (root != null) {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            root = root.right;
        }
    }

    /**
     * 中序遍历，递归实现
     *
     * @param root 根节点
     */
    private void inOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    /**
     * 中序遍历，非递归实现
     *
     * @param root 根节点
     */
    private void inOrderNonRecursive(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }

    /**
     * 后序遍历，递归实现
     *
     * @param root 根节点
     */
    private void lastOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.println(root.value);
        }
    }

    /**
     * 后序遍历，非递归实现
     *
     * @param root 根节点
     */
    private void lastOrderNonRecursive(BinaryTreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                if (root.left == null && root.right == null) {
                    list.add(root.value);
                }
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                if (stack.lastElement().right == null) {

                    root = stack.pop();
//                    System.out.println(root.value);
                    while (root == stack.lastElement().right) {
                        root = stack.pop();
//                        System.out.println(root.value);

                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    root = stack.lastElement().right;
                } else {
                    root = null;
                }
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    /**
     * 层序遍历
     *
     * @param root 根节点
     */
    private void levelOrder(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> temp;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.println(temp.value);

            BinaryTreeNode<Integer> node = temp.left;
            if (node != null) {
                queue.add(node);
            }

            node = temp.right;
            if (node != null) {
                queue.add(node);
            }
        }
    }

    public int minDepth() {

        return minDepth(rootNode);
    }

    public int minDepth(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + leftDepth + rightDepth;
        } else {
            return leftDepth > rightDepth ? 1 + rightDepth : 1 + leftDepth;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(20);
        binarySearchTree.insert(13);
        binarySearchTree.insert(16);
        binarySearchTree.insert(15);
        binarySearchTree.insert(30);
        binarySearchTree.insert(25);
        binarySearchTree.insert(22);
        binarySearchTree.insert(28);
        binarySearchTree.insert(27);
        binarySearchTree.insert(26);
        binarySearchTree.insert(29);

//        System.out.println("depth: " + binarySearchTree.minDepth());

        binarySearchTree.printf();

//        binarySearchTree.delete(25);

//        System.out.println("----------------");
//
//        binarySearchTree.printf();
    }

}
