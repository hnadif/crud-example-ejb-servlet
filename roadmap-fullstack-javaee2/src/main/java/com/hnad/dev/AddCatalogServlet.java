package com.hnad.dev;

import java.io.IOException;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedin.CatalogEJBLocal;
import com.linkedin.CatalogItem;

/**
 * Servlet implementation class AddCatalogServlet
 */
@WebServlet("/AddCatalogServlet")
public class AddCatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CatalogEJBLocal catalogBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCatalogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("addCatalog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String manufacturer = request.getParameter("manufacturer");
		String availableDate = request.getParameter("availableDate");

		CatalogItem catalogeItem = new CatalogItem(name, manufacturer, description, LocalDate.parse(availableDate));
		this.catalogBean.addItem(catalogeItem);
		request.getRequestDispatcher("RoadServlet").forward(request, response);
	}

}
