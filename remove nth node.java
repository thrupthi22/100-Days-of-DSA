class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print the linked list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Remove nth node from end (2-pointer approach)
    public void removeNthFromEnd(int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        // Move fast pointer n+1 steps
        for (int i = 0; i <= n; i++) {
            if (fast != null)
                fast = fast.next;
        }

        // Move fast and slow until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth node from end
        if (slow.next != null)
            slow.next = slow.next.next;

        // Update head in case first node was removed
        head = dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println("Original list:");
        list.printList();

        int n = 2; // Remove 2nd node from end (i.e., 40)
        list.removeNthFromEnd(n);

        System.out.println("After removing " + n + "th node from end:");
        list.printList();
    }
}

