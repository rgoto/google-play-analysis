package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Genry;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository.GenryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class GenryService implements Serializable {

    @Autowired
    private GenryRepository genryRepository;

    public Genry findByName(String name) {
        return genryRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Genry saveAndReturn(Genry genry) {
        return genryRepository.save(genry);
    }

}
