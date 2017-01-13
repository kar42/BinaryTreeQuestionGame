//Kai Rahm
//CS3240

import java.util.Scanner;

public class QuestionTree<E> {
	private E data;
	private QuestionTree<E> rootNode;
	private QuestionTree<E> leftNode;
	private QuestionTree<E> rightNode;
	private int height=0;
	Scanner in = new Scanner(System.in);

	public QuestionTree(){
	}
	public QuestionTree(E data){
		this.data = data;
		leftNode=null;
		rightNode=null;
	}
	public static void print(Object line) {
	    System.out.println(line);
	}
	
	public void insertRootNode(E data1){
		QuestionTree<E> newLink = new QuestionTree<E>(data1);
		newLink.leftNode = null;
		newLink.rightNode = null;
		newLink.height = 0;
		if(rootNode==null){
			rootNode = newLink;
		}else{
			print("There already exists a root node.");
			return;
		}
		System.out.println("The root node '"+rootNode.data+"' was inserted.\n");
	}//End insertRootNode()
	
	public QuestionTree<E> insertNode(E[] list, int index, int height){  //index & height should normally be set to 0, start of list, but can be different 
		QuestionTree<E> newNode = new QuestionTree<E>();
		newNode.height = height;
    	try{
		if(index < list.length && list.length != 0){
        	newNode.data = list[index];
        	//print("The Data: '"+list[index]+"' was inserted from index "+index+" in the list to tree height "+newNode.height+"."); //Prints insertion report
        	
        	if((2*index + 1)<list.length)
        		newNode.leftNode = insertNode(list, (2*index + 1), (height+1)); //inserts index 1 from list, then index 3 and 4 as it's children, etc
        	if((2*index + 2)<list.length)
        		newNode.rightNode = insertNode(list, (2*index + 2), (height+1)); //inserts index 2 from list, then index 5 and 6 as it's children, and so on 
		}
		else
			print("Insertion could not occur.");
    	}catch(NullPointerException e){
    		print("Null Pointer Exception occurred.");
    	}
    	if(index == 0){
    		rootNode = newNode;
    		print("Tree Insertion Completed.");
    	}
        return newNode;
    }//end insertNode()
	
	public void runTree(){
		QuestionTree<E> tempNode = rootNode;
		if (tempNode == null){
			print("There were no questions to ask!");
			return;
		}
		print("You can answer by typing 'y' or 'yes' OR 'n' or 'no'. Anything else ends the game.\nStarting the Question Game!");
		String answer;
			
		while (tempNode != null){
			if (tempNode.leftNode == null && tempNode.rightNode == null || tempNode.leftNode.data == null && tempNode.rightNode.data == null){
				print(tempNode.data);
				print("Thanks for playing!");	
				return;
			} // This concludes game if winner was announced in the last iteration
			
			print(tempNode.data); //Prints the question
			answer = in.nextLine(); //Takes user response
			
			if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){ //yes answers go to left node
				tempNode = tempNode.leftNode;
			}
			else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){ //no answers go to the right node
				tempNode = tempNode.rightNode;
			}else{ //if response is not yes or no, game ends
				print ("Not a response. Game will end now.");
				return;
			}
		}//end while - question traversal
	}//End runTree()
	
	public QuestionTree<E> getRootNode(){
		return rootNode;
	}
	public void printPreOrder(QuestionTree<E> tempNode) {
		if (tempNode != null) {
			print(tempNode.data);
			printPreOrder(tempNode.leftNode);
			printPreOrder(tempNode.rightNode);
		}
	}
	public void printPostOrder(QuestionTree<E> tempNode) {
		if (tempNode != null) {
			printPostOrder(tempNode.leftNode);
			printPostOrder(tempNode.rightNode);
			print(tempNode.data);
		}
	}

	public void printInOrder(QuestionTree<E> tempNode) {
		if (tempNode != null) {
			printInOrder(tempNode.leftNode);
			print(tempNode.data);
			printInOrder(tempNode.rightNode);
		}
	}
	public void printLevelOrder(QuestionTree<E> tempNode, int treeHeight) {
		try{
		if (treeHeight == 0){ //height will decrement until it reaches this condition
			print(tempNode.data);
		}
		else if (treeHeight > 0){ //while height is not at root level, it will print current node then children of said node.
			print(tempNode.data);
			print("Left child of '"+tempNode.data+"' :");
			printLevelOrder(tempNode.leftNode, (treeHeight-1));
			print("Right child of '"+tempNode.data+"' :");
			printLevelOrder(tempNode.rightNode, (treeHeight-1));	
		}
		}catch(NullPointerException e){
			//return;
			print (null); //when the child of an element in the tree is null it prints null
		}
	}//end printLevelOrder()
	
	public static void exit(){
		print("Thank you for trying the program!");
		System.exit(0);
	}
	
}//End QuestionTree
