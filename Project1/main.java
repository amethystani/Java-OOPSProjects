import java.util.*;

class Item {
String name;
double pricePerUnit;
double quantity;
boolean isPerishable;

Item(String name, double pricePerUnit, double quantity, boolean isPerishable) {
this.name = name;
this.pricePerUnit = pricePerUnit;
this.quantity = quantity;
this.isPerishable = isPerishable;
}

double getShippingCost() {
if (isPerishable) {
return quantity > 5 ? (quantity - 5) * 5 : 0;
} else {
return quantity > 4 ? (quantity - 4) * 2 : 0;
}
}
}

class Cart {
List<Item> items = new ArrayList<>();

void addItem(Item item) {
items.add(item);
}

List<Item> getItems() {
return items;
}
}

class Store {
Cart cart = new Cart();
Map<String, Item> inventory = new HashMap<>();

void addItemToInventory(Item item) {
inventory.put(item.name, item);
}

void addItemToCart(String itemName, double quantity) {
Item item = inventory.get(itemName);
if (item != null) {
cart.addItem(new Item(item.name, item.pricePerUnit, quantity, item.isPerishable));
}
}
double calculateShippingCost() {
        double totalShippingCost = 0;
        double totalPerishableWeight = 0;
        double totalNonPerishableVolume = 0;
        for (Item item : cart.getItems()) {
            if (item.isPerishable) {
                totalPerishableWeight += item.quantity;
            } else {
                totalNonPerishableVolume += item.quantity;
            }
        }
        if (totalPerishableWeight > 5) {
            totalShippingCost += (totalPerishableWeight - 5) * 5;
        }
        if (totalNonPerishableVolume > 4) {
            totalShippingCost += (totalNonPerishableVolume - 4) * 2;
        }
        return totalShippingCost;
    }
void checkout() {
        double total = 0;
        double shippingCost = calculateShippingCost();

        for (Item item : cart.getItems()) {
            double cost = item.pricePerUnit * item.quantity;
            total += cost;
        }
        total += shippingCost;
        System.out.println("Shipping " + shippingCost);
        System.out.println("Total: " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String itemName = scanner.next();
            if (itemName.equals("End")) break;

            double pricePerUnit = scanner.nextDouble();
            boolean isPerishable = scanner.nextBoolean();

            store.addItemToInventory(new Item(itemName, pricePerUnit, 1, isPerishable));
        }
        while (true) {
            String itemName = scanner.next();
            if (itemName.equals("Checkout")) break;

            double quantity = scanner.nextDouble();
            store.addItemToCart(itemName, quantity);
        }
        store.checkout();
    }
}
