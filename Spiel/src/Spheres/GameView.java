package Spheres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GameView extends JPanel {
	
	private GameModel gModel;
	private JPanel centerPa, southPa, gamePa, eastPa, westPa;
	private JLabel pointsLa, nameLa, timeDrawsLeftLa, northLa;
	private JButton cbB, ssB, cnB, menuB, shopB, beendenB;
	private TitledBorder cbBrd, ssBrd, cnBrd, pointsBrd, nameBrd,
			timeDrawsLeftBrd;

	public GameView(GameModel gModelArgs) {
		super();
		gModel=gModelArgs;

		cbBrd = BorderFactory.createTitledBorder("");
		cbBrd.setTitleJustification(TitledBorder.LEFT);
		ssBrd = BorderFactory.createTitledBorder("");
		ssBrd.setTitleJustification(TitledBorder.CENTER);
		cnBrd = BorderFactory.createTitledBorder("");
		cnBrd.setTitleJustification(TitledBorder.RIGHT);
		pointsBrd = BorderFactory.createTitledBorder("");
		nameBrd = BorderFactory.createTitledBorder("");
		timeDrawsLeftBrd = BorderFactory.createTitledBorder("");

		setLayout(new BorderLayout(5, 5));
		setBackground(Color.green.darker());
		southPa = createFooter();
		add(southPa, BorderLayout.SOUTH);
		// ---------------------------------center-Panel_Spielfeld
		centerPa = new JPanel();
		centerPa.setMaximumSize(new Dimension(400, 400));
		centerPa.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		add(centerPa, BorderLayout.CENTER);
		// ----------------------------------east-Panel_f�r_die_Joker
		eastPa = new JPanel();
		eastPa.setSize(new Dimension(100, 400));
		eastPa.setLayout(new GridLayout(7, 1, 10, 10));
		eastPa.setBackground(Color.gray.darker());
		eastPa.add(new JLabel());
		// ................Bronson-Button
		cbB = new JButton("Bronson");
		cbB.setSize(new Dimension(100, 50));
		cbB.setBorder(cbBrd);
		cbB.setBackground(Color.red.brighter());
		eastPa.add(cbB);

		eastPa.add(new JLabel());
		// .................Seagal-button
		ssB = new JButton("Seagal");
		ssB.setSize(new Dimension(100, 50));
		ssB.setBorder(ssBrd);
		ssB.setBackground(Color.cyan);
		eastPa.add(ssB);
		eastPa.add(new JLabel());
		// .................Norris-button
		cnB = new JButton("Norris");
		cnB.setSize(new Dimension(100, 50));
		cnB.setBorder(cnBrd);
		cnB.setBackground(Color.yellow);
		eastPa.add(cnB);
		eastPa.add(new JLabel());
		add(eastPa, BorderLayout.EAST);

		// -------------------------------------north-Panel
		northLa = new JLabel("S P H E R E S");
		northLa.setHorizontalAlignment(JLabel.CENTER);
		add(northLa, BorderLayout.NORTH);

		// -------------------------------------west-Panel
		westPa = new JPanel();
		westPa.setSize(new Dimension(100, 400));
		westPa.setLayout(new GridLayout(7, 1, 10, 10));
		westPa.setBackground(Color.gray.darker());

		westPa.add(new JLabel());
		// ------------------------Name-Label

		westPa.add(new JLabel());
		// ------------------------Punktestand-Label
		pointsLa = new JLabel();
		pointsLa.setBorder(pointsBrd);
		westPa.add(new JLabel());
		// ------------------------Zeit / Z�ge-Label
		westPa.add(new JLabel());
		add(westPa, BorderLayout.WEST);

	}

	// ==================_footer_anlegen_=========
	public JPanel createFooter() {
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(1, 4, 10, 10));
		add(footer, BorderLayout.SOUTH);
		beendenB = new JButton("EXIT");
		beendenB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		beendenB.setSize(new Dimension(10, 20));
		beendenB.setAlignmentX(LEFT_ALIGNMENT);
		beendenB.setMnemonic(KeyEvent.VK_E);
		footer.add(beendenB);

/*		beendenB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//saveUser(user);
				System.exit(0);
			}
		});
*/

		shopB = new JButton("Shop");
		shopB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		shopB.setSize(new Dimension(10, 20));
		shopB.setAlignmentX(CENTER_ALIGNMENT);
		shopB.setMnemonic(KeyEvent.VK_S);
		footer.add(shopB);
/*
 * abmeldenB.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * spheres.navigateTo(new ViewLogin(spheres),
 * SlidingPanel.Direction.RIGHT); saveUser(user); } });
 */

		menuB = new JButton("Menu");
		menuB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		menuB.setSize(new Dimension(10, 20));
		menuB.setAlignmentX(LEFT_ALIGNMENT);
		menuB.setMnemonic(KeyEvent.VK_M);
		footer.add(menuB);
/*
 * backB.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * spheres.navigateTo(new Menu(spheres, user),
 * SlidingPanel.Direction.RIGHT); //saveUser(user); } });
 */
		return footer;
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
		cbBrd.setTitle(txt);
	}

	public void setSSB(String txt) {
		ssBrd.setTitle(txt);
	}

	public void setCNB(String txt) {
		cnBrd.setTitle(txt);
	}

	public void setNameBrd(String txt) {
		nameBrd.setTitle(txt);
	}

	public void setPointsBrd(String txt) {
		pointsBrd.setTitle(txt);
	}

	public void setTimeDrawsLeftBrd(String txt) {
		timeDrawsLeftBrd.setTitle(txt);
	}
	
	public void addExitListener(ActionListener exit) {
		beendenB.addActionListener(exit);
	}
	
	public void addShopListener(ActionListener shop) {
		shopB.addActionListener(shop);
	}
	
	public void addMenuListener(ActionListener menu) {
		menuB.addActionListener(menu);
	}

}
