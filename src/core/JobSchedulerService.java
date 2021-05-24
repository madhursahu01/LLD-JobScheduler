package core;

import api.Job;
import constants.AlgorithmType;
import factory.SimpleAlgorithmFactory;

import java.util.*;

public class JobSchedulerService {

    private PriorityQueue<Job> queue;
    private Comparator<Job> algorithm;
    private List<List<Job>> results;

    public JobSchedulerService(AlgorithmType type)
    {
        this.algorithm = new SimpleAlgorithmFactory().getAlgorithmObject(type);
        queue = new PriorityQueue<>(this.algorithm);
        results = new ArrayList<>();
    }

    public List<List<Job>> getExecutionOrderByThread(List<Job> jobs, int threadCount)
    {
        queue.addAll(jobs);
        int[] threadCapacity = new int[threadCount];
        int[] totatTimeTaken = new int[threadCount];

        for(int i = 0 ; i<threadCount ; i++)
        {
            results.add(new ArrayList<>());
            threadCapacity[i] = 0;
            totatTimeTaken[i] = 0;
        }
        while(!queue.isEmpty())
        {
            for(int i = 0 ; i < threadCount ; i++)
            {
                if(threadCapacity[i]==0)
                {
                    if(!queue.isEmpty())
                    {
                        Job job = queue.peek();
                        totatTimeTaken[i] += job.getDuration();
                        if(totatTimeTaken[i] < job.getDeadline())
                        {
                            results.get(i).add(job);
                            threadCapacity[i] += job.getDuration();
                        }
                        else
                            totatTimeTaken[i] -= job.getDuration();
                        queue.poll();
                    }
                }
            }
            processThreads(threadCapacity);

        }
        return results;
    }

    private void processThreads(int[] threadCapacity) {

        int minDuration = Integer.MAX_VALUE;
        for(int value : threadCapacity)
        {
            minDuration = Math.min(minDuration,value);
        }
        for (int i=0; i < threadCapacity.length ; i++)
        {
            threadCapacity[i] -= minDuration;
        }
    }


}
