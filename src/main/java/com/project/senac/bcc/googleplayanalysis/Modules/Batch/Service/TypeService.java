package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Type;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class TypeService implements Serializable {
    @Autowired
    private TypeRepository typeRepository;

    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Type saveAndReturn(Type type) {
        return typeRepository.save(type);
    }
}
