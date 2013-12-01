package Spheres;

import java.io.Serializable;

public class GameModel implements Serializable {

	private Ball[] balls;
	private int gameMode;
	private User user;
	private GameView gView;

	public GameModel(GameView gViewArgs, int modeArgs, User userArgs) {
		gView = gViewArgs;
		user = userArgs;
		gameMode = modeArgs;
		
		// ----------------------------------Anzeige_Einstellen
		/*
		gView.setUsername(user.getName());
		gView.setPoints((Integer)user.getPoints());
		gView.setTimeDraftsLeftLa((Integer)30);
		gView.setCBB(user.getCbAnzS());
		gView.setSSB(user.getSsAnzS());
		gView.setCNB(user.getCnAnzS());
		*/
		//for (int i = 0; i < 36; i++) {
			//balls[i] = new Ball(i,user.getColorChoice());
		//}
	}
}
