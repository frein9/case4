package com.gtone.dq.customer.util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
 

public class SysUtil {
 

	/***************************************************************************
	*                                                                           
	*    ��  ��  ��  �� : eCF                                              
	*    ����ý���  �� : ����� �˸�
	*    ��          �� : ���� ���̺귯��            
	*    ��    ��    �� : SysUtil.java
	*    �ۼ���/ �ۼ��� : ȫ�浿/2010.03.05                                    
	*    ��  ��  ��  �� :                                                       
	*        1) �ʱ�����: ȫ�浿/2010.03.08
	*        2) �Լ��߰�:       /
	*
	**************************************************************************/


 

		private static String sep = System.getProperty("line.separator");
		private static Properties properties = new Properties();

		/*****
		 * ȭ���� path ����
	     * ex) $HOME/conf/config.ini ==> /XXX/YYY/conf/config.ini
		 * @@@@param path String
		 * @@@@return ini ȭ���� ��ü ���
		 * @@@@throws Exception
		 */
		public static String getRealPath(String path) throws Exception
		{
			
			int index = path.indexOf("/");
			if (index == -1)
				return path;
			
			String envname = null;
			
			if (path.charAt(0) == '$')
				envname = path.substring(1, index).trim(); 
			else
				if (path.charAt(0) == '%')
					envname = path.substring(1, index - 1).trim(); 	
				else
					return path;
			
			String envvalue = getEnv(envname);
			return envvalue + path.substring(index);
		}

		/*****
		 * �ý��� ȯ�� ���� ����
		 * @@@@param envname String
		 * @@@@return ȭ���� ��ġ ��� 
		 * @@@@throws Exception
		 */
		public static String getEnv(String envname) throws Exception
		{
			String envval = properties.getProperty(envname);
			if (envval != null)
				return envval;

			String osName = System.getProperties().getProperty("os.name");
			Properties p = new Properties();
			Process ps;

			if (osName.equals("Windows NT") || osName.equals("Windows 2000"))
			{
				ps = Runtime.getRuntime().exec("cmd /C echo %" + envname + "%");
				envval = getValue(ps.getInputStream());
			}
			else
				if (osName.startsWith("Win"))
				{
					ps = Runtime.getRuntime().exec("c:/windows/command.com /C echo %" + envname + "%");
					envval = getValue(ps.getInputStream());
				}
				else
				{
					/***** ����ȯ�濡 ���� �������� �޸��� */

					String strCmd = null;
					strCmd = "/usr/bin/env";
									
					ps = Runtime.getRuntime().exec(strCmd);
					Properties props = new Properties();
					props.load(ps.getInputStream());

					envval = System.getProperty(envname);
				}

			if (envval == null)
				return null;

			properties.setProperty(envname, envval);
			return envval;
		}
		
		/*****
		 * ȭ���� �� �پ� Read
		 * @@@@param in InputStream 
		 * @@@@return 
		 * @@@@throws Exception
		 */
		protected static String getValue(InputStream in) throws Exception
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null)
				sb.append(line + sep);

			return sb.toString().trim();
		}
		
		/*****
		 * ���� ��¥�� �������� ���� ����,����� ��¥ ����.
		 * @@@@param yearAmount int,monthAmount int,dayAmount int
		 * @@@@return  ���� ����,����� ��¥
		 * @@@@throws 
		 */
		public static String addDate(int yearAmount, int monthAmount, int dayAmount) {
			Calendar cal = Calendar.getInstance();
	 
			cal.add(Calendar.YEAR, yearAmount);
			cal.add(Calendar.MONTH, monthAmount);
			cal.add(Calendar.DAY_OF_MONTH, dayAmount);
	 
			String year = String.valueOf(cal.get(Calendar.YEAR));
			String mon  = String.valueOf(cal.get(Calendar.MONTH) + 1);
			String day  = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	 
			if (mon.length() == 1) mon = "0" + mon;
			if (day.length() == 1) day = "0" + day;
	 
			String yymmdd = year + mon + day;
			return yymmdd;
		}
		
		/*****
		 * ���ڿ� ��ȯ.(from: �ٲ� ����, to: �ٲ� ����)
		 * @@@@param src String,from String,to String
		 * @@@@return  ���� ����,����� ��¥
		 * @@@@throws 
		 */
		public static String replaceAll(String src, String from, String to) {
			StringBuffer sb = new StringBuffer();
			int start=0;
			int end=0;
			int end2=0;
			while ((end=src.indexOf(from,start))!=-1) {
				sb.append(src.substring(start,end));
				sb.append(to);
				start=end+from.length();
			}
			sb.append(src.substring(start));
			return sb.toString();
		}
		
		/*****
		 * ���� �ð��� format�� ���� String���� ȯ����
		 * @@@@param format String
		 * @@@@return  ���˿� ���� �ٲ� ��¥��
		 * @@@@throws  
		 */
	   public static String getCurrentTime(String format)
	   {
		   try
		   {
			   return new SimpleDateFormat(format).format(new Date());
		   }
		   catch (Exception ex)
		   {
			   System.out.println("*** SysUtil.getCurrentTime() : " + ex.toString());
		   }
		   return null;
	   }

	   /*****
	     * ���� �ð��� yyyyMMddHHmmssSSS �������� String���� ȯ����
	     * @@@@param 
		 * @@@@return  ���� ��¥.
		 * @@@@throws 
		 */
	   public static String getCurrentTime()
	   {
		   return getCurrentTime("yyyyMMddHHmmssSSS");
	   }

	   /*****
	 	* String�߿��� ���ϴ� ���� ����.
	 	* @@@@param str String,outStr String
	 	* @@@@return  ������ String
	 	* @@@@throws  
		*/
	   public static String outStrFormat(String str, String outStr) { //����
		   StringBuffer buf = new StringBuffer();
		   int i;
		   for (i=0;i<str.length();i++) {
			   if (outStr.indexOf(str.charAt(i)) >=  0) buf.append(str.charAt(i));
		   }
		   return buf.toString().trim();
	   }
	

}
