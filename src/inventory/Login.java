package inventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel LoginPanel;
	private JTextField username;
	private JPanel LoginButton;
	public static String userlogin;

	private JPanel Logo;
	private Image logo_img = new ImageIcon(Login.class.getResource("/res/inventory.png")).getImage()
			.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	// private Image userIcon = new
	// ImageIcon(Login.class.getResource("/res/4664092721557740377-128.png")).getImage().getScaledInstance(30,
	// 30, Image.SCALE_SMOOTH);
	// private Image passIcon = new
	// ImageIcon(Login.class.getResource("/res/10280736291557740359-128.png")).getImage().getScaledInstance(50,
	// 50, Image.SCALE_SMOOTH);
	private Image loginButton = new ImageIcon(Login.class.getResource("/res/key.png.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JLabel logoImg;
	private JLabel LogoImg;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel buttonIcon;
	private JPasswordField Password;

	// Declaration of global variables
	static String user;
	static String pass;
	static String uCheck;
	static String pCheck;
	static boolean CheckingPassword;
	JLabel displayStatus;

	static String[] myusername = { "admin", "user" };
	static String[] mypassword = { "admin123", "user123" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login mylogin = new Login();
					mylogin.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Login() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(245, 245, 245));
		LoginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginPanel);
		LoginPanel.setLayout(null);
		setTitle("i-Inventory");
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		JPanel loginHolder = new JPanel();
		loginHolder.setBackground(new Color(72, 61, 139));
		loginHolder.setBounds(158, 65, 365, 346);
		LoginPanel.add(loginHolder);
		loginHolder.setLayout(null);

		username = new JTextField("");
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pattern = Pattern.compile("[A-Za-z]{4,15}");
				Matcher matcher = pattern.matcher(username.getText());

				if (matcher.matches()) {
					username.setForeground(new Color(0, 128, 0));

				} else {
					username.setForeground(Color.RED);
				}
			}
		});
		username.setColumns(10);
		username.setBounds(77, 108, 206, 42);
		loginHolder.add(username);

		// Using a regular expression to validate username and password

		Password = new JPasswordField("");
		Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern passpt = Pattern.compile("[A-Za-z0-9@.#%&!*%$]{8,16}");
				Matcher passmatch = passpt.matcher(Password.getText());

				if (passmatch.matches()) {
					Password.setForeground(new Color(0, 128, 0));
				} else {
					Password.setForeground(Color.RED);
				}
			}
		});
		Password.setBounds(77, 168, 206, 42);

		loginHolder.add(Password);

		LogoImg = new JLabel("");
		LogoImg.setIcon(new ImageIcon(logo_img));
		LogoImg.setBounds(143, 18, 87, 90);
		loginHolder.add(LogoImg);

		JButton Submit = new JButton("Submit");

		Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					logincheck();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		Submit.setBounds(121, 222, 122, 42);
		loginHolder.add(Submit);

		displayStatus = new JLabel("");
		displayStatus.setBounds(102, 276, 162, 28);
		loginHolder.add(displayStatus);

		// setUndecorated(true);
	}

	public void logincheck() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		// Checking username with Database credentials
		userlogin = username.getText();
		pass = Password.getText();
		if (userlogin.equals(myusername[0]) && pass.equals(mypassword[0])) {
			displayStatus.setText("Login Successful");
			displayStatus.setForeground(new Color(0, 198, 10));
			Maindashboard frame = new Maindashboard();
			frame.setVisible(true);
			setVisible(false);

		} else if (userlogin.equals(myusername[1]) && pass.equals(mypassword[1])) {
			displayStatus.setText("Login Successful");
			displayStatus.setForeground(new Color(0, 198, 10));
			Maindashboard frame = new Maindashboard();
			frame.setVisible(true);
			setVisible(false);

		} else {
			displayStatus.setText("Invalid Entry");
		}
	}

}
