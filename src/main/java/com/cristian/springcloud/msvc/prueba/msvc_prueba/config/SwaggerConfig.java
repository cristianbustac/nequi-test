package com.cristian.springcloud.msvc.prueba.msvc_prueba.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Nequi API")
                        .version("1.0")
                        .description("API de Nequi desplegada en Railway"))
                .servers(List.of(
                        new Server().url("https://nequi-test-production.up.railway.app").description("Railway Server")
                ));
    }
}
