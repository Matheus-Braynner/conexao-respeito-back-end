package br.com.grupoconexao.msinvolved.repositories;

import br.com.grupoconexao.msinvolved.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRegistration(String register);
}
