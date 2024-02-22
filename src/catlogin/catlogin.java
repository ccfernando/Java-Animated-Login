package catlogin;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Button;
import javax.swing.SwingConstants;

public class catlogin extends JFrame {

	private JPanel contentPane;
	private JTextField passwordTextField;
	private JTextField usernameTextField;

	/**
	 * MAIN Method
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					catlogin frame = new catlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creating the jframe.
	 */
	public catlogin() {
		setTitle("FurryMovers");
		setResizable(false);
		ImageIcon img = new ImageIcon(catlogin.class.getResource("/img/icon.png"));
		setIconImage(img.getImage());
		setBounds(100, 100, 507, 398);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	/**
	 * Creating panel for the moving cat
	 */	
		JPanel catpanel = new JPanel();
		catpanel.setBackground(new Color(255, 255, 255));
		catpanel.setBounds(0, 0, 250, 368);
		contentPane.add(catpanel);
		catpanel.setLayout(null);
	
	/**
	 * Creating the layered images 
     */
		JLabel boximage = new JLabel("");
		boximage.setIcon(new ImageIcon(new ImageIcon(catlogin.class.getResource("/img/Picture2.png")).getImage()
				.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
		boximage.setBounds(0, 115, 250, 256);
		catpanel.add(boximage);

		JLabel catImage = new JLabel("");
		catImage.setIcon(new ImageIcon(new ImageIcon(catlogin.class.getResource("/img/Picture1.png")).getImage()
				.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
		catImage.setBounds(0, 245, 250, 256);
		catpanel.add(catImage);

		JLabel boximage2 = new JLabel("");
		boximage2.setIcon(new ImageIcon(new ImageIcon(catlogin.class.getResource("/img/Picture3.png")).getImage()
				.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
		boximage2.setBounds(0, 115, 250, 256);
		catpanel.add(boximage2);
		
	/**
	 * Creating panel for the login
	 */	
		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(260, 0, 234, 368);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);

		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordTextField.setBounds(28, 235, 167, 19);
		loginpanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		passwordLabel.setBounds(28, 220, 92, 13);
		loginpanel.add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(28, 191, 167, 19);
		loginpanel.add(usernameTextField);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		usernameLabel.setBounds(28, 176, 68, 13);
		loginpanel.add(usernameLabel);
		
		JLabel signinLabel = new JLabel("Sign in to your account");
		signinLabel.setForeground(new Color(255, 153, 51));
		signinLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		signinLabel.setBounds(28, 139, 167, 27);
		loginpanel.add(signinLabel);
		
		JButton signinButton = new JButton("SIGN IN");
		signinButton.setBackground(new Color(255, 153, 51));
		signinButton.setForeground(new Color(255, 250, 250));
		signinButton.setBounds(28, 297, 167, 21);
		loginpanel.add(signinButton);
		
		JLabel forgotPasswordLabel = new JLabel("Forgot password?");
		forgotPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		forgotPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		forgotPasswordLabel.setBounds(101, 264, 92, 13);
		loginpanel.add(forgotPasswordLabel);
		
		JLabel logo = new JLabel();
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(new ImageIcon(catlogin.class.getResource("/img/icon.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		logo.setBounds(28, 0, 167, 164);
		loginpanel.add(logo);
		
		JLabel newtoFMLabel = new JLabel("New to FurryMovers?");
		newtoFMLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newtoFMLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		newtoFMLabel.setBounds(27, 332, 105, 13);
		loginpanel.add(newtoFMLabel);
		
		JLabel registerLabel = new JLabel("REGISTER");
		registerLabel.setForeground(new Color(255, 153, 51));
		registerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		registerLabel.setBounds(135, 332, 83, 13);
		loginpanel.add(registerLabel);

		passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

	/**
	 * Changing the position of the jlabel when password changes
	 * create the illusion that the cat is moving
	 */	
			public void warn() {
				String text = passwordTextField.getText();
				int counttext = text.length();
				int newpos;
				if (counttext > 0) {
					if (counttext < 12) {
						newpos = 230 - (counttext * 10);
					} else {
						newpos = 230 - 110;
					}
					
					catImage.setBounds(10, newpos, 250, 256);
				}
			}
		});
	}
}
