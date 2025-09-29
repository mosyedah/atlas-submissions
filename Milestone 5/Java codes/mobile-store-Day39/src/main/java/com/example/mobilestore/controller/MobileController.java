package com.example.mobilestore.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobilestore.dto.mobileDTO;
import com.example.mobilestore.service.MobileService;

@RestController
@RequestMapping("/mobiles")

public class MobileController {
	private final MobileService mobileService;

	@Autowired
	public MobileController(MobileService mobileService) {
		this.mobileService = mobileService;
	}

	@PostMapping
	public ResponseEntity<mobileDTO> createmobile(@Valid @RequestBody mobileDTO mobileDTO) {
		mobileDTO savedmobile = mobileService.createmobile(mobileDTO);
		return new ResponseEntity<>(savedmobile, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<mobileDTO> getmobileById(@PathVariable("id") Long id) {
		mobileDTO mobileDTO = mobileService.getmobileById(id);
		return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<mobileDTO>> getAllmobiles() {
		List<mobileDTO> mobiles = mobileService.getAllmobiles();
		return new ResponseEntity<>(mobiles, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<mobileDTO> updatemobile(@PathVariable("id") Long id,
			@Valid @RequestBody mobileDTO mobileDTO) {
		mobileDTO updatedmobile = mobileService.updatemobile(id, mobileDTO);
		return new ResponseEntity<>(updatedmobile, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletemobile(@PathVariable("id") Long id) {
		mobileService.deletemobile(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/search")
	public ResponseEntity<List<mobileDTO>> searchmobiles(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "price", required = false) Double price,
			@RequestParam(value = "brand", required = false) String brand) {
		List<mobileDTO> mobiles = mobileService.searchmobiles(name, price, brand);
		return new ResponseEntity<>(mobiles, HttpStatus.OK);
	}
}