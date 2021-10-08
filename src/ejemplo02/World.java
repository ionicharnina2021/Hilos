package ejemplo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jdk.nashorn.api.tree.ForInLoopTree;

public class World {
	private List<Being> beings = new ArrayList<>();
	private final int MAXBEINGS = 5;
	private Cornucopia cornucopia = Cornucopia.getInstance();
	private boolean fullWorld = false;
	private WorldView view;

	public World(WorldView view) {
		super();
		this.view = view;
	}

	public void makeHistory() {
//		WorldPresenter worldPresenter = new WorldPresenter();
		for (int i = 0; i < MAXBEINGS; i++) {
			new Being(cornucopia).start();
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cornucopia.setEnable(false);
		System.out.println("El world is over");
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
