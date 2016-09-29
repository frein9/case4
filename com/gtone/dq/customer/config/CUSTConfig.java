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
		 * ini ȭ���� ����� ��ġ�� ȭ���� �о� ������,���� �о� ���δ�. 
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
		 * ini ȭ�Ͽ� ����� �������� �޾Ƽ� ���� ���� ������ �������� ������ �⺻ ���� ȯ��. 
		 * @@@@param paramName String
		 * @@@@return ini ȭ�Ͽ� ����� ȯ�� ������ ����  
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
		 * ini ȭ�Ͽ� ����� �������� �޾Ƽ� ���� �� ȯ��.
		 * @@@@param paramName String
		 * @@@@return ini ȭ�Ͽ� ����� ȯ�� ������.  
		 * @@@@throws Exception
		 */
		public synchronized static String getConfig(String paramName) throws Exception
		{
			if (almprop == null)
				initConfig();
			return almprop.getProperty(paramName);
			
		}
 
}
