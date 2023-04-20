package nuos.dzhurynskyi.web_lw11.bean;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import nuos.dzhurynskyi.web_lw11.dao.HouseDao;
import nuos.dzhurynskyi.web_lw11.entities.House;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Named
@SessionScoped
public class HouseBean implements Serializable {
    @EJB
    private HouseDao houseDao;
    private House house;
    int numberOfApartment;
    double square;
    int floor;
    int numberOfRooms;
    int minFloor;
    int maxFloor;
    String street;
    @PostConstruct
    public void init(){
        house=new House();
        numberOfApartment=0;
        square=0.0;
        floor=0;
        numberOfRooms=0;
        street="";
        minFloor=0;
        maxFloor=0;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getNumberOfApartment() {
        return numberOfApartment;
    }

    public void setNumberOfApartment(int numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void add() {
        houseDao.add(house);
        house = new House();
    }

    public List<House> findAll() {
        return houseDao.findAll();
    }

    public void delete(int id) {
        houseDao.delete(id);
    }

    public List<House> findByNumberOfRooms(int numberOfRooms) {
        return houseDao.findByNumberOfRooms(numberOfRooms);
    }

    public List<House> findByNumberOfRoomsByFloors(int numberOfRooms, int minFloor, int maxFloor) {
        return houseDao.findByNumberOfRoomsByFloors(numberOfRooms, minFloor, maxFloor);
    }

    public List<House> filterBySquare(double square) {
        return houseDao.filterBySquare(square);
    }

    public List<House> sortBySquare() {
        return houseDao.sortBySquare();
    }

    public List<Integer> listFloors() {
        return houseDao.listFloors();
    }

    public Map<Integer, List<House>> mapFloors() {
        return houseDao.mapFloors();
    }

}
