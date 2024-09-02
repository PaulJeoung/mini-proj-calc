/* 
 * Author        : pj
 * Class Name    : Calc_Runner.java
 * modified date : 2024-09-01
 * description   : 계산기 실행 메인 함수
 * */
package app;

public class Calc_Runner {
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		calculator.setPower(true);
		calculator.runSystem();

	}

}
