package com.noah.solo.global.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageInfo {

    /**
     * 현재 페이지 번호
     */
    private Integer page;

    /**
     * 페이지 당 데이터 수
     */
    private Integer size;

    /**
     * 전체 페이지 수
     */
    private Integer totalPage;

    /**
     * 전체 데이터 수
     */
    private Long totalCount;

    /**
     * [Page]
     * 첫 페이지 여부
     */
    private Boolean isFirst;

    /**
     * [Page]
     * 마지막 페이지 여부
     */
    private Boolean isLast;

    /**
     * [Slice]
     * 이전 페이지 유무 여부
     */
    private Boolean hasPrevious;

    /**
     * [Slice]
     * 다음 페이지 유무 여부
     */
    private Boolean hasNext;

    public static PageInfo of(Page page) {
        return PageInfo.builder()
                .page(page.getPageable().getPageNumber())
                .size(page.getPageable().getPageSize())
                .totalPage(page.getTotalPages())
                .totalCount(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }

    public static PageInfo of(Slice slice) {
        return PageInfo.builder()
                .page(slice.getPageable().getPageNumber())
                .size(slice.getPageable().getPageSize())
                .hasPrevious(slice.hasPrevious())
                .hasNext(slice.hasNext())
                .build();
    }
}
