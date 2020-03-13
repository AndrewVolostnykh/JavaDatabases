package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repos.UserRepo;

@Service
public class UserService implements UserDetailsService {

    private UserRepo repo;

    @Autowired
    public UserService(UserRepo userRepo)
    {
        this.repo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        return repo.findByEmail(useremail);
    }
}
