package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Config;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.vo.AppVO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public FlatFileItemReader<AppVO> reader() {
        return new FlatFileItemReaderBuilder<AppVO>()
                .name("personItemReader")
                .resource(new FileSystemResource("/home/rafael/Downloads/google-play-store-apps/googleplaystore.csv"))
                .delimited()
                .names(new String[] {"name", "category", "rating", "reviewsQty", "size", "installsQty", "type", "price", "contentRating", "genry", "lastUpdate", "version", "androidVersion"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<AppVO>(){{
                    setTargetType(AppVO.class);
                }})
                .build();
    }

    @Bean
    public AppItemProcessor processor() {
        return new AppItemProcessor();
    }

    @Bean
    public AppItemWriter writer() {
        return new AppItemWriter();
    }

    @Bean
    public Job importApp(Step step1) {
        return jobBuilderFactory.get("importApp")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<AppVO, AppVO> chunk(100)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


}
