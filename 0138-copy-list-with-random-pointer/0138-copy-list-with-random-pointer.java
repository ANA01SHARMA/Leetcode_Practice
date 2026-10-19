class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Create new nodes and weave them into the original list
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Separate the two lists
        curr = head;
        Node copyHead = head.next;
        while (curr != null) {
            Node copyNode = curr.next;
            curr.next = copyNode.next;
            curr = curr.next;
            if (curr != null) {
                copyNode.next = curr.next;
            }
        }
        
        return copyHead;
    }
}