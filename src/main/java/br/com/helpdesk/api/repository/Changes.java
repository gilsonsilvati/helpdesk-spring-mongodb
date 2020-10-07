package br.com.helpdesk.api.repository;

import br.com.helpdesk.api.entity.Change;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Changes extends MongoRepository<Change, String> {

    Iterable<Change> findByTicketIdOrderByDateChangeDesc(String ticketId);

}
