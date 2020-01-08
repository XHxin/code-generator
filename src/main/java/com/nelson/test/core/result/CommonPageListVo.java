package com.nelson.test.core.result;

import lombok.Data;

import java.util.List;

@Data
public class CommonPageListVo<T> {
    private List<T> list;
    private long rowCount;

    public CommonPageListVo(List<T> list, long rowCount) {
        this.list = list;
        this.rowCount = rowCount;
    }

    public CommonPageListVo() {
    }
}
