import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Alarm_clock {

	static boolean Rang=false;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alarm_clock window = new Alarm_clock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Alarm_clock() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 461, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSpinner hours = new JSpinner(new SpinnerNumberModel(0,0,23,1));
		hours.setBounds(0, 40, 100, 30);
		frame.getContentPane().add(hours);
		
		JSpinner minutes = new JSpinner(new SpinnerNumberModel(0,0,59,1));
		minutes.setBounds(120, 40, 100, 30);
		frame.getContentPane().add(minutes);
		
		JSpinner seconds = new JSpinner(new SpinnerNumberModel(0,0,59,1));
		seconds.setBounds(240, 40, 100, 30);
		frame.getContentPane().add(seconds);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setBounds(5, 5, 70, 30);
		frame.getContentPane().add(lblHours);
		
		JLabel Minutes = new JLabel("Minutes");
		Minutes.setHorizontalAlignment(SwingConstants.CENTER);
		Minutes.setBounds(120, 5, 70, 30);
		frame.getContentPane().add(Minutes);
		
		JLabel Seconds = new JLabel("Seconds");
		Seconds.setHorizontalAlignment(SwingConstants.CENTER);
		Seconds.setBounds(240, 5, 70, 30);
		frame.getContentPane().add(Seconds);
		
		JLabel Days = new JLabel("Days");
		Days.setHorizontalAlignment(SwingConstants.CENTER);
		Days.setBounds(5, 120, 70, 30);
		frame.getContentPane().add(Days);
		
		JLabel Month = new JLabel("Month");
		Month.setHorizontalAlignment(SwingConstants.CENTER);
		Month.setBounds(120, 120, 70, 30);
		frame.getContentPane().add(Month);
	
		JLabel Year = new JLabel("Year");
		Year.setHorizontalAlignment(SwingConstants.CENTER);
		Year.setBounds(240, 120, 70, 30);
		frame.getContentPane().add(Year);
		
		JSpinner mm = new JSpinner(new SpinnerNumberModel(0,0,12,1));
		mm.setBounds(120, 140, 100, 30);
		frame.getContentPane().add(mm);
	
		JSpinner dd = new JSpinner(new SpinnerNumberModel(0,0,31,1));
		dd.setBounds(0, 140, 100, 30);
		frame.getContentPane().add(dd);
		
		JSpinner yyyy = new JSpinner(new SpinnerNumberModel(2019,2018,3000,1));
		yyyy.setBounds(240, 140, 100, 30);
		frame.getContentPane().add(yyyy);
		/**
		 * adding action on set alarm button which executes the thread  
		 */
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Rang=false;
				Date Alarm=new Date();
				Alarm.setDate((int)dd.getValue());
				Alarm.setMonth((int)mm.getValue()-1);
				Alarm.setYear((int)yyyy.getValue());
				Alarm.setMinutes((int)minutes.getValue());
				Alarm.setSeconds((int)seconds.getValue());
				Alarm.setHours((int)hours.getValue());
				/**
				 * Thread t will run an infinite loop until the rang variable turns to false
				 */	
				Thread t=new Thread() {
					public void run()
					{
						while(true) {
							Date now=new Date();
							//System.out.println((boolean)(now.getDate()==Alarm.getDate())+ " " +(boolean)(now.getHours()==Alarm.getHours())
							//		+" "+(boolean)(now.getMinutes()==Alarm.getMinutes()));
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(now.getDate()==Alarm.getDate()&&now.getHours()==Alarm.getHours()&&now.getMinutes()==Alarm.getMinutes())
							{
								try {
									while(Rang)
									{
										File f=new File("D:\\Program Files\\Workspace\\Assignment\\src\\temp.wav");
										Desktop.getDesktop().open(f);
										sleep(4000);
									}
//								AudioInputStream audioIn = AudioSystem.getAudioInputStream(Alarm_clock.class.getResource("C:\\Users\\Piyush\\source\\repos\\PythonApplication1\\PythonApplication1\\temp.wav"));
//								Clip clip = AudioSystem.getClip();
//								clip.open(audioIn);
//								clip.start();
								break;
							}
							catch(Exception e)
							{
								System.out.println("Error!!!!");
							}
						
						}
							else {
								Rang=true;
							}
						
					}
				}
				
			};
				t.start();
		}});
		 btnSetAlarm.setBounds(10, 250, 100, 30);
		frame.getContentPane().add(btnSetAlarm);
		
		JButton SeeAlarm= new JButton("Stop");
		/**
		 * It turns Rang variable as false which will terminate the infinite loop
		 */
		SeeAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rang=false;
			}
		});
		 SeeAlarm.setBounds(200, 250, 150, 30);
		frame.getContentPane().add( SeeAlarm);
		
		JLabel lbl=new JLabel();
		frame.getContentPane().add(lbl);
	}

}
