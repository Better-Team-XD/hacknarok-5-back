package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.entity.MyUser;

import java.util.Optional;

@Repository
public interface IMyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findMyUserByEmail(String email);
}
