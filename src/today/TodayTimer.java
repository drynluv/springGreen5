package today;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TodayTimer {
	private static TodayTimer instance = new TodayTimer();
	private int x; 
	private Timer timer;
	private JLabel label;
	
	private TodayTimer() {
		x = 500;
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 2;
				if(label != null) {
					label.setBounds(x, label.getY(), label.getWidth(), label.getHeight());
				}
				if(x < -225) {
					x = 500;
				}
			}
		});
		timer.start();
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public static TodayTimer getInstance() {
		return instance;
	}
	
	
}

