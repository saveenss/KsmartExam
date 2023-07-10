package com.employeeproject.employeeproject.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tr_employee")

public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "EmpID")
    @NotNull
    private int empID;

    @Column(name = "EmpName")
    @NotNull
    private String name ;
     @Column(name = "EmpPhone")
    @NotNull
    private String phone;
    @Past(message = "Birth date must be past date")
    @Column(name = "EmpDob")
    @NotNull
    private Date dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "empID")
    private address address;

    
}
