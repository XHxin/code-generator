package cn.org.cvc.model;

import java.io.Serializable;
import java.util.Date;

public class CaseTestItem implements Serializable {
    /**
     * 产品测试项目编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 案例编号
     *
     * @mbg.generated
     */
    private Integer caseId;

    /**
     * 测试项目编号
     *
     * @mbg.generated
     */
    private Integer testItemId;

    /**
     * 是否添加到报告中：0-不添加 1-添加
     *
     * @mbg.generated
     */
    private Boolean addInReport;

    /**
     * 该测试项是否及格（因为需求规定了测试项的结果与附件的结果没有绝对的关系，由此新增此字段）
     *
     * @mbg.generated
     */
    private Boolean pass;

    private Boolean del;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Integer testItemId) {
        this.testItemId = testItemId;
    }

    public Boolean getAddInReport() {
        return addInReport;
    }

    public void setAddInReport(Boolean addInReport) {
        this.addInReport = addInReport;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", caseId=").append(caseId);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", addInReport=").append(addInReport);
        sb.append(", pass=").append(pass);
        sb.append(", del=").append(del);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CaseTestItem other = (CaseTestItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCaseId() == null ? other.getCaseId() == null : this.getCaseId().equals(other.getCaseId()))
            && (this.getTestItemId() == null ? other.getTestItemId() == null : this.getTestItemId().equals(other.getTestItemId()))
            && (this.getAddInReport() == null ? other.getAddInReport() == null : this.getAddInReport().equals(other.getAddInReport()))
            && (this.getPass() == null ? other.getPass() == null : this.getPass().equals(other.getPass()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCaseId() == null) ? 0 : getCaseId().hashCode());
        result = prime * result + ((getTestItemId() == null) ? 0 : getTestItemId().hashCode());
        result = prime * result + ((getAddInReport() == null) ? 0 : getAddInReport().hashCode());
        result = prime * result + ((getPass() == null) ? 0 : getPass().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}