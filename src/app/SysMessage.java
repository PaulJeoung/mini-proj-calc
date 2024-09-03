/* 
 * Author        : pj
 * Class Name    : FourBasicOperation.java
 * modified date : 2024-09-01
 * description   : 계산기의 연산을 처리
 * modified      : 메시지 삭제
 * */
package app;

public enum SysMessage {
	INVALID_INPUT("ERROR_01", "유효하지 않은 입력값 입니다"),
	INCORRECT_RESULT("ERROR_02", "잘못된 계산 결과 입니다"),
	INVALID_INPUT_INT("ERROR_11", "입력값은 INT 형이 아닙니다"),
	INVALID_INPUT_DOUBLE("ERROR_12", "입력값은 DOUBLE 형이 아닙니다"),
	INVALID_INPUT_STRING("ERROR_13", "입력값은 STRING 형이 아닙니다"),
	
	SYSTEM_ON("MSG_000", "전원을 켭니다"),
	SYSTEM_OFF("MSG_001", "전원을 끕니다"),
	SYSTEM_OPERATING("MSG_002", "전원이 켜져 있습니다"),
	
	CALC_RESULT("MSG_100", "결과 : "),
	MENU_SELECT("MSG_103", "선택 > "),
	INPUT_VALUE_1("MSG_104", "1번째 숫자 > "),
	INPUT_VALUE_2("MSG_105", "2번째 숫자 > "),
	EXIT("MSG_999", "EXIT");
	
	private final String code;
	private final String message;
	
	private SysMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s", code, message);
	}
	
}
