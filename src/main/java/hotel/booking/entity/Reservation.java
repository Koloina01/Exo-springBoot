package hotel.booking.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor    
@AllArgsConstructor
public class Reservation {
    private String clientName;
    private String phoneNumber;
    private String email;
    private int roomNumber;
    private String roomDescription;
    private LocalDate date;
}
