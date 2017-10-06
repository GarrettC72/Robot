package chatbotProject;

public class ChatbotAmanat implements Topic {

	private String username;
	private boolean onSpicy;
	private String sour;
	private String spicy;
	private String sweet;
	private String bitter;
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private boolean sayingHi;
	private String[] humored;
	private String[] annoyed;
	private String heAboutToDoIt;
	private String terminate;
	private int hellosC;
	private String[] yesWords;
	private String[] spicyList;

	private boolean terminated;
	
	public ChatbotAmanat() {
		String[] keywords = {"flavor","taste","savor","zest"};
		spicy = "spicy";
		sour = "sour";
		sweet = "sweet";
		bitter = "bitter";
		this.keywords = keywords;
		goodbyeWord = "bye";
		secretWord = "flavor town";
		String[] humored = {"Who's there? Oh, it's you " + username +".", "You're just messing with me haha"};
		String[] annoyed = {"Can you not?","I've heard this one before.","You must be fun at parties."};
		this.humored = humored;
		this.annoyed = annoyed;
		heAboutToDoIt = "Say hi or hello one more time and watch what happens";
		terminate = "You've forced this upon yourself! Terminating...";
		hellosC = 0;
		String[] yesWords = {"yes","ok","very well","please do","let me see them","yea","okey-dokey","yp"} ;
		this.yesWords = yesWords;
		String[] spicyList = {"chilli","pepper","curry","salsa",""};
		this.spicyList = spicyList;
		}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
			
		}
		if(ChatbotMain.findKeyword(response, "hi", 0) 
				>= 0 ){
			hellosC = hellosC + 1;
			getFeeling();
			return true;
		}
		else if(ChatbotMain.findKeyword(response, "hello", 0) 
				>= 0 ){
			hellosC = hellosC + 1;
			getFeeling();
			return true;
		}
		return false;
	}

	

	public void startChatting(String response) {
		username = ChatbotMain.chatbot.getUserName();
		chatting = true;
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more " + username + "!");
		while(chatting) {
		 response = ChatbotMain.getInput();
		 if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
			 chatting = false;
			 ChatbotMain.chatbot.startTalking();
		 }
		 else if(ChatbotMain.findKeyword(response,secretWord,0) >= 0) {
			 ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now."); 
		 }
		 else if(ChatbotMain.findKeyword(response,sweet,0) >= 0) {
				 ChatbotMain.print("Ah how I love sweets! You must love them too no? Let me pull up a list of sweets."); 
		 }
		 else if(ChatbotMain.findKeyword(response,sour,0) >= 0) {
			 ChatbotMain.print("Say yes and I'll make sure to show you some foods that'll make you pucker!"); 
		 }
		 else if(ChatbotMain.findKeyword(response,spicy,0) >= 0) {
			 ChatbotMain.print("Spicy foods for a spicy person! Would you like a list of torturous foods?"); 
			 for(int i = 0; i < keywords.length; i++) {
					if (ChatbotMain.findKeyword(response, yesWords[i], 0) >= 0) {
						 if(onSpicy == true) {
							 ChatbotMain.print("OK here you go: " + spicyList);
					}
					}
			 
		 }
		 }
		 else if(ChatbotMain.findKeyword(response,bitter,0) >= 0) {
			 ChatbotMain.print("I see you are a connoisseur of bitter foods. Do you want a list of some?"); 
		 }
		 else {
			 ChatbotMain.print("Huh," + response + ". I guess my creators were too lazy to implement that. ");
		 }
		}
	}
	
	public String helloResponse(String response) {
		sayingHi = true;
		while(sayingHi){
			getFeeling();
			response = ChatbotMain.getInput();
		}
		return response;
	}
	public void getFeeling() {
		int x = 0;
		if(hellosC<4) {
			x = (int)(Math.random()* 
					humored.length);
			ChatbotMain.print(humored[x]);
		}
		else if(hellosC > 3 && hellosC<6) {
			x = (int)(Math.random()* 
					annoyed.length);
			ChatbotMain.print(annoyed[x]);
		}
		else if(hellosC>5 && hellosC <7) {
			ChatbotMain.print(heAboutToDoIt);
		}
		else if(hellosC > 6) {
			ChatbotMain.print(terminate);
			sayingHi = false;
			System.exit(1);
		}
	}

}
