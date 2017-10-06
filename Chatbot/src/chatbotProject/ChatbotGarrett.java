package chatbotProject;

public class ChatbotGarrett implements Topic {
	
	private String[] keywords;
	private String[] fruits;
	private String[] calmResponses;
	private String[] angryResponses;
	private String[] angryAllCapsResponses;
	private String goodbyeWord;
	private String secretWord;
	private String userName;
	
	private boolean chatting;
	private boolean fruitChatting;
	
	private int fruitCount;
	
	
	public ChatbotGarrett() {
		String[] temp = {"grow", "growing", "fruits", "garden", "gardening"};
		String[] temp2 = {"apples", "mangoes", "peaches", "pears", "coconuts"};
		String[] temp3 = {"You really love talking about fruit, don't you, " + userName + "?", "You must love fruit as much as I do ... fantastic!!!", "Our love for fruit make us a really good 'pear', doesn't it?"};
		String[] temp4 = {"Actually, I think we've talked about fruit for too long. Maybe you should talk about other food, " + userName + ".", 
				"You look like you want to talk endlessly about fruit, but can you coco-not?", "I can tell you really like fruit, but how about we talk about other food instead?"};
		String[] temp5 = {"OK, SERIOUSLY WE'VE ALREADY TALKED ABOUT THIS! IT'S TIME TO MOVE ON! I CAN ONLY TALK ABOUT GARDENING FOR SO LONG!!!!!", 
				".......................", "TYPE 'BYE' ALREADY. I DON'T WANT TO TALK ABOUT FRUIT ANYMORE!"};
		keywords = temp;
		fruits = temp2;
		calmResponses = temp3;
		angryResponses = temp4;
		angryAllCapsResponses = temp5;
		goodbyeWord = "bye";
		secretWord = "green thumb";
		fruitCount = 0;
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		userName = ChatbotMain.chatbot.getUserName();
		ChatbotMain.print("Hey! It sounds like you want to learn more about fruit! What would you like to know specifically, " + userName + "?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			for (int i = 0; i < fruits.length; i++) {
				if (ChatbotMain.findKeyword(response, fruits[i], 0) >= 0) {
					chatting = false;
					fruitConvo(fruits[i]);
					return;
				}
			}
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You must be a gardening fanatic!");
			}
			else {
				ChatbotMain.print("Sorry, I don't know anything about " + response + ". Tell me another fruit!");
			}
		}
	}
	

	public void fruitConvo(String response) {
		fruitCount++;
		ChatbotMain.print("You can grow " + response + " on trees. Anything else?");
		fruitChatting = true;
		boolean fruitFound;
		while (fruitChatting) {
			fruitFound = false;
			response = ChatbotMain.getInput();
			for (int i = 0; i < fruits.length; i++) {
				if (ChatbotMain.findKeyword(response, fruits[i], 0) >= 0) {
					fruitCount++;
					ChatbotMain.print("You can grow " + fruits[i] + " on trees. Anything else?");
					fruitFound = true;
				}
			}
			if (fruitFound) {
				printResponse();
			}
			else {
				if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
					fruitChatting = false;
					ChatbotMain.chatbot.startTalking();
				}
				else {
					ChatbotMain.print("Sorry, I don't know anything about " + response + ". Tell me another fruit!");
				}
			}
		}
	}
	
	public void printResponse() {
		if (fruitCount >= 3 && fruitCount < 5) {
			int responseInd = (int)(Math.random()*calmResponses.length);
			ChatbotMain.print(calmResponses[responseInd]);
		}
		else if (fruitCount >= 5 && fruitCount < 8) {
			int responseInd = (int)(Math.random()*angryResponses.length);
			ChatbotMain.print(angryResponses[responseInd]);
		}
		else if (fruitCount >= 8) {
			int responseInd = (int)(Math.random()*angryAllCapsResponses.length);
			ChatbotMain.print(angryAllCapsResponses[responseInd]);
		}
	}
}
