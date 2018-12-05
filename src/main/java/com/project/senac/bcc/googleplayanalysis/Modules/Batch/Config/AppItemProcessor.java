package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Config;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.vo.AppVO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Configuration
public class AppItemProcessor implements ItemProcessor<AppVO, AppVO> {

    @Override
    public AppVO process(AppVO appVO) throws Exception {
        String price = appVO.getPrice().replace("$", "");
        appVO.setPrice(price);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        Date date = sdf.parse(appVO.getLastUpdate());
        sdf.applyPattern("yyyy-MM-dd");
        appVO.setLastUpdate(sdf.format(date));


        String installsQty = appVO.getInstallsQty()
                    .replace("+", "")
                    .replace(",", "");

        appVO.setInstallsQty(installsQty);

        if ("NaN".equalsIgnoreCase(appVO.getRating())) {
            appVO.setRating("0.0");
        }

        return appVO;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        Date date = sdf.parse("June 14, 2018");
        sdf.applyPattern("dd/MM/yyyy");
        System.out.println(sdf.format(date));
    }
}
