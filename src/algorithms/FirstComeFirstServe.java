package algorithms;

import api.Job;

import java.util.Comparator;

public class FirstComeFirstServe implements Comparator<Job> {

    public int compare(Job job1, Job job2)
    {
        return job1.getId() - job2.getId();
    }
}
