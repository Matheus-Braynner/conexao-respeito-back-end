package br.com.grupoconexao.mscontent.repositories;

import br.com.grupoconexao.mscontent.entities.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
}
