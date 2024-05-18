package br.com.grupoconexao.msinvolved.repositories;

import br.com.grupoconexao.msinvolved.entities.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {

    Responsible findFirstByStudentRegistration(String registration);
}
