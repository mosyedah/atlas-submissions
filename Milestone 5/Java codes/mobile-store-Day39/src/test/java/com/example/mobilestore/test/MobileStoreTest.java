package com.example.mobilestore.test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mobilestore.dto.mobileDTO;
import com.example.mobilestore.entity.Mobile;
import com.example.mobilestore.repo.MobileRepository;
import com.example.mobilestore.service.impl.MobileServiceImpl;


@ExtendWith(MockitoExtension.class)
public class MobileStoreTest {
	
	@Mock
	private MobileRepository mobileRepository;
	
	@InjectMocks
	private MobileServiceImpl mobileService;
	
	@Test
	void testListAllMobiles() {
		Mobile mobile = new Mobile();
		mobile.setBrand("Samsung");
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		when(mobileRepository.findAll()).thenReturn(mobiles);
		
		List<mobileDTO> mobilesDtos = mobileService.getAllmobiles();
		assertNotNull(mobilesDtos);
	}
	
}
