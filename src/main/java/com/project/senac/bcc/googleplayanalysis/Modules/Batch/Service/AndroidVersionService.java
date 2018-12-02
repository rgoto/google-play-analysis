package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.AndroidVersion;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository.AndroidVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class AndroidVersionService implements Serializable {

    @Autowired
    private AndroidVersionRepository androidVersionRepository;

    public AndroidVersion findByName(String name) {
        return androidVersionRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AndroidVersion saveAndReturn(AndroidVersion androidVersion) {
        return androidVersionRepository.save(androidVersion);
    }

    public Iterable<AndroidVersion> findAll() {
        return androidVersionRepository.findAll();
    }
}
