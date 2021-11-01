

import java.util.HashMap;
import java.util.Map;

public class DailyDTO {
	int income; // 수익
	int pay; // 지출
	int dayCal; // 일일정산금
	int weekCal;// 주간정산금
	Map<Integer , String> salesList = new HashMap<Integer, String>();//판매리스트
//	List<Map<Integer, String>> salesList;
	int salesNo;
	int DateCheck;

	public int getDateCheck() {
		return DateCheck;
	}

	public void setDateCheck(int dateCheck) {
		DateCheck = dateCheck;
	}

	public int getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	 public  Map<Integer,String> getSalesList() {
		return salesList;
	}
	public void setSalesList( Map<Integer, String> map1) {
		this.salesList = map1;
	}
	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getDayCal() {
		return dayCal;
	}

	public void setDayCal(int dayCal) {
		this.dayCal = dayCal;
	}

	public int getWeekCal() {
		return weekCal;
	}

	public void setWeekCal(int weekCal) {
		this.weekCal = weekCal;
	}

	@Override
	public String toString() {
		return "DailyDTO [income=" + income + ", pay=" + pay + ", dayCal=" + dayCal + ", weekCal=" + weekCal + "]";
	}

	public DailyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
