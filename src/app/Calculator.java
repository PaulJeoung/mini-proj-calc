/* 
 * Author        : pj
 * Class Name    : System.java
 * modified date : 2024-08-29
 * description   : 계산기 전원 ON/OFF
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
		System.out.println(SysMessage.valueOf("SYSTEM_ON"));
		while (power) {
			
			System.out.println(SysMessage.valueOf("BOARD_LINE"));
			System.out.println(SysMessage.valueOf("MENU_SET"));
			
			InputReceiver inputReceiver = new InputReceiver();			
			
			int selectNo = inputReceiver.receiveIntInput("선택 > ");
			
			if (selectNo == MenuSelector.PLUS) {
				System.out.println(selectNo + "번, 덧셈을 하겠습니다. 차례대로 2개의 숫자를 넣으세요");
				double plusA = inputReceiver.receiveDoubleInput("숫자1 > ");
				double plusB = inputReceiver.receiveDoubleInput("숫자2 > ");
				System.out.print(SysMessage.valueOf("CALC_RESULT"));
				System.out.print(FourBasicOperation.plus(plusA, plusB)+"\n");
			} else if (selectNo == MenuSelector.MINUS) {
				System.out.println(selectNo + "번, 뺄셈을 하겠습니다. 차례대로 2개의 숫자를 넣으세요");
				double minusA = inputReceiver.receiveDoubleInput("숫자1 > ");
				double minusB = inputReceiver.receiveDoubleInput("숫자2 > ");
				System.out.print(SysMessage.valueOf("CALC_RESULT"));
				System.out.println(FourBasicOperation.minus(minusA, minusB)+"\n");
			} else if (selectNo == MenuSelector.MULTIPLE) {
				System.out.println(selectNo + "번, 곱셈을 하겠습니다. 차례대로 2개의 숫자를 넣으세요");
				double multipleA = inputReceiver.receiveDoubleInput("숫자1 > ");
				double multipleB = inputReceiver.receiveDoubleInput("숫자2 > ");
				System.out.print(SysMessage.valueOf("CALC_RESULT"));
				System.out.println(FourBasicOperation.multiple(multipleA, multipleB)+"\n");
			} else if (selectNo == MenuSelector.DEVIDE) {
				System.out.println(selectNo + "번, 나눗셈을 하겠습니다. 차례대로 2개의 숫자를 넣으세요");
				double devideA = inputReceiver.receiveDoubleInput("숫자1 > ");
				double devideB = inputReceiver.receiveDoubleInput("숫자2 > ");
				System.out.print(SysMessage.valueOf("CALC_RESULT"));
				System.out.println(FourBasicOperation.divide(devideA, devideB)+"\n");
			} else if (selectNo == MenuSelector.EXIT) {
				System.out.println(SysMessage.valueOf("SYSTEM_OFF"));
				power = false;
			} else {
				System.out.println(SysMessage.valueOf("INVALID_INPUT"));
			}
		}
	}
	
}