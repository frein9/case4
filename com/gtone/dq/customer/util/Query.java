package com.gtone.dq.customer.util;

/***************************************************************************
*                                                                           
*    ��  ��  ��  �� : eCF                                              
*    ����ý���  �� : ����� �˸�
*    ��          �� : Query �� ����.         
*    ��    ��    �� : Query.java
*    �ۼ���/ �ۼ��� : ȫ�浿/2010.03.05                                    
*    ��  ��  ��  �� :                                                       
*        1) �ʱ�����: ȫ�浿/2010.03.08
*        2) �Լ��߰�:       /
*
**************************************************************************/


public class Query 
{
	private String insertQuery = "";	//SQL Query��
	private String deleteQuery = "";	//SQL Query��
	private String selectQuery = "";	//SQL Query��
	
	/*****
	 * Insert Query�� ����.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void selectQuery(String selectQuery){
		this.insertQuery = selectQuery;
	}

	/*****
	 * Insert Query�� ����.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public String getSelectQuery(){
		return this.selectQuery;
	}

	/*****
	 * Insert Query�� ����.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void setInsertQuery(String insertQuery){
		this.insertQuery = insertQuery;
	}
	/*****
	 * Delete Query�� ����.
	 * @@@@param newSqlQuery String
	 * @@@@return 
	 * @@@@throws 
	 */
	public void setDeleteQuery(String deleteQuery){
		this.deleteQuery = deleteQuery;
	}
	/*****
	 * Insert Query�� ȯ��.
	 * @@@@param 
	 * @@@@return sqlQuery String 
	 * @@@@throws 
	 */
	public String getInsertQuery(){
		return insertQuery;
	}
	/*****
	 * Delete Query�� ȯ��.
	 * @@@@param 
	 * @@@@return sqlQuery String 
	 * @@@@throws 
	 */
	public String getDeleteQuery(){
		return deleteQuery;
	}
}