package com.gtone.dq.customer.server;

/***************************************************************************
*                                                                           
*    시  스  템  명 : eCF                                              
*    서브시스템  명 : 사용자 알림
*    분          류 : 알림 메일 CTW Web Mail 송신.          
*    문    서    명 : ALMAIL00010Q.java
*    작성자/ 작성일 : 홍길동/2010.03.05                                    
*    수  정  이  력 :                                                       
*        1) 초기제작: 홍길동/2010.03.05
*        2) 함수추가:       /
*
**************************************************************************/
import java.sql.Connection;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.gtone.dq.customer.config.CUSTConfig;
import com.gtone.dq.customer.query.SQLQuery;
import com.gtone.dq.customer.util.CustomerMaster;

public class CustomerMasterRun extends Thread
{
	public  Connection  conn  = null;
	private static Logger logger = Logger.getLogger(CustomerMasterRun.class);

	public CustomerMasterRun() { //추가자
	}

	/*****
 
	 * @@@@param  
	 * @@@@return 
	 * @@@@throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		logger.info("######Customer Master START######");
		CustomerMasterRun masterrun = new CustomerMasterRun();
		CustomerMaster data;
		SQLQuery 	sqlQuery= new SQLQuery();
		Vector 		master 	= new Vector();
 
		
		try { 
				master 	= sqlQuery.CustomerMasterSelect();
				
				for(int i=0; i < master.size(); i++){
					data= (CustomerMaster)master.get(i);
					logger.info(data.toString());
				}
			
		}catch (Exception e){
			logger.error("######main Exception######"+e);
		}	
		logger.info("######Customer Master START   END######");
	}
}


