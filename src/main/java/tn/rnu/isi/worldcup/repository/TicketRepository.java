package tn.rnu.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long>{

}
