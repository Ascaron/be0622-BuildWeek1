package it.gestionebiglietti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="oggetto_da_vidimare")
@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OggettoDaVidimare {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String codUnivoco;
	/*@ManyToOne
	@JoinTable(name= "erogatoreservizi_servizioerogato",
	joinColumns = {@JoinColumn(name="id_oggetto_da_vidimare", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="id_biglietteria", referencedColumnName = "id")})
	private Biglietteria biglietteria;*/
	
	public OggettoDaVidimare(String codUnivoco) {
		this.codUnivoco=codUnivoco;
		//this.biglietteria=biglietteria;
	}
}
