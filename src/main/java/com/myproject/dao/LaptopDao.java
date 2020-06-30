package com.myproject.dao;

import com.myproject.pojo.Laptop;

import java.sql.SQLException;
import java.util.List;

/**
 * LaptopDao.
 *
 * @author Roman Khokhlov
 */
public interface LaptopDao {
    boolean addLaptop(Laptop laptop);

    Laptop getLaptopById(Integer id);

    void createTable();

    List<Laptop> getAllLaptop();
}