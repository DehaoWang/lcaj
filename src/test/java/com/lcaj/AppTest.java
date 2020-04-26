package com.lcaj;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

import datastructures.basics.linkedlist.DLLNode;
import datastructures.basics.linkedlist.DoublyLinkedList;
import datastructures.basics.linkedlist.LinkedList;

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

        LinkedList ll = new LinkedList(new int[]{1, 2, 3, 4, 5});
        ll.print();

        DoublyLinkedList dll = new DoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        dll.print();
    }
}
