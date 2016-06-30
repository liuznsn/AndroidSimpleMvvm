package com.example.leoliu.androidsimplemvvm.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repository implements Serializable {

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("owner")
    public Owner owner;


}