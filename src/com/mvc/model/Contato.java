package com.mvc.model;

import javax.persistence.*;

@Entity
@Table(name="contato")
public class Contato {
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue
	private Integer id;
	@Column(name="nome", length=64,nullable=false)
	private String nome;
	@Column(name="telefone", length=64,nullable=false)
	private String telefone;
	@Column(name="email", length=64,nullable=false)
	private String email;
	
	public Contato(){
		
	}
	
	public Contato(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
