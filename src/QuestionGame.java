//Kai Rahm
//CS3240

import java.util.Scanner;

/**
 * A simple game of 20 question. Game is performed by using a binary tree that navigates using preset questions and answers.
 * @author Kai
 */
public class QuestionGame {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("Hello, welcome to the question game!");
		String[] treeData = {"Does it have 4 legs?", "Does it have hooves?", "Is it feathered?", "Do we use the milk it produces?", "Is it often a herbivore/insectivore?",
				"Can it swim?", "Does it live in water?", "Does it go moo?", "Do people often eat it?", "Does it have long ears?", "Do they have retractable claws?",
				"Does it have it's own fairytale/nursery rhyme?", "Do we eat/use their eggs?", "Does it have any legs?", "Is it legless?", "I'm guessing it's a cow?",
				"I'm guessing it's a goat?", "Does it graze a lot?", "Is it commonly ridden?", "I'm guessing it's a rabbit?", "Is it a mammal?", "I'm guessing it's a cat?", "I'm guessing it's a dog?",
				"Is it all white?", "I'm guessing it's a duck?", "Is it larger than a dog?", "Is it farmed most at thanksgiving?", "Does it have claws?", 
				"I'm guessing it's a fish?", "Does it have scales?", "I'm guessing it's an insect (like spider, crickets, butterflies, etc)?",
				"Computer Wins.", "You Win!", "Computer Wins.", "You Win!", "I'm guessing it's a sheep?", "I'm guessing it's a pig?", "I'm guessing it's a horse?",
				"I'm guessing it's a donkey or mule?", "Computer Wins.", "You Win!", "I'm guessing it's a rodent (like a mouse, hamster, guinea pig, etc.)?",
				"I'm guessing it's a reptile or amphibean? (like a lizard, turtle, frog, etc)", "Computer Wins.", "You Win!", "Computer Wins.", "You Win!",
				"I'm guessing it's a swan?", "I'm guessing it's a goose?", "Computer Wins.", "You Win!", "I'm guessing it's an ostrich?",
				"I'm guessing it's a chicken?", "I'm guessing it's a turkey?", "I'm guessing it's a house bird? (like parrot, finch, parakeet, etc)",
				"I'm guessing it's a crustacian (like lobster or crab)?", "I'm guessing it's shrimp?", "Computer Wins.", "You Win!", "I'm guessing it's a snake?", "I'm guessing it's a snail?", "Computer Wins.", "You Win!",
				null, null, null, null,null, null, null, null, "Computer Wins.", "You Win!", "Computer Wins.", "You Win!","Computer Wins.", "You Win!","Computer Wins.", "You Win!",
				null,null,null,null,"Computer Wins.", "You Win!","Computer Wins.", "You Win!",null,null,null,null,null, null, null, null, "Computer Wins.", "You Win!","Computer Wins.", "You Win!",
				null,null,null,null,"Computer Wins.", "You Win!","Computer Wins.", "You Win!","Computer Wins.", "You Win!", "Computer Wins.", "You Win!", 
				"Computer Wins.", "You Win!","Computer Wins.", "You Win!",null,null,null,null,"Computer Wins.", "You Win!","Computer Wins.", "You Win!",null,null,null,null
		};
		
		QuestionTree<String> tree = new QuestionTree<String>();
		System.out.println("The questions are being are being inserted into their Question Tree...");
		tree.insertNode(treeData, 0, 0); // the 0s represent the starting index height to parse tree for insertion (starting at the root)
		int response = 1;
		while(response == 1){
			System.out.println("\nYou'll need to think of a domesticated animal (kept by humans)");
			tree.runTree();
			System.out.println("Do you want to play again? Press 1. If not press any other key.");
			try{
				response = Integer.parseInt(in.nextLine());
			}catch(NumberFormatException e){
				break;
			}
		}
		System.out.println("Hope you enjoyed the game! Goodbye!");
		in.close();
	}//end main

}//end QuestionGame
