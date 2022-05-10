package com.javaex.phonebook;

import java.util.*;
import java.io.*;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> pList = new ArrayList<>();

		Reader fr = new FileReader("./src/PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
				
		while (true) {
			String info = br.readLine();
			
			if (info == null) {
				break;
			}
			
			String[] person = info.split(",");
			pList.add(new Person(person[0], person[1], person[2]));
		}
		
		System.out.println("********************************************");
		System.out.println("*             전화번호 관리 프로그램              *");
		System.out.println("********************************************");
		
		boolean flag = true;
		
		while (flag) {
			System.out.println();
			System.out.println("1. 리스트    2.등록    3.삭제    4.검색    5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("> 메뉴번호: ");
			
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					System.out.println("<1. 리스트>");
					printAll(pList);
					break;
					
				case 2:
					System.out.println("<2. 등록>");
					
					System.out.print("> 이름: ");
					String name = sc.next();
					System.out.print("> 휴대전화: ");
					String hp = sc.next();					
					System.out.print("> 회사전화: ");
					String company = sc.next();					
				
					pList.add(new Person(name, hp, company));
					break;
					
				case 3:
					System.out.println("<3. 삭제>");
					System.out.print("> 번호: ");
					int no = sc.nextInt();
					
					pList.remove(no-1);
					break;
					
				case 4:
					System.out.println("<4. 검색>");
					System.out.print("> 이름: ");
					String search = sc.next();	
					
					for (int i = 0; i < pList.size(); i++) {
						Person curr = pList.get(i);
						
						if (curr.getName().contains(search)) {
							print(pList, i);
						}
					}
					break;
					
				case 5:
					flag = false;
					break;
					
				default:
					System.out.println("[다시 입력해 주세요.]");
										
			}
		}
		System.out.println();
		System.out.println("********************************************");
		System.out.println("*                 감사합니다                  *");
		System.out.println("********************************************");
		
		br.close();
		sc.close();
	}
	
	public static void printAll(ArrayList<Person> p) {
		for (int i = 0; i < p.size(); i++) {
			Person curr = p.get(i);
			System.out.println(i+1 + "    " + curr.getName() + "    " + curr.getHp() + "    " + curr.getCompany());
		}
	}
	
	public static void print(ArrayList<Person> p, int i) {
		    Person curr = p.get(i);
			System.out.println(i+1 + "    " + curr.getName() + "    " + curr.getHp() + "    " + curr.getCompany());
		
	}

}
