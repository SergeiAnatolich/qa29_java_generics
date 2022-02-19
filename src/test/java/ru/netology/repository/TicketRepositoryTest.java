package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);

    @Test
    void shouldSave() {
        repository.save(ticket1);
        repository.save(ticket2);

        Ticket[] expected = new Ticket[]{ticket1, ticket2};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveTicketRepeatedId() {
        repository.save(ticket1);

        assertThrows(AlreadyExistsException.class, () -> repository.save(ticket1));
    }

    @Test
    void shouldRemoveById() {
        repository.save(ticket1);
        repository.save(ticket2);

        repository.removeById(1);

        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveByIdNotId() {
        repository.save(ticket1);
        repository.save(ticket2);

        assertThrows(NotFoundException.class, () -> repository.removeById(3));
    }

    @Test
    void shouldFindById() {
        repository.save(ticket1);
        repository.save(ticket2);

        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = repository.findById(2);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        repository.save(ticket1);
        repository.save(ticket2);

        Ticket[] expected = null;
        Ticket[] actual = repository.findById(3);

        assertArrayEquals(expected, actual);
    }
}