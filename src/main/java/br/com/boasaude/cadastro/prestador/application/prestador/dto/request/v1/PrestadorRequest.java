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
	
	@ApiModelProperty(notes = "Tipo do prestador",name="tipo",required=true,value="Teste Tipo prestador")
	private String tipo;

	@ApiModelProperty(notes = "Telefone do prestador",name="telefone",required=true,value="Teste telefone")
	private String telefone;

	@ApiModelProperty(notes = "Status do prestador",name="status",required=true,value="Status prestador")
	private String status;
	
	@ApiModelProperty(notes = "Conselho Profissional do prestador",name="conselho",required=true,value="Conselho Profissional")
	private String conselho;
	
	@ApiModelProperty(notes = "Numero no conselho do prestador",name="numeroConselho",required=true,value="Numero no conselho")
	private String numeroNoConselho;
	
	@ApiModelProperty(notes = "CBOS do prestador",name="cbos",required=true,value="CBOS")
	private String cbos;
	
	@ApiModelProperty(notes = "CNES do prestador",name="cnes",required=true,value="CNES")
	private String cnes;

}
