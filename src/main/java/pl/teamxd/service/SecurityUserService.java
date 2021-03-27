package pl.teamxd.service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.teamxd.model.security.MyUserDetails;
import pl.teamxd.repository.IMyUserRepository;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {
    private final IMyUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(repository.findMyUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username + " not found")
        ));
    }
}
