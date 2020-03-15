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
 * Servlet Filter implementation class waiting
 */
@WebFilter("/123123")
public class waiting implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		MemberVO member = (MemberVO) req.getSession().getAttribute("member");
		String path = req.getRequestURI();
		System.out.println(path);
		if(path.equals("/vote/waiting.sr")) {
			chain.doFilter(request, response);
			return;
		}
		if(member!=null) {
			if(path.equals("/member/login.sr")) {
				res.sendRedirect("/member/myPage.sr");
				return;
			}
			if (member.isWaiting() == false) {
				res.sendRedirect("/vote/waiting.sr");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}


}
