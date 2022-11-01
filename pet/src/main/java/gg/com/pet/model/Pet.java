package gg.com.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pet")
public class Pet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

	@NotBlank(message = "O nome é obrigatório")
    @Column(name = "name",length = 255,nullable = false)
    private String name;

	@NotBlank(message = "A idade é obrigatória")
    @Column(name = "age",length = 255,nullable = false)
    private String age;

	@NotBlank(message = "A raça é obrigatória")
    @Column(name = "dogbreed",length = 255,nullable = true)
    private String dogbreed;
    
	@Column(columnDefinition="TEXT", name = "url",nullable = true)
    private String  url;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getDogbreed() {
		return dogbreed;
	}


	public void setDogbreed(String dogbreed) {
		this.dogbreed = dogbreed;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	

    
    
    
}
