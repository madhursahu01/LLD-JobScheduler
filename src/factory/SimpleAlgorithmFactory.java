package factory;

import algorithms.EarliestDeadlineFIrst;
import algorithms.FirstComeFirstServe;
import algorithms.MorePriorityFirst;
import algorithms.ShortestJobFirst;
import api.Job;
import constants.AlgorithmType;

import java.util.Comparator;

public class SimpleAlgorithmFactory {

    public Comparator<Job> getAlgorithmObject(AlgorithmType type)
    {
        switch(type)
        {
            case SJF:
                return new ShortestJobFirst();
            case EDF:
                return new EarliestDeadlineFIrst();
            case MPF:
                return new MorePriorityFirst();
            default:
                return new FirstComeFirstServe();
        }

    }
}
