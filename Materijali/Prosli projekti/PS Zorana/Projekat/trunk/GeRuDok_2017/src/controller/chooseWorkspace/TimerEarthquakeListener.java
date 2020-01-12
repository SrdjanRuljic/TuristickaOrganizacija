package controller.chooseWorkspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.chooseWorkspace.DialogEarthquakeCenter;

public class TimerEarthquakeListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// calculate elapsed time
		long elapsed = System.currentTimeMillis() - DialogEarthquakeCenter.startTime;
		// use sin to calculate an x-offset
		double waveOffset = (elapsed % DialogEarthquakeCenter.SHAKE_CYCLE) / DialogEarthquakeCenter.SHAKE_CYCLE;
		double angle = waveOffset * DialogEarthquakeCenter.TWO_PI;
		// offset the x-location by an amount
		// proportional to the sine, up to
		// shake_distance
		int shakenX = (int) ((Math.sin (angle) * DialogEarthquakeCenter.SHAKE_DISTANCE) + DialogEarthquakeCenter.naturalLocation.getX());
		DialogEarthquakeCenter.dialog.setLocation(shakenX, (int) DialogEarthquakeCenter.naturalLocation.getY());
		DialogEarthquakeCenter.dialog.repaint();
		// should we stop timer?
		if (elapsed >= DialogEarthquakeCenter.SHAKE_DURATION)
		DialogEarthquakeCenter.stopShake();

	}

}
