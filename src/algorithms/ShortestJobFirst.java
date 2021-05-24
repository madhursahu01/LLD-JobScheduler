package algorithms;

import api.Job;

import java.util.Comparator;

public class ShortestJobFirst implements Comparator<Job> {

    public int compare(Job job1, Job job2)
    {
        if(job1.getDuration() == job2.getDuration())
        {
            if(job1.getPriority() == job2.getPriority())
            {
                if(job1.getUsertype() == job2.getUsertype())
                {
                    return job1.getDeadline()-job2.getDeadline();
                }
                return job1.getUsertype().ordinal() - job2.getUsertype().ordinal();
            }
            return job1.getPriority().ordinal() - job2.getPriority().ordinal();

        }
        return job1.getDuration()-job2.getDuration();
    }
}
