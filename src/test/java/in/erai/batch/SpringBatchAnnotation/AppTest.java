package in.erai.batch.SpringBatchAnnotation;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:application-context.xml",
"classpath:test-context.xml"})
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    @Autowired
    DataSource dataSource;

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Bean
    public JobLauncherTestUtils getJobLauncherTestUtils() {
        return new JobLauncherTestUtils() {
            @Override
            @Autowired
            public void setJob(@Qualifier("importUserJob") Job job) {
                super.setJob(job);

            }
        };
    }

    @Test
    public void testJob() throws Exception {

         //JobExecution jobExecution = jobLauncherTestUtils.launchJob();
         //assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

    }
}
