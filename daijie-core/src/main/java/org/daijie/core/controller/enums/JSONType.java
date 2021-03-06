package org.daijie.core.controller.enums;

import org.apache.commons.lang.StringUtils;

public enum JSONType {
	/**JSONObject*/  
	JSON_TYPE_OBJECT,  
	/**JSONArray*/  
	JSON_TYPE_ARRAY,  
	/**不是JSON格式的字符串*/  
	JSON_TYPE_ERROR;

	/*** 
	 * 
	 * 获取JSON类型 
	 *         判断规则 
	 *             判断第一个字母是否为{或[ 如果都不是则不是一个JSON格式的文本 
	 * 
	 * @param str 
	 * @return 
	 */  
	public static JSONType getJSONType(String str){  
		if(StringUtils.isEmpty(str)){  
			return JSONType.JSON_TYPE_ERROR;  
		}  

		final char[] strChar = str.substring(0, 1).toCharArray();  
		final char firstChar = strChar[0];  


		if(firstChar == '{'){  
			return JSONType.JSON_TYPE_OBJECT;  
		}else if(firstChar == '['){  
			return JSONType.JSON_TYPE_ARRAY;  
		}else{  
			return JSONType.JSON_TYPE_ERROR;  
		}  
	} 

} 