package com.hurynovich.paginator.impl;

import com.hurynovich.paginator.PaginationParams;

import java.util.Objects;

public class PaginationParamsImpl implements PaginationParams {

    private final Integer offset;

    private final Integer limit;

    public PaginationParamsImpl(final Integer offset, final Integer limit) {
        this.offset = Objects.requireNonNull(offset);
        this.limit = Objects.requireNonNull(limit);
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
}
