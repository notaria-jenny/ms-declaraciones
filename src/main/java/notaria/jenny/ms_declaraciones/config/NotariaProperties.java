package notaria.jenny.ms_declaraciones.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import notaria.jenny.ms_declaraciones.validation.RutValido;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Datos de la notaría que van en el documento. Se validan al arrancar:
 * si el RUT del notario está mal escrito, la aplicación no levanta.
 */
@Getter
@Setter
@Component
@Validated
@ConfigurationProperties(prefix = "notaria")
public class NotariaProperties {

    @NotBlank
    private String nombre;

    @NotBlank
    @RutValido
    private String notarioRut;
}