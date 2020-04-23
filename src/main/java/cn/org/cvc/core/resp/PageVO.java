package cn.org.cvc.core.resp;

import lombok.Data;

import java.util.List;

/**
* 分页返回的封装类
* Created by Nelson on 2020/4/7.
*/
@Data
public class PageVO<T> {
    private List<T> list;
    private long rowCount;

    public PageVO(List<T> list, long rowCount) {
        this.list = list;
        this.rowCount = rowCount;
    }

    public PageVO() {
    }
}