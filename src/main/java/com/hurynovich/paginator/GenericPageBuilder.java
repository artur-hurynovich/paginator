package com.hurynovich.paginator;

import java.util.List;

public interface GenericPageBuilder<T> {

    List<T> getElements();

    GenericPageBuilder<T> withElements(List<T> elements);

    Long getTotalElementsCount();

    GenericPageBuilder<T> withTotalElementsCount(Long totalElementsCount);

    Long getCurrentPageNumber();

    GenericPageBuilder<T> withCurrentPageNumber(Long currentPageNumber);

    Long getTotalPagesCount();

    GenericPageBuilder<T> withTotalPagesCount(Long totalPagesCount);

    GenericPage<T> build();
}
