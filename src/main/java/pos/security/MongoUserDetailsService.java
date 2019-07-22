package pos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pos.user.AppUser;
import pos.user.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByUserName(userName);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("AppUser not found");
        }
        List<SimpleGrantedAuthority> autorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(user.get().getUserName(), user.get().getPassword(), autorities);
    }
}
