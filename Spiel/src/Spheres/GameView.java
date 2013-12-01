package Spheres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel {

	private JPanel centerPa, northPa, southPa, eastPa, westPa;
	private JLabel pointsLa, nameLa, timeDrawsLeftLa;
	private JButton cbB, ssB, cnB;
	private Spheres spheres;
	private String username;

	public GameView() {
		super();

		setLayout(new BorderLayout());
		northPa = new JPanel();
		northPa.setLayout(new GridLayout(1,4));

		// ---------------------------------Name_oben_links
		nameLa = new JLabel();
		nameLa.setMinimumSize(new Dimension(74, 49));
		nameLa.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		northPa.add(nameLa);
		

		// ---------------------------------Punkte_oben_links

		pointsLa = new JLabel();
		pointsLa.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		northPa.add(pointsLa);

		// --------------------------------_Zeit_/_Punkte_übrig_oben_links
		
		westPa = new JPanel();
		timeDrawsLeftLa = new JLabel();
		timeDrawsLeftLa.setBorder(BorderFactory.createEtchedBorder(
				Color.LIGHT_GRAY, Color.black));
		
		westPa.add(timeDraftsLeftLa);
		
		// --------------------------------_Spielfeld (JPanel)
		center = new JPanel();
		center.setMinimumSize(new Dimension(450, 450));
		center.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		

		// ---------------------------_Charles_Bronson_Joker_Buttn_unten_links

		cbB.setMinimumSize(new Dimension(50, 50));
		cbB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		add(cbB, BorderLayout.EAST);

		// ---------------------------_Chuck_Norris_Joker_Buttn_unten_links
		cnB = new JButton();
		cnB.setMinimumSize(new Dimension(50, 50));
		cnB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		

		// ---------------------------_Steven_Seagal_Joker_Buttn_unten_links
		ssB = new JButton();
		ssB.setMinimumSize(new Dimension(50, 50));
		ssB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		
		add(timeDrawsLeftLa, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		add(ssB, BorderLayout.SOUTH);
		add(northPa, BorderLayout.NORTH);
	}

	public void setUsername(String name) {
		nameLa.setText(name);
	}

	public void setPoints(Integer points) {
		pointsLa.setText(points.toString());
	}

	public void setTimeDraftsLeftLa(Integer draws) {
		timeDrawsLeftLa.setText(draws.toString());
	}

	public void setCBB(String txt) {
		cbB.setText(txt);
	}

	public void setCBB(String txt) {
		cbB.setText(txt);
	}

	public void setCBB(String txt) {
		cbB.setText(txt);
	}

}
