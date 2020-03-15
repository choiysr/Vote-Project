package org.kakarrot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.domain.MemberVO;

/**
 * Servlet Filter implementation class admin
 */
@WebFilter("/vote/build.sr")
public class admin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		MemberVO member = (MemberVO) req.getSession().getAttribute("member");
		String path = "";

		// 로그인 창으로 이동
		if (member == null) {
			res.sendRedirect("/member/login.sr");
			return;
		}
		else {
			String admin = member.getAdmin();
			if (admin.equals("Y")) {
				chain.doFilter(request, response);
				return;
			}
		}
		System.out.println(req.getHeader("Referer"));
		res.sendRedirect(req.getHeader("Referer"));
	}

}
