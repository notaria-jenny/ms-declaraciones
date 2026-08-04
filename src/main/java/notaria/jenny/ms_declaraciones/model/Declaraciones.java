package notaria.jenny.ms_declaraciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "declaraciones_juradas")
public class Declaraciones {

    public enum Estado{
        EMITIDA,
        ANULADA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeclaracion;

    //compareciente, copiado desde ms-clientes al momento de emitir
    @Column(nullable = false, length = 12)
    private String rutCliente;

    @Column(nullable = false, length = 200)
    private String nombreCliente;

    @Column(nullable = false, length = 255)
    private String direccionCliente;

    //contenido que redacta el funcionario
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    //funcionario que tramitó (copiado desde ms-administradores)
    @Column(nullable = false, length = 12)
    private String rutAdministrador;

    @Column(nullable = false, length = 200)
    private String nombreAdministrador;

    //Notario que autoriza (copiado desde ms-administradores)
    @Column(nullable = false, length = 12)
    private String rutNotario;

    @Column(nullable = false, length = 200)
    private String nombreNotario;

    //Estado y fechas
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Estado estado;

    @Column(nullable = false)
    private LocalDateTime fechaComparecencia;

    @Column(nullable = false)
    private LocalDateTime fechaEmision;
}
