/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.ADT;

import edu.hdsb.gwss.yulia.ics4u.u5.*;

/**
 *
 * @author yulia
 */
public class LinkedList {

    private Node head;
    private Node tail;
//    private Node current;  
//    private Node n;
//    private String removed;
//    private int size;

    //SPECIAL CASES
    //WHEN IT'S EMPTY
    //WHEN IT'S SIZE 1
    public LinkedList() {
        makeEmpty();
    }

    public int size() {
        int size = 0;
        Node n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    //can I make makeEmpty a boolean?
    public void makeEmpty() {
        this.head = null;
        this.tail = null;

    }

    public boolean isEmpty() {

        
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /**
     * Adds a node to the front of the linked list.
     *
     * @param str
     */
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNext( head );
            this.head = newNode;
        }

//        //make a new node
//        Node front = new Node(str);
//        front.setNext(this.head); 
//        
//        //if this is the first node added, set the tail
//        if( this.isEmpty()){
//            this.tail = front;
//        }
//        this.head = front;
//        
//        
//        size++;
    }

    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd(String str) {
        Node newNode = new Node(str);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

//        if (!this.isEmpty()) {
//            this.tail.setNext(end);
//            
//        } else {
//            this.head = end;
//            
//        }
//        this.tail = end;
//        end.setNext(null); 
//        size++;
    }

    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove(String str) {

        if (isEmpty()) {
            System.out.println(".remove; LL is empty");
        }
        else {
            if( size() == 1 ) {
                if( head().equals(str) ) {
                    System.out.println(".remove; removed " + str );
                    makeEmpty();
                }
                else {
                    System.out.println(".remove; string not found" );
                }
            }
            else {
                if( head.getValue().equals(str) ) {
                    removeHead();
                }
                else {
                    Node n = head;
                    while( n.getNext() != null && !n.getNext().getValue().equals( str ) ) {
                        n = n.getNext();
                    }
                    
                    // NOT IN THERE!
                    if( n.getNext() == null ) {
                        System.out.println(".remove; string not found" );
                    }
                    else {
                        Node toDelete = n.getNext();
                        n.setNext( n.getNext().getNext() );
                        toDelete.setNext( null );
                    }
                    
                }
            }
            
        }

        //2 cases --> it exists, or it does not exist in the LL
        //??don't have to do case for if isEMpty() bc of null pointer? 
        //is it more efficient to loop through LL for size of to keep a constant counter?
        //start at the head
//        if (!this.isEmpty()) {
//            current = this.head;
//             
//            
//            //check the value at the head
//            while (!current.getNext().equals(n)) {
//                
//                if()
//                if (!current.getValue().equals(str) /*&& !current.getValue().equals(n.getValue())*/) {
//                    
//                    if (current.getNext().getValue().equals(str)) {
//
//                        //MOVE THE POINTER
//                        System.out.println("1");
//                        current.setNext(current.getNext().getNext());
//                        System.out.println("2");
//                        //remove floating pointer and end the loop
//                        current.getNext().setNext(n);
//                        System.out.println("3");
//                        size--;
//
//                    }  
//                    else{
//                    current = current.getNext().getNext();
//                    System.out.println("HI");
//                    }
//                }
//                else{
//                    System.out.println("This string does not exist in the LL");
//                    current.getNext().setNext(n);
//                }
//
//            }
//
//        } else {
//            System.out.println("cannot remove from empty LL");
//        }
    }

    public String removeHead() {
        String value = null;
        if (isEmpty()) {
            System.out.println(".removeHead; LL is empty");
        }
        else if( size() == 1 ) {
            String s = head();
            makeEmpty();
            value = s;
        }
        else {
            Node toDelete = head;
            this.head = toDelete.getNext();
            toDelete.setNext( null );
            value = toDelete.getValue();
        }
        return value;
    }

    public String removeTail() {
        String value = null;
        if (isEmpty()) {
            System.out.println(".removeHead; LL is empty");
        }
        else if( size() == 1 ) {
            value = tail();
            makeEmpty();
        }
        else {
           value = tail();
           Node n = head;
           while( n.getNext() != tail ) {
               n = n.getNext();
           }
           n.setNext(null);
           this.tail = n;

        }
        return value;

    }

    public String head() {
        if (isEmpty()) {
            return null;
        }
        return head.getValue();
    }

    public String tail() {
        if (isEmpty()) {
            return null;
        }
        return tail.getValue();
    }

    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @return string
     */
    @Override
    public String toString() {

        String s = "H-->";

        Node n = head;
        while (n != null) {
            s = s + n.getValue() + "-->";
            n = n.getNext();
        }

        s = s + "T";

        return s;
    }

}
