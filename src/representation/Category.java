package representation;

import java.util.HashSet;
import java.util.Set;

public class Category {

    Set<Item> items;
    String name;

    public Category( String name) {
        items = new HashSet<>();
        this.name = name;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Set<Item> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return name;
    }
}
