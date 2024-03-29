package pl.training.shop.payments.adapters.persistence.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.training.shop.commons.data.Page;
import pl.training.shop.commons.data.ResultPage;
import pl.training.shop.payments.domain.Payment;
import pl.training.shop.payments.domain.PaymentStatus;
import pl.training.shop.payments.ports.PaymentRepository;

import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Transactional(propagation = MANDATORY)
@Component
@RequiredArgsConstructor
public class MongoPaymentRepositoryAdapter implements PaymentRepository {

    private final MongoPaymentRepositoryMapper mapper;
    private final MongoPaymentRepository repository;

    @Override
    public Payment save(Payment payment) {
        var paymentEntity = mapper.toDocument(payment);
        return mapper.toDomain(repository.save(paymentEntity));
    }

    @Override
    public Optional<Payment> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public ResultPage<Payment> findByStatus(PaymentStatus paymentStatus, Page page) {
        var status = mapper.toDocument(paymentStatus);
        var result = repository.findByStatus(status, PageRequest.of(page.getNumber(), page.getSize()));
        return mapper.toDomain(result);
    }

}
