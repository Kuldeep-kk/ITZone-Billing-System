import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ITZoneLog extends JFrame  {

	private JFrame frame;
	private JTextField uservar;
	private JPasswordField passwordField;
	JLabel loginbtn;

	public int eyeflag=1;
	public int passfocus=0;
	public int userfocus=0;
	static String gmail="";

	PreparedStatement pst=null;
	ResultSet rs=null;

	static StringBuffer s1=new StringBuffer();

	String color[] ={"BLACK", "BLUE", "BROWN", "GREEN"};
	int i=0;

	/**
	 * Launch the application.
	 */

	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ITZoneLog window = new ITZoneLog();

					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;


	/**
	 * Create the application.
	 */
	public ITZoneLog() {
		initialize();








	}




	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connection=sqlconnect.dbConnector();
		frame = new JFrame();

		frame.getContentPane().setBackground(Color.WHITE);


		frame.setUndecorated(true);
		frame.setBounds(100, 100, 765, 443);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setBackground(Color.WHITE);
		Image img=new ImageIcon(this.getClass().getResource("/userlog.png")).getImage();
		frame.setIconImage(img);
		frame.setTitle("KK_Creation");

		JSeparator usersap = new JSeparator();
		usersap.setForeground(Color.LIGHT_GRAY);
		usersap.setBounds(484, 227, 177, 11);
		frame.getContentPane().add(usersap);

		JSeparator passsap = new JSeparator();
		passsap.setForeground(Color.LIGHT_GRAY);
		passsap.setBounds(484, 275, 177, 11);
		frame.getContentPane().add(passsap);


		JLabel lblNewLabel_10 = new JLabel("Zone");
		lblNewLabel_10.setForeground(new Color(0, 255, 0));
		lblNewLabel_10.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_10.setBounds(153, 348, 246, 66);
		frame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("IT ");
		lblNewLabel_9.setForeground(new Color(255, 140, 0));
		lblNewLabel_9.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_9.setBounds(84, 355, 401, 37);
		frame.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_8 = new JLabel("Log in to continue...");
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_8.setForeground(new Color(0, 191, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(32, 56, 475, 171);


		frame.getContentPane().add(lblNewLabel_8);


		JLabel lblNewLabel_7 = new JLabel("Welcome Back,");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(22, 20, 446, 116);
		frame.getContentPane().add(lblNewLabel_7);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);

		panel.setBounds(0, 0, 333, 482);
		frame.getContentPane().add(panel);

		JLabel mpic1 = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/mpic.png")).getImage();
		mpic1.setIcon(new ImageIcon(img1));

		panel.add(mpic1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(320, -12, 490, 148);
		Image img2=new ImageIcon(this.getClass().getResource("/s3.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));

		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" X ");
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.repaint();
				lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.setBackground(Color.RED);
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.repaint();
				lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.setBackground(SystemColor.control);
				lblNewLabel_1.setForeground(SystemColor.activeCaption);
				lblNewLabel_1.repaint();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(733, 11, 27, 25);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/imguser2.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(514, 89, 106, 106);
		frame.getContentPane().add(lblNewLabel_2);

		uservar = new JTextField();
		uservar.setText("Enter Registered Email");
		uservar.setBorder(null);


		uservar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		uservar.setForeground(Color.GRAY);
		uservar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usersap.setForeground(new Color(0, 255, 255));
				if(uservar.getText().equals("Enter Registered Email")) {
					uservar.setText("");
					uservar.setForeground(Color.BLACK);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				}
				else {
					uservar.setForeground(Color.BLACK);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				usersap.setForeground(new Color(192, 192, 192));

				if(uservar.getText().equals("")) {
					uservar.setText("Enter Registered Email");
					uservar.setForeground(Color.LIGHT_GRAY);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 10));}

			}
		});


		uservar.setBounds(484, 202, 177, 25);
		frame.getContentPane().add(uservar);
		uservar.setColumns(10);

		JLabel msg = new JLabel("");
		msg.setBounds(539, 291, 67, 20);
		frame.getContentPane().add(msg);

		passwordField = new JPasswordField();
		passwordField.setText("Enter Password");
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setEchoChar((char)0);

		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passsap.setForeground(new Color(0, 255, 255));
