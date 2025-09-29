package com.example.mobilestore.service;

import java.util.List;

import com.example.mobilestore.dto.mobileDTO;

public interface MobileService {
    List<mobileDTO> getAllmobiles();
    mobileDTO getmobileById(Long id);
    mobileDTO createmobile(mobileDTO mobileDTO);
    mobileDTO updatemobile(Long id, mobileDTO mobileDTO);
    boolean deletemobile(Long id);
    List<mobileDTO> searchmobilesByName(String name);
    List<mobileDTO> searchmobilesByPrice(Double price);
    List<mobileDTO> searchmobilesByBrand(String brand);
    List<mobileDTO> searchmobiles(String name, Double price, String brand);
}
