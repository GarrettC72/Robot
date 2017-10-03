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
		String[] temp2 = {"corn", "lettuce", "potato", "tomato", "carrot", "broccoli"};
		String[] temp3 = {"apple", "banana", "strawberry", "strawberries", "grapes", "watermelon"};
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
		ChatbotMain.print("Hey! It sounds like you want to grow your own food! What would you like to know?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You must be a gardening fanatic!");
			}else {
			ChatbotMain.print("Sorry, I don't know how to grow that particular plant. Can you tell me another one?");
			}
		}
	}
}
