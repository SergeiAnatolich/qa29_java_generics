package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(9, 2199, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 1599, "DME", "AER", 155);
    private Ticket ticket4 = new Ticket(25, 2399, "VKO", "AER", 200);
    private Ticket ticket5 = new Ticket(11, 999, "SVO", "KZN", 60);
    private Ticket ticket6 = new Ticket(2, 1599, "AER", "DME", 150);
    private Ticket ticket7 = new Ticket(66, 2700, "SVO", "KZN", 150);
    private Ticket ticket8 = new Ticket(28, 1599, "SVO", "KZN", 90);
    private Ticket ticket9 = new Ticket(31, 2000, "SVO", "KZN", 20);
    private Ticket ticket10 = new Ticket(7, 1000, "SVO", "KZN", 91);
    private Ticket ticket11 = new Ticket(6, 1599, "AER", "DME", 150);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
    }

    @Test
    void shouldAdd() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10,ticket11};
        Ticket[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllWithAirports() {
        Ticket[] expected = new Ticket[]{ticket5, ticket10, ticket1, ticket8, ticket9, ticket7};
        Ticket[] actual = manager.findAllWithAirports("SVO", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAllWithAirports() {
        Ticket[] expected = null;
        Ticket[] actual = manager.findAllWithAirports("KZN", "VKO");

        assertArrayEquals(expected, actual);
    }
}