package chatbotProject;

public class ChatbotGarrett implements Topic {
	
	private String[] keywords;
	private String[] vegetables;
	private String[] fruits;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotGarrett() {
		String[] temp = {"grow", "plants", "fruits", "vegetables"};
		String[] temp2 = {"corn", "lettuce", "potato", "cucumber"};
		String[] temp3 = {"apple", "orange", "watermelon", "grapes"};
		keywords = temp;
		vegetables = temp2;
		fruits = temp3;
		goodbyeWord = "bye";
		secretWord = "rainbow carrots";
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
		ChatbotMain.print("Hey! It sounds like you and I have common interests! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	}
}
