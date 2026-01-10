package JavaHacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface IVehicle {
    void setMake(String make);
    String getMake();
    void setModel(String model);
    String getModel();
    void setYear(int year);
    int getYear();
    void setPrice(int price);
    int getPrice();
}

interface IInventory {
    void addVehicle(IVehicle vehicle);
    void removeVehicle(IVehicle vehicle);
    int calculateTotalValue();
    List<IVehicle> getVehiclesByModel(String model);
    Map<Integer, List<IVehicle>> getVehiclesByYear();
    List<Triple<Integer, Integer, List<IVehicle>>> getVehiclesByYearRange();
}

class Triple<T, U, V> {

    private final T first;
    private final U second;
    private final V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
    public V getThird() { return third; }
}

class Vehicle implements IVehicle {



    private String make;
    private String model;
    private int year;
    private int price;

    public void setMake(String make) { this.make = make; }
    public String getMake() { return make; }

    public void setModel(String model) { this.model = model; }
    public String getModel() { return model; }

    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }

    public void setPrice(int price) { this.price = price; }
    public int getPrice() { return price; }


}

class Inventory implements IInventory {


    private final List<IVehicle> vehicles = new ArrayList<>();

    public void addVehicle(IVehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(IVehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public int calculateTotalValue() {
        return vehicles.stream().mapToInt(IVehicle::getPrice).sum();
    }

    public List<IVehicle> getVehiclesByModel(String model) {
        return vehicles.stream()
                .filter(v -> v.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    public Map<Integer, List<IVehicle>> getVehiclesByYear() {
        return vehicles.stream()
                .collect(Collectors.groupingBy(IVehicle::getYear));
    }

    public List<Triple<Integer, Integer, List<IVehicle>>> getVehiclesByYearRange() {
        List<Triple<Integer, Integer, List<IVehicle>>> result = new ArrayList<>();
        int minYear = vehicles.stream().mapToInt(IVehicle::getYear).min().orElse(0);
        int maxYear = vehicles.stream().mapToInt(IVehicle::getYear).max().orElse(0);

        for (int start = minYear; start <= maxYear; start += 5) {

int end = start + 4;
    final int rangeStart = start;
    final int rangeEnd = end;

    List<IVehicle> rangeVehicles = vehicles.stream()
        .filter(v -> v.getYear() >= rangeStart && v.getYear() <= rangeEnd)
        .collect(Collectors.toList());

    result.add(new Triple<>(rangeStart, rangeEnd, rangeVehicles));

        }

        return result;
    }



}


public class VehicleDetails {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int vCount = Integer.parseInt(br.readLine().trim());

        IInventory inventory = new Inventory();

        for (int i = 0; i < vCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IVehicle e = new Vehicle();
            e.setMake(a[0]);
            e.setModel(a[1]);
            e.setYear(Integer.parseInt(a[2]));
            e.setPrice(Integer.parseInt(a[3]));
            inventory.addVehicle(e);
        }

        String[] b = br.readLine().trim().split(" ");
        List<IVehicle> vehicles = inventory.getVehiclesByModel(b[0]);

        out.println(b[0] + ":");

        for (IVehicle vehicle : vehicles) {
            out.println(vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
        }

        Map<Integer, List<IVehicle>> vehiclesByYear = inventory.getVehiclesByYear();

        for (Map.Entry<Integer, List<IVehicle>> item : vehiclesByYear.entrySet()) {
            out.println(item.getKey());

            for (IVehicle vehicle : item.getValue()) {
                out.println(vehicle.getMake());
            }
        }

        List<Triple<Integer, Integer, List<IVehicle>>> vehiclesByYearRange = inventory.getVehiclesByYearRange();

        for (Triple<Integer, Integer, List<IVehicle>> item : vehiclesByYearRange) {
            out.println(item.getFirst() + "-" + item.getSecond());

            for (IVehicle vehicle : item.getThird()) {
                out.println(vehicle.getMake() + "-" + vehicle.getModel() + "-" + vehicle.getYear());
            }

            if (item.getThird().isEmpty()) {
                out.println("-");
            }
        }

        int totalValue = inventory.calculateTotalValue();
        out.println("Total Value: " + totalValue);
        
        out.flush();
        out.close();



	}

}
