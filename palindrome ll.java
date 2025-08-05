class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    ListNode head;

    // Add a new node at the end
    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print the list
    public void printList() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Reverse a linked list and return new head
    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }

    // Check if linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalfStart = reverseList(slow.next);

        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfStart;
        boolean isPalin = true;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // (Optional) Step 4: Restore the list
        slow.next = reverseList(secondHalfStart);

        return isPalin;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Try different test cases:
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        System.out.println("Linked List:");
        list.printList();

        if (list.isPalindrome()) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
    }
}
