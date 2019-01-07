package com.testtriangle.forexengine.domain;

import com.testtriangle.forexengine.data.repository.ForexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * This class will load some data into the database
 *
 */
@Component
public class DbSeeder implements CommandLineRunner {
    private ForexRepository forexRepository;

    public DbSeeder(ForexRepository forexRepository) {
        this.forexRepository = forexRepository;
    }

    @Override
    public void run(String... args) {

        //create country
        Country ireland = new Country("Ireland ", "EURO", 3.0);
        Country australia = new Country("Australia ", "DOLLAR", 2.8);

        //create forex
        Forex euroDollar = new Forex(ireland, australia);
        Forex dollarEuro = new Forex(australia, ireland);

        this.forexRepository.deleteAll();
        List<Forex> forex = Arrays.asList(euroDollar, dollarEuro);
        this.forexRepository.saveAll(forex);


    }

}
