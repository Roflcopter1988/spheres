package Spheres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GameView extends JPanel {

	private JPanel centerPa, southPa, gamePa, eastPa, westPa;
	private JLabel pointsLa, nameLa, timeDrawsLeftLa, northLa;
	private JButton cbB, ssB, cnB, menuB, shopB, beendenB;

	public GameView() {
		super();
		setLayout(new BorderLayout(5,5));
		setBackground(Color.green.darker());
		southPa = createFooter();
		add(southPa, BorderLayout.SOUTH);
		// ---------------------------------center-Panel_Spielfeld
		centerPa = new JPanel();
		centerPa.setMaximumSize(new Dimension(400, 400));
		centerPa.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		add(centerPa, BorderLayout.CENTER);
		// ----------------------------------east-Panel_für_die_Joker
		eastPa = new JPanel();
		eastPa.setSize(new Dimension(100, 400));
		eastPa.setLayout(new GridLayout(7, 1, 10, 10));

		eastPa.add(new JLabel());
		// ................Bronson-Button
		cbB = new JButton("");
		cbB.setSize(new Dimension(100, 50));
		TitledBorder brd = null;
		brd =BorderFactory.createTitledBorder("Bronson");
		brd.setTitleJustification(TitledBorder.TRAILING);
		cbB.setBorder(brd);
		cbB.setBackground(Color.red.darker());
		eastPa.add(cbB);

		eastPa.add(new JLabel());
		// .................Seagal-button
		ssB = new JButton("");
		ssB.setSize(new Dimension(100, 50));
		ssB.setBorder(BorderFactory.createTitledBorder("Seagal"));
		ssB.setBackground(Color.cyan.darker());
		eastPa.add(ssB);
		eastPa.add(new JLabel());
		// .................Norris-button
		cnB = new JButton("");
		cnB.setSize(new Dimension(100, 50));
		cnB.setBorder(BorderFactory.createTitledBorder("Norris"));
		cnB.setBackground(Color.yellow.darker());
		eastPa.add(cnB);
		eastPa.add(new JLabel());

		add(eastPa, BorderLayout.EAST);
		
		// -------------------------------------north-Panel
		northLa= new JLabel("S P H E R E S");
		northLa.setHorizontalAlignment(JLabel.CENTER);
		add(northLa, BorderLayout.NORTH);
		
		// -------------------------------------west-Panel
		westPa= new JPanel();
		westPa.setSize(new Dimension(100,400));
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
		/*
		 * beendenB.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * saveUser(user); System.exit(0); } });
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
		cbB.setText("       " + txt + "       ");
	}

	public void setSSB(String txt) {
		ssB.setText("       " + txt + "       ");
	}

	public void setCNB(String txt) {
		cnB.setText("       " + txt + "       ");
	}

	// @SuppressWarnings("deprecation")
	public void selectCBB() {
		cbB.setSelected(true);
	}

}
