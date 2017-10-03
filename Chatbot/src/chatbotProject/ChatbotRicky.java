package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String[] snacks;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private String userName;
	
	public ChatbotRicky() {
		String[] temp = {"oreos","popcorn", "cookies","chips","doritos"};
		String[] temp1 = {"eat","hungry","starving", "snacks"}; 
		keywords = temp1;
		snacks = temp;
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
		userName = ChatbotMain.chatbot.getUserName();
		ChatbotMain.print("Hey " + userName + " ! You and I have a common interest in snacks!!");
		chatting = true;
		while (chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0 ) {
				ChatbotMain.print("Oh my goodness! You are a legend! Go Pringles!");
			}
			else { 
				ChatbotMain.print("Huh. I don't understand. Mind telling me something else, instead? Maybe a snack?");
			}
		}
	}
	
	public void continueChatting() {
		ChatbotMain.print("This is a test.");
	}
}