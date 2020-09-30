package m02aula06.model;

import m02aula06.basica.Cliente;
import m02aula06.repository.ConexaoException;
import m02aula06.repository.DAOCliente;
import m02aula06.repository.RepositoryException;

public class RNClienteAlterar{

	public void	altere(Cliente cliente) throws Exception {
		
		mudarDados(cliente);
		
	}

	private void mudarDados(Cliente cliente) throws Exception {
		
		DAOCliente dao = new DAOCliente();
		try {
			dao.alterar(cliente);
		} catch (ConexaoException e) {
			throw new Exception(
					"Erro conexao Banco de dados<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("Erro ao ALTERAR!!! <br/>" + e.getMessage());
		}

		
		
		
	}
	
	
}
