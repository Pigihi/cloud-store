package com.cloudstore.service.authentication;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudstore.entity.CustomerEntity;
import com.cloudstore.entity.ShopEntity;
import com.cloudstore.entity.UserAuthenticationEntity;
import com.cloudstore.entity.VerificationTokenEntity;
import com.cloudstore.model.UserRegistrationModel;
import com.cloudstore.repository.CustomerRepository;
import com.cloudstore.repository.ShopRepository;
import com.cloudstore.repository.UserAuthenticationRepository;
import com.cloudstore.repository.VerificationTokenRepository;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationServiceInterface {

	// TODO How to prevent multiple registration attack. How about using captcha
	// similar to that of binance

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserAuthenticationRepository userAuthenticationRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public UserAuthenticationEntity registerUser(UserRegistrationModel userRegistrationModel) {
		UserAuthenticationEntity user = new UserAuthenticationEntity();
		user.setFullName(userRegistrationModel.getFullName());
		user.setEmail(userRegistrationModel.getEmail());
		user.setPassword(passwordEncoder.encode(userRegistrationModel.getPassword()));
		user.setRole(userRegistrationModel.getRole());

		userAuthenticationRepository.save(user);
		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, UserAuthenticationEntity user) {
		VerificationTokenEntity verificationTokenEntity = new VerificationTokenEntity(user, token);
		verificationTokenRepository.save(verificationTokenEntity);
	}

	@Override
	public String validateVerificationToken(String token) {
		VerificationTokenEntity verificationTokenEntity = verificationTokenRepository.findByToken(token);
		if (verificationTokenEntity == null) {
			return "invalid";
		}
		UserAuthenticationEntity user = verificationTokenEntity.getUser();
		Calendar calendar = Calendar.getInstance();

		if (verificationTokenEntity.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0) {
			// TODO Provide option for regenerating verification token
			verificationTokenRepository.delete(verificationTokenEntity);
			return "expired";
		}

		user.setEnabled(true);
		userAuthenticationRepository.save(user);
		verificationTokenRepository.delete(verificationTokenEntity);
		return "valid";

	}

	@Override
	public void saveToDB(String token) {
		//TODO The below statement won't work as intended because the token is already deleted from the db (as soon as the token is validated)
		VerificationTokenEntity verificationTokenEntity = verificationTokenRepository.findByToken(token);
		UserAuthenticationEntity user = verificationTokenEntity.getUser();
		if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setFullName(user.getFullName());
			customerEntity.setEmail(user.getEmail());
			customerEntity.setRole(user.getRole());

			customerRepository.save(customerEntity);
		} else if (user.getRole().equalsIgnoreCase("SHOP")) {
			ShopEntity shopEntity = new ShopEntity();
			shopEntity.setFullName(user.getFullName());
			shopEntity.setEmail(user.getEmail());
			shopEntity.setRole(user.getRole());

			shopRepository.save(shopEntity);
		}
		// TODO Auto-generated method stub

	}

}
