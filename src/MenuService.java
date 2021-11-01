
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuService {
	Scanner s = new Scanner(System.in);

	void addMenu(List<MenuDTO> list) {
		MenuDTO menu = new MenuDTO();
		System.out.println("메뉴 이름을 입력해주세요.");
		menu.setMenuName(s.next());
		menu.setMenuNo(list.size() + 1);
		System.out.println("메뉴 가격을 입력해주세요");
		menu.setPrice(s.nextInt());
		if (menu.getPrice() <= 0) {
			System.out.println("금액을 잘못입력하셨습니다.");
			addMenu(list);
		}
		System.out.println("원가를 입력해주세요");
		menu.setSorce(s.nextInt());
		list.add(menu);
		System.out.println("메뉴등록이 완료되었습니다.");
	}

	void updateMenu(List<MenuDTO> list) {
		if(list.size()==0) {
			System.out.println("등록된 메뉴가 없습니다.");
			return;
		}
		System.out.println("수정하실 메뉴의 번호를 입력해주세요");
		int select = s.nextInt() - 1;
		if(select<list.size()) {
			System.out.println("잘못 선택하셨습니다.");
			updateMenu(list);
		}
		MenuDTO selMenu = list.get(select);
		System.out.println("수정하실 판매가를 입력해주세요");
		selMenu.setPrice(s.nextInt());
		System.out.println("수정하실 원가를 입력해주세요");
		selMenu.setSorce(s.nextInt());
		list.set(select, selMenu);
		System.out.println("수정이 완료되었습니다.");

	}

	void delMenu(List<MenuDTO> list) {
		if(list.size()==0) {
			System.out.println("등록된 메뉴가 없습니다.");
			return;
		}
		System.out.println("삭제하실 메뉴의 번호를 입력해주세요");
		int select = s.nextInt() - 1;
		if (select > list.size() + 1) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		MenuDTO selMenu = list.get(select);
		System.out.println("선택하신 메뉴는" + selMenu.getMenuName() + "입니다.");
		System.out.println("삭제를 원하시면 1번을 눌러주세요");
		if (s.nextInt() == 1) {
			list.remove(select);
			System.out.println("삭제가 완료되었습니다.");
			return;
		}
		System.out.println("삭제 취소");
	}

	void menuView(List<MenuDTO> list) {
		if(list.size()==0) {
			System.out.println("등록된 메뉴가 없습니다.");
			return;
		}
		for (MenuDTO menu : list) {
			System.out.println(menu);
		}
		
	}

}
