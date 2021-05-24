package client;

import api.Job;
import constants.AlgorithmType;
import constants.Priority;
import constants.UserType;
import core.JobSchedulerService;

import java.util.ArrayList;
import java.util.List;

public class JobSchedulerClient {

    public static void main(String[] args)
    {
        List<Job> job = new ArrayList<>();

        Job job1 = new Job("Job1",3, Priority.P3, UserType.USER,10);
        Job job2 = new Job("Job2",6, Priority.P1, UserType.ADMIN,12);
        Job job3 = new Job("Job3",2, Priority.P2, UserType.ROOT,6);
        Job job4 = new Job("Job4",7, Priority.P3, UserType.ADMIN,14);
        Job job5 = new Job("Job5",1, Priority.P1, UserType.ROOT,3);
        Job job6 = new Job("Job6",4, Priority.P2, UserType.USER,2);

        job.add(job1);
        job.add(job2);
        job.add(job3);
        job.add(job4);
        job.add(job5);
        job.add(job6);

        JobSchedulerService schedulerService = new JobSchedulerService(AlgorithmType.SJF);

        List<List<Job>> results = schedulerService.getExecutionOrderByThread(job,2);

        for(List<Job> joblist : results)
        {
            System.out.println("----------------------------");
            for (Job j : joblist)
            {
                System.out.println(j.toString());
            }
            System.out.println("----------------------------");
        }

    }
}
