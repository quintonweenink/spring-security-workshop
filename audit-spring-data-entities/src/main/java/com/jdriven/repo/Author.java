package com.jdriven.repo;

import java.util.Date;

import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true, of = {})
@ToString(callSuper = true)
public class Author extends AbstractPersistable<Long> {
	private String name;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
}
