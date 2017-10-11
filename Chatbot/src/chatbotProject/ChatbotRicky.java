package chatbotProject;

public class ChatbotRicky implements Topic {
	
	private String[] keywords;
	private String[] calmPopcornResponses;
	private String[] angryPopcornResponses;
	private String[] lookingForResponse;
	private String goodbyeWord;
	private String secretWord;
	private String userName;
	private boolean chatting;
	private boolean popcornChatting;

	
	public ChatbotRicky() {
		String[] temp1 = {"popcorn", "snack","snacks"}; 
		keywords = temp1;
		
		String[] temp2 = {"You should give it a try. You'll like it.","It sure would be wonderful if you liked it as much as I do!!",
		"Don't do this to yourself, you're missing out big time.", "You won't regret this! Popcorn is the snack you have been missing in your life!","..."};
		
		angryPopcornResponses = temp2;
		
		String[] temp3 = {"Did you try it yet?", "It tastes good, right?", "Are you eating popcorn right now?", "Adding popcorn to your diet will make your life much butter.","Are you enjoying it?"};
		calmPopcornResponses = temp3;
		
		String[] temp4 = {"Why aren't you answering me?!","Answer my question?!","I'm getting ANNOYED. Just answer my question and we can talk about other stuff if you want!"};
		lookingForResponse = temp4;
		
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
		ChatbotMain.print("Hey " + userName + " ! You and I have a common interest in popcorn!! ");
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
			else if(ChatbotMain.findKeyword(response, "popcorn", 0)>= 0) {
				popcornForever(response);
			} 
			else {
				ChatbotMain.print("This Chatbot does not know what you are talking about. Please type something else that's related to popcorn instead.");
			}
		}
	}
	
	public void popcornForever(String response){
		ChatbotMain.print("Hey! You want to talk about snacks like Popcorn,eh? Sounds good to me.");
		popcornChatting = true;
		while(popcornChatting) {
				ChatbotMain.print("Don't you think popcorn is the best?");
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "no", 0)>= 0 || (ChatbotMain.findKeyword(response, "not", 0)>= 0) || (ChatbotMain.findKeyword(response, "bad", 0)>= 0)){
					int int1 = (int)(Math.random()*angryPopcornResponses.length);
					ChatbotMain.print(angryPopcornResponses[int1]);
				}
				else if(ChatbotMain.findKeyword(response, "yes", 0)>= 0 || (ChatbotMain.findKeyword(response, "yeah", 0)>= 0) || (ChatbotMain.findKeyword(response, "good", 0)>= 0)) {
					int int1 = (int)(Math.random()*calmPopcornResponses.length);
					ChatbotMain.print(calmPopcornResponses[int1]);
				}
				else if (ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
					popcornChatting = false;
					ChatbotMain.chatbot.startTalking();
				} 
				else {
					int int1 = (int)(Math.random()*lookingForResponse.length);
					ChatbotMain.print(lookingForResponse[int1]);
					ChatbotMain.print("Don't you think popcorn is the best?");
				}
		}
	}
}
