package br.com.fiap.cp1.controller;

import br.com.fiap.cp1.dto.ProductRequest;
import br.com.fiap.cp1.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@Tag(name = "Products", description = "Operações relacionadas ao cadastro de produtos")
public interface ProductApi {

    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<ProductResponse>> getAll();

    @Operation(summary = "Buscar produto por ID", description = "Retorna os dados de um produto específico com base no ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{idProduct}")

    ResponseEntity<ProductResponse> getById(@PathVariable Long idProduct);


    @Operation(summary = "Cadastrar novo produto", description = "Cria um novo produto com os dados fornecidos.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do produto")
    })
    @PostMapping
    ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request);


    @Operation(summary = "Atualizar dados do produto", description = "Atualiza as informações de um produto existente com base no ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{idProduct}")
    ResponseEntity<ProductResponse> update(
            @PathVariable Long idProduct,
            @Valid @RequestBody ProductRequest request);


    @Operation(summary = "Excluir produto", description = "Remove um produto existente com base no ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{idProduct}")
    ResponseEntity<Void> delete(@PathVariable Long idProduct);
}