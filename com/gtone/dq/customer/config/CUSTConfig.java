package com.gtone.dq.customer.config;
import java.io.FileInputStream;
import java.util.Properties;

import com.gtone.dq.customer.util.Constants;
import com.gtone.dq.customer.util.SysUtil;
 

public class CUSTConfig {

 
		private static Properties almprop;

		public CUSTConfig()
		{
		}

		/*****
		 * ini 화일이 저장된 위치의 화일을 읽어 변수명,값을 읽어 들인다. 
		 * @@@@param 
		 * @@@@return 
		 * @@@@throws Exception
		 */
		public synchronized static void initConfig() throws Exception
		{
			try
			{
				almprop = new Properties();
				almprop.load(new FileInputStream(SysUtil.getRealPath(Constants.ALARM_PROPERTIES)));
			}
			catch (Exception ex)
			{
				throw ex;
			}
		}
		
		/*****
		 * ini 화일에 저장된 변수명을 받아서 변수 값이 있으면 변수값을 없으면 기본 값을 환반. 
		 * @@@@param paramName String
		 * @@@@return ini 화일에 저장된 환경 변수의 내용  
		 * @@@@throws Exception
		 */
		public synchronized static String getConfig(String paramName, String defaultValue) throws Exception
		{
			if (almprop == null)
				initConfig();
			String paramValue = almprop.getProperty(paramName);
			if (paramValue == null)
				return defaultValue;
			return paramValue;
		}
		
		/*****
		 * ini 화일에 저장된 변수명을 받아서 변수 값 환반.
		 * @@@@param paramName String
		 * @@@@return ini 화일에 저장된 환경 변수값.  
		 * @@@@throws Exception
		 */
		public synchronized static String getConfig(String paramName) throws Exception
		{
			if (almprop == null)
				initConfig();
			return almprop.getProperty(paramName);
			
		}
 
}
