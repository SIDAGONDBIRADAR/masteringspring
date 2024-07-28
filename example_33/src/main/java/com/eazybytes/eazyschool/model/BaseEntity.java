package com.eazybytes.eazyschool.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@CreatedBy
	@Column(updatable = false)
	@JsonIgnore
	private String createdBy;
	@CreatedDate
	@JsonIgnore
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedBy
	@Column(insertable = false)
	@JsonIgnore
	private String updatedBy;

	@LastModifiedDate
	@Column(insertable = false)
	@JsonIgnore
	private LocalDateTime updatedAt;

}
