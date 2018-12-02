package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Genry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenryRepository extends CrudRepository<Genry, Integer> {

    Genry findByName(String name);

}
