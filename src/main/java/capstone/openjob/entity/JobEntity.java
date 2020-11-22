package capstone.openjob.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "public", catalog = "dden3j8ulj98p8")
public class JobEntity {
    private Integer id;
    private String title;
    private String description;
    private Date applyTo;
    private Date createDate;
    private Integer companyId;
    @ApiModelProperty(hidden = true)
    private CompanyEntity companyByCompanyId;
    private String currency;
    private Double salaryFrom;
    private Boolean salaryHidden;
    private Double salaryTo;
    private String status;
    private Integer vacancies;
    private String jobType;
//    @ApiModelProperty(hidden = true)
//    private CategoryEntity categoryByCategoryId;
    private String skill;
    private String location;
    private Integer accountId;
    @ApiModelProperty(hidden = true)
    private AccountEntity accountByAccountId;
    @ApiModelProperty(hidden = true)
    private Collection<JobApplicationEntity> jobApplicationByIds;
    private String category;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "apply_to")
    public Date getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(Date applyTo) {
        this.applyTo = applyTo;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "salary_from")
    public Double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    @Basic
    @Column(name = "salary_hidden")
    public Boolean getSalaryHidden() {
        return salaryHidden;
    }

    public void setSalaryHidden(Boolean salaryHidden) {
        this.salaryHidden = salaryHidden;
    }

    @Basic
    @Column(name = "salary_to")
    public Double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "vacancies")
    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    @Basic
    @Column(name = "job_type")
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "skill")
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable=false, updatable=false)
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable=false, updatable=false)
//    public CategoryEntity getCategoryByCategoryId() {
//        return categoryByCategoryId;
//    }
//
//    public void setCategoryByCategoryId(CategoryEntity categoryId) {
//        this.categoryByCategoryId = categoryId;
//    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable=false, updatable=false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountId) {
        this.accountByAccountId = accountId;
    }

    @OneToMany(mappedBy = "jobByJobId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "miss")
    public Collection<JobApplicationEntity> getJobApplicationByIds() {
        return jobApplicationByIds;
    }

    public void setJobApplicationByIds(Collection<JobApplicationEntity> jobApplicationByIds) {
        this.jobApplicationByIds = jobApplicationByIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobEntity jobEntity = (JobEntity) o;
        return Objects.equals(id, jobEntity.id) &&
                Objects.equals(title, jobEntity.title) &&
                Objects.equals(description, jobEntity.description) &&
                Objects.equals(applyTo, jobEntity.applyTo) &&
                Objects.equals(createDate, jobEntity.createDate) &&
                Objects.equals(companyId, jobEntity.companyId) &&
                Objects.equals(currency, jobEntity.currency) &&
                Objects.equals(salaryFrom, jobEntity.salaryFrom) &&
                Objects.equals(salaryHidden, jobEntity.salaryHidden) &&
                Objects.equals(salaryTo, jobEntity.salaryTo) &&
                Objects.equals(status, jobEntity.status) &&
                Objects.equals(vacancies, jobEntity.vacancies) &&
                Objects.equals(jobType, jobEntity.jobType) &&
                Objects.equals(skill, jobEntity.skill) &&
                Objects.equals(location, jobEntity.location) &&
                Objects.equals(accountId, jobEntity.accountId) &&
                Objects.equals(category, jobEntity.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, applyTo, createDate, companyId, currency, salaryFrom, salaryHidden, salaryTo, status, vacancies, jobType, skill, location, accountId, category);
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
