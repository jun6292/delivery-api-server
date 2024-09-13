package com.delivery.mono.store.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.store.dto.StoreSummaryResponseDto;
import org.springframework.data.domain.Page;

@UseCase(value = "readStoreListUseCase")
public interface ReadStoreListUseCase {
    Page<StoreSummaryResponseDto> readStoreList(int page, int size, String sortBy, String orderBy);
    Page<StoreSummaryResponseDto> searchStore(int page, int size, String text);

    // 평점 추가된 리스트
    Page<StoreSummaryResponseDto> getStoresWithAverageRate(int page, int size, String sortBy, String orderBy);
}
