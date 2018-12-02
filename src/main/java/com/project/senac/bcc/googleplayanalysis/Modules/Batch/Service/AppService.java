package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.App;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class AppService implements Serializable {

    @Autowired
    private AppRepository appRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public App save(App app) {
        return appRepository.save(app);
    }
}
