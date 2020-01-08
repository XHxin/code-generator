package cn.generation.code.core.result;

import lombok.Data;

import java.util.List;

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
