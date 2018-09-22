package edu.hdsb.gwss.ics4u.ADT;

/**
 * Linked List of Students
 *
 * @version v2018.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        // TO DO
        int size = 0;
        NodePT n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        // TO DO
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        // TO DO
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        // TODO
        NodePT newNode = new NodePT(student);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        // TODO
        if (isEmpty()) {
            System.out.println("LL is empty, cannot get");
            return null;
        } else {
            if (size() == 1) {
                if (head.getData().getKey() == key) {
                    System.out.println("got " + head.getData().toString());
                    return head.getData();
                } else {
                    System.out.println("student not found");
                    return null;
                }
            } else {
                if (head.getData().getKey() == key) {
                    return head.getData();
                } else {
                    NodePT n = head;
                    while (n.getNext() != null && n.getNext().getData().getKey() != key) {
                        n = n.getNext();
                    }

                    // NOT IN THERE!
                    if (n.getNext() == null) {
                        System.out.println("student not found");
                        return null;
                    } else {
                        return n.getNext().getData();
                    }

                }
            }
        }

    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        //call get?

        if (isEmpty()) {

            return this.get(key);
        } else {
            if (size() == 1) {
                if (head.getData().getKey() == key) {

                    CSStudent n = this.get(key);
                    this.makeEmpty();
                    return n;
                } else {
                    return this.get(key);
                }
            } else {
                if (head.getData().getKey() == key) {
                    NodePT temp = head;
                    head = head.getNext();
                    temp.setNext(null);
                    return this.get(key);
                } else {
                    NodePT n = head;
                    while (n.getNext() != null && n.getNext().getData().getKey() != key) {
                        n = n.getNext();
                    }

                    // NOT IN THERE!
                    if (n.getNext() == null) {
                        System.out.println("student not found");
                        return null;
                    } else {
                        NodePT toDelete = n.getNext();
                        n.setNext(n.getNext().getNext());
                        toDelete.setNext(null);
                        return toDelete.getData();
                    }

                }
            }

        }
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
