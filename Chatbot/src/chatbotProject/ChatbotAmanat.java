package chatbotProject;

public class ChatbotAmanat implements Topic {
	
	private String[] keywords;
	private String username;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private String[] humored;
	private String[] annoyed;
	private String heAboutToDoIt;
	private String terminate;
	private int hellosC;
	private String[] flavorList;
	private String[] hiList;
	private String[] flavorFoods;
	
	public ChatbotAmanat() {
		String[] keywords = {"flavor","taste","savor","zest"};
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
		String[] flavorList= {"spicy","sweet","sour","salty","bitter","mixed"};
		this.flavorList = flavorList;
		String[] hiList = {"hi","hello","hey","whats up","how are you","yo"};
		this.hiList = hiList;
		}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		username = ChatbotMain.chatbot.getUserName();
		chatting = true;
		sayByeOrSecret(response);
		getFeeling(response);
		ChatbotMain.print("So you want to know about flavors and their respective foods " + username + "? Just type in a flavor!");
		while(chatting) {
		 response = ChatbotMain.getInput();
		 flavorTalk(response);
	}
	}
	public void flavorTalk(String response) {
		sayByeOrSecret(response);
		getFeeling(response);
		for(int i = 0; i < flavorList.length; i++) {
			if(ChatbotMain.findKeyword(response, flavorList[i], 0) >= 0) {
				ChatbotMain.print("So you want to  know more about the flavor " + response + " huh? Well I got you covered!");
				flavorFoods(response);
			}
		}
		 }
	public void flavorFoods(String response) {
		sayByeOrSecret(response);
		getFeeling(response);
		for(int i = 0; i < flavorList.length; i++) {
			if(ChatbotMain.findKeyword(response, flavorList[i], 0) >= 0) {
				ChatbotMain.print(flavorFoods[i]);
	}
		}
	}
	
	public void sayByeOrSecret(String response) {
		 if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
			 chatting = false;
			 ChatbotMain.chatbot.startTalking();
		 }
		 else if(ChatbotMain.findKeyword(response,secretWord,0) >= 0) {
			 ChatbotMain.print("Let's take a trip to Flavor Town with Guy Fieri!"); 
		 }
		 else
		 {
			 ChatbotMain.print("Sorry I don't understand waht you are talking about please rephrase it.");
		 }
	}
	
	public void getFeeling(String response) {
		for(int i = 0; i < hiList.length; i++){
			if(ChatbotMain.findKeyword(response, hiList[i], 0) >= 0) {
				
		hellosC++;
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
			System.exit(1);
		}
	}
		}
	}
}
