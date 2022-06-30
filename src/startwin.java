
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class startwin extends JFrame {

	private JPanel contentPane;
	static JProgressBar progressBar = new JProgressBar(0,99);
	JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					startwin frame = new startwin();
					frame.setBackground(null);

					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	Thread t=new Thread(new Runnable()  {
		@Override
		public void run() {
		int count=0;
		while(count<=99) {
		progressBar.setValue(count);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count=count+1;
		}
		ITZoneLog itk=new ITZoneLog();
		ITZoneLog.call();
		dispose();
		}

	});

	JLabel lblNewLabel_1;

	Thread t2=new Thread(new Runnable()  {
		@Override
		public void run() {
		int textcount=0;
		int imgcount=-50;
		while(textcount<=130) {
			lblNewLabel.setBounds(35, imgcount, 136, 97);


		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textcount=textcount+1;
		imgcount=imgcount+1;
		}

		}
	});
	Thread t3=new Thread(new Runnable()  {
		@Override
		public void run() {
		int textcount=250;

		while(textcount>=87) {
			lblNewLabel_2.setBounds(175, textcount, 170, 70);
			lblNewLabel_4.setBounds(340, textcount+5, 160, 70);

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textcount=textcount-1;

		}
		t4.start();
		}
	});

	Thread t4=new Thread(new Runnable()  {
		@Override
		public void run() {
		int textcount=450;

		while(textcount>=300) {

			lblNewLabel_5.setBounds(textcount, 152, 124, 26);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textcount=textcount-1;

		}
		progressBar.setVisible(true);
		t.start();
		}
	});


	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel bg;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Create the frame.
	 */
	public startwin() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 306);
		contentPane = new JPanel();
		contentPane.setBackground(null);

		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblNewLabel_3 = new JLabel("Starting...");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 238, 89, 26);
		lblNewLabel_3.setVisible(false);

		lblNewLabel_5 = new JLabel("2022 - 06");
		lblNewLabel_5.setForeground(new Color(85, 107, 47));
		lblNewLabel_5.setFont(new Font("STLiti", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_5.setBounds(450, 152, 124, 26);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_4 = new JLabel("Inc.");
		lblNewLabel_4.setForeground(new Color(0, 255, 255));
		lblNewLabel_4.setFont(new Font("STLiti", Font.BOLD, 40));
		lblNewLabel_4.setBounds(341, 87, 108, 70);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_3);
		progressBar.setBackground(new Color(245, 255, 250));
		progressBar.setForeground(new Color(0, 255, 127));


		progressBar.setBounds(10, 260, 439, 15);
		contentPane.add(progressBar);

		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setVisible(false);




		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 300, 600, 26);

		contentPane.add(lblNewLabel_1);

		lblNewLabel = new JLabel("");

		lblNewLabel.setBounds(30, 70, 136, 97);
		Image imgm=new ImageIcon(this.getClass().getResource("/startpic.PNG")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgm));
		contentPane.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("ITZone");
		lblNewLabel_2.setForeground(new Color(255, 140, 0));
		lblNewLabel_2.setFont(new Font("STLiti", Font.BOLD, 55));
		lblNewLabel_2.setBounds(158, 97, 192, 70);
		contentPane.add(lblNewLabel_2);



		bg = new JLabel("");
		bg.setBounds(-50, -150, 686, 535);
		Image imgbg=new ImageIcon(this.getClass().getResource("/bgload.PNG")).getImage();
		bg.setIcon(new ImageIcon(imgbg));

		t2.start();
		t3.start();

		contentPane.add(bg);



	}
}
