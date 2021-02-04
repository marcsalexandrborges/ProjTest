package proj;

import java.io.IOException;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction ut;
	
    @PersistenceContext    
    private EntityManager em;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto p = new Produto();
		p.setDescricao("mochila");
		p.setPreco(80.0);
		
		
		
	try {
		
		ut.begin();
		em.persist(p);
		ut.commit();
		
	}  catch (Exception e) {
		throw new ServletException(e);
	}
		
		
		
		
		response.getWriter().append("Produto criado com ID" + p.getId()).close();
	}

}
