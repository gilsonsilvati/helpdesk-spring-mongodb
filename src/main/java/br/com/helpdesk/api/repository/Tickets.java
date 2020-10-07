package br.com.helpdesk.api.repository;

import br.com.helpdesk.api.entity.Ticket;
import br.com.helpdesk.api.entity.User;
import br.com.helpdesk.api.entity.enums.Priority;
import br.com.helpdesk.api.entity.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tickets extends MongoRepository<Ticket, String> {

    Page<Ticket> findByUserIdOrderByDateDesc(String userId, Pageable pageable);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
            String title, Status status, Priority priority, Pageable pageable
    );

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingUserIdOrderByDateDesc(
            String title, Status status, Priority priority,String userId, Pageable pageable
    );

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingUserOrderByDateDesc(
            String title, Status status, Priority priority, User user, Pageable pageable
    );

    Page<Ticket> findByNumber(Integer number, Pageable pageable);

}
