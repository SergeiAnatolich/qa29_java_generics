package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAllWithAirports(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] tickets = repository.findAll();
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureAirport() == from & ticket.getArrivalAirport() == to) {
                i++;
            }
        }
        Ticket[] result = new Ticket[i];
        if (i > 0) {
            int j = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getDepartureAirport() == from & ticket.getArrivalAirport() == to) {
                    result[j] = ticket;
                    j++;
                }
            }
        } else {
            result = null;
            return result;
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public Ticket[] findAll() {
        return repository.findAll();
    }
}
