package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Config;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.*;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service.*;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.vo.AppVO;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppItemWriter implements ItemWriter<AppVO> {

    @Autowired
    private AppService appService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GenryService genryService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private AndroidVersionService androidVersionService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void write(List<? extends AppVO> list) throws Exception {
        list.forEach(appVO -> {
            AndroidVersion androidVersion = androidVersionService.findByName(appVO.getAndroidVersion().trim());
            if (androidVersion == null) {
                androidVersion = androidVersionService.saveAndReturn(new AndroidVersion(appVO.getAndroidVersion().trim()));
            }

            Category category = categoryService.findByName(appVO.getCategory().trim());
            if (category == null) {
                category = categoryService.saveAndReturn(new Category(appVO.getCategory().trim()));
            }

            String[] splited = appVO.getGenry().split(";");
            List<String> genriesNames = new ArrayList<>(Arrays.asList(splited));

            List<Genry> genries = new ArrayList<>();
            genriesNames.forEach(name -> {
                if (!name.trim().isEmpty()) {
                    Genry genry = genryService.findByName(name);
                    if (genry == null) {
                        genry = genryService.saveAndReturn(new Genry(name.trim()));
                    }
                    genries.add(genry);
                }
            });

            Type type = typeService.findByName(appVO.getType().trim());
            if (type == null) {
                type = typeService.saveAndReturn(new Type(appVO.getType()));
            }

            App app = new App(appVO.getName(), Double.valueOf(appVO.getRating()), category, Integer.valueOf(appVO.getReviewsQty()), appVO.getSize(), appVO.getInstallsQty(), type, appVO.getPrice(), appVO.getContentRating(), genries, appVO.getLastUpdate(), appVO.getVersion(), androidVersion);

            System.out.println(app.toString());
            appService.save(app);
        });
    }

}
