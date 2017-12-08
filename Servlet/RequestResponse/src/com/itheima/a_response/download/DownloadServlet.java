package com.itheima.a_response.download;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. get file mime type
		String fileName = request.getParameter("name");
		ServletContext context = this.getServletContext();
		String mimeType = context.getMimeType(fileName);
		
		//2. config response
		response.setContentType(mimeType);
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		
		//3. get input and output streams
		InputStream input = context.getResourceAsStream("/Download/"+fileName);
		ServletOutputStream output = response.getOutputStream();
		
		//4. copy and paste between two streams
//		int len = -1;
//		byte[] bytes = new byte[1024];
//		while( (len = input.read(bytes)) != -1) {
//			output.write(bytes, 0, len);
//		}
		
		//You can use the apache commons-io-1.4.jar file for simplicity
		IOUtils.copy(input, output);
		output.close();
		input.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
