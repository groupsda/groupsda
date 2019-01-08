package com.sda.project.groupsda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.exception.DataException;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SearchPropertyModel {

    private String destination;
    private Date checkInDate;
    private Date checkOutDate;
    private int rooms;
    private int adults;
    private int children;
}
