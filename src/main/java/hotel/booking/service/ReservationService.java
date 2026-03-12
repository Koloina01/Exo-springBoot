package hotel.booking.service;

import hotel.booking.entity.Reservation;
import hotel.booking.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation addReservation(Reservation reservation) {
        if (reservation.getRoomNumber() < 1 || reservation.getRoomNumber() > 9) {
            throw new RuntimeException("Invalid room number, the room number should be between 1 and 9");
        }

        for (Reservation r : repository.findAll()) {
            if (r.getRoomNumber() == reservation.getRoomNumber()
                && r.getDate().equals(reservation.getDate())) {
                throw new RuntimeException("This room is already booked for the selected date");
            }
        }

        repository.save(reservation);
        return reservation;
    }
}
