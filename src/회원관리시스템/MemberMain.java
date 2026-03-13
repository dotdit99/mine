package 회원관리시스템;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> mainMenu = new ArrayList<>();
        while (true) {
            System.out.println("[1]회원가입  [2]로그인  [3]전체회원조회  [4]회원삭제  [5]총 회원수  [6]종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1:
                    System.out.println("===== 회원가입 =====");
                    System.out.print("이름을 입력하세요: ");
                    String name = sc.nextLine();
                    System.out.print("아이디를 입력하세요: ");
                    String userId = sc.nextLine();
                    boolean isDuplicate = false;
                    for (Member m : mainMenu){
                        if (m.getUserId().equals(userId)){
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate){
                        System.out.println("이미 사용중인 아이디입니다.");
                        break;
                    }
                    System.out.print("비밀번호를 입력하세요: ");
                    String password = sc.nextLine();
                    System.out.print("나이를 입력하세요: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    mainMenu.add(new Member(name, userId, password, age));
                    System.out.println(name + "님의 가입이 완료되었습니다.");
                    break;
                case 2:
                    System.out.println("===== 로그인 =====");
                    System.out.print("아이디 입력: ");
                    String inputId = sc.nextLine();

                    Member foundMember = null;

                    for (Member m : mainMenu) {
                        if (m.getUserId().equals(inputId)) {
                            foundMember = m;
                            break;
                        }
                    }

                    if (foundMember == null) {
                        System.out.println("❌ 존재하지 않는 아이디입니다.");
                    } else {
                        System.out.print("비밀번호 입력: ");
                        String inputPw = sc.nextLine();

                        if (foundMember.login(inputId, inputPw)) {
                            System.out.println("🔓 로그인 성공! " + foundMember.name + "님 환영합니다.");
                            while (true){
                                System.out.println("[1]내 정보보기  [2]정보수정  [3]비밀번호 변경  [4]로그아웃");
                                System.out.print("메뉴 선택: ");
                                int subMenu = sc.nextInt();
                                sc.nextLine();
                                switch (subMenu) {
                                    case 1:
                                        foundMember.printInfo();
                                        break;
                                    case 2:
                                        System.out.print("이름 입력 (현재: " + foundMember.name + ") :" );
                                        String newName = sc.nextLine();
                                        if (!newName.isBlank()) foundMember.name = newName;
                                        System.out.print("나이 입력 (현재: " + foundMember.age + ") :" );
                                        foundMember.age = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("✅ 정보가 수정되었습니다.");
                                        break;
                                    case 3:
                                        System.out.print("현재 비밀번호 입력: ");
                                        String currentPw = sc.nextLine();

                                        if (!currentPw.equals(inputPw)) {
                                            System.out.println("❌ 현재 비밀번호가 일치하지 않습니다.");
                                            break;
                                        }

                                        System.out.print("새 비밀번호 입력: ");
                                        String newPw = sc.nextLine();

                                        System.out.print("새 비밀번호 확인: ");
                                        String newPwCheck = sc.nextLine();

                                        if (!newPw.equals(newPwCheck)) {
                                            System.out.println("❌ 새 비밀번호가 일치하지 않습니다.");
                                            break;
                                        }

                                        foundMember.changePassword(currentPw, newPw);
                                        inputPw = newPw;
                                        System.out.println("✅ 비밀번호가 변경되었습니다.");
                                        break;
                                    case 4:
                                        System.out.println("👋 " + foundMember.name + "님 로그아웃 되었습니다.");
                                        break;
                                    default:
                                        System.out.println("올바른 번호를 입력하세요.");
                                }

                                if (subMenu == 4) break;

                            }

                        } else {
                            System.out.println("🔒 비밀번호가 일치하지 않습니다.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("===== 전체 회원 조회 =====");
                    if (mainMenu.isEmpty()) {
                        System.out.println("등록된 회원이 없습니다.");
                    } else {
                        for (Member m : mainMenu) {
                            m.printInfo();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("===== 회원 삭제 =====");
                    System.out.print("삭제할 아이디 입력: ");
                    String deleteId = sc.nextLine();

                    Member deleteMember = null;
                    for (Member m : mainMenu) {
                        if (m.getUserId().equals(deleteId)) {
                            deleteMember = m;
                            break;
                        }
                    }

                    if (deleteMember == null) {
                        System.out.println("존재하지 않는 아이디입니다.");
                    } else {
                        System.out.print("정말 삭제하시겠습니까? [y/n]: ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("y")) {
                            mainMenu.remove(deleteMember);
                            Member.decreaseTotalCount();  // totalCount 감소
                            System.out.println("✅ " + deleteMember.name + "님의 계정이 삭제되었습니다.");
                        } else {
                            System.out.println("삭제가 취소되었습니다.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("===== 총 회원 수 =====");
                    System.out.println("총 회원 수: " + Member.getTotalCount() + "명");
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }
}