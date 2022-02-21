package co.com.poli.servicebookings.entities;

import co.com.poli.servicebookings.model.Movies;
import co.com.poli.servicebookings.model.Showtimes;
import co.com.poli.servicebookings.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "showtime_id")
    private Long showtimeId;

    @Column(name = "moviesid")
    private Long moviesid;

    @Transient
    private Users users;

    @Transient
    private Showtimes showtimes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bookings_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<BookingsItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(id, bookings.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
