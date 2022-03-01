package com.hurynovich.paginator;

import java.util.List;

class GenericPageImpl<T> implements GenericPage<T> {

    private final List<T> elements;

    private final Long totalElementsCount;

    private final Long currentPageNumber;

    private final Long totalPagesCount;

    public GenericPageImpl(final GenericPageBuilder<T> builder) {
        this.elements = builder.getElements();
        this.totalElementsCount = builder.getTotalElementsCount();
        this.currentPageNumber = builder.getCurrentPageNumber();
        this.totalPagesCount = builder.getTotalPagesCount();
    }

    @Override
    public List<T> getElements() {
        return elements;
    }

    @Override
    public Long getTotalElementsCount() {
        return totalElementsCount;
    }

    @Override
    public Long getCurrentPageNumber() {
        return currentPageNumber;
    }

    @Override
    public Long getTotalPagesCount() {
        return totalPagesCount;
    }
}
