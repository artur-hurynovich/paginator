package com.hurynovich.paginator;

import java.util.List;

class PaginatorImpl implements Paginator {

    @Override
    public PaginationParams buildParams(final Integer pageNumber,
                                        final Integer elementsPerPage) {
        assert pageNumber != null;
        assert elementsPerPage != null;

        return new PaginationParamsImpl((pageNumber - 1) * elementsPerPage, elementsPerPage);
    }

    @Override
    public <T> GenericPage<T> buildPage(final List<T> elements,
                                        final Long totalElementsCount,
                                        final PaginationParams params) {
        assert elements != null;
        assert totalElementsCount != null;
        assert params != null;

        final Integer offset = params.getOffset();
        final Integer limit = params.getLimit();

        final long currentPageNumber = calculateCurrentPageNumber(elements, offset, limit);
        final long totalPagesCount = calculateTotalPagesCount(totalElementsCount, limit);

        return new GenericPageBuilderImpl<T>()
                .withElements(elements)
                .withTotalElementsCount(totalElementsCount)
                .withCurrentPageNumber(currentPageNumber)
                .withTotalPagesCount(totalPagesCount)
                .build();
    }

    private <T> long calculateCurrentPageNumber(final List<T> elements,
                                                final Integer offset,
                                                final Integer limit) {
        final long currentPageNumber;
        if (elements.size() > 0) {
            currentPageNumber = offset / limit + 1;
        } else {
            currentPageNumber = 0;
        }

        return currentPageNumber;
    }

    private long calculateTotalPagesCount(final Long totalElementsCount,
                                          final Integer limit) {
        final long totalPagesCount;
        if (totalElementsCount % limit > 0) {
            totalPagesCount = totalElementsCount / limit + 1;
        } else {
            totalPagesCount = totalElementsCount / limit;
        }

        return totalPagesCount;
    }
}
