package co.com.poli.servicemovies.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @NotEmpty(message = "El nit/numero no puede ser vacio")

    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name = "title")
    private String title;

    @Email(message = "El nombre no puede ser vacio")
    @Column(name = "director")
    private String director;

    @Column(name = "rating")
    private String rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
