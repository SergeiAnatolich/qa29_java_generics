package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket newTicket) {
        if (tickets.length == 0) {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            System.arraycopy(tickets, 0, tmp, 0, tickets.length);
            tmp[tmp.length - 1] = newTicket;
            tickets = tmp;
        } else {
            if (findById(newTicket.getId()) != null) {
                throw new AlreadyExistsException("Ticket with id: " + newTicket.getId() + " already exists");
            } else {
                Ticket[] tmp = new Ticket[tickets.length + 1];
                System.arraycopy(tickets, 0, tmp, 0, tickets.length);
                tmp[tmp.length - 1] = newTicket;
                tickets = tmp;
            }
        }
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int index = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() != id) {
                    tmp[index] = ticket;
                    index++;
                }
            }
            tickets = tmp;
        } else {
            throw new NotFoundException("Ticket with id: " + id + " not found");
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] findById(int id) {
        Ticket[] findTicket = new Ticket[1];
        for (Ticket ticket : tickets) {
            if (id == ticket.getId()) {
                findTicket[0] = ticket;
                return findTicket;
            }
        }
        return null;
    }
}
