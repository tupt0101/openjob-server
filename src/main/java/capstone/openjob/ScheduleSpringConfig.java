package capstone.openjob;

import capstone.openjob.entity.JobEntity;
import capstone.openjob.job.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableScheduling
public class ScheduleSpringConfig {



    @Autowired
    IJobService jobService;



    @Scheduled(fixedRate = 86400000)
    public void scanForExpiredJob() {
        List<JobEntity> jobEntities = jobService.getOpenJob();
        for (int i = 0; i < jobEntities.size(); i++) {
            JobEntity job = jobEntities.get(i);
            if ( job.getApplyTo().isBefore(LocalDateTime.now())) {
                jobService.closeJob(job.getId());
                System.out.println(job.getTitle());
            }
        }
    }

}
