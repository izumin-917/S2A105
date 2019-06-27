package todo;

import java.io.Serializable;
import java.util.ArrayList;

public class TodoArrayBean implements Serializable {

	private ArrayList<TodoRecordBean> todoArray = new ArrayList<TodoRecordBean>();
	private String sessionld;

	//Constructor
	public TodoArrayBean() {
	}

	public ArrayList<TodoRecordBean> getTodoArray() {
		return todoArray;
	}

	public void addToBean(TodoRecordBean tb) {
		todoArray.add(tb);
	}

	public int getArraySize() {
		return todoArray.size();
	}

	public String getSessionld() {
		return sessionld;
	}

	public void setSessionld(String sessionld) {
		this.sessionld = sessionld;
	}

}
