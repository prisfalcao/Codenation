package br.com.codenation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.MeuTimeInterface;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

private DesafioMeuTimeService desafioMeuTimeService = new DesafioMeuTimeService();


public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        desafioMeuTimeService.incluirTime(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario, null);
        }


public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        desafioMeuTimeService.incluirJogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        }


public void definirCapitao(Long idJogador) {
        desafioMeuTimeService.definirCapitao(idJogador);
        }


public Long buscarCapitaoDoTime(Long idTime) {
        return desafioMeuTimeService.buscarCapitaoDoTime(idTime);
        }


public String buscarNomeJogador(Long idJogador) {
        return desafioMeuTimeService.buscarNomeJogador(idJogador);
        }


public String buscarNomeTime(Long idTime) {
        return desafioMeuTimeService.buscarNomeTime(idTime);
        }


public List<Long> buscarJogadoresDoTime(Long idTime) {
        return desafioMeuTimeService.buscarJogadoresDoTime(idTime);
        }


public Long buscarMelhorJogadorDoTime(Long idTime) {
        return desafioMeuTimeService.buscarMelhorJogadorDoTime(idTime);
        }


public Long buscarJogadorMaisVelho(Long idTime) {
        return desafioMeuTimeService.buscarJogadorMaisVelho(idTime);
        }


public List<Long> buscarTimes() {
        return desafioMeuTimeService.buscarTimes();
        }


public Long buscarJogadorMaiorSalario(Long idTime) {
        return desafioMeuTimeService.buscarJogadorMaiorSalario(idTime);
        }


public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return desafioMeuTimeService.buscarSalarioDoJogador(idJogador);
        }


public List<Long> buscarTopJogadores(Integer top) {
        return desafioMeuTimeService.buscarTopJogadores(top);
        }


public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        return desafioMeuTimeService.buscarCorCamisaTimeDeFora(timeDaCasa, timeDeFora);
        }

        }