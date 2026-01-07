package Models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private int id;
    private  String status;
    private BigDecimal totalAmount;
    private int userId;
    private int customerId;

    public static ArrayList<Order> ordersList = new ArrayList<>();

    /**
     * Constructeur complet d'une commande
     * @param id
     * @param status: statut de la commande
     * @param totalAmount: prix total
     * @param userId: identifiant de l'utilisateur
     * @param customerId: identifiant du client
     */
    public Order(int id, String status, BigDecimal totalAmount, int userId, int customerId) {
        this.id = id;
        this.status = status;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.customerId = customerId;
        ordersList.add(this);
    }

    /**
     * Constructeur utilitaire pour créer un objet Order
     * @param status: statut de la commande
     * @param totalAmount: prix total
     * @param userId: identifiant de l'utilisateur
     * @param customerId: identifiant du client
     */
    public Order(String status, BigDecimal totalAmount, int userId, int customerId) {
        this.status = status;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", userId=" + userId +
                ", customerId=" + customerId +
                '}';
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal totalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int userId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int customerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
