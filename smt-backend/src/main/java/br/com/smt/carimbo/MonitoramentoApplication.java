package br.com.smt.carimbo;

import java.util.Timer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.smt.carimbo.repositories.utils.Agendador;

/**
 * 
 * @author Joao Guedes
 * Data: 25/07/2019
 *
 */
// @ComponentScan
@SpringBootApplication
public class MonitoramentoApplication implements CommandLineRunner { // extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MonitoramentoApplication.class, args);
		
		
		// varificacao de mudanda de temperarutura
        Timer timer = new Timer();
        Agendador agendador = new Agendador();
        timer.schedule(agendador, 0, 90000);
        System.out.println("########## Monitoramento de Temperatura #############:");
 
	}

	@Override
	public void run(String... args) throws Exception {	
	}
	
}
