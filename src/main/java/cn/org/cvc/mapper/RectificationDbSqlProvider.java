package cn.org.cvc.mapper;

import cn.org.cvc.model.RectificationDb;
import cn.org.cvc.model.RectificationDbExample.Criteria;
import cn.org.cvc.model.RectificationDbExample.Criterion;
import cn.org.cvc.model.RectificationDbExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RectificationDbSqlProvider {

    public String countByExample(RectificationDbExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rectification_db");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RectificationDbExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rectification_db");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RectificationDb record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rectification_db");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRectificationAdviceNum() != null) {
            sql.VALUES("rectification_advice_num", "#{rectificationAdviceNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectNum() != null) {
            sql.VALUES("project_num", "#{projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestItem() != null) {
            sql.VALUES("test_item", "#{testItem,jdbcType=VARCHAR}");
        }
        
        if (record.getPass() != null) {
            sql.VALUES("pass", "#{pass,jdbcType=BIT}");
        }
        
        if (record.getReason() != null) {
            sql.VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getSolutions() != null) {
            sql.VALUES("solutions", "#{solutions,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            sql.VALUES("imgs", "#{imgs,jdbcType=VARCHAR}");
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

    public String selectByExample(RectificationDbExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("rectification_advice_num");
        sql.SELECT("project_num");
        sql.SELECT("product_name");
        sql.SELECT("test_item");
        sql.SELECT("pass");
        sql.SELECT("reason");
        sql.SELECT("solutions");
        sql.SELECT("imgs");
        sql.SELECT("del");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.FROM("rectification_db");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RectificationDb record = (RectificationDb) parameter.get("record");
        RectificationDbExample example = (RectificationDbExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rectification_db");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRectificationAdviceNum() != null) {
            sql.SET("rectification_advice_num = #{record.rectificationAdviceNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectNum() != null) {
            sql.SET("project_num = #{record.projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestItem() != null) {
            sql.SET("test_item = #{record.testItem,jdbcType=VARCHAR}");
        }
        
        if (record.getPass() != null) {
            sql.SET("pass = #{record.pass,jdbcType=BIT}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        }
        
        if (record.getSolutions() != null) {
            sql.SET("solutions = #{record.solutions,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            sql.SET("imgs = #{record.imgs,jdbcType=VARCHAR}");
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
        sql.UPDATE("rectification_db");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("rectification_advice_num = #{record.rectificationAdviceNum,jdbcType=VARCHAR}");
        sql.SET("project_num = #{record.projectNum,jdbcType=VARCHAR}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("test_item = #{record.testItem,jdbcType=VARCHAR}");
        sql.SET("pass = #{record.pass,jdbcType=BIT}");
        sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        sql.SET("solutions = #{record.solutions,jdbcType=VARCHAR}");
        sql.SET("imgs = #{record.imgs,jdbcType=VARCHAR}");
        sql.SET("del = #{record.del,jdbcType=BIT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        
        RectificationDbExample example = (RectificationDbExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RectificationDb record) {
        SQL sql = new SQL();
        sql.UPDATE("rectification_db");
        
        if (record.getRectificationAdviceNum() != null) {
            sql.SET("rectification_advice_num = #{rectificationAdviceNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectNum() != null) {
            sql.SET("project_num = #{projectNum,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestItem() != null) {
            sql.SET("test_item = #{testItem,jdbcType=VARCHAR}");
        }
        
        if (record.getPass() != null) {
            sql.SET("pass = #{pass,jdbcType=BIT}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getSolutions() != null) {
            sql.SET("solutions = #{solutions,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            sql.SET("imgs = #{imgs,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, RectificationDbExample example, boolean includeExamplePhrase) {
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