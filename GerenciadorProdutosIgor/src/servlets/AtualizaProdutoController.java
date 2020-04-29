package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;




@WebServlet("/atualizaProduto.do")
public class AtualizaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoService produtoService = new ProdutoService(); 
       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoService produtoService = new ProdutoService(); 
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Produto produto = produtoService.consultarProduto(codigo);
				
				
				response.setContentType("text/html");
				
				
				PrintWriter out = response.getWriter();
				
				out.println("<form action='atualizaProduto.do' method='post'>");
				out.println("<table>");
				out.println("Código: " + produto.getCodigo());
				out.println("<tr><td></td><td><input type=\"hidden\" name='codigo' value='"
								+ produto.getCodigo() + "'/></td></tr>");
				out.println("<tr><td>Nome:</td><td>");
				out.println("<input type='text' name='nome' value='" 
								+ produto.getNome() + "'/></td></tr>");
				out.println("<tr><td>Descricao:</td><td>");
				out.println("<input type='text' name='descricao' value='" 
								+ produto.getDescricao() + "'/></td></tr>");
				out.println("<tr><td>Valor:</td><td>");
				out.println("<input type='text' name='valor' value='"
								+ produto.getValor() + "'/></td></tr> ");
				out.println("<tr><td>Estoque:</td><td>");
				out.println("<input type='text' name='estoque' value='"
								+ produto.getEstoque() + "'/></td></tr>");
				out.println("<tr><td colspan='2'><input type=\"submit\" value=\"Atualizar Produto\"/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				
			
	}
	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
				
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));		
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
		
		produtoService.atualizarProduto(produto);
				
	            
		response.sendRedirect("listaProdutos.do");
	            
	       
		
		
		
	}
	

}
