package Exercicio01;

public class ContaMapper {

    public ContaDTO toDto(Conta entity) {
       return new ContaDTO(
        entity.getId(),
        entity.getNumeroAgencia(),
        entity.getNumeroConta(),
        entity.getSaldo(),
        entity.getChequeEspecial()
       );
    }
}
