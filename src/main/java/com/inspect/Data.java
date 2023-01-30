package com.inspect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.*;

/**
 * Servlet implementation class Data
 */
@WebServlet("/data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServletHttpServlet()
	 */
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServletdoGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServletdoPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String end = "------------------------------------------------------------------------------------------";
		String prefix = "-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- End Of ";
		String suffix = " -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<html><head><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + "<script\r\n"
				+ "	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "<script\r\n"
				+ "	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
				+ "<script\r\n"
				+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n" + "\r\n"
				+ "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css\"\r\n"
				+ "	integrity=\"sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==\"\r\n"
				+ "	crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />" + "<style>" + "body {\r\n"
				+ "	background-image:url(\"https://images.unsplash.com/photo-1454165205744-3b78555e5572?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80\");\r\n"
				+ "	background-repeat: no-repeat;\r\n" + "	background-size: cover;\r\n" + "	text-align: center;\r\n"
//				+ "	margin-top: 15vw;\r\n"
				+ "\r\n" + "	color: white;\r\n" + "}" + "span{\r\n" + "border: 1px solid black;\r\n" + "}" + "div{"
				+ "}" + "</style>"

				+ "</head>" + "<body style=\"text-align:center;\" >");

		try {
			Class C = Class.forName(name);

			out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "<h2>");
			out.print("METHODS DETAILS" + "<br>");
			out.print("</h2></div>");
			Method[] m = C.getDeclaredMethods();
			if (m.length == 0)
				out.print("0 Methods" + "<br>" + end + "<br>");
			else {
				for (int i = 0; i < m.length; i++) {
					Method method = m[i];

					out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "Method Name:- "
							+ method.getName() + "<br>");
					out.print("Declared Class :- " + method.getDeclaringClass() + "<br>");
					Class p[] = method.getParameterTypes();
					for (int j = 0; j < p.length; j++) {
						out.print("Parameters :- " + p[j].getName() + "<br>");
					}
					out.print("Return Type :- " + method.getReturnType() + "<br>");
					int mm = method.getModifiers();
					out.print("Modifiers :- " + Modifier.toString(mm) + "</div>");
					out.print("<br>" + end + "<br><br>");
				}
			}
			out.print(prefix+"Method"+suffix+"<br>");
			out.print(end + "<br>");

			out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "<h2><br>");
			out.print("ATTRIBUTES DETAILS" + "<br>");
			out.print("</h2>" + "</div>");

			Field[] f = C.getDeclaredFields();
			if (f.length == 0)
				out.print("Doesn't have any Attribute" + "<br>" + end + "<br>");
			else {
				for (int i = 0; i < f.length; i++) {
					Field field = f[i];
					out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "Fields Name:- "
							+ field.getName() + "<br>");
					out.print("Declared Class :- " + field.getDeclaringClass() + "<br>");
					out.print("DataType:- " + field.getType() + "</div><br>");
					out.print(end + "<br><br>");
				}
			}
			out.print(prefix+"Attributes"+suffix+"<br>");

			out.print(end + "<br>");

			out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "<h2>" + "" + "<br>");
			out.print("CONSTRUCTORS DETAILS" + "<br>");
			out.print("</div>" + "</h2>");
			Constructor[] constructors = C.getDeclaredConstructors();
			for (Constructor cons : constructors) {
				out.print("Constructor Name: " + cons.getName() + "<br>");
				int modifier = cons.getModifiers();
				String mod = Modifier.toString(modifier);
				out.print("Modifier: " + mod + "<br>");
				out.print("Parameters: " + cons.getParameterCount() + "<br>");
				Class p[] = cons.getParameterTypes();
				if (p.length == 0) {
					out.print("0 Parametarised Constructor " + "<br>" + end + "<br>");
				} else {
					for (int j = 0; j < p.length; j++) {
						out.print("Parameters :- " + p[j].getName() + "<br>");
					}
					out.print(end + "<br>");
				}
			}
			out.print(prefix+"Contructors"+suffix+"<br>");
			out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">" + "<h2>" + "" + "<br>");
			out.print("INSTANCE DETAILS" + "<br>");
			out.print("</div>" + "</h2>");

			try {
				Object O = instanceCreation(name);
				out.print(end + "<br>");
				out.print("<div class=\"container text-center shadow p-3 mb-5 bg-body rounded\">");
				if (O != null) {
					out.print("Hash Code :- " + O.hashCode() + "<br>");
					out.print("ToString :- " + O.toString() + "<br>");
				} else {
					out.print("Unable to Instance" + "<br>");
				}
				out.print("</div>");
				out.print(end + "<br>");
			} catch (Exception E) {
			}
			out.print(prefix+"Instance"+suffix+"<br>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</body></html>");

	}

	public static Object instanceCreation(String s) throws ClassNotFoundException {
		try {
			return Class.forName(s).newInstance();
		} catch (Exception E) {
		}
		return null;
	}

}
