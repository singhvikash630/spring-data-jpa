package com.jpa.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String name;

	@ManyToMany(mappedBy = "tags")
	private List<Post> posts = new ArrayList<>();

	public Tag(String name) {
		this.name = name;
	}

}
