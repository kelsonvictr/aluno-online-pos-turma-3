package br.com.alunoonline.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleTask {

    @Scheduled(cron = "0 * * * * *")
    public void executeTask(){
        log.info("Turma Backend Jr - Task executada");
    }
}
