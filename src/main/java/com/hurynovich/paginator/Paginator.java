package com.hurynovich.paginator;

import java.util.List;

public interface Paginator {

    PaginationParams buildParams(Integer pageNumber, Integer elementsPerPage);

    <T> GenericPage<T> buildPage(List<T> elements,
                                 Long totalElementsCount,
                                 PaginationParams params);
}
