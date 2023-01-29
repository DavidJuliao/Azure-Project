package com.azureproject.Azure.Project.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserData implements Serializable {
    private String userName;
    private String password;

}
