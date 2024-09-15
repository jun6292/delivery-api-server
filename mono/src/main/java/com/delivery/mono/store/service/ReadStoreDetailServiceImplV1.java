package com.delivery.mono.store.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.store.domain.Store;
import com.delivery.mono.store.dto.StoreDetailResponseDto;
import com.delivery.mono.store.repository.StoreRepository;
import com.delivery.mono.store.usecase.ReadStoreDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReadStoreDetailServiceImplV1 implements ReadStoreDetailUseCase {

    private final StoreRepository storeRepository;

    @Override
    public StoreDetailResponseDto readStoreDetail(UUID storeId) {
        Store store = storeRepository.findByIdAnAndIsDeletedFalse(storeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.STORE_NOT_FOUND));

        return StoreDetailResponseDto.fromEntity(store);
    }
}
