package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findByName(String name);

}
