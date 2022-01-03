package br.com.boasaude.cadastro.prestador.application.prestador.dto.request.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrestadorRequest {

	@ApiModelProperty(notes = "Nome do prestador",name="nome",required=true,value="Teste nome")
	private String nome;
	
	@ApiModelProperty(notes = "Cnpj do prestador",name="cnpj",required=true,value="Teste cnpj")
	private String cnpj;
	
	@ApiModelProperty(notes = "Cpf do prestador",name="cpf",required=true,value="Teste Cpf")
	private String cpf;
	
	@ApiModelProperty(notes = "Razao Social do prestador",name="razaoSocial",required=true,value="Teste Razao social")
	private String razaoSocial;

	@ApiModelProperty(notes = "Tipo do prestador",name="tipo",required=true,value="Teste Tipo prestador")
	private String tipo;

}
