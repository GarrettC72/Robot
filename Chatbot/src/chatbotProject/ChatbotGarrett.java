package chatbotProject;

public class ChatbotGarrett implements Topic {
	
	private String[] keywords;
	private String[] vegetables;
	private String[] fruits;
	private String goodbyeWord;
	private String secretWord;
	private String userName;
	private boolean chatting;
	private boolean veggiechatting;
	private boolean fruitchatting;
	private int fruitCount;
	private int veggieCount;
	
	public ChatbotGarrett() {
		String[] temp = {"grow", "plants", "fruits", "vegetables"};
		String[] temp2 = {"turnips", "onions", "potatoes", "cabbage", "carrots"};
		String[] temp3 = {"apples", "mangoes", "peaches", "pears", "coconuts"};
		keywords = temp;
		vegetables = temp2;
		fruits = temp3;
		goodbyeWord = "bye";
		secretWord = "green thumb";
		fruitCount = 0;
		veggieCount = 0;
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
		veggieCount++;
		ChatbotMain.print("You would need to plant the " + response + " in fertile soil.");
		veggiechatting = true;
		response = "";
		startChatting(response);
	}
	
	public void fruitConvo(String response) {
		fruitCount++;
		ChatbotMain.print("You would need to plant the " + response + " in fertile soil.");
		fruitchatting = true;
		response = "";
		startChatting(response);
	}
}
