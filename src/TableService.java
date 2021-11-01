

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TableService extends CalService {
	Scanner s = new Scanner(System.in);

	void useTable(List<TableDTO> list, List<MenuDTO> menu, Map<Integer, DailyDTO> daily) {
		System.out.println("사용하실 테이블을 선택해주세요");
		int select = s.nextInt() - 1;
		if (select > list.size()) {
			System.out.println("테이블이 존재하지 않습니다. 다시 선택해주세요");
			return;
		}
		TableDTO table = list.get(select);
		try {
			int testprice = menu.get(0).getPrice(); // 메뉴등록 검증
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("메뉴가 존재하지 않습니다. 등록부터 진행해주세요");
			return;
		}

		if (table.isState() == true) {
			System.out.println("계산은 1번,메뉴추가는 2번을 눌러주세요");
			int i = s.nextInt();
			if (i == 1) {
				endTable(table, daily);
				list.set(select, table);
				return;
			} else if (i == 2) {
				setTable(table, menu);
				list.set(select, table);
				return;

			} else
				return;
		}

		table.setState(true);
		setTable(table, menu);
		list.set(select, table);
	}

	void setTable(TableDTO table, List<MenuDTO> menu) {
		Map<Integer, Integer> map = table.getServing();
		System.out.println("추가하실 메뉴를 선택해주세요");
		for (MenuDTO dto : menu) {
			System.out.println(dto);
		}
		int selectNo = s.nextInt() - 1;
		try {
			int select = (menu.get(selectNo).getMenuNo()) - 1;
			System.out.println("추가하실 수량을 선택해주세요");
			int quantity = s.nextInt();
			map.put(select + 1, quantity);
			table.setServing(map);// 메뉴,수량
			table.setPayment(table.getPayment() + (menu.get(select).getPrice() * quantity));
			table.setSorce(table.getSorce() + (menu.get(select).getSorce() * quantity));

			System.out.println("추가되었습니다.");

		} catch (Exception e) {
			System.out.println("등록된 메뉴가 없습니다.");
		}

	}

	void endTable(TableDTO table, Map<Integer, DailyDTO> daily) {
		tableCal(table, daily);
	}
}
