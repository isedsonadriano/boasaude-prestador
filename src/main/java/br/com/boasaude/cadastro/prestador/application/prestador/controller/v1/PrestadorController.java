package br.com.boasaude.cadastro.prestador.application.prestador.controller.v1;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.boasaude.cadastro.prestador.application.prestador.dto.request.v1.PrestadorRequest;
import br.com.boasaude.cadastro.prestador.application.prestador.dto.response.v1.PrestadorResponse;
import br.com.boasaude.cadastro.prestador.core.domain.entity.Prestador;
import br.com.boasaude.cadastro.prestador.core.service.PrestadorService;
import br.com.boasaude.cadastro.prestador.core.util.Paginador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("v1/prestadores")
@Api(tags = "/v1/prestadores", value = "API's para manipular prestadores", authorizations = {@Authorization(value="jwtToken")})
@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Retorno para a inclusão de prestador"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Erro de autorização"),
		@ApiResponse(code = 404, message = "Recurso não encontrado")}
)
public class PrestadorController  {

	@Autowired
	private PrestadorService service;
	
	@Autowired
	protected ModelMapper modelMapper;

	
	@ApiOperation(value = "API para salvar um prestador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PrestadorResponse> salvar(@RequestBody @Valid PrestadorRequest prestadorRequest, UriComponentsBuilder uriBuilder) {
		Prestador prestador = buildPrestador(prestadorRequest);
		this.service.salvar(prestador);
		URI uri = uriBuilder.path("{id}").buildAndExpand(prestador.getId()).toUri();
		return ResponseEntity.created(uri).body(buildPrestadorResponse(prestador));
	}
	
	@ApiOperation(value = "API para listar prestadores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	@ResponseBody
	public List<PrestadorResponse> listar(@PageableDefault(sort="id", direction = Direction.DESC) Pageable pageable) {
		 List<Prestador> prestadores = service.capturarTodos(new Paginador(pageable.getOffset(), pageable.getPageNumber(), pageable.getPageSize(), false, false));
		return prestadores.stream().map(this::buildPrestadorResponse).collect(Collectors.toList());
	}

	@ApiOperation(value = "API para capturar prestador por id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<PrestadorResponse> catpurar(@PathVariable Long id) {
		Prestador prestador = service.capturarPorId(id);
		if (Objects.nonNull(prestador)) {
			return ResponseEntity.ok(buildPrestadorResponse(prestador));
		}
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "API para atualizar o prestador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<PrestadorResponse> atualizar(@PathVariable Long id, @RequestBody @Valid PrestadorRequest prestadorRequest, UriComponentsBuilder uriBuilder) {
		Prestador prestador = buildPrestador(prestadorRequest);
		prestador.setId(id);
		this.service.atualizar(prestador);
		return ResponseEntity.ok(buildPrestadorResponse(prestador));
	}

	@ApiOperation(value = "API para deletar um prestador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<PrestadorResponse> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}

	private PrestadorResponse buildPrestadorResponse(Prestador prestador) {
		return modelMapper.map(prestador, PrestadorResponse.class);
	}
	
	private Prestador buildPrestador(PrestadorRequest prestadorRequest) {
		return modelMapper.map(prestadorRequest, Prestador.class);
	}

}
