


public class LinkedList{

    // Nested Node class to represent the nodes of the linked list
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Head, tail, and size variables to maintain the state of the linked list
    public static Node head;
    public static Node tail;
    public static int size;


    // ADD OPERATIONS
    // --------------
    // Method to add a node with given data at the beginning of the linked list
    public void addFirst(int data){
        Node newNode = new Node(data);  // Create new node
        size++;   // Increase size

        // if LinkedList is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        newNode.next = head;  // Set the new node's next reference to the current head
        head = newNode;  // Update the head to the new node
    }

    // Method to add a node with given data at the end of the linked list
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // If the linked list is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        tail.next = newNode;  // Set the current tail's next reference to the new node
        tail = newNode;   // Update the tail to the new node
    }


    // Method to add a node with given data at the specified index in the linked list
    public void addInMiddle(int ind, int data){

        if(ind == 0){
            addFirst(data);  // If the index is 0, call addFirst method to add at the beginning
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;  // Store head to the temp
        int i = 0;

        while(i < ind - 1){  // Traverse the linked list until the node at index (ind - 1)
            temp = temp.next;  // Move temp to the next node
            i++;  // Increase i
        }

        // Set the new node's next reference to the current node at index (ind - 1)'s next node
        newNode.next = temp.next;  
        temp.next = newNode;  // Set the current node at index (ind - 1)'s next reference to the new node
    }

    // DELETE OR REMOVE OPERATIONS
    // ---------------------------

    // Method to remove first element from the linked list
    public int removeFirst(){
        // Step 1: Check if the linked list is empty
        if(size == 0){
            return Integer.MIN_VALUE;  // If list is empty return infinite value as spacia indicator
        }
        else if(size == 1){    // Step 2: Check if the linked list contains only one element
            // If size is 1, there is only one node in the list
            int val = head.data;  // Store the value of the data in the node in the variable 'val'
            // Set both 'head' and 'tail' references to 'null'
            head = tail = null;
            size = 0;   // Update the 'size' variable to 0 to reflect the new size of the list (empty list)

            return val;  // Return the value of the removed node (stored in 'val')
        }

        // Step 3: If the linked list has more than one element
        // Store the value of the data in the first node in the variable 'val'
        int val = head.data;   
        // Move the 'head' reference to the next node in the list, effectively removing the first node
        head = head.next;
        size--;  // Decrement the 'size' variable to reflect the reduced size of the list
        return val;  // Return the value of the removed node (stored in 'val')
    }

    // Method to remove the last element from the linked list
    public int removeLast(){

        // Step 1: Check if the linked list is empty
        if(size == 0){
            return Integer.MIN_VALUE;  // If list is empty, return infinite value as a special indicator
        }

        // Step 2: Check if the linked list contains only one element
        else if(size == 1){
            // If size is 1, there is only one node in the list
            int val = head.data;  // Store the value of the data in the node in the variable 'val'

            // Set both 'head' and 'tail' references to 'null'
            head = tail = null;
            size = 0;  // Update the 'size' variable to 0 to reflect the new size of the list (empty list)
            return val;  // Return the value of the removed node (stored in 'val')
        }

        // Step 3: If the linked list has more than one element
        // Create a reference 'prev' and initialize it with the 'head' node
        Node prev = head;

        // Step 4: Traverse the list to find the second-to-last node (prev)
        // Stop at the node before the last node (size - 2) because we need to update its 'next' reference
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }

        // Step 5: Get the value of the last node (tail.data) before removing it
        int val = tail.data;

        // Step 6: Set the 'next' reference of the second-to-last node to null, effectively removing the last node
        prev.next = null;

        // Step 7: Update the 'tail' reference to point to the second-to-last node (prev)
        tail = prev;

        // Step 8: Decrement the 'size' variable to reflect the reduced size of the list
        size--;
        return val;  // Step 9: Return the value of the removed node (stored in 'val')
    }

    // Method to remove an element at the specified index from the linked list
    public int removeInMiddle(int ind){

        // Step 1: Check if the linked list is empty
        if(size == 0){
            return Integer.MIN_VALUE;  // If list is empty, return infinite value as a special indicator
        }

        // Step 2: Check if the linked list contains only one element
        else if(size == 1){  // If size is 1, there is only one node in the list

            // Store the value of the data in the node in the variable 'val'
            int val = head.data;

            // Set both 'head' and 'tail' references to 'null'
            head = tail = null;
            // Update the 'size' variable to 0 to reflect the new size of the list (empty list)
            size = 0;
            return val;  // Return the value of the removed node (stored in 'val')
        }

        // Step 3: Check if the index is 0, indicating the first element needs to be removed
        else if(ind == 0){  
            return removeFirst();  // Call the 'removeFirst()' method to remove the first element
        }
        // Step 4: Check if the index is the last element of the list
        else if(ind == size - 1){
            return removeLast();  // Call the 'removeLast()' method to remove the last element
        }

        // Step 5: If the element to remove is neither the first nor the last, we need to find it
        // Create two references, 'first' and 'last', and initialize them with the first two nodes
        Node first = head;
        Node last = head.next;

        // Step 6: Traverse the list to find the nodes at index (ind - 1) and (ind)
        // Stop at the nodes before the one to remove (ind - 1) and the one to remove (ind)
        for(int i = 0; i < ind - 1; i++){
            first = first.next;
            last = last.next;
        }

        // Step 7: Get the value of the node to remove (last.data) before removing it
        int val = last.data;

        // Step 8: Update the 'next' reference of the node before the one to remove
        first.next = last.next;

        // Step 9: Decrement the 'size' variable to reflect the reduced size of the list
        size--;
        return val;  // Step 10: Return the value of the removed node (stored in 'val')
    }


    // // Method to remove the nth node from the end of the linked list
    public int removeNthFromLast(int n){

        // Step 1: Create a reference 'temp' and initialize it with the 'head' node
        Node temp = head;

        // Step 2: Initialize a variable 'size' to keep track of the size of the linked list
        int size = 0;

        // Step 3: Traverse the linked list to calculate its size
        while(temp != null){
            temp = temp.next;
            size++;
        }

        // Step 4: Check if the 'n' is equal to the size of the linked list
        if(n == size){
            return removeFirst();  // Call the 'removeFirst()' method to remove the first node
        }

        // Step 5: Calculate the index of the node to remove from the start of the list
        int ind = size - n;

        // Step 6: Call the 'removeInMiddle()' method to remove the node at the calculated index
        return removeInMiddle(ind);
    }

    // Searching in LinedList
    // ----------------------
    // Method to perform an iterative search in the linked list and find the index of the target value
    public int itrSearch(int target){

        // Step 1: Create a reference 'temp' and initialize it with the 'head' node
        Node temp = head;

        // Step 2: Initialize a variable 'i' to keep track of the index of the current node
        int i = 0;

        // Step 3: Traverse the linked list using a while loop until 'temp' becomes null (end of the list)
        while(temp != null){

            // Step 4: Check if the data in the current node matches the target value
            if(temp.data == target){
                return i;  // Return the index 'i' where the target value is found
            } 

            // Step 5: If the target value is not found, increment the index 'i'
            i++;

            // Step 6: Move 'temp' to the next node in the linked list
            temp = temp.next;
            
        }

        // Step 7: If the target value is not found in the linked list, return -1 as a special indicator
        return -1;
    }

    // Recursive helper method to find the index of the target value in the linked list
    public int helper(Node head, int target){
        
        // Step 1: Base case - If the current node (head) is null, we have reached the end of the list
        // and the target value is not found, so return -1 as a special indicator.
        if(head == null){
            return - 1;
        } 

        // Step 2: Check if the data in the current node (head.data) matches the target value.
        if(head.data == target){
            return 0;  // Return 0 to indicate that the target value is found at the current node.
        }

        // Step 3: Recursively call the helper method with the next node in the linked list
        // to search for the target value in the remaining part of the list.
        int ind = helper(head.next, target);

        // Step 4: If the target value is not found in the remaining part of the list (ind == -1),
        // return -1 as a special indicator.
        if(ind == -1){
            return -1;
        }

        // Step 5: If the target value is found in the remaining part of the list (ind >= 0),
        // increment the index (ind + 1) to reflect the current node's position and return it.
        return ind + 1;
    }

    // Method to perform a recursive search in the linked list and find the index of the target value
    public int recSearch(int target){

        // Step 1: Call the helper method with the 'head' of the linked list and the target value.
        return helper(head, target);
    } 

    // Method to reverse a linkedList
    public void reverse(){

        // Step 1: Create three node references: 'prev', 'curr', and 'aft'
        // Initialize 'prev' to null, 'curr' and 'tail' to the 'head' node.
        Node prev = null;
        Node curr = tail = head;
        Node aft;

        // Step 2: Traverse the linked list using a while loop until 'curr' becomes null (end of the list)
        while(curr != null){

            // Step 3: In each iteration, store the reference to the next node (curr.next) in the 'aft' variable
            aft = curr.next;

            // Step 4: Update the 'next' reference of the current node (curr.next) to point to the previous node (prev)
            curr.next = prev;

            // Step 5: Move the 'prev' reference to the current node (prev = curr), preparing for the next iteration
            prev = curr;

            // Step 6: Move the 'curr' reference to the next node (curr = aft), preparing for the next iteration
            curr = aft;
        }

        // Step 7: After the while loop, 'prev' will be pointing to the last node in the original list,
        // which is now the new 'head' of the reversed list. Update the 'head' reference to 'prev'.
        head = prev;
    }

    // Method to print the elements of the linked list
    public void printList(){
        Node temp = head;  // Store head to the temp

        while(temp != null){  // Traversethe list untill null is occured
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move temp to the next node
        }
        System.out.println("null"); 
    }

    // Check If a liked list is palindrome or not

    // Helper method to find the middle node of the linked list
    public Node findMidNode(Node head){
        Node slow = head;
        Node fast = head;

        // Traverse the linked list using slow and fast pointers
        // The slow pointer moves one step at a time, while the fast pointer moves two steps at a time
        // When the fast pointer reaches the end, the slow pointer will be at the middle node
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return the middle node
        return slow;
    }

    // Method to check if the linked list is a palindrome
    public boolean checkPalindrome(){

        // Step 0: Base case - an empty list or a list with only one node is always a palindrome
        if(head == null || head.next == null){
            return true;
        }

        // Step 1: Find the middle Node of the linked list using the findMidNode method
        Node midNode = findMidNode(head);

        // Step 2: Reverse the second half of the linked list (starting from the middle node)

        // Initialize three pointers: prev (to keep track of the previous node), curr (to keep track of the current node)
        // and aft (to keep track of the next node in the original list before modifying the 'next' pointer).
        Node prev = null;
        Node curr = midNode;
        Node aft;

        // Reverse the second half of the linked list
        while(curr != null){
            aft = curr.next;  // Store the next node in 'aft'
            curr.next = prev;  // Reverse the 'next' pointer to point to the previous node
            prev = curr;    // Move 'prev' to the current node
            curr = aft;   // Move 'curr' to the next node in the original list
        }

        // 'prev' now points to the head of the reversed second half of the linked list.
        // 'head' still points to the head of the original list.
        Node right = prev;
        Node left = head;

        // Step 3: Compare the elements of the first half (left) and the reversed second half (right) of the linked list

        // Traverse both halves simultaneously and check if the elements are equal.
        // If at any point the elements are not equal, the list is not a palindrome.
        while(right != null){
            if(left.data != right.data){
                return false;  // Not a palindrome
            }

            left = left.next;
            right = right.next;
        }

        // If the loop completes without finding any mismatch, the list is a palindrome.
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        //ll.printList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.printList();

        // ll.addInMiddle(2, 5);
        // ll.printList();

        ll.printList();
        // System.out.println(head.data);
        // System.out.println(tail.data);
        // System.out.println(size);

        // System.out.println(ll.removeFirst());
        // ll.printList();
        // System.out.println(size);

        // System.out.println(ll.removeLast());
        // ll.printList();
        // System.out.println(size);

        // System.out.println(ll.removeInMiddle(0));
        // ll.printList();

        // System.out.println(ll.removeInMiddle(size));
        // ll.printList();

        // System.out.println(ll.removeInMiddle(2));
        // ll.printList();

        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // ll.reverse();
        // ll.printList();

        // System.out.println(head.data);
        // System.out.println(tail.data);

        // System.out.println(ll.removeNthFromLast(1));
        // ll.printList();

        ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);

        ll.printList();
        System.out.println(ll.checkPalindrome());

    }
}