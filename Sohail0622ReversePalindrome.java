import java.util.*;

public class Sohail0622ReversePalindrome {
	//1. (10 points) Print out the inputs in reverse order.
	//e.g.: input: " Taco cat "
	//output: " tac ocaT "
	
	//2. (10 points) Display/print out if the input as a whole is palindrome 
	//(ignore case and non-letter characters)
	//e.g. " Taco cat " is palindrome, or
	//" I Love DSA" is not palindrome
	
	class Node{
		char data;
		Node next;
		
		//constructor for Nodes
		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	Node tail;
		
	//Insert last, used for traversing
	public void insertLast(char input) {
		//List is empty
		if(this.head == null) {
			this.head = this.tail = new Node(input);
		}
			
		//List not empty, make the new Node the new head
		else {
			Node nodeToAdd = new Node(input);
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
	}
	
	//Print out LinkedList	
	public void printList(Node headNode) {
		Node currentNode = headNode;
		while(currentNode!=null) {
			System.out.print(currentNode.data);
			currentNode=currentNode.next;
		}
		System.out.println();
	}
	
	//Get User Input
	public String getUserInput() {
		System.out.println("Enter Input String to Reverse and Check if Palindrome:");
		Scanner stringInput = new Scanner(System.in);
		String input = stringInput.nextLine();
		stringInput.close();
		return input;
	}
	
	//Insert each char at end of linked list, used for question 1
	public void traverseString(String userInput) {
		for(int i = 0;i<userInput.length();i++) {
			insertLast(userInput.charAt(i));
		}
	}
	
	//Insert each char at end of linked list, ignore case and non-letter characters, used for question 2
	public void traverseStringPalindrome(String userInput) {
		userInput = userInput.toLowerCase();
		for(int i = 0;i<userInput.length();i++) {
			if(Character.isAlphabetic(userInput.charAt(i))) {
				insertLast(userInput.charAt(i));
			}
		}
		
	}
	
	//Reverse Linked List given head node
	public Node reverseString(Node headNode) {
		Node prev = null;
		
		while(headNode!=null) {
			Node next = headNode.next;
			headNode.next = prev;
			prev = headNode;
			headNode = next;
		}
		return prev;
	}
	
	//Check if Palindrome
	public boolean isPalindrome() {

		Node slow = head;
		Node fast = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
	
		slow = reverseString(slow);
		fast = head;
		
		while(slow!=null) {
			
			if(slow.data != fast.data) {
				return false;
			}
			
			slow = slow.next;
			fast = fast.next;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		//Create a LinkedList to store chars of input string
		Sohail0622ReversePalindrome originalString = new Sohail0622ReversePalindrome();
		
		//read user input
		String userInput1 = originalString.getUserInput();
		
		//Create linked list of chars by inserting each char at end of linked list
		originalString.traverseString(userInput1);

		//Print original input
		System.out.print("Input: ");
		originalString.printList(originalString.head);
		
		//Reverse input, storing the head of the LinkedList with reversed input
		originalString.head = originalString.reverseString(originalString.head);
		
		//Print reversed input
		System.out.print("Output Reversed: ");
		originalString.printList(originalString.head);
		
		//Create another LinkedList for ignoring case and non-characters
		Sohail0622ReversePalindrome checkPalindromeList = new Sohail0622ReversePalindrome();
		checkPalindromeList.traverseStringPalindrome(userInput1);
		checkPalindromeList.head = checkPalindromeList.reverseString(checkPalindromeList.head);
		
		//Check for palindrome
		boolean palindrome = checkPalindromeList.isPalindrome();
		
		//Output if Palindrome or not
		if(palindrome) {
			System.out.print(userInput1 + " is Palindrome");
		}else {
			System.out.print(userInput1 + " is not a Palindrome");
		}
		
	}
	
}
