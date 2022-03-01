package com.hurynovich.paginator.impl;

import com.hurynovich.paginator.GenericPage;
import com.hurynovich.paginator.GenericPageBuilder;

import java.util.List;

public class GenericPageBuilderImpl<T> implements GenericPageBuilder<T> {

    private List<T> elements;

    private Long totalElementsCount;

    private Long currentPageNumber;

    private Long totalPagesCount;

    @Override
    public List<T> getElements() {
        return elements;
    }

    public GenericPageBuilder<T> withElements(final List<T> elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public Long getTotalElementsCount() {
        return totalElementsCount;
    }

    public GenericPageBuilder<T> withTotalElementsCount(final Long totalElementsCount) {
        this.totalElementsCount = totalElementsCount;

        return this;
    }

    @Override
    public Long getCurrentPageNumber() {
        return currentPageNumber;
    }

    public GenericPageBuilder<T> withCurrentPageNumber(final Long currentPageNumber) {
        this.currentPageNumber = currentPageNumber;

        return this;
    }

    @Override
    public Long getTotalPagesCount() {
        return totalPagesCount;
    }

    public GenericPageBuilder<T> withTotalPagesCount(final Long totalPagesCount) {
        this.totalPagesCount = totalPagesCount;

        return this;
    }

    @Override
    public GenericPage<T> build() {
        return new GenericPageImpl<>(this);
    }
}
