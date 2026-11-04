package Exercicio02;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BancoEmMemoria {

 private final Map<String, CarroEntity> mapaDecarros = new ConcurrentHashMap<>();

    public CarroEntity salvar(CarroEntity carro) {
        if (carro == null) {
            throw new IllegalArgumentException("Não é possível salvar um carro nulo.");
        }

        if (carro.getCodigo() == null || carro.getCodigo().isEmpty()) {
            String codigo = "CAR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            carro.setCodigo(codigo);
        }
        
        mapaDecarros.put(carro.getCodigo(), carro);
        return carro;
    }

    public CarroEntity buscar(String codigo) {
        if (codigo == null) return null;
        return mapaDecarros.get(codigo);
    }
}
