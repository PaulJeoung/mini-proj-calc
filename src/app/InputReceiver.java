/* 
 * Author        : pj
 * Class Name    : InputReceiver.java
 * modified date : 2024-09-01
 * description   : 입력값 처리
 * */
package app;

import java.util.Scanner;

public class InputReceiver {
	private Scanner scanner; // 스캐너 필드 선언
	
	public InputReceiver() { // 생성자 선언
		this.scanner = new Scanner(System.in);
	}
	
	// 문자열 입력 받기
	public String receiveStringInput(String prompt) { 
		System.out.println(prompt);
		return scanner.nextLine();
	}
	
	// 정수 입력 받기 (미사용)
	public int receiveIntInput(String prompt) {
		System.out.println(prompt);
		while (!scanner.hasNextInt()) {
			System.out.println(SysMessage.valueOf("INVALID_INPUT_INT"));
			scanner.next(); // 잘못된 입력을 버림
			System.out.println(prompt);
		}
		return scanner.nextInt();
	}
	
	// 실수 입력 받기
	public double receiveDoubleInput(String prompt) {
		System.out.println(prompt);
		while(!scanner.hasNextDouble()) {
			System.out.println(SysMessage.valueOf("INVALID_INPUT_DOUBLE"));
			scanner.next();
			System.out.println(prompt);
		}
		return scanner.nextDouble();
	}
	
	// 스캐너 메소드 닫기
	public void close() {
		scanner.close();
	}
}
