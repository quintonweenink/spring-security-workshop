package com.jdriven.repo;

import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.AbstractAuditable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true, of = {})
@ToString(callSuper = true)
public class Blogpost extends AbstractAuditable<Author, Long> {

	private String title;
	private String content;
	private boolean published;

}
