package co.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.ufps.beans.Candidato;
import co.ufps.beans.Eleccion;
import co.ufps.dao.CandidatoDao;
import co.ufps.dao.CandidatoJPA;
import co.ufps.dao.EleccionDao;
import co.ufps.dao.EleccionJPA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServices
 */
@WebServlet("/")
public class IndexServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CandidatoDao candidatoDao;
	EleccionDao eleccionDao;
    /**
     * Default constructor. 
     */
    public IndexServices() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.candidatoDao = new CandidatoJPA();
		this.eleccionDao = new EleccionJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch(action){
			case "/inscripcionCandidato":
				showInscripcionCandidato(request,response);
				break;
			case "/insertarCandidato":
				insertarCandidato(request,response);
				break;
			default:
				showInscripcionCandidato(request,response);
				break;
			}
		}catch(SQLException e)
		{
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showInscripcionCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Eleccion> elecciones = eleccionDao.selectAll();
		request.setAttribute("elecciones", elecciones);
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/inscripcionCandidatos.jsp");
		dispatcher.forward(request, response); 
	}
	
	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException, IOException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Candidato c = new Candidato(documento,nombre,apellido);
		this.candidatoDao.insert(c);
		response.sendRedirect("inscripcionCandidato");
	}

}