passwordField.setForeground(Color.BLACK);


				if(passwordField.getText().length()==0) {
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);




				}
				else if(passwordField.getText().length()>0 && passfocus==0) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);
					passfocus=1;
				}
				else {
					passwordField.setEchoChar('●');

					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);

				}




			}
		});


		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passsap.setForeground(new Color(0, 255, 255));

				passwordField.setForeground(Color.BLACK);

				if(passwordField.getText().length()==0) {
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);




				}
				else if(passwordField.getText().length()>0 && passfocus==0) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);
					passfocus=1;
				}
				else {
					passwordField.setEchoChar('●');

					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);

				}



			}

			@Override
			public void focusLost(FocusEvent e) {

				passsap.setForeground(Color.LIGHT_GRAY);
					if(passwordField.getText().length()==0) {
						passwordField.setEchoChar((char)0);
						passwordField.setText("Enter Password");
						passwordField.setForeground(Color.LIGHT_GRAY);
						passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
						passfocus=0;

					}

				}



		});
		passwordField.setBounds(484, 249, 177, 25);

		frame.getContentPane().add(passwordField);

		JLabel eye = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("/eyeclose.png")).getImage();
		eye.setIcon(new ImageIcon(img4));


		eyeflag=1;

		eye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(eyeflag==1) {
					Image img5=new ImageIcon(this.getClass().getResource("/eyeopen.png")).getImage();
					eye.setIcon(new ImageIcon(img5));
				passwordField.setEchoChar((char)0);
				eyeflag=0;
				}
				else if(eyeflag==0) {
					Image img6=new ImageIcon(this.getClass().getResource("/eyeclose.png")).getImage();
					eye.setIcon(new ImageIcon(img6));
					eyeflag=1;
					passwordField.setEchoChar('●');


				}



			}
		});


		eye.setBounds(664, 252, 24, 17);
		frame.getContentPane().add(eye);

		JLabel lblNewLabel_3 = new JLabel("Forgot your Password ?");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3.repaint();
				lblNewLabel_3.setOpaque(true);
				lblNewLabel_3.setBackground(Color.WHITE);
				lblNewLabel_3.setForeground(Color.RED);
				lblNewLabel_3.repaint();
				frame.setLocation(500, 175);

				forgot f1=new forgot();


				f1.setLocationRelativeTo(null);
				f1.setUndecorated(true);
				f1.setVisible(true);
				frame.dispose();


			}


			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.repaint();
				lblNewLabel_3.setOpaque(true);
				lblNewLabel_3.setBackground(Color.WHITE);
				lblNewLabel_3.setForeground(new Color(0, 191, 255));
				lblNewLabel_3.repaint();
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setBounds(526, 277, 135, 20);
		frame.getContentPane().add(lblNewLabel_3);



		loginbtn = new JLabel("");
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 
				try {
					String query="select * from users where  email=? and pass=? ";
				 pst=connection.prepareStatement(query);
				 
				
					pst.setString(1,uservar.getText().trim());
					pst.setString(2,passwordField.getText().trim());

					rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					pst.close();
					rs.close();
					if(count == 1) {



						uservar.setForeground(new Color(32, 178, 170));
						passwordField.setForeground(new Color(32, 178, 170));

						s1.append(uservar.getText());
						gmail=uservar.getText();



						frame.dispose();
						mframe m1=new mframe();
						m1.setLocationRelativeTo(null);
						m1.setUndecorated(true);
						
						m1.setVisible(true);
						mframe.scrolldown();




					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else
					{
						uservar.setForeground(new Color(250, 128, 114));
						passwordField.setForeground(new Color(250, 128, 114));
						msg.setForeground(new Color(250, 128, 114));

						msg.setText("Try Again!!!");

					}
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				 
				 

			}
		});
		Image img7=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		loginbtn.setIcon(new ImageIcon(img7));
		loginbtn.setBounds(494, 322, 154, 40);

		frame.getContentPane().add(loginbtn);


		JLabel lblNewLabel_5 = new JLabel("Don't have IT Zone Account?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(464, 373, 177, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Sign Up");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6.repaint();
				lblNewLabel_6.setOpaque(true);
				lblNewLabel_6.setBackground(Color.WHITE);
				lblNewLabel_6.setForeground(Color.GREEN);
				lblNewLabel_6.repaint();
				frame.setLocation(500, 175);

				signup s=new signup();

				s.setLocationRelativeTo(null);
				s.setUndecorated(true);

				s.setVisible(true);
				frame.dispose();


			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.repaint();
				lblNewLabel_6.setOpaque(true);
				lblNewLabel_6.setBackground(Color.WHITE);
				lblNewLabel_6.setForeground(new Color(0, 191, 255));
				lblNewLabel_6.repaint();
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(new Color(0, 191, 255));
		lblNewLabel_6.setBounds(639, 370, 49, 20);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_4 = new JLabel("  -  ");
		lblNewLabel_4.setForeground(SystemColor.activeCaption);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.repaint();
				lblNewLabel_4.setOpaque(true);
				lblNewLabel_4.setBackground(new Color(0, 191, 255));
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_4.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.repaint();
				lblNewLabel_4.setOpaque(true);
				lblNewLabel_4.setBackground(SystemColor.control);
				lblNewLabel_4.setForeground(SystemColor.activeCaption);
				lblNewLabel_4.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);

			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(727, 407, 33, 25);
		frame.getContentPane().add(lblNewLabel_4);













	}
	public static StringBuffer tokk() {
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;
	}





}
