package com.example.mobilestore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobilestore.dto.mobileDTO;
import com.example.mobilestore.entity.Mobile;
import com.example.mobilestore.exception.ResourceNotFoundException;
import com.example.mobilestore.repo.MobileRepository;
import com.example.mobilestore.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {
    private final MobileRepository mobileRepository;

    @Autowired
    public MobileServiceImpl(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public List<mobileDTO> getAllmobiles() {
        List<Mobile> mobiles = mobileRepository.findAll();
        return mapmobilesToDTOs(mobiles);
    }

    @Override
    public mobileDTO getmobileById(Long id) {
        Optional<Mobile> optionalmobile = mobileRepository.findById(id);
        if (optionalmobile.isPresent()) {
            Mobile mobile = optionalmobile.get();
            return mapmobileToDTO(mobile);
        }
        throw new ResourceNotFoundException("mobile not found with id: " + id);
    }

    @Override
    public mobileDTO createmobile(mobileDTO mobileDTO) {
        Mobile mobile = mapDTOTomobile(mobileDTO);
        Mobile savedmobile = mobileRepository.save(mobile);
        return mapmobileToDTO(savedmobile);
    }

    @Override
    public mobileDTO updatemobile(Long id, mobileDTO mobileDTO) {
        Optional<Mobile> optionalmobile = mobileRepository.findById(id);
        if (optionalmobile.isPresent()) {
            Mobile mobile = optionalmobile.get();
            mobile.setName(mobileDTO.getName());
            mobile.setPrice(mobileDTO.getPrice());
            mobile.setBrand(mobileDTO.getBrand());
            mobile.setStorage(mobileDTO.getStorage());
            mobile.setRam(mobileDTO.getRam());
            mobile.setProcessor(mobileDTO.getProcessor());

            Mobile updatedmobile = mobileRepository.save(mobile);
            return mapmobileToDTO(updatedmobile);
        }
        throw new ResourceNotFoundException("mobile not found with id: " + id);
    }

    @Override
    public boolean deletemobile(Long id) {
        if (!mobileRepository.existsById(id)) {
        	throw new ResourceNotFoundException("mobile not found with id: " + id);
              }
        mobileRepository.deleteById(id);
        return true;
    }

    @Override
    public List<mobileDTO> searchmobilesByName(String name) {
        List<Mobile> mobiles = mobileRepository.findByName(name);
        return mapmobilesToDTOs(mobiles);
    }

    @Override
    public List<mobileDTO> searchmobilesByPrice(Double price) {
        List<Mobile> mobiles = mobileRepository.findByPrice(price);
        return mapmobilesToDTOs(mobiles);
    }

    @Override
    public List<mobileDTO> searchmobilesByBrand(String brand) {
        List<Mobile> mobiles = mobileRepository.findByBrand(brand);
        return mapmobilesToDTOs(mobiles);
    }

    private mobileDTO mapmobileToDTO(Mobile mobile) {
        mobileDTO mobileDTO = new mobileDTO();
        mobileDTO.setId(mobile.getId());
        mobileDTO.setName(mobile.getName());
        mobileDTO.setPrice(mobile.getPrice());
        mobileDTO.setBrand(mobile.getBrand());
        mobileDTO.setStorage(mobile.getStorage());
        mobileDTO.setRam(mobile.getRam());
        mobileDTO.setProcessor(mobile.getProcessor());
        return mobileDTO;
    }

    private List<mobileDTO> mapmobilesToDTOs(List<Mobile> mobiles) {
        return mobiles.stream()
                .map(this::mapmobileToDTO)
                .collect(Collectors.toList());
    }

    private Mobile mapDTOTomobile(mobileDTO mobileDTO) {
        Mobile mobile = new Mobile();
        mobile.setName(mobileDTO.getName());
        mobile.setPrice(mobileDTO.getPrice());
        mobile.setBrand(mobileDTO.getBrand());
        mobile.setStorage(mobileDTO.getStorage());
        mobile.setRam(mobileDTO.getRam());
        mobile.setProcessor(mobileDTO.getProcessor());
        return mobile;
    }
    
    @Override
    public List<mobileDTO> searchmobiles(String name, Double price, String brand) {
        List<Mobile> mobiles = mobileRepository.findByNameOrPriceOrBrand(name, price, brand);
        return mapmobilesToDTOs(mobiles);
    }
}