package tn.rnu.isi.worldcup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Ticket;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.TicketRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TicketController {
	@Autowired
    private TicketRepository ticketRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    @PostMapping("/tickets")
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getUserById(
            @PathVariable(value = "id") Long ticketId)
            throws ResourceNotFoundException {
    	Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket introuvable avec le code = " + ticketId));
        return ResponseEntity.ok().body(ticket);
    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(
            @PathVariable(value = "id") Long ticketId,@Valid @RequestBody Ticket ticketDetails) throws ResourceNotFoundException {
    	Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new ResourceNotFoundException("Ticket introuvable avec le code = " + ticketId));
        ticket.setMatche(ticketDetails.getMatche());
        ticket.setPrix(ticketDetails.getPrix());
        ticket.setQuantite(ticketDetails.getQuantite());
      
        final Ticket updatedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/tickets/{id}")
    public Map<String, Boolean> deleteTicket(
            @PathVariable(value = "id") Long ticketId)
            throws ResourceNotFoundException {
    	Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new ResourceNotFoundException("Ticket introuvable avec le code = " + ticketId));

        ticketRepository.delete(ticket);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
