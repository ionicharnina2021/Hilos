package ejemplo02;

public class Cornucopia {
	public long getConsumed() {
		return consumed;
	}

	// que ellos apliquen en singleton
	private long consumed = 0;
	private static Cornucopia cornucopia = new Cornucopia();
	private boolean enable = true;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	private Cornucopia() {
		super();
	}

	public static Cornucopia getInstance() {
		return cornucopia;
	}

	public int provide(int amount) {
		if (enable) {
			consumed += amount;
			return amount;
		}
		return 0;
	}

}
