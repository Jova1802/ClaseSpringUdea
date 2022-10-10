package com.co.udea.mintic.UdeaDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPersona extends JpaRepository <EntityPersona, Long>{

    EntityPersona findByDoc(String doc);

}
