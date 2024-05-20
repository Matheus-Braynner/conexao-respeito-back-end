package br.com.grupoconexao.msinvolved.repositories;

import br.com.grupoconexao.msinvolved.entities.Complaint;
import br.com.grupoconexao.msinvolved.entities.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
