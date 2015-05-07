package br.com.casadocodigo.loja.conf.security;

import br.com.casadocodigo.loja.models.SystemUser;
import br.com.casadocodigo.loja.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Configuração do {@link UserDetailsService}
 *
 * @author Tiarê Balbi Bonamini
 * @version 1.0.0
 */
@Component
public class LojaUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        SystemUser user = this.systemUserRepository.findOneByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("O usuario " + username + " não existe");
        }

        return user;
    }
}
