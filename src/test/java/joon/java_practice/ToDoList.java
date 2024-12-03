package joon.java_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Boolean> ToDoMap = new HashMap<>();


        while (true) {
            displayMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("할 일을 입력하세요: ");
                String task = scanner.nextLine();
                // 할 일 추가 구현
                tasks.add(task);
                ToDoMap.put(task, false);
                System.out.println("추가 완료");
            }
            // 여기에 나머지 메뉴 선택에 대한 처리를 완성하세요
            //할 일 목록 보기
            if (choice == 2) {
                if (ToDoMap.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    System.out.println("할 일 목록");
                    String check = "";
                    for (int i = 1; i <= ToDoMap.size(); i++) {
                        check = ToDoMap.get(tasks.get(i - 1)) ? "√" : " ";
                        System.out.println("[" + check + "] " + i + "번 " + tasks.get(i - 1));
                    }
                }
            }
            //할 일 삭제
            if (choice == 3) {
                if (ToDoMap.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    System.out.println("할 일 목록");
                    String check = "";
                    for (int i = 1; i <= ToDoMap.size(); i++) {
                        check = ToDoMap.get(tasks.get(i - 1)) ? "√" : " ";
                        System.out.println("[" + check + "] " + i + "번 " + tasks.get(i - 1));
                    }


                    System.out.print("삭제할 번호를 입력하세요 : ");

                    int deleteNumber = Integer.parseInt(scanner.nextLine());

                    if (deleteNumber > tasks.size()) {
                        System.out.println("잘못된 번호입니다.");
                    }

                    System.out.println(tasks.get(deleteNumber - 1) + "가 삭제되었습니다");
                    ToDoMap.remove(tasks.get(deleteNumber - 1));
                    tasks.remove(deleteNumber - 1);
                }

            }
            //할 일 완료/미완료 처리
            if (choice == 4) {
                if (ToDoMap.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    System.out.println("할 일 목록");
                    String check = "";
                    for (int i = 1; i <= ToDoMap.size(); i++) {
                        check = ToDoMap.get(tasks.get(i - 1)) ? "√" : " ";
                        System.out.println("[" + check + "] " + i + "번 " + tasks.get(i - 1));
                    }
                    System.out.print("완료/미완료 처리할 번호를 입력하세요 : ");

                    int checkNumber = Integer.parseInt(scanner.nextLine());

                    if (ToDoMap.get(tasks.get(checkNumber - 1))) {
                        ToDoMap.put(tasks.get(checkNumber - 1), false);
                    } else {
                        ToDoMap.put(tasks.get(checkNumber - 1), true);
                    }
                    System.out.println(tasks.get(checkNumber - 1) + "가 완료되었습니다.");
                }
            }
            //완료된 할 일만 보기
            if (choice == 5) {
                if (ToDoMap.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    System.out.println("할 일 목록");
                    String check = "";
                    for (int i = 1; i <= ToDoMap.size(); i++) {
                        if (ToDoMap.get(tasks.get(i - 1))) {
                            check = ToDoMap.get(tasks.get(i - 1)) ? "√" : " ";
                            System.out.println("[" + check + "] " + i + "번 " + tasks.get(i - 1));
                        }
                    }
                }
            }
            //미완료만 보기
            if (choice == 6) {
                if (ToDoMap.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    System.out.println("할 일 목록");
                    String check = "";
                    for (int i = 1; i <= ToDoMap.size(); i++) {
                        if (!ToDoMap.get(tasks.get(i - 1))) {
                            check = ToDoMap.get(tasks.get(i - 1)) ? "√" : " ";
                            System.out.println("[" + check + "] " + i + "번 " + tasks.get(i - 1));
                        }
                    }
                }
            }
            //종료
            if (choice == 7) {
                System.out.println("To-do List를 종료합니다");
                break;
            }
        }
    }

    // 메뉴를 출력하는 메소드
    public static void displayMenu() {
        System.out.println();
        System.out.println("=== 할 일 관리 프로그램 ===");
        System.out.println("1. 할 일 추가");
        System.out.println("2. 할 일 목록 보기");
        System.out.println("3. 할 일 삭제");
        System.out.println("4. 할 일 완료/미완료 처리");
        System.out.println("5. 완료된 일 보기");
        System.out.println("6. 미완료된 일 보기");
        System.out.println("7. 종료");
        System.out.println();
        System.out.print("메뉴를 선택하세요: ");
    }

}