package m02aula06.model;

import m02aula06.basica.Cliente;
import m02aula06.repository.ConexaoException;
import m02aula06.repository.DAOCliente;
import m02aula06.repository.RepositoryException;

public class RNClienteExcluir {

	public void excluir(Cliente cliente) throws Exception {
		
		exclude(cliente);
	}
	
	private void exclude(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consulta(cliente);
			if (aux == null) {
				throw new Exception("Cliente não existe");
			}else {
				dao.excluir(cliente);
			}
		} catch (ConexaoException e) {
			throw new Exception(
					"Erro conexão com Banco de dados<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("Erro !!! <br/>" + e.getMessage());
		}
		
	}
	
	
}
