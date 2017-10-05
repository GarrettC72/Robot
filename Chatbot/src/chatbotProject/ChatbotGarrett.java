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
		String[] temp = {"grow", "growing", "fruits", "garden"};
		String[] temp2 = {"apples", "mangoes", "peaches", "pears", "coconuts"};
		String[] temp3 = {};
		String[] temp4 = {};
		String[] temp5 = {};
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
		ChatbotMain.print("Hey! It sounds like you want to grow your own food! What would you like to know, " + userName + "?");
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
				ChatbotMain.print("Sorry, I don't know how to grow that particular food. Can you tell me another one?");
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
					ChatbotMain.print("Sorry, I don't know how to grow that particular food. Can you tell me another one?");
				}
			}
		}
	}
	
	public void printResponse() {
		if (fruitCount >= 3 && fruitCount < 5) {
			ChatbotMain.print("You really love talking about fruit, " + userName + "? I love fruits myself.");
		}
		else if (fruitCount >= 5 && fruitCount < 8) {
			ChatbotMain.print("Actually, I think we've talked about fruit for too long. Maybe you should talk about other food, " + userName + ".");
		}
		else if (fruitCount >= 8) {
			ChatbotMain.print("OK, SERIOUSLY WE'VE ALREADY TALKED ABOUT THIS! IT'S TIME TO MOVE ON! I CAN ONLY TALK ABOUT GARDENING FOR SO LONG!!!!!"
					+ "IF YOU KEEP THIS UP I'M LEAVING YOU!");
		}
	}
}
