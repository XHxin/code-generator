package cn.org.cvc.model;

import java.io.Serializable;
import java.util.Date;

public class RectificationDb implements Serializable {
    /**
     * 整改建议编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 整改建议编码(如果是还没归档的是没有整改建议编号的)
     *
     * @mbg.generated
     */
    private String rectificationAdviceNum;

    /**
     * 所属项目编号（直接在整改库新增的整改建议是没有项目编号的）
     *
     * @mbg.generated
     */
    private String projectNum;

    /**
     * 产品名称
     *
     * @mbg.generated
     */
    private String productName;

    /**
     * 测试项目
     *
     * @mbg.generated
     */
    private String testItem;

    /**
     * 是否及格：0-不及格  1-及格
     *
     * @mbg.generated
     */
    private Boolean pass;

    /**
     * 方案/及格或不及格的原因
     *
     * @mbg.generated
     */
    private String reason;

    /**
     * 应对措施
     *
     * @mbg.generated
     */
    private String solutions;

    /**
     * 图片数组
     *
     * @mbg.generated
     */
    private String imgs;

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

    public String getRectificationAdviceNum() {
        return rectificationAdviceNum;
    }

    public void setRectificationAdviceNum(String rectificationAdviceNum) {
        this.rectificationAdviceNum = rectificationAdviceNum;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSolutions() {
        return solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
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
        sb.append(", rectificationAdviceNum=").append(rectificationAdviceNum);
        sb.append(", projectNum=").append(projectNum);
        sb.append(", productName=").append(productName);
        sb.append(", testItem=").append(testItem);
        sb.append(", pass=").append(pass);
        sb.append(", reason=").append(reason);
        sb.append(", solutions=").append(solutions);
        sb.append(", imgs=").append(imgs);
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
        RectificationDb other = (RectificationDb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRectificationAdviceNum() == null ? other.getRectificationAdviceNum() == null : this.getRectificationAdviceNum().equals(other.getRectificationAdviceNum()))
            && (this.getProjectNum() == null ? other.getProjectNum() == null : this.getProjectNum().equals(other.getProjectNum()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getTestItem() == null ? other.getTestItem() == null : this.getTestItem().equals(other.getTestItem()))
            && (this.getPass() == null ? other.getPass() == null : this.getPass().equals(other.getPass()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getSolutions() == null ? other.getSolutions() == null : this.getSolutions().equals(other.getSolutions()))
            && (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRectificationAdviceNum() == null) ? 0 : getRectificationAdviceNum().hashCode());
        result = prime * result + ((getProjectNum() == null) ? 0 : getProjectNum().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getTestItem() == null) ? 0 : getTestItem().hashCode());
        result = prime * result + ((getPass() == null) ? 0 : getPass().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getSolutions() == null) ? 0 : getSolutions().hashCode());
        result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}