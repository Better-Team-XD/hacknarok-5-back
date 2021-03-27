package pl.teamxd.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.repository.IUserRepository;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MockData {
    private final IUserRepository userRepository;

    @PostConstruct
    public void generate(){
        userRepository.save(new MyUser());
    }
}
