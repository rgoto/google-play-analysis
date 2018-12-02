package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AppGenry implements Serializable {

    @Id
    private Integer id;

    private Integer appId;
    private Integer genryId;

}
