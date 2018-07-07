/** 
 * @FileName: DateJsonValueProcessor.java 
 * @Description: TODO(Json����ʱ���ʽת����) 
 * @Copyright: Copyright(C) 2010-2015 All rights Reserved 
 * @Company: ShenZhen  Information Technology Co.,LTD. 
 * @author: neil 
 * @version V1.0  
 * @Createdate: 2015-11-3 
 * 
 * Modification  History: 
 * Date         Author        Version        Discription 
 * ----------------------------------------------------------------------------------- 
 * 2015-11-3       NEIL          1.0             1.0 
 * Why & What is modified: <�޸�ԭ������> 
 */  
package com.gupiao.web.tools;  
  
//import java.security.Timestamp;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
  
import net.sf.json.JsonConfig;  
import net.sf.json.processors.JsonValueProcessor;  
  
public class DateJsonValueProcessor implements JsonValueProcessor {  
   
  
    public static final String Default_DATE_PATTERN = "yyyy-MM-dd";  
    private DateFormat dateFormat;  
  
    public DateJsonValueProcessor(String datePattern) {  
        try {  
            dateFormat = new SimpleDateFormat(datePattern);  
        } catch (Exception e) {  
            dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);  
        }  
    }  
  
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {  
        // TODO Auto-generated method stub  
        return process(value);  
    }  
  
    public Object processObjectValue(String key, Object value,  
            JsonConfig jsonConfig) {  
        // TODO Auto-generated method stub  
        return process(value);  
    }  
  
    private Object process(Object value) {  
        if (value == null) {  
            return "";  
        } else {  
            return dateFormat.format((java.sql.Timestamp) value);  
        }  
    }  
  
}  