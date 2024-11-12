package com.june.yorushika_java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Announcement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;
    public Date created_date;
}
