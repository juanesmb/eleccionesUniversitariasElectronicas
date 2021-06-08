package co.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import co.ufps.beans.Candidato;
import co.ufps.beans.Eleccion;
import co.ufps.beans.Estamento;
import co.ufps.beans.TipoDocumento;
import co.ufps.beans.Votante;
import co.ufps.beans.Voto;
import co.ufps.dao.CandidatoDao;
import co.ufps.dao.EleccionDao;
import co.ufps.dao.EstamentoDao;
import co.ufps.dao.TipoDocumentoDao;
import co.ufps.dao.VotanteDao;
import co.ufps.dao.VotoDao;
import co.ufps.entities.CandidatoEntity;
import co.ufps.entities.EleccionEntity;
import co.ufps.entities.EstamentoEntity;
import co.ufps.entities.TipoDocumentoEntity;
import co.ufps.entities.VotanteEntity;
import co.ufps.entities.VotoEntity;
import co.ufps.jpa.CandidatoJPA;
import co.ufps.jpa.EleccionJPA;
import co.ufps.jpa.EstamentoJPA;
import co.ufps.jpa.TipoDocumentoJPA;
import co.ufps.jpa.VotanteJPA;
import co.ufps.jpa.VotoJPA;
import co.ufps.util.ServicioEmail;
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
	VotanteDao votanteDao;
	TipoDocumentoDao tipoDocumentoDao;
	EstamentoDao estamentoDao;
	VotoDao votoDao;
	String host = "http://localhost:8080/";
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
		this.tipoDocumentoDao = new TipoDocumentoJPA();
		this.votanteDao = new VotanteJPA();
		this.estamentoDao = new EstamentoJPA();
		this.votoDao = new VotoJPA();
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
			case "/inscripcionVotante":
				showInscripcionVotante(request,response);
				break;
			case "/insertarVotante":
				insertarVotante(request,response);
				break;
			case "/formularioValidacion":
				showValidarVotante(request,response);
				break;
			case "/validarVotante":
				validarVotante(request,response);
				break;
			case "/elegirCandidato":
				showCandidatos(request,response);
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
		String eleccionId = request.getParameter("eleccionId");
		Integer eleccion = Integer.valueOf(eleccionId);
		Candidato c = new Candidato(documento,nombre,apellido,eleccion);
		this.candidatoDao.insert(c);
		response.sendRedirect("inscripcionCandidato");
	}
	
	private void showInscripcionVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TipoDocumento> tipodocumentos = tipoDocumentoDao.selectAll();
		request.setAttribute("tipodocumentos",tipodocumentos);
		
		List<Eleccion> elecciones = eleccionDao.selectAll();
		request.setAttribute("elecciones", elecciones);
		
		List<Estamento> estamentos = estamentoDao.selectEleccion(3);
		request.setAttribute("estamentos", estamentos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/inscripcionVotante.jsp");
		dispatcher.forward(request, response); 
	}
	
	private void insertarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		VotanteEntity v = new VotanteEntity(nombre,email,documento);

		String eleccionId = request.getParameter("eleccionId");
		EleccionEntity e = this.eleccionDao.select(Integer.valueOf(eleccionId));
		
		String tipoDocumentoId = request.getParameter("tipoDocumentoId");
		TipoDocumentoEntity t = this.tipoDocumentoDao.select(Integer.valueOf(tipoDocumentoId));
		
		String estamendoId = request.getParameter("estamentoId");
		int idEstamento = Integer.parseInt(estamendoId);
		EstamentoEntity estamento = this.estamentoDao.select(idEstamento);
		
		v.setEleccion(e);
		v.setTipodocumento(t);
		this.votanteDao.insert(v);
		
		v = this.votanteDao.select(documento);
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
   
		ServicioEmail servicioEmail = new ServicioEmail("ejemplo.email.ufps@gmail.com", "nfrbdxklxggkgoko");
		//http://localhost:8080/eleccionesUniversitariasElectronicas/formularioValidacion?
		String link = host + request.getContextPath() + "/" +  "formularioValidacion" + "?nombre=" + nombre + "&email=" + 
		email + "&id=" + v.getId() + "&eleccionCargo=" + e.getCargo() + "&fechaInicio=" + e.getFechaInicio().toString() + "&fechaFin=" + 
	    e.getFechaFin().toString() + "&estamentoId=" + estamento.getId().intValue() +"&estamento=" + estamento.getDescripcion();
		
		System.out.println(link);
		
		servicioEmail.enviarEmail(email, e.getNombre(), "link para la validar y escoger su voto: " + link);
		
		response.sendRedirect("inscripcionVotante");
		
	}
	
	private void showValidarVotante(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		Votante v = new Votante(id,nombre,email);
		
		String eleccionCargo = request.getParameter("eleccionCargo");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		Eleccion e = new Eleccion(eleccionCargo,fechaInicio,fechaFin);
		
		Integer estamentoId = Integer.parseInt(request.getParameter("estamentoId"));
		String estamentoDescripcion = request.getParameter("estamento");
		Estamento est = new Estamento(estamentoId, estamentoDescripcion);
		
		List<TipoDocumento> tipoDocumentos = tipoDocumentoDao.selectAll();
		
		request.setAttribute("tipoDocumentos",tipoDocumentos);
		request.setAttribute("votante", v);
		request.setAttribute("eleccion", e);
		request.setAttribute("estamento", est);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/validacionVoto.jsp");
		dispatcher.forward(request, response);
	}

	private void validarVotante(HttpServletRequest request, HttpServletResponse response)  throws ServletException, SQLException, IOException
	{
		Integer id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		Integer tipoDocumento = Integer.parseInt(request.getParameter("documentoId"));
		VotanteEntity v = this.votanteDao.select(id);
		
		Integer estamentoId = Integer.parseInt(request.getParameter("estamentoId"));
		String estamentoDescripcion = request.getParameter("estamentoDescripcion");
		Estamento est = new Estamento(estamentoId, estamentoDescripcion);
		
		String eleccionCargo = request.getParameter("eleccionCargo");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		Eleccion e = new Eleccion(eleccionCargo,fechaInicio,fechaFin);
		
		List<Candidato> candidatos = this.candidatoDao.selectAll();
		
		
		if(v.getDocumento().equals(documento) && v.getTipodocumento().getId().intValue()==tipoDocumento.intValue())
		{
			request.setAttribute("votante", v);
			request.setAttribute("estamento", est);
			request.setAttribute("eleccion", e);
			request.setAttribute("candidatos", candidatos);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/elegirCandidato.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("datosErroneos", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/validacionVoto.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void showCandidatos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
				/*List<Estamento> estamentos = estamentoDao.selectAll();
				request.setAttribute("estamentos",estamentos);
				
				List<Candidato> candidatos = candidatoDao.selectAll();
				request.setAttribute("candidatos", candidatos);
				
				String votanteId = request.getParameter("votanteId");
				VotanteEntity t = this.votanteDao.select(Integer.valueOf(votanteId));*/
		
		// TODO Auto-generated method stub
				String estamentoId = request.getParameter("estamentoId");
				EstamentoEntity e = this.estamentoDao.select(Integer.valueOf(estamentoId));
				
				String candidatoId = request.getParameter("candidatoId");
				CandidatoEntity c = this.candidatoDao.select(Integer.valueOf(candidatoId));
				
				String votanteId = request.getParameter("votanteId");
				VotanteEntity t = this.votanteDao.select(Integer.valueOf(votanteId));
				
				String uuid = request.getParameter("uuid");
				String enlace = request.getParameter("enlace");
				Timestamp creacion = Timestamp.valueOf(request.getParameter("fechacreacion"));
				Timestamp voto = Timestamp.valueOf(request.getParameter("fechacreacion"));
				VotoEntity v = new VotoEntity(creacion,voto,uuid,enlace);
				
				v.setEstamento(e);
				v.setVotante(t);
				v.setCandidato(c);
				this.votoDao.insert(v);
				
				//response.sendRedirect("inscripcionVotante");
	}
}
