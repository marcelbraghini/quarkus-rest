package br.com.marcelbraghini.quarkusrest.taks;

import io.quarkus.scheduler.Scheduled;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApliccationTask {

    private static final Logger logger = Logger.getLogger(ApliccationTask.class);

    @Scheduled(every = "30s")
    public void schedule() {
        logger.info("schedule running...");
    }

}
