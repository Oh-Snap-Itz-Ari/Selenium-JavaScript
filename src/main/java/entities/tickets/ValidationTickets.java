package entities.tickets;

public class ValidationTickets {

    String originCity; // Encapsulamiento para actualizarlarlas y utilizarlas cuando se necesiten
    String destinyCity;

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public void setDestinyCity(String destinyCity) {
        this.destinyCity = destinyCity;
    }

}