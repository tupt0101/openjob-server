package capstone.openjob.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "job_application", schema = "public", catalog = "dden3j8ulj98p8")
public class JobApplicationEntity {
    private Integer id;
    private Integer jobId;
    @ApiModelProperty(hidden = true)
    private JobEntity jobByJobId;
    private Integer accountId;
    @ApiModelProperty(hidden = true)
    private AccountEntity accountByAccountId;
    private Date applyAt;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "job_id")
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "account_id")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "id", insertable=false, updatable=false)
    public JobEntity getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(JobEntity jobId) {
        this.jobByJobId = jobId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable=false, updatable=false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountId) {
        this.accountByAccountId = accountId;
    }

    @Basic
    @Column(name = "apply_at")
    public Date getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(Date applyAt) {
        this.applyAt = applyAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobApplicationEntity that = (JobApplicationEntity) o;
        return id == that.id &&
                Objects.equals(jobByJobId, that.jobByJobId) &&
                Objects.equals(accountByAccountId, that.accountByAccountId) &&
                Objects.equals(applyAt, that.applyAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobByJobId, accountByAccountId, applyAt);
    }
}
