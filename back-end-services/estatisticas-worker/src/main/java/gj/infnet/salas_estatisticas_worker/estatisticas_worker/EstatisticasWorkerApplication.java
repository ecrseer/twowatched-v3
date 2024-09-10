package gj.infnet.salas_estatisticas_worker.estatisticas_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EstatisticasWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstatisticasWorkerApplication.class, args);
	}

}
