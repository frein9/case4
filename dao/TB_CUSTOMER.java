package dao;

import java.sql.*;
import java.util.*;

public class TB_CUSTOMER {

	public boolean getData()
	{
		DAO cp = new DAO();
		boolean result = false;
		
		
		String query = " select * ";
		query += "from TB_CUSTOMER10 a, TB_CUSTOMER20 b where a.CUST_ID = b.CUST_ID ";

		  Connection con = null;
		  Statement stmt = null;
		  ResultSet rs = null;

		  try{
		   con = cp.getConnection();
		   stmt = con.createStatement();
		   rs = stmt.executeQuery(query);

		   result = rs.next();

		  } catch(Exception e) {
		   e.printStackTrace();
		  } finally {
		   try{
		    rs.close();
		    stmt.close();
		   } catch(Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return result;

		}
	public boolean getData2()
	{
		DAO cp = new DAO();
		boolean result = false;
		
		
		String query = "select CODE_ID, LAST_CHMN_MPNO, LAST_CHNG_DTTM, PGM_ID, CODE_NAME, CODE_OUNM, CODE_TYPE, CODE_GRNT_STDD, RELN_CD1, RELN_CD2, INER_STDD_CODE, EXPL_1, EXPL_2, EXPL_3, EXPL_4, EXPL_5, EXPL_6, FRST_RGST_MPNO, STRT_DATE, END_DATE, LAST_CHNG_CHCD, LAST_CHMN_DPCD, DEL_DATE, DOMN_YN  ";
		query += "from TB_CUSTOMER10 ";

		  Connection con = null;
		  Statement stmt = null;
		  ResultSet rs = null;

		  try{
		   con = cp.getConnection();
		   stmt = con.createStatement();
		   rs = stmt.executeQuery(query);

		   result = rs.next();

		  } catch(Exception e) {
		   e.printStackTrace();
		  } finally {
		   try{
		    rs.close();
		    stmt.close();
		   } catch(Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return result;

		}		


public int insertData()
	{
		DAO cp = new DAO();
		int result = -1;
		
		
		String query = "INSERT INTO CUST_ID, LAST_CHMN_MPNO, LAST_CHNG_DTTM, PGM_ID  ";
		query += "VALUE('1', '1', '1', '1', '1') ";
		query += "from TB_CUSTOMER10 ";

		  Connection con = null;
		  Statement stmt = null;
		  ResultSet rs = null;

		  try{
		   con = cp.getConnection();
		   stmt = con.createStatement();
		   result = stmt.executeUpdate(query);

		   

		  } catch(Exception e) {
		   e.printStackTrace();
		  } finally {
		   try{
		    rs.close();
		    stmt.close();
		   } catch(Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return result;

		}	

	public int updateData()
	{
		DAO cp = new DAO();
		int result = -1;
		
		
		String query = "UPDATE TB_CUSTOMER10 SET LAST_CHMN_MPNO = '1', LAST_CHNG_DTTM = '1', PGM_ID = '1'  WHERE CUST_ID = '1' ";


		  Connection con = null;
		  Statement stmt = null;
		  ResultSet rs = null;

		  try{
		   con = cp.getConnection();
		   stmt = con.createStatement();
		   result = stmt.executeUpdate(query);

		   

		  } catch(Exception e) {
		   e.printStackTrace();
		  } finally {
		   try{
		    rs.close();
		    stmt.close();
		   } catch(Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return result;

		}	


	public int deleteData()
	{
		DAO cp = new DAO();
		int result = -1;
		
		
		String query = "DELETE FROM TB_CUSTOMER20 WHERE CUST_ID = '1' ";


		  Connection con = null;
		  Statement stmt = null;
		  ResultSet rs = null;

		  try{
		   con = cp.getConnection();
		   stmt = con.createStatement();
		   result = stmt.executeUpdate(query);

		   

		  } catch(Exception e) {
		   e.printStackTrace();
		  } finally {
		   try{
		    rs.close();
		    stmt.close();
		   } catch(Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return result;

		}
}
