package Eldar.EldarCompleto.common;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@Getter
@EnableJpaAuditing
public class EldarConfig {

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();
    }
}
