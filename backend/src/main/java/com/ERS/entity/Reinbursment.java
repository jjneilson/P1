package com.ERS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reinbursment")
public class Reinbursment {
    
    /*
     * The unique identifier for the reinbursment.
     */
    @Column(name = "reimbursmentid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reimbursmentid;

    /*
     * A brief description of the reimbursement.
     */
    @Column
    private String description;

    /*
     * Amount of reimbursment.
     */
    @Column
    private int amount;
    
    /*
     * Status of the reinbursment.
     */
    @Column
    private String status;
    
    /*
     * Id of user reinbursment belongs to.
     */
    @Column
    private int userid;

    /*
     * Default constructor for the Reinbursment class.
     * Initializes a new instance of the Reinbursment class.
     */
    public Reinbursment() {
    }

    /*
     * Constructs a new Reinbursment object with the specified description, amount, status, and userid.
     *
     * @param description A brief description of the reimbursement.
     * @param amount The amount of the reimbursement.
     * @param status The current status of the reimbursement.
     * @param userid The ID of the user associated with the reimbursement.
     */

    public Reinbursment(int reimbursmentid,String description, int amount, String status, int userid) {
        this.reimbursmentid = reimbursmentid;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.userid = userid;
    }

    public int getreimbursmentid() {
        return reimbursmentid;
    }

    public void setreimbursmentid(int reimbursmentid) {
        this.reimbursmentid = reimbursmentid;
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

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    /*
     * Returns a string representation of the Reinbursment object.
     * The string representation includes the description, amount, status, and userid fields.
     *
     * @return a string representation of the Reinbursment object
     */
    @Override
    public String toString() {
        return "Reinbursment{" +
                "description=" + description + '\'' +
                "amount" + amount + '\'' +
                "status" + status + '\'' +
                "userid" + userid + '\'' +
                '}';
    }

}
