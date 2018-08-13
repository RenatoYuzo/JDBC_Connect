package view.mainview;

public class ItemComboBox {
	private int id;
	private String desc;
	private String pw;

	public ItemComboBox(int id, String desc, String pw) {
	    this.id = id;
	    this.desc = desc;
	  }

	public int getId() {
		return id;
	}

	public String getdesc() {
		return desc;
	}
	
	public String getPW() {
		return pw;
	}

	@Override
	public String toString() {
		return desc;
	}
}
