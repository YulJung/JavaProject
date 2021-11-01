

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CalService {
	Scanner s = new Scanner(System.in);

	void tableCal(TableDTO table, Map<Integer, DailyDTO> daily) {// 테이블 계산
		Map<Integer, Integer> map = table.getServing();
		int pay = table.getPayment();
		int sorce = table.getSorce();
		System.out.println("총" + pay + "원 입니다.  계산을 원하시면 1번을 눌러주세요.");
		int check = s.nextInt();
		if (check == 1) {
			Date nowDate = new java.util.Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			int i = Integer.parseInt(simpleDateFormat.format(nowDate));
			DailyDTO day = daily.get(i);
			int salesNo = day.getSalesNo() + 1;
			day.setSalesNo(salesNo);
//			System.out.println(table.getServing());
			int index = map.size();
//			System.out.println(index + "size");
//			System.out.println(map.get(index));
			String str = "";
			for (int x = 1; x <= index; x++) {
				int quan = map.get(x);
				str = str + (x) + "번메뉴,수량 :" + quan + "개  ";
			}

			Map<Integer, String> map1 = day.getSalesList();
			map1.put(day.getSalesNo(), str);
//			System.out.println(str);

			day.setSalesList(map1);
			day.setIncome(day.getIncome() + pay); // 일일매출에 매출금입력
			day.setPay(day.getPay() + sorce);
			daily.put(i, day);
			table.setPayment(0);
			table.setState(false);
			System.out.println("계산이 완료되었습니다.");

		} else
			return;
	}

	void deleveryCal(Map<Integer, DailyDTO> daily, List<MenuDTO> menu) { // 배달 계산
		int allprice = 0;
		int sorce = 0;
		Date nowDate = new java.util.Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int i = Integer.parseInt(simpleDateFormat.format(nowDate));
		DailyDTO day = daily.get(i);
		Map<Integer, String> map1 = day.getSalesList();
		String str = "";
		while (true) {
			System.out.println("메뉴를 선택해주세요");
			for (MenuDTO dto : menu) {
				System.out.println(dto);
			}
			int selectMenu = s.nextInt() - 1;
			if (selectMenu > menu.size()) {
				System.out.println("메뉴가 존재하지 않습니다.");
				return;
			}
			MenuDTO selectDto = menu.get(selectMenu);
			System.out.println("수량을 입력해주세요");
			int quantity = s.nextInt();
			allprice = (allprice + (selectDto.getPrice()) * quantity);
			sorce = (sorce + (selectDto.getSorce() * quantity));

			str = str + (selectMenu + 1) + "번 메뉴 " + quantity + "개 ";
			System.out.println("계산은 1번, 추가 주문은 2번을 눌러주세요.");
			if (s.nextInt() == 1) {
				break;
			}
		}

		System.out.println("계산하실 금액은 총" + allprice + "원 입니다.");
		map1.put((day.getSalesNo() + 1), str);
		day.setSalesList(map1);
		day.setIncome(day.getIncome() + allprice); // 일일매출에 매출금입력
		day.setPay(day.getPay() + sorce); // 원가 계산
		daily.put(i, day);
		System.out.println("계산이 완료되었습니다.");

	}
}
