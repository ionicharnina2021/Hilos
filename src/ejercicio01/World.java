package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
	private List<Being> beings = new ArrayList<>();
	private final int MAXBEINGS = 20;
	private Cornucopia cornucopia = Cornucopia.getInstance();
	private boolean fullWorld = false;
	private WorldView view;

	public World(WorldView view) {
		super();
		this.view = view;
	}

	public void makeHistory() {
		WorldPresenter worldPresenter = new WorldPresenter();
		do {
			if (!isFullWorld()) {
				beings.add(new Being());
				setFullWorld(checkFullBox());
			}
			for (Iterator iterator = beings.iterator(); iterator.hasNext();) {
				Being being = (Being) iterator.next();
				being.feed(this.cornucopia);
				being.aging();
				if (!being.isAlive()) {
					iterator.remove();
				}
			}
			view.showInstant(worldPresenter.getInstant(this));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {}
		} while (isAnyoneIn());
		
	}

	public boolean isFullWorld() {
		return fullWorld;
	}

	public void setFullWorld(boolean fullWorld) {
		this.fullWorld = fullWorld;
	}

	private boolean isAnyoneIn() {
		return beings.size() > 0;
	}

	public List<Being> getBeings() {
		return beings;
	}

	public long getConsumed() {
		return cornucopia.getConsumed();
	}

	private boolean checkFullBox() {
		return beings.size() >= MAXBEINGS;
	}

}
