

public class MenuDTO implements Comparable<MenuDTO> {
	int menuNo; //번호
	String menuName; //이름
	int price; //판매가
	int sorce; //원가
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSorce() {
		return sorce;
	}
	public void setSorce(int sorce) {
		this.sorce = sorce;
	}
	@Override
	public String toString() {
		return "메뉴 번호 :" + menuNo + ", 메뉴 :" + menuName + ", 가격 " + price ;
	}
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(MenuDTO o) {
		if (o.price < price) {
			return 1;
			} else if (o.price > price) {
			return -1;
			}

		return 0;
	}
	
}
