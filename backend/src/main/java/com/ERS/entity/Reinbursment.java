



@Entity
@Table(name = "reinbursment")
public class Reinbursment {
    
    /**
     * The unique identifier for the reinbursment.
     */
    @Column(name = "reimbId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reimbId;

    /**
     * A brief description of the reimbursement.
     */
    private String description;

    /**
     * Amount of reimbursment.
     */
    private int amount;
    
    /**
     * Status of the reinbursment.
     */
    private String status;
    
    /**
     * Id of user reinbursment belongs to.
     */
    private int userId;

    /**
     * Default constructor for the Reinbursment class.
     * Initializes a new instance of the Reinbursment class.
     */
    public Reinbursment() {
    }

    /**
     * Constructs a new Reinbursment object with the specified description, amount, status, and userId.
     *
     * @param description A brief description of the reimbursement.
     * @param amount The amount of the reimbursement.
     * @param status The current status of the reimbursement.
     * @param userId The ID of the user associated with the reimbursement.
     */

    public Reinbursment(String description, int amount, String status, int userId) {
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns a string representation of the Reinbursment object.
     * The string representation includes the description, amount, status, and userId fields.
     *
     * @return a string representation of the Reinbursment object
     */
    @Override
    public String toString() {
        return "Reinbursment{" +
                "description=" + description + '\\' +
                "amount" + amount + '\\' +
                "status" + status + '\\' +
                "userId" + userId + '\\' +
                '}';
    }

}
