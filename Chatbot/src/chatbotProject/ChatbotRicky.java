package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotRicky() {
<<<<<<< HEAD
		String[] temp = {"snack"}; 
		String[] temp2 = {"oreos","popcorn", "cookies","chips","doritos"};
		keywords = temp;
=======
		String[] temp = {"eat","hungry","starving", "snack"}; 
		keywords = temp;v
>>>>>>> branch 'master' of https://github.com/GarrettC72/Robot.git
		goodbyeWord = "bye";	
		secretWord = "Pringles";
	}
	
	public boolean isTriggered(String response) {
		for (int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Hey! It sounds like you and I have a common interest in snacks!!");
		chatting = true;
		while (chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0 ) {
				ChatbotMain.print("Oh my goodness! You are a legend if you like Pringles!");
				continueChatting(response);
			}
			else { 
				ChatbotMain.print("Huh. I don't understand. Mind telling me something else, instead? Maybe a snack?");
				continueChatting(response);
			}
		}
	}
	
	public void continueChatting (String response) {
		ChatbotMain.print("What is your favorite snack?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0 ) {
				ChatbotMain.print("Oh my goodness! You are a legend if you like Pringles!");
				continueChatting(response);
			}
			else {
				ChatbotMain.print("test");
			}
		}
	}
}
