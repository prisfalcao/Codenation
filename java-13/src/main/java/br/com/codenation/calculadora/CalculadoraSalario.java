package br.com.codenation.calculadora;

public class CalculadoraSalario {

        public long calcularSalarioLiquido(double salarioBase) {
            if(salarioBase < 1039) {
                return 0;
            }
            double salarioLiquido = calcularInss(salarioBase);
            if (salarioLiquido >= 3000) salarioLiquido = calcularIrrf(salarioLiquido);
            return Math.round(salarioLiquido);
        }

        private double calcularInss(double inss) {
            if(inss <= 1500) {
                return inss * 0.92;
            }
            else if(inss <= 4000) {
                return inss * 0.91;
            }
            else {
                return inss * 0.89;
            }
        }

        private double calcularIrrf(double impostoRenda) {
            if(impostoRenda >= 3001 && impostoRenda <= 6000) {
                return impostoRenda * 0.925;
            }
            else {
                return impostoRenda * 0.85;
            }
        }

    }
