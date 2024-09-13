package com.delivery.mono.payment.application.service;

import com.delivery.mono.order.domain.entity.Order;
import com.delivery.mono.order.domain.repository.OrderRepository;
import com.delivery.mono.payment.application.dto.PaymentListDTO;
import com.delivery.mono.payment.application.dto.PaymentRequestDTO;
import com.delivery.mono.payment.application.dto.PaymentResponseDTO;
import com.delivery.mono.payment.domain.entity.Payment;
import com.delivery.mono.payment.domain.repository.PaymentRepository;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    /**
     * 결제 목록 조회
     *
     * @param userId
     * @param page
     * @param size
     * @param sortBy
     * @param orderBy
     * @return Page<PaymentListDTO>
     */
    @Override
    public Page<PaymentListDTO> getPaymentList(UUID userId, int page, int size, String sortBy, boolean orderBy) {

        // 사이즈 10,30,50 이외의 값이 들어왔을 때 값 고정
        if(size != 10 && size != 30 && size != 50){
            size = 10;
        }

        // 정렬 방향
        Sort.Direction direction = orderBy ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<Payment> paymentPage = paymentRepository.findAllByUserId(userId, pageable);

        return paymentPage.map(PaymentListDTO::toDTO);
    }


    /**
     * 결제 내역 생성
     *
     * @param paymentRequestDTO
     * @return PaymentResponseDTO
     */
    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {

        User user = userRepository.findById(paymentRequestDTO.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Order order = orderRepository.findById(paymentRequestDTO.getOrderId()).orElseThrow(
                () -> new IllegalArgumentException("주문이 존재하지 않습니다."));

        Payment payment = Payment.builder()
                .user(user)
                .order(order)
                .totalPrice(order.getTotalPrice())
                .status(paymentRequestDTO.getStatus())
                .paymentMethod(paymentRequestDTO.getPaymentMethod())
                .build();

        paymentRepository.save(payment);

        return PaymentResponseDTO.toDTO(payment);
    }

    /**
     * 주문 내역 조회
     *
     * @param paymentId
     * @return
     */
    @Override
    public PaymentResponseDTO findByPaymentId(UUID paymentId) {

        Payment payment = paymentRepository.findById(paymentId).orElseThrow(
                () -> new IllegalArgumentException("결제 내역이 존재하지 않습니다."));

        return PaymentResponseDTO.toDTO(payment);
    }
}
