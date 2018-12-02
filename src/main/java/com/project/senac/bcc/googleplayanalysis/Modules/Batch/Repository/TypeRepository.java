package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

    Type findByName(String name);

}
