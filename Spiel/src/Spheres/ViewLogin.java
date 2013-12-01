package Spheres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewLogin extends JPanel {
	/**
	 * Die Klasse ViewLogin hält die für den Login benötigten Textfelder,
	 * Buttons und Funktionen *
	 */

	// --------Variablendeklaration---------------------------------------------------------
	private static final String USERS_PROPERTIES = "users.properties";
	private static final Logger LOGGER = Logger.getLogger(ViewLogin.class
			.getName());
	private static final String REGTXT = "<html>Zum Registrieren bitte die Felder für"
			+ "<br> den Beutzername und das Passwort ausfüllen."
			+ "<br> Anschließen den Registrieren Knopf betätigen.</html>";
	private JTextField usertf;
	private JLabel titelLa, errorLa, pwLa, userLa, regLa;
	private JPanel header, center, footer;
	private JPasswordField PWpf;
	private JButton loginB, newUserB, beendenB;
	private String Username, Password;
	private Spheres spheres;

	// -------Konstruktor---------------------------------------------------------------------
	public ViewLogin(Spheres spheresArgs) {
		// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&_Aufbau_Inhalt_Frame__&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		this.spheres = spheresArgs;
		setBackground(Color.lightGray);
		setLayout(new BorderLayout(10, 20));
		// ================================================================> Ost
		// und West
		add(new JLabel(), BorderLayout.EAST);
		add(new JLabel(), BorderLayout.WEST);
		// ===========================================================> HEADER
		header = new JPanel();
		header.setLayout(new GridLayout(2, 1, 0, 2));
		add(header, BorderLayout.NORTH);
		// ---------------------------------------> Platzhalter
		titelLa = new JLabel();
		titelLa.setHorizontalAlignment(JLabel.CENTER);
		titelLa.setText("<html><h3>Willkommen zu</h3><br><h1>S p h e r e S<h1></html>");

		header.add(titelLa);
		// ---------------------------------------> Header unten
		errorLa = new JLabel();
		errorLa.setHorizontalAlignment(JLabel.CENTER);
		header.add(errorLa);
		// ============================================================> Center
		center = new JPanel();
		setBackground(Color.GREEN.darker());
		center.setBorder(BorderFactory
				.createTitledBorder("Bitte hier mit Ihrem Benutzernamen und Passwort anmelden"));
		center.setLayout(new GridLayout(4, 2));
		add(center, BorderLayout.CENTER);

		// +++++ Panel Platzhalter
		center.add(new JPanel());
		center.add(new JPanel());
		// +++++++ Abfrage Username
		userLa = new JLabel("Benutzername:     ");
		userLa.setHorizontalAlignment(JLabel.RIGHT);
		center.add(userLa);
		usertf = new JTextField();
		usertf.setColumns(10);
		center.add(usertf);
		// ++++++++ Abfrage Passwort
		pwLa = new JLabel("Passwort:     ");
		pwLa.setHorizontalAlignment(JLabel.RIGHT);
		center.add(pwLa);
		PWpf = new JPasswordField();
		center.add(PWpf);
		// +++++ Panel Platzhalter und Login-Button
		center.add(new JPanel());
		loginB = new JButton("Login");
		loginB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		loginB.setToolTipText(REGTXT);
		loginB.setMnemonic(KeyEvent.VK_L);
		center.add(loginB);
		loginB.addActionListener(new ActionListener() {
			// Annonyme Listenerklasse für den Loginbutton
			@Override
			public void actionPerformed(ActionEvent e) {
				Username = usertf.getText();
				Password = new String(PWpf.getPassword());
				if (authenticate(Username, Password))
					spheres.navigateTo(new Menu(spheres, loadProperties(Username)));
				else
					setError("Benutzername oder Passwort falsch !");
			}
		});
		// ================================================================>
		// footer anlegen und befüllen
		footer = new JPanel();
		add(footer, BorderLayout.SOUTH);
		footer.setLayout(new GridLayout(2, 3, 10, 20));
		footer.add(new JLabel());
		regLa = new JLabel("Noch nicht registriert? ");
		regLa.setHorizontalAlignment(JLabel.RIGHT);
		regLa.setForeground(Color.blue);
		regLa.setToolTipText(REGTXT);
		footer.add(regLa);
		newUserB = new JButton("Registrieren");
		newUserB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		newUserB.setToolTipText(REGTXT);
		footer.add(newUserB);
		newUserB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Username = usertf.getText();
				Password = new String(PWpf.getPassword());

				if (createUser(Username, Password))
					spheres.navigateTo(new Menu(spheres, loadProperties(Username)));
			}
		});
		beendenB = new JButton("EXIT");
		beendenB.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,
				Color.black));
		beendenB.setSize(new Dimension(10, 20));
		beendenB.setMnemonic(KeyEvent.VK_E);
		footer.add(beendenB);
		beendenB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		footer.add(new JLabel());
		footer.add(new JLabel());
	}

	// &&&&&&&&&&&&&&&&&&&&&&&_Ende_der_Anzeige_&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	// ---------------------------Methoden----------------------------------

	public String getUser() {
		return usertf.getText();
	}

	public void setError(String msg) {
		errorLa.setForeground(Color.red);
		errorLa.setText(msg);
	}

	// ================== Innere Klassen ========================
	private boolean createUser(String user, String pw) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			byte[] result = digest.digest(pw.getBytes());
			String hashValue = new String(result);
			User benutzer = loadProperties(user);
			if (benutzer != null) {
				setError("Benutzername bereits vorhanden !");
				return false;
			}
			newUserFile(user, hashValue);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.log(Level.SEVERE, "MD5 Algorithmus nicht gefunden", e);
		}
		return true;
	}

	boolean authenticate(String user, String pw) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] result = digest.digest(pw.getBytes());
			String hashValue = new String(result);
			User benutzer = loadProperties(user);
			if (benutzer == null)
				return false;
			String passwordHash = benutzer.getPass();
			return hashValue.equals(passwordHash);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.log(Level.SEVERE, "MD5 Digester nicht gefunden");
		}
		return false;
	}

	private void newUserFile(String user, String pw) {
		FileOutputStream fos = null;
		File userData = new File(user);
		ObjectOutputStream oos = null;
		User benutzer = new User(user, pw);
		try {
			fos = new FileOutputStream(userData);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(benutzer);

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,
					"Properties konnten nicht gespeichert werden", e);
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					LOGGER.log(Level.WARNING,
							"Properties konnten nicht geschlossen werden", e);
				}
		}
	}

	private User loadProperties(String username) {
		User benutzer = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File userName = new File(username);
		if (userName.exists()) {
			try {
				fis = new FileInputStream(userName);
				ois = new ObjectInputStream(fis);
				benutzer = (User) ois.readObject();
				return benutzer;
			} catch (FileNotFoundException e) {
				LOGGER.log(Level.WARNING,
						" File username konnte nicht gefunden", e);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE,
						"user.properties konnten nicht geladen werden", e);
			} catch (ClassNotFoundException e) {
				LOGGER.log(Level.SEVERE,
						"Class User konnte nicht geladen werden", e);
			} finally {
				if (ois != null)
					try {
						ois.close();
					} catch (IOException e) {
						LOGGER.log(
								Level.WARNING,
								"ObjectInputStream konnten nicht geschlossen werden",
								e);
					}
			}
		}
		return null;
	}
}