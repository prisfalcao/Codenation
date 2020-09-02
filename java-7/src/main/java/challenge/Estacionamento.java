package challenge;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Estacionamento {

    private final int Vagas = 10;

    private Set<Carro> carros = new LinkedHashSet<>();

    public int getVagas() {
        return Vagas;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void estacionar(Carro carro) {
        // Requesitos mínimos para estacionar:
        if (carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("O motorista é menor de idade. Proibido estacionar aqui!");
        }
        if (carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("O motorista possui mais de 20 pontos na habilitação. Proibido estacionar aqui!");
        }
        // O estacionamento está cheio?
        if (carros.size() >= getVagas()) {
            Iterator<Carro> itCarros = carros.iterator();

            while (itCarros.hasNext()) {
                // Verificando se o primeiro motorista a sair do estacionamento é >= 55;
                Carro carroEstacionado = itCarros.next();
                Motorista motora = carroEstacionado.getMotorista();
                if (motora.getIdade() < 55) {

                    carros.remove(carroEstacionado);
                    carros.add(carro);
                    return;

                }
            }
            // Para estacionamento lotado:
            throw new EstacionamentoException("Estacionamento lotado!");
        }
        carros.add(carro);
    }

    // carro estacionado
    public Boolean carroEstacionado(Carro carro) {
        Iterator<Carro> itCarros = carros.iterator();
        while (itCarros.hasNext()) {
            if (itCarros.next() == carro) {
                return true;
            }
        }
        return false;
    }

    // carros estacionados
    public long carrosEstacionados() {
        return carros.size();
    }

}
