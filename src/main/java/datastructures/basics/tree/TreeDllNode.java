package datastructures.basics.tree;

public class TreeDllNode {
    // only for Tree2Dll & Dll2Tree
    public int val;
    public TreeDllNode left;
    public TreeDllNode right;
    public TreeDllNode prev;
    public TreeDllNode next;

    public TreeDllNode(int x) {
        val = x;
    }

    public static void printListNode(TreeDllNode l) {
        TreeDllNode curr = l;
        System.out.println("Printing Node List");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printListNodeRev(TreeDllNode l) {
        TreeDllNode curr = l;
        System.out.println("Printing Node List");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.prev;
        }
        System.out.println();
    }
}
