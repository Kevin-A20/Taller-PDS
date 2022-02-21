package co.com.poli.servicebookings.entities;

import co.com.poli.servicebookings.model.Movies;
import co.com.poli.servicebookings.model.Showtimes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "bookings_items")
public class BookingsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Positive(message = "La cantidad debe ser mayor que cero")
    @Column(name = "quantity")
    private Double quantity;

    @Positive(message = "El precio debe ser mayor que cero")
    @Column(name = "price")
    private Double price;



    @Column(name = "movies_id")
    private Long movies_id;

    @Transient
    private Movies movies;

    @Transient
    private Showtimes showtimes;

    @Transient
    private Double subTotal;

    public Double getSubTotal(){
        if(this.price>0 && this.quantity>0){
            return this.quantity*this.price;
        }else{
            return (double) 0;
        }
    }

    public BookingsItem() {
        this.price = (double) 0;
        this.quantity = (double) 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsItem that = (BookingsItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
