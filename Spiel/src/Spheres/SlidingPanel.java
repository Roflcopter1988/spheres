package Spheres;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

public class SlidingPanel extends JPanel {

	private Component current;
	private Component old;
	private int delay = 10;
	private int animationDuration = 300;
	private int animtationSteps = animationDuration / delay;

	public SlidingPanel() {
		setLayout(new BorderLayout());
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				if (current != null)
					current.setSize(getSize());
				if (old != null)
					old.setSize(getSize());
			}
		});
	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		add(comp, Direction.LEFT);
		return comp;
	}

	@Override
	public void add(Component comp, Object constraints) {
		super.add(comp);
		validate();
		if (current == null) {
			comp.setLocation(0, 0);
			comp.setSize(getSize());
			current = comp;
		} else {
			old = current;
			current = comp;
			if (Direction.RIGHT.equals(constraints))
				comp.setLocation(-getSize().width, 0);
			else
				comp.setLocation(getSize().width, 0);
			comp.setSize(getSize());
			startAnimation((Direction) constraints);
		}
	}

	private void startAnimation(final Direction direction) {
		new Thread(new Runnable() {
			int currentStep = 0;
			long startTime = System.currentTimeMillis();

			@Override
			public void run() {
				while (true) {
					long currentTime = System.currentTimeMillis();
					if (current.getLocation().x == 0) {
						remove(old);
						old = null;
						break;
					} else {
						int distance = getWidth() / animtationSteps;
						currentStep++;
						switch (direction) {
						case RIGHT:
							current.setLocation(
									Math.min(0, -(getWidth() - currentStep
											* distance)), 0);
							old.setLocation(currentStep * distance, 0);
							break;
						case LEFT:
							current.setLocation(
									Math.max(0, getWidth() - currentStep
											* distance), 0);
							old.setLocation(-(currentStep * distance), 0);
							break;
						}
						repaint();
					}
					long sleepTime = (startTime + (delay * currentStep))
							- currentTime;
					try {
						if (sleepTime >= 4)
							Thread.sleep(sleepTime);
						else
							Thread.yield();
					} catch (InterruptedException e) {
						current.setLocation(0, 0);
						remove(old);
						break;
					}
				}

			}
		}).start();
	}

	public static enum Direction {
		LEFT, RIGHT;
	}
}
