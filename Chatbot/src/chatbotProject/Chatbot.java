package chatbotProject;

public class Chatbot {
	
	private String userName;
	private Topic garrett;
	private Topic ricky;
	private Topic amanat;
	private boolean chatting;
	
	public Chatbot() {
		garrett = new ChatbotGarrett();
		ricky = new ChatbotRicky();
		amanat = new ChatbotAmanat();
		userName = "unknown user";
		chatting = true;
	}

	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		chatting = true;
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(garrett.isTriggered(response)) {
				chatting = false;
				garrett.startChatting(response);
			}else if(ricky.isTriggered(response)) {
				chatting = false;
				ricky.startChatting(response);
			}else if(amanat.isTriggered(response)) {
				chatting = false;
				amanat.startChatting(response);
			}else{
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}

}
