package pl.teamxd.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.repository.IMyUserRepository;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MockData {
    private final IMyUserRepository userRepository;

    @PostConstruct
    public void generate(){
        userRepository.save(new MyUser());
    }
}
