package br.com.casadocodigo.loja.repository;

import br.com.casadocodigo.loja.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para acesso aos dados da entidade {@link SystemUser}
 *
 * @author Tiarê Balbi Bonamini
 * @version 1.0.0
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {

    SystemUser findOneByLogin(String login);

}