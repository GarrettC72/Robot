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
		String[] humored = {"Who's there? Oh, it's you.", "You're just messing with me haha"};
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
		String[] flavorFoods = {"Some spicy foods you can try are:" + "\n" + "Salsa with some chips to satisfy those late night cravings!" + "\n" + "Curry whether it's raw or with meat it'll fill you with creamy spicy goodness!" + "\n" + "Chilli is a great food to eat and it doesn't matter when you eat it." + "\n" + "And if you're feeling devilish you can try some raw peppers but beware as the California Reaper and Ghost Pepper are not for the faint of heart.",
				"Some sweet foods you can try are:" + "\n" + "Ice cream cake, you don't need to have a birthday to enjoy. :)" + "\n" + "Candy, any type of candy is good but I would say chocolate to satisfy a sweet tooth." + "\n" + "Wafers, creamy crispy goodness all in one stick ready to be eaten at a moment's notice." + "\n" + "Donuts are perfect to eat on the go and why not grab some coffee with it?" ,
				"Some sour foods you can try are:" + "\n" + "Greek yogurt, while it may not be for everyone, has a good texture with a sour punch to keep your taste buds alive." + "\n" + "Lemons, of course! Lemons are natural and if life gives you lemons you make lemonade." + "\n" + "Kefir is creamy drinkable fermented milk which boosts your intestinal tract.",
				"Some salty foods you can try are:" + "\n" + "Popcorn. Ready up a bag of popcorn and get ready for Movie Night!" + "\n" + "French Fries,although not made by the French, are a food that almost everyone enjoys." + "\n" + "Pretzels are deliciou and savory but I reccommend going for the soft ones as the hard ones are too crunchy.",
				"Some salty foods you can try are:" + "\n" + "Eggplant is a bitter plant that tastes good especially when cooked" + "\n" + "Pure chocolate or raw cocoa is very bitter and is not anything like the milk chocolate we all know and love." + "\n" + "Broccoli is another bitter plant that you can eat but I personally don't like it. Yuck!"};
		this.flavorFoods = flavorFoods;
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