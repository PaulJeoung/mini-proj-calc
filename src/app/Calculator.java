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
		System.out.println("콘솔계산기 사용 방법\n1.숫자 입력 | 2.연산자 입력 | 3.숫자 입력 | 4.결과 확인  | 5.종료 [q]");
		System.out.println("Enter를 누르면 누적 계산이 됩니다. 초기화 하려면 [c]를 누르세요");
		double temp = 0, firstNumber = 0, nextNumber = 0;
		
		while (power) {
			
			firstNumber = numbers.receiveDoubleInput("숫자 입력> ");
			String selectNo = menu.receiveStringInput("연산자 입력 [+][-][*][/][q] > ");
			
			if (temp == 0) {
				nextNumber = numbers.receiveDoubleInput("숫자입력 > ");
			} else { // 덧셈, 곱셈은 상관 X, 뺄셈, 나눗셈은 temp 가 첫번째로 이동
				if (selectNo.equals(MenuSelector.MINUS) || selectNo.equals(MenuSelector.DEVIDE)) {
					nextNumber = firstNumber;
					firstNumber = temp;
				} else {
					nextNumber = temp;
				}
			}
			
			if (selectNo.equals(MenuSelector.PLUS)) {
				double result = FourBasicOperation.plus(firstNumber, nextNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + nextNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.MINUS)) {
				double result = FourBasicOperation.minus(firstNumber, nextNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + nextNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.MULTIPLY)) {
				double result = FourBasicOperation.multiply(firstNumber, nextNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + nextNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			} else if (selectNo.equals(MenuSelector.DEVIDE)) {
				double result = FourBasicOperation.divide(firstNumber, nextNumber);
				System.out.println("계산 : "+ firstNumber + " " + selectNo + " " + nextNumber + " = " + result);
				temp = result;
				temp = tempClear(temp);
			 } else if (selectNo.equals(MenuSelector.EXIT)) {
				 System.out.println(SysMessage.valueOf("SYSTEM_OFF"));
				 power = false;
			} else {
				System.out.println(SysMessage.valueOf("INVALID_INPUT"));
			}
		}
	}
	
	public double tempClear(double temp) {
		InputReceiver clear = new InputReceiver();
		String selectNo =  clear.receiveStringInput("초기화 [c], 계속 [enterKey] \n");
		temp = (selectNo.equals(MenuSelector.CLEAR)) ? 0 : temp;
		return temp;
	}
}