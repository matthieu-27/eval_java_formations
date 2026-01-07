package Models;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe représentant un panier d'achat
 * @author Matthieu Couderc
 * @version 1.0
 */
public class Cart {
    private int userId;
    private ArrayList<Course> items;

    public static ArrayList<Cart> cartsList = new ArrayList<>();

    /**
     * Constructeur pour un panier
     * @param userId: identifiant de l'utilisateur propriétaire
     */
    public Cart(int userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
        cartsList.add(this);
    }

    /**
     * Ajoute un article au panier
     * @param course: la formation à ajouter
     */
    public void addItem(Course course) {
        // Vérifier si l'article existe déjà
        for (Course item : items) {
            if (item.id() == course.id()) {
                return;
            }
        }
        items.add(new Course(course.name(), course.description(), course.duration(), course.type(), course.price()));
    }

    /**
     * Retire un article du panier
     * @param course: la formation à retirer
     */
    public void removeItem(Course course) {
        items.removeIf(item -> item.id() == course.id());
    }


    /**
     * Calcule le montant total du panier
     * @return BigDecimal représentant le total
     */
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Course item : items) {
            total = total.add(item.price());
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", items=" + items +
                ", total=" + getTotal() +
                '}';
    }

    /* GETTERS AND SETTERS */

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Course> getItems() {
        return items;
    }

    public void setItems(ArrayList<Course> items) {
        this.items = items;
    }
}
