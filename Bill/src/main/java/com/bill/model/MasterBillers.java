package com.bill.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MasterBillers {
    @Id
    private String billerCode;
    private String name;
}
