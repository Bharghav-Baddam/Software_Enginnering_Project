package com.buddyfinder.main.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Advertisement;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.repository.AdvertisementRepository;

@Service
public class CommercialService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AdvertisementRepository advertisementRepository;
	
	public void saveImageFile(Account owner, MultipartFile file) {
		try {
		Byte[] byteObjects = new Byte[file.getBytes().length];
		
		int i = 0;
		for(byte b: file.getBytes()) {
			byteObjects[i++] = b;
		}
		
		Advertisement advertisement = new Advertisement(byteObjects);
		advertisementRepository.save(advertisement);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<String> getImages() {
		ArrayList<Advertisement> list = (ArrayList<Advertisement>) advertisementRepository.findAll();
		ArrayList<String> imgLinks = new ArrayList<>();
		list.forEach(x->{
			
			 Byte[] BYTE = x.getImage();
			 byte[] byteArr = new byte[BYTE.length];
			 int j = 0;
			 for(Byte b : BYTE) {
				 byteArr[j++] = b.byteValue();
			 }
			 String url = Base64.getEncoder().encodeToString(byteArr);
			 imgLinks.add(url);
		});
		return imgLinks;
	}
}
