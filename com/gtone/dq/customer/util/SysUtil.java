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
	*    시  스  템  명 : eCF                                              
	*    서브시스템  명 : 사용자 알림
	*    분          류 : 공통 라이브러리            
	*    문    서    명 : SysUtil.java
	*    작성자/ 작성일 : 홍길동/2010.03.05                                    
	*    수  정  이  력 :                                                       
	*        1) 초기제작: 홍길동/2010.03.08
	*        2) 함수추가:       /
	*
	**************************************************************************/


 

		private static String sep = System.getProperty("line.separator");
		private static Properties properties = new Properties();

		/*****
		 * 화일의 path 설정
	     * ex) $HOME/conf/config.ini ==> /XXX/YYY/conf/config.ini
		 * @@@@param path String
		 * @@@@return ini 화일의 전체 경로
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
		 * 시스템 환경 변수 설정
		 * @@@@param envname String
		 * @@@@return 화일의 위치 경로 
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
					/***** 개발환경에 따라 설정값을 달리함 */

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
		 * 화일을 한 줄씩 Read
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
		 * 현재 날짜를 기준으로 전후 몇일,몇개월의 날짜 구함.
		 * @@@@param yearAmount int,monthAmount int,dayAmount int
		 * @@@@return  전후 몇일,몇개월의 날짜
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
		 * 문자열 변환.(from: 바뀔 문자, to: 바뀔 문자)
		 * @@@@param src String,from String,to String
		 * @@@@return  전후 몇일,몇개월의 날짜
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
		 * 현재 시간을 format에 따라 String으로 환반함
		 * @@@@param format String
		 * @@@@return  포맷에 따라 바뀐 날짜형
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
	     * 현재 시간을 yyyyMMddHHmmssSSS 형식으로 String으로 환반함
	     * @@@@param 
		 * @@@@return  현재 날짜.
		 * @@@@throws 
		 */
	   public static String getCurrentTime()
	   {
		   return getCurrentTime("yyyyMMddHHmmssSSS");
	   }

	   /*****
	 	* String중에서 원하는 문자 제거.
	 	* @@@@param str String,outStr String
	 	* @@@@return  제거한 String
	 	* @@@@throws  
		*/
	   public static String outStrFormat(String str, String outStr) { //문자
		   StringBuffer buf = new StringBuffer();
		   int i;
		   for (i=0;i<str.length();i++) {
			   if (outStr.indexOf(str.charAt(i)) >=  0) buf.append(str.charAt(i));
		   }
		   return buf.toString().trim();
	   }
	

}
