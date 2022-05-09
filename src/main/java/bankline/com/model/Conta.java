package bankline.com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable

public class Conta {
	
	@Column(name = "conta_numero")
	private Long numero;
	@Column(name = "conta_saldo")
	private Double saldo;
}
