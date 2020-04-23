package cn.org.cvc.mapper;

import cn.org.cvc.model.CaseDb;
import cn.org.cvc.model.CaseDbExample.Criteria;
import cn.org.cvc.model.CaseDbExample.Criterion;
import cn.org.cvc.model.CaseDbExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CaseDbSqlProvider {

    public String countByExample(CaseDbExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("case_db");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CaseDbExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("case_db");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CaseDb record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("case_db");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCaseNum() != null) {
            sql.VALUES("case_num", "#{caseNum,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getProjectNum() != null) {
            sql.VALUES("project_num", "#{projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("model", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTime() != null) {
            sql.VALUES("order_time", "#{orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyer() != null) {
            sql.VALUES("buyer", "#{buyer,jdbcType=VARCHAR}");
        }
        
        if (record.getLab() != null) {
            sql.VALUES("lab", "#{lab,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.VALUES("company_address", "#{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getLastEditor() != null) {
            sql.VALUES("last_editor", "#{lastEditor,jdbcType=VARCHAR}");
        }
        
        if (record.getDel() != null) {
            sql.VALUES("del", "#{del,jdbcType=BIT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CaseDbExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("case_num");
        sql.SELECT("status");
        sql.SELECT("project_num");
        sql.SELECT("product_name");
        sql.SELECT("model");
        sql.SELECT("order_time");
        sql.SELECT("buyer");
        sql.SELECT("lab");
        sql.SELECT("company_address");
        sql.SELECT("company_name");
        sql.SELECT("company_id");
        sql.SELECT("last_editor");
        sql.SELECT("del");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.FROM("case_db");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CaseDb record = (CaseDb) parameter.get("record");
        CaseDbExample example = (CaseDbExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("case_db");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCaseNum() != null) {
            sql.SET("case_num = #{record.caseNum,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getProjectNum() != null) {
            sql.SET("project_num = #{record.projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyer() != null) {
            sql.SET("buyer = #{record.buyer,jdbcType=VARCHAR}");
        }
        
        if (record.getLab() != null) {
            sql.SET("lab = #{record.lab,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getLastEditor() != null) {
            sql.SET("last_editor = #{record.lastEditor,jdbcType=VARCHAR}");
        }
        
        if (record.getDel() != null) {
            sql.SET("del = #{record.del,jdbcType=BIT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("case_db");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("case_num = #{record.caseNum,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("project_num = #{record.projectNum,jdbcType=VARCHAR}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        sql.SET("buyer = #{record.buyer,jdbcType=VARCHAR}");
        sql.SET("lab = #{record.lab,jdbcType=VARCHAR}");
        sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("last_editor = #{record.lastEditor,jdbcType=VARCHAR}");
        sql.SET("del = #{record.del,jdbcType=BIT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        
        CaseDbExample example = (CaseDbExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CaseDb record) {
        SQL sql = new SQL();
        sql.UPDATE("case_db");
        
        if (record.getCaseNum() != null) {
            sql.SET("case_num = #{caseNum,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getProjectNum() != null) {
            sql.SET("project_num = #{projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{model,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyer() != null) {
            sql.SET("buyer = #{buyer,jdbcType=VARCHAR}");
        }
        
        if (record.getLab() != null) {
            sql.SET("lab = #{lab,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getLastEditor() != null) {
            sql.SET("last_editor = #{lastEditor,jdbcType=VARCHAR}");
        }
        
        if (record.getDel() != null) {
            sql.SET("del = #{del,jdbcType=BIT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CaseDbExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}