package hotel.booking.controller;

import hotel.booking.entity.Reservation;
import hotel.booking.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getBookings() {
        return service.getAllReservations();
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Reservation reservation) {

        try {
            Reservation newReservation = service.addReservation(reservation);
            return ResponseEntity.ok(newReservation);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
