# LLD-JobScheduler

Takes list of Jobs which have different parameters like :
id,
name,
priority,
usertype,
deadline,
duration

It also takes number of threads in inputs and give out execution of different jobs per thread as different scheduling type like:
Earliest Job First,
More Priority First,
Shortest Job First,
First Come First 

If the deadline of job has already been passed or it cannot be completed in current time, that job will not be scheduled.
