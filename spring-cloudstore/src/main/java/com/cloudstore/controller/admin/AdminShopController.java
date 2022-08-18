package com.cloudstore.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cloudstore.entity.ShopEntity;
import com.cloudstore.service.admin.AdminShopServiceInterface;


public class AdminShopController {

	@Autowired
	private AdminShopServiceInterface adminShopService;

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/admin/shops")
	public List<ShopEntity> shopInfo() {
		List<ShopEntity> shops = adminShopService.findAllShops();
		return shops;
	}

	protected Object addShopUser() {
		return null;
	}

	protected Object editShopUser() {
		return null;
	}

	@CrossOrigin("http://localhost:3000")
	@DeleteMapping("/admin/shops")
	public String disableShops(@RequestBody String[] emails) {
		adminShopService.disableShops(emails);

		return "SUCCESSFULLY DISABLED: \n" + emails;
	}

}