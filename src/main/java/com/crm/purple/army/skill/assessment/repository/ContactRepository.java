package com.crm.purple.army.skill.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.purple.army.skill.assessment.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
