package com.bill.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "custom_id",sequenceName = "custom_id",initialValue = 101)
public class RegisteredBillers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custom_id")
    private int billerSequenceId;
    private String billerCode;
    private Long consumerNumber;
    private int accountNumber;
    private boolean autoPay;
    private int autoPayLimit;

}
