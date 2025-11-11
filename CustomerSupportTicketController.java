package com.example.onlineshop.controller;

import com.example.onlineshop.model.CustomerSupportTicket;
import com.example.onlineshop.service.CustomerSupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:3000") // for React frontend
public class CustomerSupportTicketController {

    @Autowired
    private CustomerSupportTicketService service;

    // Create
    @PostMapping
    public CustomerSupportTicket createTicket(@RequestBody CustomerSupportTicket ticket) {
        return service.createTicket(ticket);
    }

    // Get All
    @GetMapping
    public List<CustomerSupportTicket> getAllTickets() {
        return service.getAllTickets();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Optional<CustomerSupportTicket> getTicketById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    // Update
    @PutMapping("/{id}")
    public CustomerSupportTicket updateTicket(@PathVariable Long id, @RequestBody CustomerSupportTicket updatedTicket) {
        return service.updateTicket(id, updatedTicket);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
        return "Ticket with ID " + id + " deleted successfully!";
    }
}
