package com.application.codingadventures.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.codingadventures.model.UsersModel;
import com.application.codingadventures.service.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class UserDetailsController {
	@Autowired
	FirebaseInitializer db;
	
	@GetMapping("/getAllUsers")
	public List<UsersModel> getAllUsers() throws InterruptedException, ExecutionException {
		List<UsersModel> userList = new ArrayList<UsersModel>();
		CollectionReference Users =  db.getFirebase().collection("users");
		ApiFuture<QuerySnapshot> querySnapshot = Users.get();
		for(DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
			UsersModel usr = doc.toObject(UsersModel.class);
			userList.add(usr);
		}
		return userList;
	}
	
	@PostMapping("/addUsers")
	public String addUser(@RequestBody UsersModel User ) {
		CollectionReference newUser =  db.getFirebase().collection("users");
		newUser.document(String.valueOf(User.getName())).set(User);
		return "Done";
	}
}
