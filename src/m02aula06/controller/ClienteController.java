package m02aula06.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m02aula06.basica.Cliente;
import m02aula06.model.RNClienteExcluir;
import m02aula06.model.RNClienteListar;
import m02aula06.model.RNClienteSalvar;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at GET: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Salvar os dados no DB
		if(request.getParameter("action").equals("salvar")) {
			Cliente cliente = new Cliente();
			cliente.setNome(request.getParameter("nome"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setDataNascimento(request.getParameter("dataNasc"));
			cliente.setSexo(request.getParameter("sexo"));
			cliente.setNomeSocial(request.getParameter("nomeSocial"));
			cliente.setApelido(request.getParameter("apelido"));
			cliente.setTelefone(request.getParameter("telefone"));

			try {
				//Salva os dados
				RNClienteSalvar rnSalva = new RNClienteSalvar();
				rnSalva.salvar(cliente);

				//Pego a lista de clientes para exibir na sa�da
				RNClienteListar rnLista = new RNClienteListar();
				ArrayList<Cliente> lista = (ArrayList<Cliente>)rnLista.listar();
				request.setAttribute("clientes", lista);

				//Redireciona a saida
				RequestDispatcher view = request.getRequestDispatcher("lista_clientes.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}

		//Excluir os dados no DB
		if((request.getParameter("excluir")!=null) && (request.getParameter("excluir").equals("1")) && (request.getParameter("id")!=null)) {
			
			Cliente cliente = null;
			

				try {
					
					//Pesquisa CLiente com ID
					RNClienteListar rnLista = new RNClienteListar();
					ArrayList<Cliente> lista = (ArrayList<Cliente>)rnLista.listar();
					
					for (Cliente aux : lista) {
						if ((""+aux.getId()).equals(request.getParameter("id"))) {
							cliente = aux;
							break;
						}
					}
										
					//Exclue os dados
					RNClienteExcluir rnExclude = new RNClienteExcluir();
					rnExclude.excluir(cliente);

					//Pega lista de clientes para exibir na saida

					request.setAttribute("clientes", lista);

					//Redireciona a saida
					RequestDispatcher view = request.getRequestDispatcher("lista_clientes.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					response.getWriter().append("Erro: " + e.getMessage());
				}
			}

		}	
	

}
