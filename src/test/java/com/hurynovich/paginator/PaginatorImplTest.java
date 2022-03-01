package com.hurynovich.paginator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

class PaginatorImplTest {

    private static final int ELEMENTS_PER_PAGE = 5;

    private final Paginator paginator = new PaginatorImpl();

    @Test
    void buildParamsTest1() {
        final PaginationParams params = paginator.buildParams(1, ELEMENTS_PER_PAGE);

        Assertions.assertEquals(0, params.getOffset());
        Assertions.assertEquals(5, params.getLimit());
    }

    @Test
    void buildParamsTest2() {
        final PaginationParams params = paginator.buildParams(5, ELEMENTS_PER_PAGE);

        Assertions.assertEquals(20, params.getOffset());
        Assertions.assertEquals(5, params.getLimit());
    }

    @Test
    void buildPageTest1() {
        final long totalElementsCount = 27L;
        final GenericPage<DummyObject> page = paginator.buildPage(buildMockElements(totalElementsCount),
                totalElementsCount, new PaginationParamsImpl(0, ELEMENTS_PER_PAGE));

        Assertions.assertEquals(totalElementsCount, page.getTotalElementsCount());
        Assertions.assertEquals(1, page.getCurrentPageNumber());
        Assertions.assertEquals(6, page.getTotalPagesCount());
    }

    @Test
    void buildPageTest2() {
        final long totalElementsCount = 27L;
        final GenericPage<DummyObject> page = paginator.buildPage(buildMockElements(totalElementsCount),
                totalElementsCount, new PaginationParamsImpl(10, ELEMENTS_PER_PAGE));

        Assertions.assertEquals(totalElementsCount, page.getTotalElementsCount());
        Assertions.assertEquals(3, page.getCurrentPageNumber());
        Assertions.assertEquals(6, page.getTotalPagesCount());
    }

    @Test
    void buildPageTest3() {
        final long totalElementsCount = 27L;
        final GenericPage<DummyObject> page = paginator.buildPage(buildMockElements(totalElementsCount),
                totalElementsCount, new PaginationParamsImpl(25, ELEMENTS_PER_PAGE));

        Assertions.assertEquals(27L, page.getTotalElementsCount());
        Assertions.assertEquals(6, page.getCurrentPageNumber());
        Assertions.assertEquals(6, page.getTotalPagesCount());
    }

    @Test
    void buildPageTest4() {
        final long totalElementsCount = 3L;
        final GenericPage<DummyObject> page = paginator.buildPage(buildMockElements(totalElementsCount),
                totalElementsCount, new PaginationParamsImpl(0, ELEMENTS_PER_PAGE));

        Assertions.assertEquals(totalElementsCount, page.getTotalElementsCount());
        Assertions.assertEquals(1, page.getCurrentPageNumber());
        Assertions.assertEquals(1, page.getTotalPagesCount());
    }

    @Test
    void buildPageTest5() {
        final GenericPage<DummyObject> page = paginator.buildPage(
                new ArrayList<>(), 0L, new PaginationParamsImpl(0, ELEMENTS_PER_PAGE));

        Assertions.assertEquals(0L, page.getTotalElementsCount());
        Assertions.assertEquals(0L, page.getCurrentPageNumber());
        Assertions.assertEquals(0, page.getTotalPagesCount());
    }

    private List<DummyObject> buildMockElements(final long totalElementsCount) {
        return LongStream.range(0, totalElementsCount)
                .mapToObj(x -> new DummyObject())
                .toList();
    }

    private static class DummyObject {

    }
}
