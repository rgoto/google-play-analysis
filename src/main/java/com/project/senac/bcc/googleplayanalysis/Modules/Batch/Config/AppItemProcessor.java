package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Config;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.vo.AppVO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppItemProcessor implements ItemProcessor<AppVO, AppVO> {

    @Override
    public AppVO process(AppVO appVO) throws Exception {
        String price = appVO.getPrice().replace("$", "");
        appVO.setPrice(price);

        if ("NaN".equalsIgnoreCase(appVO.getRating())) {
            appVO.setRating("0.0");
        }

        return appVO;
    }
}
