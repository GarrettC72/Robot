package chatbotProject;

public class HelloResponse implements Topic{
	private boolean sayingHi;
	private String username;
	private String[] humored;
	private String[] annoyed;
	private String HeAboutToDoIt;
	private String Terminate;
	private int hellosC;
	private boolean terminated;
	
	public HelloResponse(){
		username = ChatbotMain.chatbot.getUserName();
		String[] humored = {"Who's there? Oh it's you" + username, "You're just messing with me haha"};
		String[] annoyed = {"Can you not?","I've heard this one before.","You must be fun at parties."};
		this.humored = humored;
		this.annoyed = annoyed;
		HeAboutToDoIt = "Say hi or hello one more time and watch what happens";
		Terminate = "You've forced this upon yourself! Terminating...";
		hellosC = 0;
	}
	
	public boolean isTriggered(String response) {
		if(ChatbotMain.findKeyword(response, "hi", 0) 
				>= 0 ){
			return true;
		}
		if(ChatbotMain.findKeyword(response, "hello", 0) 
				>= 0 ){
			return true;
		}
		return false;
	}

	
	public void startChatting(String response) {
		sayingHi = true;
		while(sayingHi){
			hellosC++;
			getFeeling();
			Terminate = ChatbotMain.getInput();
			//! is used for negation
			if(!isTriggered(Terminate)){
				sayingHi = false;
				System.exit(1);
			}
		}
	}
	
	private void getFeeling() {
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
			x = (int)(Math.random()* 
					HeAboutToDoIt.length());
			ChatbotMain.print(HeAboutToDoIt);
		}
		else if(hellosC > 6) {
			x = (int)(Math.random()* 
					Terminate.length());
			ChatbotMain.print(Terminate);
		}
	}

}
