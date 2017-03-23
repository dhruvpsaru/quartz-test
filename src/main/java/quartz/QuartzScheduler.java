package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by dhruv on 21/3/17.
 */
@WebListener
public class QuartzScheduler implements ServletContextListener {

    private Scheduler scheduler = null;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Context Initialized");

        try {
            // Setup the Job class and the Job group
            JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity(
                    "CronQuartzJob", "Group").build();

            // Create a Trigger that fires every 5 minutes.
            Trigger trigger = newTrigger()
                    .withIdentity("TriggerName", "Group")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();

            // Setup the Job and Trigger with Scheduler & schedule jobs
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("Context Destroyed");
        try
        {
            scheduler.shutdown();
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }
    }
}
