package com.osmeet.os.model.net.utils.box;

import java.util.List;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class ListContent<T> {

    private List<T> content;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    private boolean first;
    private boolean last;
    private int number;
    private int numberOfElements;
    private Pageable pageable;
    private int size;
    private Sort sort;
    private int totalElements;
    private int totalPages;


    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean getFirst() {
        return first;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean getLast() {
        return last;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public static class Sort {

        private boolean sorted;
        private boolean unsorted;

        public void setSorted(boolean sorted) {
            this.sorted = sorted;
        }

        public boolean getSorted() {
            return sorted;
        }

        public void setUnsorted(boolean unsorted) {
            this.unsorted = unsorted;
        }

        public boolean getUnsorted() {
            return unsorted;
        }

    }

    public static class Pageable {

        private int offset;
        private int pageNumber;
        private int pageSize;
        private boolean paged;
        private Sort sort;
        private boolean unpaged;

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getOffset() {
            return offset;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPaged(boolean paged) {
            this.paged = paged;
        }

        public boolean getPaged() {
            return paged;
        }

        public void setSort(Sort sort) {
            this.sort = sort;
        }

        public Sort getSort() {
            return sort;
        }

        public void setUnpaged(boolean unpaged) {
            this.unpaged = unpaged;
        }

        public boolean getUnpaged() {
            return unpaged;
        }

    }
}
