package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int flyTime;

    public Ticket() {
    }

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, int flyTime) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public int compareTo(Ticket o) {
        Ticket ticket = (Ticket) o;
        return this.cost - ticket.cost;
    }
}
