package com.application.codingadventures.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {
	
	@PostConstruct
	private void initDB() throws IOException {
		InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./codingadventures-48a78-firebase-adminsdk-3gvm7-b8e88806b2.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://codingadventures-48a78-default-rtdb.firebaseio.com")
				  .build();
				FirebaseApp.initializeApp(options);
	}
	
	public Firestore getFirebase() {
		
		return FirestoreClient.getFirestore();
	}
	
}
