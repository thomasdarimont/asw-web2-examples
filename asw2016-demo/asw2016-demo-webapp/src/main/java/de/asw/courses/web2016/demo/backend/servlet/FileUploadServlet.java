package de.asw.courses.web2016.demo.backend.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/upload", //
		initParams = @WebInitParam(name = "location", value = "/tmp") //
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Part filePart = req.getPart("file");

		String uploadLocation = getInitParameter("location");

		File file = new File(uploadLocation, filePart.getSubmittedFileName());
		try (//
				ReadableByteChannel in = Channels.newChannel(filePart.getInputStream()); //
				FileOutputStream out = new FileOutputStream(file)//
		) {
			out.getChannel().transferFrom(in, 0, filePart.getSize());
		}

		resp.getWriter().println("Upload completed: " + file.getAbsolutePath());
	}
}