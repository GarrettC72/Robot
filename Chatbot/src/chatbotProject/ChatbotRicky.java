package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String[] calmPopcornResponses;
	private String[] angryPopcornResponses;
	private String goodbyeWord;
	private String secretWord;
	private String userName;
	private boolean chatting;
	private boolean popcornChatting;

	
	public ChatbotRicky() {
		String[] temp1 = {"popcorn", "snack","snacks"}; 
		keywords = temp1;
		
		String[] temp2 = {"You should give it a try. You'll like it.","Just beleive me when I say that it is a stairway to heaven for your tastebuds",
		"Don't do this to yourself, you're missing out big time.", "You won't regret this! Popcorn is the snack you have been missing in your life!","..."};
		
		angryPopcornResponses = temp2;
		
		String[] temp3 = {"Did you try it yet?","If you don't mind telling me, what flavor did you pick?", "It tastes good, right?", "Are you eating popcorn right now?", "Adding popcorn to your diet will make your life much butter."};
		calmPopcornResponses = temp3;
		
		goodbyeWord = "bye";	
		secretWord = "Kettle Corn";
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
		ChatbotMain.print("Hey " + userName + " ! You and I have a common interest in popcorn!!");
		chatting = true;
		while (chatting) {
			response = ChatbotMain.getInput();	
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}			
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0 ) {
				ChatbotMain.print("Oh my goodness! I like Kettle Corn too!");
			}			
			else { 
				popcornForever(response);
			} //commit
		}
	}
	
	public void popcornForever(String response){
		ChatbotMain.print("Hey! You want to talk about snacks like Popcorn,eh? Sounds good to me.");
		popcornChatting = true;
		while(popcornChatting) {
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "no", 0)>= 0 || (ChatbotMain.findKeyword(response, "not", 0)>= 0)){
					int int1 = (int)(Math.random()*angryPopcornResponses.length);
					ChatbotMain.print(angryPopcornResponses[int1]);
				}
				else {
					int int1 = (int)(Math.random()*calmPopcornResponses.length);
					ChatbotMain.print(calmPopcornResponses[int1]);
				}
				if (ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				} 
		}
	}
}
