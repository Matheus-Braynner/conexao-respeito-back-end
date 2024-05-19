package br.com.grupoconexao.msinvolved.repositories;

import br.com.grupoconexao.msinvolved.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByRegistration(String registration);

    Optional<Teacher> findByEmail(String email);

    Optional<Teacher> findByCpf(String involvedCpf);
}
