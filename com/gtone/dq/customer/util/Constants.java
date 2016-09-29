package com.gtone.dq.customer.util;
 
 

/***************************************************************************
*                                                                           
*    시  스  템  명 : eCF                                              
*    서브시스템  명 : 사용자 알림
*    분          류 : Ini File 관리.           
*    문    서    명 : Constants.java
*    작성자/ 작성일 : 홍길동/2010.03.05                                    
*    수  정  이  력 :                                                       
*        1) 초기제작: 홍길동/2010.03.08
*        2) 함수추가:       /
*
**************************************************************************/


public final class Constants {
	//Configuration Files
	public static String ALARM_PROPERTIES = "";
	
	static {
		/***** 개발환경에 따라 설정값을 달리함 */

		String strUri = null;
				
		ALARM_PROPERTIES = "c:\\CUST_test.ini";
	}	
}
