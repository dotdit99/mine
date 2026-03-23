package 해시맵응용;

import java.util.HashMap;
import java.util.Map;

public class MenuService {
    private final Map<String, Menu> map = new HashMap<>();

    // 초기 데이터
    public MenuService() {
        map.put("아메리카노", new Menu("아메리카노", 4000, "커피", "기본 커피"));
        map.put("카페라떼",   new Menu("카페라떼",   5000, "커피",   "에스프레소와 스팀 밀크"));
        map.put("그린티라떼", new Menu("그린티라떼", 5500, "논커피", "말차와 스팀 밀크"));
        map.put("초코라떼",   new Menu("초코라떼",   5500, "논커피", "진한 초콜릿과 스팀 밀크"));
    }
    // 메뉴 검색
    public Menu searchMenu(String key){
        return map.get(key);  // 있으면 Menu, 없으면 null
    }

    // 전체 조회
    public void printAllMenu() {
        for (Menu menu : map.values()) { // Map에서 키를 뽑아서 키를 기준으로 반복 순회
            System.out.println(menu); // 키 값으로 엔티티(키, 값) 가져 옴
        }
    }

    // 메뉴 추가
    public void addMenu(String key, int price, String category, String desc) {
        if (map.containsKey(key)) {
            System.out.println(key + " 메뉴가 이미 존재합니다.");
        } else {
            map.put(key, new Menu(key, price, category, desc));
            System.out.println(" 메뉴가 추가되었습니다.");
        }
    }

    // 메뉴 삭제
    public void removeMenu(String key) {
        if (map.containsKey(key)) {
            map.remove(key); // 키를 이용해 엔티티(키, 값) 삭제
            System.out.println(key + " 메뉴가 삭제되었습니다.");
        } else {
            System.out.println(key + " 메뉴를 찾을 수 없습니다.");
        }
    }

    // 메뉴 수정
    public void updateMenu(String key, int newPrice, String newCategory, String newDesc) {
        Menu menu = map.get(key);
        if (menu != null) {
            menu.setPrice(newPrice);
            menu.setCategory(newCategory);
            menu.setDesc(newDesc);
            System.out.println(key + " 메뉴가 수정되었습니다.");
        } else {
            System.out.println(key + " 메뉴를 찾을 수 없습니다.");
        }
    }
}