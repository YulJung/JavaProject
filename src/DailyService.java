

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class DailyService {
	Date nowDate = new java.util.Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	int i = Integer.parseInt(simpleDateFormat.format(nowDate));
	Scanner s= new Scanner(System.in);
	void dailyCheck(Map<Integer,DailyDTO> list) { //일일 매출조회
		DailyDTO day =  list.get(i);
		System.out.println("금일 매출은 :"+day.getIncome()+"원입니다.");
	}
	void salesDetail(Map<Integer,DailyDTO> list) {//매출 상세조회
		if(list.size()==0) {
			System.out.println("조회할 내용이 없습니다.");
			return;
		}
		DailyDTO day =  list.get(i);
		System.out.println("금일 매출리스트입니다.");
		Map<Integer,String> map = day.getSalesList();
		for(Integer k : map.keySet()) {
			System.out.println(k+"번  "+map.get(k));
		}
	}
	void dailyPayment(Map<Integer,DailyDTO> list) {//일일정산
		DailyDTO day =  list.get(i);
		int dayCal = 0;
		System.out.println("금일 지출금 : "+day.getPay()+"원");
		System.out.println("금일 수입 : "+day.getIncome()+"원");
		dayCal =((day.getIncome()-day.getPay()));
		System.out.println("오늘의 수익은"+dayCal+"원 입니다.");
		day.setDayCal(dayCal);
		day.setDateCheck(day.getDateCheck()+1);
		if(day.getDateCheck()==7) { //주간 초기화
			day.setDateCheck(0);
			day.setWeekCal(0);
		}
		day.setWeekCal(day.getWeekCal()+dayCal);
		
	}
	void weeklyPayment(Map<Integer,DailyDTO> list) {//주간정산
		DailyDTO day =  list.get(i);
		if(day.getWeekCal()==0) {
			System.out.println("일일정산을 실행해주세요");
			return;
		}
		System.out.println("주간정산금은"+day.getWeekCal()+"원 입니다.");
	}
}
