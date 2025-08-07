package day25;

interface USCharger {
    void chargeWithFlatPins();
}

class EuropeanCharger {
    void chargeWithRoundPins() {
        System.out.println("Charging with European round pins at 220V");
    }
}

class ChargerAdapter implements USCharger {
    private EuropeanCharger europeanCharger;

    public ChargerAdapter(EuropeanCharger europeanCharger) {
        this.europeanCharger = europeanCharger;
    }

    @Override
    public void chargeWithFlatPins() {
        // Convert the interface
        System.out.println("Adapter converting flat pins to round pins...");
        europeanCharger.chargeWithRoundPins();
    }
}
public class Task02 {
    public static void main(String[] args) {
        EuropeanCharger euroCharger = new EuropeanCharger();
        USCharger adapter = new ChargerAdapter(euroCharger);

        // Charge using US plug (but internally uses European charger)
        adapter.chargeWithFlatPins();
    }
}
