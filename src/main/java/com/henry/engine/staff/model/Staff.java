package com.henry.engine.staff.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column
    private String birthPlace;

    @Column
    @JsonFormat(pattern="yyyy-mm-dd")
    private String birthDate;

    @Column
    @NotBlank(message = "Position is mandatory")
    private String position;

    @Column
    @JsonFormat(pattern="yyyy-mm-dd")
    private String dateJoin;

    @Column
    @JsonFormat(pattern="yyyy-mm-dd")
    private String dateResign;

    @Column
    private String salary;

    @Column
    private String address;

    @Column
    private String maritalStatus;

    @Column
    private String education;

    @Column
    @NotBlank(message = "Email is mandatory")
    private String email;
}
