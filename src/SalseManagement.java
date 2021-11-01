

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SalseManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyService dSer = new DailyService();
		MenuService mSer = new MenuService();
		TableService tSer = new TableService();
		Map<Integer,DailyDTO> dList = new HashMap<Integer,DailyDTO>();
		List<MenuDTO> mList = new ArrayList<MenuDTO>();
		List<TableDTO> tList = new ArrayList<TableDTO>();
		Date nowDate = new java.util.Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int j = Integer.parseInt(simpleDateFormat.format(nowDate));
		DailyDTO day = new DailyDTO();
		dList.put(j, day);
		for (int i = 0; i < 7; i++) {
			TableDTO dto = new TableDTO();
			tList.add(dto);
		}
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("원하시는 기능을 선택해주세요");
			System.out.println("--------------------------------");
			System.out.println("1.테이블 선택 2.포장주문 3.메뉴관리 4.정산관리 ");
			int select = s.nextInt();
			switch (select) {
			case 1:
				tSer.useTable(tList, mList, dList);
				break;
			case 2:
				tSer.deleveryCal(dList, mList);
				break;
			case 3:
				System.out.println("메뉴 관리입니다. 원하시는 기능을 선택하세요.");
				System.out.println("--------------------------------");
				System.out.println("1.메뉴 등록 2.메뉴 수정 3.메뉴 삭제 4.메뉴 조회");
				int no = s.nextInt();
				if (no == 1) {
					mSer.addMenu(mList);
				} else if (no == 2) {
					mSer.updateMenu(mList);
				} else if (no == 3) {
					mSer.delMenu(mList);
				} else if (no == 4) {
					mSer.menuView(mList);
				} else {
					System.out.println("잘못선택하셨습니다.");
				}
				break;
			case 4:
				System.out.println("정산 관리입니다. 원하시는 기능을 선택하세요.");
				System.out.println("--------------------------------");
				System.out.println("1.매출조회 2.매출 상세조회 3.일일정산 4.주간정산 ");
				int no1 = s.nextInt();
				if (no1 == 1) {
					dSer.dailyCheck(dList); //매출안뜸
				} else if (no1 == 2) {
					dSer.salesDetail(dList);  //전체수정
				} else if (no1 == 3) {
					dSer.dailyPayment(dList);   //지출설정
				} else if (no1 == 4) {
					dSer.weeklyPayment(dList); //
				}
				break;
			default:
				System.out.println("잘못선택하셨습니다.");
			}
			System.out.println("--------------------------------");
		}
	}

}
