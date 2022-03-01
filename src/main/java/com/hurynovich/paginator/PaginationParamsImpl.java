package com.hurynovich.paginator;

import java.util.Objects;

class PaginationParamsImpl implements PaginationParams {

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
