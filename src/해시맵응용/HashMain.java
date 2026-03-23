package 해시맵응용;

// Map: Key와 Value의 쌍으로 이루어진 데이터를 저장하는 자료 구조
// Key는 중복될 수 없고 Value는 중복 가능
// HashMap은 순서를 보장하지 않음

// Hash 함수: 임의의 길이 데이터를 고정된 길이로 매핑하는 함수
// 해시코드: 자바에서는 객체의 메모리 주소값을 바탕으로 생성된 정수 값
// 해시 충돌(Collision): 서로 다른 키가 동일한 해시코드를 갖는 경우, 버킷 내에 여러 노드가 생기며 성능 저하의 원인이 됨

//[1]전체 조회 [2]메뉴 검색 [3]메뉴 추가 [4]메뉴 삭제 [5]메뉴 수정 [6]종료
// 1. Menu 클래스
// 2. MenuService
// 3. HashMain UI

import java.util.Scanner;

public class HashMain {

    private static final MenuService service = new MenuService();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {  // ★ 반복문 추가 - 6번 선택 시 종료
            System.out.println();
            System.out.print("[1]전체 조회 [2]메뉴 검색 [3]메뉴 추가 [4]메뉴 삭제 [5]메뉴 수정 [6]종료 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ===== [1] 전체 조회 =====
                case 1:
                    service.printAllMenu();
                    break;

                // ===== [2] 메뉴 검색 =====
                case 2:
                    System.out.print("검색할 메뉴 이름 입력: ");
                    String searchName = sc.nextLine();
                    Menu found = service.searchMenu(searchName);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println(searchName + " 메뉴를 찾을 수 없습니다.");
                    }
                    break;

                // ===== [3] 메뉴 추가 =====
                case 3:
                    System.out.print("메뉴 이름 입력: ");
                    String addName = sc.nextLine();
                    if (service.searchMenu(addName) != null) {
                        System.out.println("이미 존재하는 메뉴입니다.");
                        break;
                    }
                    System.out.print("가격 입력: ");
                    int addPrice = Integer.parseInt(sc.nextLine());
                    System.out.print("카테고리 입력: ");
                    String addCategory = sc.nextLine();
                    System.out.print("설명 입력: ");
                    String addDesc = sc.nextLine();
                    service.addMenu(addName, addPrice, addCategory, addDesc);
                    break;

                // ===== [4] 메뉴 삭제 =====
                case 4:
                    System.out.print("삭제할 메뉴 이름 입력: ");
                    String delName = sc.nextLine();
                    service.removeMenu(delName);
                    break;

                // ===== [5] 메뉴 수정 =====
                case 5:
                    System.out.print("수정할 메뉴 이름 입력: ");
                    String updateName = sc.nextLine();
                    if (service.searchMenu(updateName) == null) {
                        System.out.println(updateName + " 메뉴를 찾을 수 없습니다.");
                        break;
                    }
                    System.out.println("현재 정보: " + service.searchMenu(updateName));
                    System.out.print("새 가격 입력: ");
                    int newPrice = Integer.parseInt(sc.nextLine());
                    System.out.print("새 카테고리 입력: ");
                    String newCategory = sc.nextLine();
                    System.out.print("새 설명 입력: ");
                    String newDesc = sc.nextLine();
                    service.updateMenu(updateName, newPrice, newCategory, newDesc);
                    break;

                // ===== [6] 종료 =====
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;  // main 메서드 종료 → 프로그램 종료

                default:
                    System.out.println("1~6 사이의 숫자를 입력해주세요.");
            }
        }
    }
}