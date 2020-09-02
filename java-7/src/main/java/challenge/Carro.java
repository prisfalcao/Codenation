package challenge;
import java.util.Objects;

public class Carro {

    private final Motorista motorista;
    private final String placa;
    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            Objects.requireNonNull(placa, "A placa do veículo é obrigatória.");
            Objects.requireNonNull(cor, "A cor do veículo é obrigatória.");
            if (motorista == null) {
                throw new EstacionamentoException("O veículo deve ter um motorista!");
            }

            return new Carro(motorista, placa, cor);
        }
    }
}
