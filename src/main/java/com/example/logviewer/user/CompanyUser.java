package com.example.logviewer.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class CompanyUser implements Serializable {
    @Id
    private String userName;
    private String password;
    private Boolean passwordExpired;
    private String companyId;
}
