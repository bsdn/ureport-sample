package com.bstek.ureport.sample.controller;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class UReportSampleController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String reportFile = req.getParameter("rp");
		if (StringUtils.isEmpty(reportFile)) {
			throw new RuntimeException("reportFile path can not be null!");
		}
		InputStream in = UReportSampleController.class.getResourceAsStream("/"
				+ reportFile+".ureport.xml");
		BufferedInputStream bin = new BufferedInputStream(in);
		ServletOutputStream out = res.getOutputStream();
		try {
			IOUtils.copy(bin, out);
		} finally {
			IOUtils.closeQuietly(in);
		}
		out.flush();
		out.close();
		return null;
	}

}
