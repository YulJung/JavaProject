

import java.util.HashMap;
import java.util.Map;

public class TableDTO {
	int tableNo;
	boolean state;
	Map<Integer, Integer> serving = new HashMap<Integer, Integer>(); // 메뉴번호 키 벨류 주문수량
	int payment;
	int sorce;

	public int getSorce() {
		return sorce;
	}

	public void setSorce(int sorce) {
		this.sorce = sorce;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Map<Integer, Integer> getServing() {
		return serving;
	}

	public void setServing(Map<Integer, Integer> serving) {
		this.serving = serving;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "TableDTO [tableNo=" + tableNo + ", state=" + state + ", serving=" + serving + ", payment=" + payment
				+ "]";
	}

	public TableDTO() {
		// super();
		// TODO Auto-generated constructor stub
	}

}
