package com.itheima.b_request.param;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeUtil {

	public static void main(String[] args) throws Exception {
		System.out.println("======Below is how URL request makes Chinese not readable");
		System.out.println("First encode the chinese request using utf-8, but tomcat will translate using iso8859-1");
		String chinese = "中文";
		String encodeChinese = URLEncoder.encode(chinese, "utf-8");
		String decodeChinese = URLDecoder.decode(encodeChinese, "iso8859-1");
		System.out.println("original is: " + chinese);
		System.out.println("After utf-8 is: " + encodeChinese);
		System.out.println("After utf-8 then iso8859-1 is: " + decodeChinese);
		
		System.out.println("======Below is how to revert this and make it work");
		System.out.println("First read the content of iso8859-1, then use utf-8 to make it a string");
		byte[] b = decodeChinese.getBytes( "iso8859-1");
		String result = new String(b, "utf-8");
		System.out.println("First revert iso8859-1, then revert utf-8 is: " + result);
	}

}
