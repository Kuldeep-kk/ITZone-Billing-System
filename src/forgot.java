import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
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

public class forgot extends JFrame {

	public int eyeflag = 1;
	public int passfocus = 0;
	public int userfocus = 0;

	private JPanel contentPane;
	private JTextField uservar;
	private JPasswordField passwordField;
	private JTextField email;

	private JLabel msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					forgot frame = new forgot();

					Image img = new ImageIcon(this.getClass().getResource("/userlog.png")).getImage();
					frame.setIconImage(img);

					frame.setUndecorated(true);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs = null;
	private JTextField fabvar;

	/**
	 * Create the frame.
	 */
	public forgot() {
		connection = sqlconnect.dbConnector();
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel eye = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/eyeclose.png")).getImage();
		eye.setIcon(new ImageIcon(img4));

		eyeflag = 1;

		eye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (eyeflag == 1) {
					Image img5 = new ImageIcon(this.getClass().getResource("/eyeopen.png")).getImage();
					eye.setIcon(new ImageIcon(img5));
					passwordField.setEchoChar((char) 0);
					eyeflag = 0;
				} else if (eyeflag == 0) {
					Image img6 = new ImageIcon(this.getClass().getResource("/eyeclose.png")).getImage();
					eye.setIcon(new ImageIcon(img6));
					eyeflag = 1;
					passwordField.setEchoChar('●');

				}

			}
		});
		JLabel lblNewLabel_16 = new JLabel("Login");
		lblNewLabel_16.repaint();
		lblNewLabel_16.setBorder(BorderFactory.createRaisedBevelBorder());
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_16.setBackground(new Color(0, 191, 255));
				lblNewLabel_16.setForeground(new Color(255, 99, 71));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_16.setBackground(new Color(32, 178, 170));
				lblNewLabel_16.setForeground(new Color(255, 99, 71));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				lblNewLabel_16.setBorder(BorderFactory.createLoweredBevelBorder());
				ITZoneLog t = new ITZoneLog();
				ITZoneLog.call();
				dispose();

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				lblNewLabel_16.setBorder(BorderFactory.createRaisedBevelBorder());
			}
		});

		JSeparator passsap = new JSeparator();
		passsap.setForeground(Color.LIGHT_GRAY);
		passsap.setBounds(22, 394, 185, 18);
		contentPane.add(passsap);

		JSeparator favsap = new JSeparator();
		favsap.setForeground(Color.LIGHT_GRAY);
		favsap.setBounds(22, 358, 185, 11);
		contentPane.add(favsap);

		JSeparator emailsap = new JSeparator();
		emailsap.setForeground(Color.LIGHT_GRAY);
		emailsap.setBounds(22, 319, 185, 11);
		contentPane.add(emailsap);

		JSeparator usersap = new JSeparator();
		usersap.setForeground(new Color(192, 192, 192));
		usersap.setBounds(22, 279, 185, 11);
		contentPane.add(usersap);

		fabvar = new JTextField();
		fabvar.setText("Enter Your Favorite Song");
		fabvar.setForeground(Color.LIGHT_GRAY);
		fabvar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fabvar.setColumns(10);
		fabvar.setBorder(null);
		fabvar.setOpaque(true);
		fabvar.repaint();
		fabvar.setBounds(22, 325, 185, 30);
		contentPane.add(fabvar);

		fabvar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				favsap.setForeground(new Color(0, 255, 255));

				if (fabvar.getText().equals("Enter Your Favorite Song")) {
					fabvar.setText("");
					fabvar.setForeground(Color.BLACK);
					fabvar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				} else {
					fabvar.setForeground(Color.BLACK);
					fabvar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				favsap.setForeground(Color.LIGHT_GRAY);

				if (fabvar.getText().equals("")) {
					fabvar.setText("Enter Your Favorite Song");
					fabvar.setForeground(Color.LIGHT_GRAY);
					fabvar.setFont(new Font("Tahoma", Font.PLAIN, 10));
				}

			}
		});

		lblNewLabel_16.setOpaque(true);
		lblNewLabel_16.setBackground(new Color(32, 178, 170));
		lblNewLabel_16.setForeground(new Color(255, 99, 71));
		lblNewLabel_16.setFont(new Font("STCaiyun", Font.BOLD, 22));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(350, 150, 75, 35);
		contentPane.add(lblNewLabel_16);

		JLabel passl = new JLabel("Your Password");
		passl.setForeground(new Color(128, 128, 128));
		passl.setFont(new Font("Tahoma", Font.BOLD, 20));
		passl.setBounds(144, 138, 172, 45);
		contentPane.add(passl);

		email = new JTextField();
		email.setText("Enter Email");

		email.setBorder(null);
		email.setFont(new Font("Tahoma", Font.PLAIN, 10));
		email.setForeground(Color.LIGHT_GRAY);
		email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailsap.setForeground(new Color(0, 255, 255));

				if (email.getText().equals("Enter Email")) {
					email.setText("");
					email.setForeground(Color.BLACK);
					email.setFont(new Font("Tahoma", Font.PLAIN, 16));

				} else {
					email.setForeground(Color.BLACK);
					email.setFont(new Font("Tahoma", Font.PLAIN, 16));

				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				emailsap.setForeground(new Color(192, 192, 192));

				if (email.getText().equals("")) {
					email.setText("Enter Email");
					email.setForeground(Color.LIGHT_GRAY);
					email.setFont(new Font("Tahoma", Font.PLAIN, 10));
				}

			}
		});
		email.setColumns(10);
		email.setBounds(22, 282, 185, 34);
		contentPane.add(email);

		passwordField = new JPasswordField();
		passwordField.setText("Enter New Password");
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setEchoChar((char) 0);

		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passsap.setForeground(new Color(0, 255, 255));
				passwordField.setForeground(Color.BLACK);

				if (passwordField.getText().length() == 0) {
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);

				} else if (passwordField.getText().length() > 0 && passfocus == 0) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);
					passfocus = 1;
				} else {
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

				if (passwordField.getText().length() == 0) {
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);

				} else if (passwordField.getText().length() > 0 && passfocus == 0) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);
					passfocus = 1;
				} else {
					passwordField.setEchoChar('●');

					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
					passwordField.setForeground(Color.BLACK);

				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				passsap.setForeground(Color.LIGHT_GRAY);

				if (passwordField.getText().length() == 0) {
					passwordField.setEchoChar((char) 0);
					passwordField.setText("Enter New Password");
					passwordField.setForeground(Color.LIGHT_GRAY);
					passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
					passfocus = 0;

				}

			}

		});

		passwordField.setBounds(22, 364, 185, 28);
		contentPane.add(passwordField);

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
		lblNewLabel_1.setBounds(409, 32, 27, 25);
		contentPane.add(lblNewLabel_1);
		eye.setBounds(217, 364, 24, 17);
		contentPane.add(eye);

		uservar = new JTextField();
		uservar.setText("Enter UserName");
		uservar.setBorder(null);
		uservar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		uservar.setForeground(Color.LIGHT_GRAY);
		uservar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usersap.setForeground(new Color(0, 255, 255));

				if (uservar.getText().equals("Enter UserName")) {
					uservar.setText("");
					uservar.setForeground(Color.BLACK);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				} else {
					uservar.setForeground(Color.BLACK);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 16));

				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				usersap.setForeground(Color.LIGHT_GRAY);

				if (uservar.getText().equals("")) {
					uservar.setText("Enter UserName");
					uservar.setForeground(Color.LIGHT_GRAY);
					uservar.setFont(new Font("Tahoma", Font.PLAIN, 10));
				}

			}
		});

		uservar.setBounds(22, 241, 185, 34);
		contentPane.add(uservar);
		uservar.setColumns(10);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(Color.LIGHT_GRAY);
		separator_3_1.setBounds(90, 128, 63, 11);
		contentPane.add(separator_3_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(278, 128, 63, 11);
		contentPane.add(separator_3);

		JLabel lblNewLabel_5 = new JLabel("Forgot ");
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(188, 105, 72, 45);
		contentPane.add(lblNewLabel_5);

		msg = new JLabel("");
		msg.setBounds(156, 463, 104, 34);
		contentPane.add(msg);

		JLabel done = new JLabel("");
		done.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!"Enter Username".equals(uservar) && uservar.getText().length() > 0) {
					if (!"Enter New Password".equals(passwordField) && passwordField.getText().length() > 0) {
						if(!"Enter Your Favorite Song".equals(fabvar) && fabvar.getText().length()>0) {
						if (!"Enter Email".equals(email) && email.getText().length() > 0
								&& email.getText().contains("@")) {
							msg.setText("Well Done!!!");
							msg.setForeground(Color.GREEN);
							try {
								String query = "select * from users where username=? and email=? and fab=? ";
								pst = connection.prepareStatement(query);
								pst.setString(1, uservar.getText().trim());
								pst.setString(2, email.getText().trim());
								pst.setString(3, fabvar.getText().trim());
								

								ResultSet rs = pst.executeQuery();
								int count = 0;
								while (rs.next()) {
									count = count + 1;
								}
								if (count == 1) {

									try {
										String query2 = "update users set pass='" + passwordField.getText()
												+ "' where  email='"
												+ email.getText() + "'";
										pst1 = connection.prepareStatement(query2);
										pst1.execute();
										pst1.close();
										JOptionPane.showMessageDialog(null, "Data Updated");
										pst.close();
										rs.close();
										ITZoneLog t = new ITZoneLog();
										ITZoneLog.call();
										dispose();

									} catch (Exception e2) {
										msg.setText("Try Again!!!");
										msg.setForeground(Color.RED);
										JOptionPane.showMessageDialog(null, e2);

									}
								} else {
									msg.setText("Try Again!!!");
									msg.setForeground(Color.RED);

									JOptionPane.showMessageDialog(null, ("No existing author found with username="
											+ uservar.getText() + " & email=" + email.getText() + " &  Favorite Song=" + fabvar.getText()));
								}
								

							} catch (Exception e1) {
								msg.setText("Try Again!!!");
								msg.setForeground(Color.RED);
								JOptionPane.showMessageDialog(null, e1);

							}
						} else {
							msg.setText("Try Again!!!");
							msg.setForeground(Color.RED);

						}

					} else {

						msg.setText("Try Again!!!");
						msg.setForeground(Color.RED);

					}
				}

				else {
					msg.setText("Try Again!!!");
					msg.setForeground(Color.RED);

				}
			}

			}
		});
		Image tk = new ImageIcon(this.getClass().getResource("/tick.png")).getImage();
		done.setIcon(new ImageIcon(tk));
		done.setBounds(278, 281, 81, 71);
		contentPane.add(done);

		JLabel lblNewLabel_3 = new JLabel("");
		Image borderimg = new ImageIcon(this.getClass().getResource("/entrycornerborder.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(borderimg));
		lblNewLabel_3.setBounds(0, 209, 335, 243);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_10 = new JLabel("Zone");
		lblNewLabel_10.setForeground(new Color(0, 255, 127));
		lblNewLabel_10.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_10.setBounds(113, 11, 246, 66);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("IT ");
		lblNewLabel_9.setForeground(new Color(0, 255, 255));
		lblNewLabel_9.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_9.setBounds(79, 11, 63, 37);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_2 = new JLabel("");
		Image logoimg = new ImageIcon(this.getClass().getResource("/mpiclogo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(logoimg));

		lblNewLabel_2.setBounds(0, -20, 81, 120);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 436, 205);
		contentPane.add(lblNewLabel);
		Image bgimg = new ImageIcon(this.getClass().getResource("/appbg1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(bgimg));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-15, 341, 489, 255);
		contentPane.add(panel);

		JLabel lblNewLabel_11 = new JLabel("");
		Image bgimg2 = new ImageIcon(this.getClass().getResource("/appbg2.png")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(bgimg2));
		panel.add(lblNewLabel_11);

	}
}
