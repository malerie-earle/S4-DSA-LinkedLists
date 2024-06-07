package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Create a linked list
    public Node createLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert into a linked list
    // 0. If linked list doesn't exist
    // 1. Inserting at the beginning
    // 2. Inserting at the end
    // 3. Insert anywhere

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) { // Inserting at the beginning
            node.next = head;
            head = node;
        } else if (location >= size) { // Inserting at the end
            tail.next = node;
            node.next = null;
            tail = node;
        } else { // Inserting anywhere
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // Traverse a linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Search through a linked list
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Deleting a node from a singly linked list
    // 0. If linked list doesn't exist
    // 1. Deleting at the beginning
    // 2. Deleting at the end
    // 3. Deleting anywhere in the list

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist");
            return;
        } else if (location == 0) { // Deleting at the beginning
            head = head.next;
            size--;
            if (size == 0) { // If the list is now empty, update the tail to null
                tail = null;
            }
        } else if (location >= size - 1) { // Deleting at the end
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) { // Only one element in the list
                head = tail = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { // Deleting anywhere in the list
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

// The NullPointerException occurs because the insertInLinkedList method has incorrect pointer manipulation when
// inserting a node in the middle of the list. Specifically, in the section where it handles inserting a node at a
// position that is already occupied, it does not properly link the new node to the existing nodes, leading to a null
// reference being dereferenced.

}
