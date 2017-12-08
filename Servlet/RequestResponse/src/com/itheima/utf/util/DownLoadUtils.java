package com.itheima.utf.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class DownLoadUtils {
	public static String getName(String agent, String filename) throws UnsupportedEncodingException {
		if (agent.contains("MSIE")) {
			// IE Browser
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// Firefox browser
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// Other browsers
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}
