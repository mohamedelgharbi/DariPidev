package tn.esprit.spring.config;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitializeServiceData implements ApplicationRunner
{
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Users user = userRepository.findByEmail("hama.gharbi.95@gmail.com");
        if(user==null)
        {
            user = new Users();
            user.setEmail("hama.gharbi.95@gmail.com");
            user.setPassword(passwordEncoder.encode("123"));
            user.setRoles(Role.USER);
            user.setNom("test");
            userRepository.save(user);
            Users user1=new Users();
            user1.setEmail("hedi@gmail.com");
            user1.setPassword(passwordEncoder.encode("azerty"));
            user1.setRoles(Role.ADMINISTRATEUR);
            user1.setNom("test");
            userRepository.save(user1);
        }

    }
}