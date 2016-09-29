package com.gtone.dq.customer.server;

/***************************************************************************
*                                                                           
*    시  스  템  명 : eCF                                              
*    서브시스템  명 : 사용자 알림
*    분          류 : CTW Web Mail 로그 eCF Update           
*    문    서    명 : ALMAIL00020Q.java
*    작성자/ 작성일 : 홍길동/2010.03.05                                    
*    수  정  이  력 :                                                       
*        1) 초기제작: 홍길동/2010.03.08
*        2) 함수추가:       /
*
**************************************************************************/


import java.sql.Connection;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.gtone.dq.customer.config.CUSTConfig;
import com.gtone.dq.customer.query.SQLQuery;
import com.gtone.dq.customer.util.CustomerDetail;
import com.gtone.dq.customer.util.CustomerMaster;

 

public class CustomerDetailRun extends Thread
{
	public  Connection  conn  = null;
	private static Logger logger = Logger.getLogger(CustomerDetailRun.class);

	public CustomerDetailRun() { //추가자
	}
	
	/*
	 * @@@@param  
	 * @@@@return 
	 * @@@@throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		int errCheck 		= 0;
		int sendDelayTime	= 0;	//실행 주기
		sendDelayTime	= Integer.parseInt(CUSTConfig.getConfig("sendDelayTime"));
		
		logger.info("######Customer Master START######");
		CustomerDetailRun masterrun = new CustomerDetailRun();
		CustomerDetail data;
		SQLQuery 	sqlQuery= new SQLQuery();
		Vector 		detail  = new Vector();
		
		try { 
			detail 	= sqlQuery.CustomerDetailSelect();
				
				for(int i=0; i < detail.size(); i++){
					data= (CustomerDetail)detail.get(i);
					logger.info(data.toString());
				}
			
		}catch (Exception e){
			logger.error("######main Exception######"+e);
		}	
		logger.info("######Customer Master START   END######");
	}
}


