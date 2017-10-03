package chatbotProject;

public class ChatbotGarrett implements Topic {
	
	private String[] keywords;
	private String[] vegetables;
	private String[] fruits;
	private String goodbyeWord;
	private String secretWord;
	private String userName;
	private boolean chatting;
	
	public ChatbotGarrett() {
		String[] temp = {"grow", "plants", "fruits", "vegetables"};
		String[] temp2 = {"corn", "lettuce", "potatoes", "tomatoes", "carrots"};
		String[] temp3 = {"apples", "bananas", "strawberries", "grapes", "watermelons"};
		keywords = temp;
		vegetables = temp2;
		fruits = temp3;
		goodbyeWord = "bye";
		secretWord = "green thumb";
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
			for (int i = 0; i < vegetables.length; i++) {
				if (ChatbotMain.findKeyword(response, vegetables[i], 0) >= 0) {
					chatting = false;
					veggieConvo(vegetables[i]);
					return;
				}else if (ChatbotMain.findKeyword(response, fruits[i], 0) >= 0) {
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
			}else {
				ChatbotMain.print("Sorry, I don't know how to grow that particular food. Can you tell me another one?");
			}
		}
	}
	
	public void veggieConvo(String response) {
		ChatbotMain.print("loloxl");
	}
	
	public void fruitConvo(String response) {
		
		ChatbotMain.print("You would need to plant the " + response + " in fertile soil.");
		response = "";
		startChatting(response);
	}
}
