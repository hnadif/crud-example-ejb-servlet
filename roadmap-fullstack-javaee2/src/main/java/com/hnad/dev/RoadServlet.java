package com.hnad.dev;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedin.CatalogEJBLocal;
import com.linkedin.CatalogItem;

/**
 * Servlet implementation class RoadServlet
 */
@WebServlet(urlPatterns = "/")
public class RoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CatalogEJBLocal catalogBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		System.out.println("Action " + action);

		switch (action) {
		case "/removeItem":
			this.remove(request, response);
			break;
		case "/detailItem":
			this.detail(request, response);
			break;
		case "/editItem":
			this.update(request, response);
			break;
		case "/updateItem":
			this.updateItem(request, response);
			break;
		case "/searchItems":
			this.search(request, response);
			break;
		default:
			// Set all Catalog items
			request.setAttribute("catalogItems", this.catalogBean.getItems());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idItem = Long.parseLong(request.getParameter("idItem"));

		// Remove CatalogItem by id passed from user
		this.catalogBean.removeItem(idItem);
		request.setAttribute("catalogItems", this.catalogBean.getItems());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idItem = Long.parseLong(request.getParameter("idItem"));

		// Remove CatalogItem by id passed from user
		CatalogItem catalog = this.catalogBean.findCatalog(idItem);

		request.setAttribute("showEditForm", true);
		request.setAttribute("catalogItemData", catalog);
		request.setAttribute("catalogItems", this.catalogBean.getItems());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("idItem"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String manufacturer = request.getParameter("manufacturer");
		String availableDate = request.getParameter("availableDate");

		CatalogItem catalogeItem = new CatalogItem(name, manufacturer, description, LocalDate.parse(availableDate));
		catalogeItem.setItemId(id);
		this.catalogBean.updateItem(catalogeItem);
		request.setAttribute("showEditForm", false);
		request.setAttribute("catalogItems", this.catalogBean.getItems());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idItem = Long.parseLong(request.getParameter("idItem"));

		// Remove CatalogItem by id passed from user
		CatalogItem catalog = this.catalogBean.findCatalog(idItem);

		request.setAttribute("catalogItemData", catalog);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Method search");
		String searchKeyword = request.getParameter("searchKeyword");

		System.out.println("Value keyword " + searchKeyword);

		List<CatalogItem> items = this.catalogBean.searchItems(searchKeyword);
		System.out.println("Items size " + items.size());
		request.setAttribute("showEditForm", false);
		request.setAttribute("catalogItems", items);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
