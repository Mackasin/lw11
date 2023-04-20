package nuos.dzhurynskyi.web_lw11.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
@NamedQueries({
        @NamedQuery(name = "House.findAll", query = "select h from House h"),
        @NamedQuery(name = "House.deleteById", query = "delete from House h where h.id=:id"),
        @NamedQuery(name = "House.findByNumberOfRooms", query = "select h from House h where h.numberOfRooms=:numberOfRooms"),
        @NamedQuery(name = "House.findByNumberOfRoomsByFloors",query = "select h from House h where h.numberOfRooms=:numberOfRooms and h.floor>=:minFloor and h.floor<=:maxFloor"),
        @NamedQuery(name = "House.filterBySquare", query = "select h from House h where h.square>=:square order by h.square desc ,h.floor"),
        @NamedQuery(name = "House.sortBySquare",query = "select h from House h order by h.square"),
        @NamedQuery(name = "House.listFloors",query = "select h.floor from House h"),
        @NamedQuery(name = "House.listByFloor",query = "select h from House h where h.floor=:floor")
})
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numberOfApartment")
    private Integer numberOfApartment;

    @Column(name = "square")
    private Double square;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "numberOfRooms")
    private Integer numberOfRooms;

    @Column(name = "street", length = 45)
    private String street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfApartment() {
        return numberOfApartment;
    }

    public void setNumberOfApartment(Integer numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}