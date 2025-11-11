package com.example.onlineshop.service;

import com.example.onlineshop.model.CustomerSupportTicket;
import com.example.onlineshop.repository.CustomerSupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSupportTicketService {

    @Autowired
    private CustomerSupportTicketRepository repository;

    // Create
    public CustomerSupportTicket createTicket(CustomerSupportTicket ticket) {
        return repository.save(ticket);
    }

    // Read All
    public List<CustomerSupportTicket> getAllTickets() {
        return repository.findAll();
    }

    // Read by ID
    public Optional<CustomerSupportTicket> getTicketById(Long id) {
        return repository.findById(id);
    }

    // Update
    public CustomerSupportTicket updateTicket(Long id, CustomerSupportTicket updatedTicket) {
        return repository.findById(id).map(ticket -> {
            ticket.setOrderId(updatedTicket.getOrderId());
            ticket.setQuery(updatedTicket.getQuery());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setResolvedOn(updatedTicket.getResolvedOn());
            ticket.setResolution(updatedTicket.getResolution());
            return repository.save(ticket);
        }).orElse(null);
    }

    // Delete
    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }
}
