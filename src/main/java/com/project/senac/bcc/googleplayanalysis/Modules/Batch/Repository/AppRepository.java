package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends CrudRepository<App, Long> {

    App findByName(String name);

}
