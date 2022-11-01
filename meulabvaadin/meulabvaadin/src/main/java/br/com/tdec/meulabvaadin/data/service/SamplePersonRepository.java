package br.com.tdec.meulabvaadin.data.service;

import br.com.tdec.meulabvaadin.data.entity.SamplePerson;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, UUID> {

}