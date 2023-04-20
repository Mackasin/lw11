package nuos.dzhurynskyi.web_lw11.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import nuos.dzhurynskyi.web_lw11.entities.House;

import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class HouseDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void add(House house) {

        em.persist(house);
        em.flush();
    }

    public List<House> findAll() {
        return em.createNamedQuery("House.findAll", House.class).getResultList();
    }

    public void delete(int id) {
        Query query = em.createNamedQuery("House.deleteById");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<House> findByNumberOfRooms(int numberOfRooms) {
        TypedQuery<House> query = em.createNamedQuery("House.findByNumberOfRooms", House.class);
        query.setParameter("numberOfRooms", numberOfRooms);
        return query.getResultList();
    }

    public List<House> findByNumberOfRoomsByFloors(int numberOfRooms, int minFloor, int maxFloor) {
        TypedQuery<House> query = em.createNamedQuery("House.findByNumberOfRoomsByFloors", House.class);
        query.setParameter("numberOfRooms", numberOfRooms);
        query.setParameter("minFloor", minFloor);
        query.setParameter("maxFloor", maxFloor);
        return query.getResultList();
    }

    public List<House> filterBySquare(double square) {
        TypedQuery<House> query = em.createNamedQuery("House.filterBySquare", House.class);
        query.setParameter("square", square);
        return query.getResultList();
    }

    public List<House> sortBySquare() {
        TypedQuery<House> query = em.createNamedQuery("House.sortBySquare", House.class);
        return query.getResultList();
    }

    public List<Integer> listFloors() {
        TypedQuery<Integer> query = em.createNamedQuery("House.listFloors", Integer.class);
        return query.getResultList().stream().sorted((o1, o2) -> -o1.compareTo(o2)).distinct().toList();
    }

    private List<House> listByFloor(int floor){
        TypedQuery<House> query=em.createNamedQuery("House.listByFloor", House.class);
        query.setParameter("floor", floor);
        return query.getResultList();
    }

    public Map<Integer, List<House>> mapFloors() {
        List<Integer> floors=listFloors();
        Map<Integer,List<House>> listMap=new HashMap<>();

        for (Integer f: floors) {
            List<House> houses=listByFloor(f);
            listMap.put(f,houses);
        }
        return listMap;
    }
}
