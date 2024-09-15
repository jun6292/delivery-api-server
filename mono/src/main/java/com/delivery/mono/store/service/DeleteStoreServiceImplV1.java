package com.delivery.mono.store.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.store.domain.Store;
import com.delivery.mono.store.repository.StoreRepository;
import com.delivery.mono.store.usecase.DeleteStoreUseCase;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteStoreServiceImplV1 implements DeleteStoreUseCase {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void deleteStoreByAdmin(UUID storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.STORE_NOT_FOUND));
        store.delete();
    }

    @Override
    @Transactional
    public void deleteStoreByOwner(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Store store = storeRepository.findByUser(user)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.STORE_NOT_FOUND));
        store.delete();
    }
}
