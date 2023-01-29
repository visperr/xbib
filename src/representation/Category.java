package representation;

import java.util.HashSet;
import java.util.Set;

public class Category {

    Set<Item> items;

    public Category() {
        items = new HashSet<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Set<Item> getItems() {
        return this.items;
    }
}
