package com.example.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduler
 * @EnableScheduling를 활성화하여 스케쥴링에 사용할 클래스
 */
@Component
public class Scheduler {

    /**
     * CronJob을 실행한다
     */
    @Scheduled(cron = "0 0 10 * * *")
    public void cronJobSchedule() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String current = sdf.format(calendar.getTime());
        System.out.printf("Java cron job expression :: %s%n", current);
    }

    /**
     * 고정된 ms로 작업을 계속 실행한다.
     * 이전 작업 완료 여부를 기다리지 않고 실행한다.
     */
    @Scheduled(fixedRate = 1000)
    public void fixedReateSchedule() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String current = sdf.format(calendar.getTime());
        System.out.printf("Fixed rate expression :: %s%n", current);
    }

    /**
     * 이전 작업이 끝나고 난 뒤 지연시간을 기다리고 실행한다.
     * initialDelay는 처음 작업이 실행할 때까지 기다리는 시간.
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelaySchedule() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String current = sdf.format(calendar.getTime());
        System.out.printf("Fixed delay expression :: %s%n", current);
    }
}