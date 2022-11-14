package com.bill.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "custombill_id",sequenceName = "custombill_id",initialValue = 1001)
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custombill_id")
    private int billSequenceId;
    private String billerCode;
    private Long consumerNumber;
    private int amount;
    private Date dueDate;
    private String status;


}
