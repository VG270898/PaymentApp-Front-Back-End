package com.bill.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransaction {
    @Id
    private UUID transactionReference;

    private int sequenceId;
    private Date dateTime;
    private double amount;
    private String action;
    private String description;
    private int billReferenceNumber;
}
