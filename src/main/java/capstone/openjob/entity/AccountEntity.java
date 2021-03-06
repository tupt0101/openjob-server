package capstone.openjob.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "public", catalog = "dden3j8ulj98p8")
public class AccountEntity {
    private Integer id;
    private String email;
    private String password;
    private String role;
    private Boolean confirmation;
//    private Integer companyId;
//    @ApiModelProperty(hidden = true)
//    private CompanyEntity companyByCompanyId;
    private String phoneNo;
    private String cv;
    @ApiModelProperty(hidden = true)
    private Collection<JobEntity> jobsById;
    @ApiModelProperty(hidden = true)
    private Collection<JobApplicationEntity> jobApplicationsById;
    private String fullname;
    private String address;
    @ApiModelProperty(hidden = true)
    private Collection<CompanyEntity> companiesById;

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "confirmation")
    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable=false, updatable=false)
//    public CompanyEntity getCompanyByCompanyId() {
//        return companyByCompanyId;
//    }
//
//    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
//        this.companyByCompanyId = companyByCompanyId;
//    }



    @Basic
    @Column(name = "phone_no")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "cv")
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @OneToMany(mappedBy = "accountByAccountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "account-job")
    public Collection<JobEntity> getJobsById() {
        return jobsById;
    }

    public void setJobsById(Collection<JobEntity> jobByIds) {
        this.jobsById = jobByIds;
    }

    @OneToMany(mappedBy = "accountByAccountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "account-application")
    public Collection<JobApplicationEntity> getJobApplicationsById() {
        return jobApplicationsById;
    }

    public void setJobApplicationsById(Collection<JobApplicationEntity> jobApplicationByIds) {
        this.jobApplicationsById = jobApplicationByIds;
    }

    @OneToMany(mappedBy = "accountById", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "account-company")
    public Collection<CompanyEntity> getCompaniesById() {
        return companiesById;
    }

    public void setCompaniesById(Collection<CompanyEntity> companiesById) {
        this.companiesById = companiesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(confirmation, that.confirmation) &&
                Objects.equals(phoneNo, that.phoneNo) &&
                Objects.equals(cv, that.cv) &&
                Objects.equals(fullname, that.fullname) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role, confirmation, phoneNo, cv, fullname, address);
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
