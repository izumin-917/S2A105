package todo;

import java.io.Serializable;

public class TodoRecordBean implements Serializable {

	private String importa;
	private String info;
	private String day;
	private String bikou;
	private int id;

	//Constrictor
	public TodoRecordBean() {
	}

	public String getImporta() {
		return importa;
	}

	public void setImporta(String importa) {
		this.importa = importa;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getBikou() {
		return this.bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int iD) {
		this.id = iD;
	}

}
