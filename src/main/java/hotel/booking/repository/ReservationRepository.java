package hotel.booking.repository;

import hotel.booking.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {

    private final List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> findAll() {
        return reservations;
    }

    public void save(Reservation reservation) {
        reservations.add(reservation);
    }
}
