package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dhruv on 21/3/17.
 */
public class SimpleJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("This is my first quartz job!!");
    }
}
