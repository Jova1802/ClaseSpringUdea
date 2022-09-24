package com.co.udea.mintic.UdeaDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositoryPersona extends JpaRepository <EntityPersona, Long>, JpaSpecificationExecutor<EntityPersona> {
}
