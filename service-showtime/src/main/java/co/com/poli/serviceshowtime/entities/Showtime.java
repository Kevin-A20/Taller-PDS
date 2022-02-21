package co.com.poli.serviceshowtime.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtime")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "la fecha no debe ser vacia")
    @Column(name = "date")
    private String date;

    @Positive(message = "El precio debe ser mayor que cero")
    @Column(name = "movies")
    private String movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Objects.equals(id, showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
