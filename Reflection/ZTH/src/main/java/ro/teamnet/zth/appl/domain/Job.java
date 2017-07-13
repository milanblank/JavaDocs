package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Milan on 13-Jul-17.
 */
@Table(name = "job")
public class Job {

    @Id(name = "job_id")
    private long jobId;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "min_salary")
    private long minSalary;
    @Column(name = "max_salary")
    private long maxSalary;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(long minSalary) {
        this.minSalary = minSalary;
    }

    public long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Job o = (Job) obj;

        if (this.getJobId() == o.getJobId()
                && this.getJobTitle().equals(o.getJobTitle())
                && this.getMinSalary() == o.getMinSalary()
                && this.getMaxSalary() == o.getMaxSalary())
            return true;


        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getJobId() + " "
                + this.getJobTitle() + " "
                + this.getMinSalary() + " "
                + this.getMaxSalary();
    }
}
