package com.mypack.dao;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entities.Contact;
@Configuration
@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	

}
