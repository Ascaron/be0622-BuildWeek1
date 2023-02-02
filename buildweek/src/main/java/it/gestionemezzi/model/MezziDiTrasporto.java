package it.gestionemezzi.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="mezzi_di_trasporto")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MezziDiTrasporto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private TipoMezzi tipoMezzi;
	@Enumerated(EnumType.STRING)
	private Partenze partenza;
	@Enumerated(EnumType.STRING)
	private Arrivi arrivi;
	private int durataTratta;
	private LocalTime oraPartenza;
	private LocalTime oraArrivo;
	private int capienza;
	
	
}
