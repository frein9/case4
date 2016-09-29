package com.gtone.dq.customer.util;

/***************************************************************************
*                                                                           
*    시  스  템  명 : eCF                                              
*    서브시스템  명 : 사용자 알림
*    분          류 : Query 문 관리.         
*    문    서    명 : Query.java
*    작성자/ 작성일 : 홍길동/2010.03.05                                    
*    수  정  이  력 :                                                       
*        1) 초기제작: 홍길동/2010.03.08
*        2) 함수추가:       /
*
**************************************************************************/


public class Query 
{
	private String insertQuery = "";	//SQL Query문
	private String deleteQuery = "";	//SQL Query문
	private String selectQuery = "";	//SQL Query문
	
	/*****
	 * Insert Query문 저장.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void selectQuery(String selectQuery){
		this.insertQuery = selectQuery;
	}

	/*****
	 * Insert Query문 저장.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public String getSelectQuery(){
		return this.selectQuery;
	}

	/*****
	 * Insert Query문 저장.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void setInsertQuery(String insertQuery){
		this.insertQuery = insertQuery;
	}
	/*****
	 * Delete Query문 저장.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void setDeleteQuery(String deleteQuery){
		this.deleteQuery = deleteQuery;
	}
	/*****
	 * Insert Query문 환반.
	 * @@@@param 
	 * @@@@return sqlQuery String 
	 * @@@@throws 
	 */
	public String getInsertQuery(){
		return insertQuery;
	}
	/*****
	 * Delete Query문 환반.
	 * @@@@param 
	 * @@@@return sqlQuery String 
	 * @@@@throws 
	 */
	public String getDeleteQuery(){
		return deleteQuery;
	}
}