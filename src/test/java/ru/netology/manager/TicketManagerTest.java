package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 1599, "DME", "AER", 155);
    private Ticket ticket4 = new Ticket(4, 2399, "VKO", "AER", 200);
    private Ticket ticket5 = new Ticket(5, 999, "SVO", "KZN", 60);
    private Ticket ticket6 = new Ticket(6, 1599, "AER", "DME", 150);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    void shouldAdd() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllWithAirports() {
        TicketByPriceAscComparator flyTime = new TicketByPriceAscComparator();
        Ticket[] expected = new Ticket[]{ticket5, ticket1};
        Ticket[] actual = manager.findAllWithAirports("SVO", "KZN", flyTime);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAllWithAirports() {
        TicketByPriceAscComparator flyTime = new TicketByPriceAscComparator();
        Ticket[] expected = null;
        Ticket[] actual = manager.findAllWithAirports("KZN", "VKO", flyTime);

        assertArrayEquals(expected, actual);
    }
}