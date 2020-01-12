package view.chooseWorkspace;

import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import controller.chooseWorkspace.TimerEarthquakeListener;

public class DialogEarthquakeCenter extends Object
{
	public static final int SHAKE_DISTANCE = 10;
	public static final double SHAKE_CYCLE = 50;
	public static final int SHAKE_DURATION = 1000;
	public static final int SHAKE_UPDATE = 5;
	public static JDialog dialog;
	public static Point naturalLocation;
	public static long startTime;
	private static Timer shakeTimer;
	private final double HALF_PI = Math.PI / 2.0;
	public final static double TWO_PI = Math.PI * 2.0;
	
	public DialogEarthquakeCenter (JDialog dialog)
	{
		this.dialog = dialog;
		
		dialog.pack();
		dialog.pack();
		dialog.setModal (false);
		dialog.setVisible(true);
		
		startShake();
	
	}
	
	public void startShake() 
	{
		naturalLocation = dialog.getLocation();
		System.out.println(naturalLocation);
		startTime = System.currentTimeMillis();
		shakeTimer =new Timer(SHAKE_UPDATE, new TimerEarthquakeListener());
		shakeTimer.start();
	}
	
	public static void stopShake()
	{
		shakeTimer.stop();
		dialog.setLocation(naturalLocation);
		dialog.repaint();
	}

				
}