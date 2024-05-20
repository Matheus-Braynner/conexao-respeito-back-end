package br.com.grupoconexao.mscontent.repositories;

import br.com.grupoconexao.mscontent.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesRepository extends JpaRepository<Activity, Long> {
}
