package org.kakarrot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.annotation.RequestMapping;

@WebServlet("*.sr")
public class FrontController extends HttpServlet {

	private static final Map<String, String> controller;

	static {
		controller = new HashMap<>();
		controller.put("member", "org.kakarrot.controller.MemberController");
		controller.put("vote", "org.kakarrot.controller.VoteController");
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		action(request, response);
	}

	private void action(HttpServletRequest request, HttpServletResponse response) {
		
		
		String path = request.getRequestURI();
		String type = request.getMethod();

		String key = path.split("/")[1];
		try {
			request.setCharacterEncoding("UTF-8");
			
			Class<?> clz = Class.forName(controller.get(key));

			Method[] methods = clz.getDeclaredMethods();

			String result = "";

			for (Method m : methods) {
				RequestMapping r = m.getDeclaredAnnotation(RequestMapping.class);
				if (path.equals(r.value()) && type.equals(r.type())) {
					result = (String) m.invoke(clz.newInstance(), request, response);
					break;
				}
			}
			if (result.startsWith("redirect:"))
				response.sendRedirect(result.substring(10));
			else
				request.getRequestDispatcher("/WEB-INF/views" + result + ".jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
