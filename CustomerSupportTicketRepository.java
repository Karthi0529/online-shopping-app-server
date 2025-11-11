package com.example.onlineshop.repository;

import com.example.onlineshop.model.CustomerSupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSupportTicketRepository extends JpaRepository<CustomerSupportTicket, Long> {
}
