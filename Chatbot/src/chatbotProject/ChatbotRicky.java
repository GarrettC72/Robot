package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotRicky() {
		String[] temp = {"eat","hungry","starving", "snack"}; 
		keywords = temp;v
		goodbyeWord = "bye";	
		secretWord = "California Roll";
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
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while (chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0 ) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. Much respect to you!");
			}
			else { 
				ChatbotMain.print("Huh. I don't understand. Mind tellling me something else, instead?");
			}
		}
	}
}
