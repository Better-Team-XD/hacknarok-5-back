package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.MyUser;

import java.util.UUID;

@Repository
public interface IMyUserRepository extends JpaRepository<MyUser, Long> {
}
