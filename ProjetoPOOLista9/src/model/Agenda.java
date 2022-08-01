package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agenda {
	private String usuario;
	private int ano;
	private List<Compromisso> compromissos;
	
	public Agenda() {
		this.compromissos = new ArrayList<Compromisso>();
	}
	
	public Agenda(String usuario, int ano) {
		this.usuario = usuario;
		this.ano = ano;
		this.compromissos = new ArrayList<Compromisso>();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}


	public List<Compromisso> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}
	@Override
	public String toString() {
		return "Agenda [usuario=" + usuario + ", ano=" + ano + ", compromissos=" + compromissos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, compromissos, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return ano == other.ano && Objects.equals(compromissos, other.compromissos)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
	
	public String AdicionarCompromisso(Compromisso compromissos) {
		if(this.compromissos.add(compromissos)) {
			return Situacao.ADD;
		}else {
			return Situacao.NADD;
		}
	}
	
	public String RemoverCompromisso(int dia, int mes) {
		String retorno = "";
		if (getSizeList()) {
			
			List<Compromisso> c1 = new ArrayList<Compromisso>();
			c1.addAll(compromissos);
			for(Compromisso c : c1){
				
				if (c.getDia() == dia && c.getMes() == mes){
				
					retorno  = removeHotList(c);
				}
			}
		} else {
			retorno = Situacao.LISTVAZIA;
		}
		return retorno;
	}
	
	private String removeHotList(Compromisso c) {
		this.compromissos.remove(c);
		return Situacao.REMOVER;
	}
		
	public boolean getSizeList() {
		if(!this.compromissos.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
	
	

