package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String[] snacks;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private String userName;
	
	public ChatbotRicky() {

		String[] temp = {"eat","hungry","starving", "snack"}; 
		keywords = temp;

		String[] temp = {"oreos","popcorn", "cookies","chips","doritos"};
		String[] temp1 = {"eat","hungry","starving", "snack"}; 
		keywords = temp;
		snacks = temp1;

		goodbyeWord = "bye";	
		secretWord = "Pringles";
		userName = ChatbotMain.chatbot.getUserName();
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
		ChatbotMain.print("Hey! You and I have a common interest in snacks!!");
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
