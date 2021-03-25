package br.com.zup.cardTransaction.transaction.kafka;

import br.com.zup.cardTransaction.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class TransactionListener {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void listen(TransactionEvent transactionEvent) {
        Transaction transaction = transactionEvent.toModel();
        entityManager.merge(transaction);

        logger.info("Cartão de ID " + transaction.getId()  + " foi criado");
    }
}
