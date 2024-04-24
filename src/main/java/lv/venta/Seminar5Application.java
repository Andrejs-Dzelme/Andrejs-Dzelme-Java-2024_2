package lv.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}
	

	
	@Bean
	public CommandLineRunner testModelLayer(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				  	Product p1 = new Product("Jepi", "Zali", 0.95f, 10);
					Product p2 = new Product("Senites", "Mikrodozesanai", 10.50f, 1);
					Product p3 = new Product("Apelsini", "Runajosi", 2.65f, 10);
					productRepo.save(p1);
					productRepo.save(p2);
					productRepo.save(p3);
					System.out.println("How many: " + productRepo.count());
					System.out.println("Get: " + productRepo.findById(2).get());
					Product updatedPr = productRepo.findById(2).get();
					updatedPr.setQuantity(20);
					productRepo.save(updatedPr);
			}
		};

	}
	
	
}//End of all.
