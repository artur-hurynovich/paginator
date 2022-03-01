package com.hurynovich.paginator;

import java.util.List;

public interface GenericPage<T> {

    List<T> getElements();

    Long getTotalElementsCount();

    Long getCurrentPageNumber();

    Long getTotalPagesCount();
}
