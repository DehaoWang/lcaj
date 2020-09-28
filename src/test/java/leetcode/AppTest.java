package leetcode;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

import algorithms.utils.TreeUtils;
import datastructures.basic.tree.TreeNode;

import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class AppTest
//    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }

    /**
     * @return the suite of tests being tested
     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
    public static void main(String[] args) {
//        DLLNode dll = DLLNode.getListFromArray(new int[]{1, 2, 3, 4, 5});
//        DLLNode.printListNode(dll);
//        DLLNode.printListNodeRev(dll);

//        LinkedList ll = new LinkedList(new int[]{1, 2, 3, 4, 5});
//        ll.print();
//
//        DoublyLinkedList dll = new DoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6});
//        dll.print();

//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//        TreeUtils.inorderTraversal(root);
//        TreeUtils.preorderTraversal(root);
//        TreeUtils.postorderTraversal(root);
//        TreeUtils.dfsTraversal(root);
//        TreeUtils.bfsTraversal(root);
//
//        TreeUtils.morrisPreOrderTraversal(root);
//        TreeUtils.morrisInOrderTraversal(root);

        System.out.println(isHoliday());
    }

    public static int isHoliday() {
        Calendar now = Calendar.getInstance();
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        if(weekDay == 1 || weekDay == 7){
            return 1;
        }
        else
            return 0;
    }
}
