/* 
 * Author        : pj
 * Class Name    : System.java
 * modified date : 2024-09-03
 * description   : 계산기 전원 ON/OFF
 * modified      : 로직 수정
 * */
package app;

public class Calculator {
	
	boolean power;
	
	public void setPower(boolean power) {
		this.power = power;
	}
	
	boolean isPower() {
		if (power == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void runSystem () {
		InputReceiver menu = new InputReceiver();
		InputReceiver numbers = new InputReceiver();
		
		System.out.println(SysMessage.valueOf("SYSTEM_ON"));
		double temp = 0, firstNumber = 0, secondNumber = 0;
		
		while (power) {
			
			System.out.println("콘솔계산기 사용 방법\n1.숫자 입력 | 2.연산자 입력 | 3.숫자 입력 | 4.결과 확인  | 5.종료 [q]");
			System.out.println("Enter를 누르면 누적 계산이 됩니다. 초기화 하려면 [c]를 누르세요");
			
			firstNumber = numbers.receiveDoubleInput("숫자 입력> ");
			String selectNo = menu.receiveStringInput("\n연산자 입력 [+][-][*][/] 선택 > ");
			
//			if (selectNo.equals(MenuSelector.EXIT)) {
//				System.out.println(SysMessage.valueOf("SYSTEM_OFF"));
//				power = false;
//			}
			
			if (temp == 0) {
				secondNumber = numbers.receiveDoubleInput("숫자입력 > ");
			} else {
				secondNumber = temp;
			}
			
			if (selectNo.equals(MenuSelector.PLUS)) {
				double result = FourBasicOperation.plus(secondNumber, firstNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + secondNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.MINUS)) {
				double result = FourBasicOperation.minus(secondNumber, firstNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + secondNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.MULTIPLY)) {
				double result = FourBasicOperation.multiply(secondNumber, firstNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + secondNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.DEVIDE)) {
				double result = FourBasicOperation.divide(firstNumber, secondNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + secondNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else {
				System.out.println(SysMessage.valueOf("INVALID_INPUT"));
			}
		}
	}
	
	public double tempClear(double temp) {
		InputReceiver clear = new InputReceiver();
		String selectNo =  clear.receiveStringInput("초기화 하시겠습니까? c");
		temp = (selectNo.equals(MenuSelector.CLEAR)) ? 0 : temp;
		return temp;
	}
}