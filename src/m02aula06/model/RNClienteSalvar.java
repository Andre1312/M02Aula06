package m02aula06.model;

import m02aula06.basica.Cliente;
import m02aula06.repository.ConexaoException;
import m02aula06.repository.DAOCliente;
import m02aula06.repository.RepositoryException;

public class RNClienteSalvar {

	public void salvar(Cliente cliente) throws Exception {
		validarDados(cliente);
		verificar(cliente);
		inserir(cliente);
	}

	/**
	 * validar os dados, preenchimento, valores
	 * @param cliente
	 * @throws Exception
	 */
	private void validarDados(Cliente cliente) throws Exception {
		if ((cliente.getNome() == null) || cliente.getNome().isEmpty()) {
			throw new Exception("Nome inválido");
		}
		if ((cliente.getCpf() == null) || cliente.getCpf().isEmpty() || (cliente.getCpf().length()<=11)) {
				
			throw new Exception("CPF inválido (precisa ter 11 digitos!");
		
		}
		if ((cliente.getEmail() == null) || cliente.getEmail().isEmpty()) {
			throw new Exception("E-mail inválido");
		}else if(!cliente.getEmail().contains("@")) {
			throw new Exception("E-mail inválido, não é um endereço válido de e-mail!");
		}
	}

	/**
	 * Verifica se existe duplicidade de cadastro
	 * chama a Persistencia para ver se ja existe o CPF no BD
	 * @param cliente
	 */
	private void verificar(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		try {
			Cliente aux = dao.consulta(cliente);
			if (aux != null) {
				throw new Exception("CPF duplicado");
			}
		} catch (ConexaoException e) {
			throw new Exception(
					"Erro conexão com Banco de dados<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("Erro !!! <br/>" + e.getMessage());
		}
	}

	/**
	 * enviar para o responsavel pela persistencia
	 * @param cliente
	 * @throws Exception
	 */
	private void inserir(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		try {
			dao.inserir(cliente);
		} catch (ConexaoException e) {
			throw new Exception(
					"Erro conexao Banco de dados<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("Erro!!! <br/>" + e.getMessage());
		}

	}
}
