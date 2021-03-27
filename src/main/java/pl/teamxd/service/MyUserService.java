package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.repository.IMyUserRepository;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final IMyUserRepository myUserRepository;
}
