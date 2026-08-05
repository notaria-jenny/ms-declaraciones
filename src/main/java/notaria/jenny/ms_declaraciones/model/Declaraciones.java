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

    // Folio visible del documento. No se usa el id de la base:
    // un autoincremental es un detalle técnico, no un número de documento legal.
    @Column(nullable = false, unique = true, length = 30)
    private String numeroDocumento;

    // Declarante: copiado desde ms-clientes al momento de emitir ──
    // Se guarda copia y no se resuelve en vivo: si el cliente cambia de
    // domicilio, las declaraciones ya emitidas deben conservar el que tenía
    // el día que compareció.
    @Column(nullable = false, length = 12)
    private String rutCliente;

    @Column(nullable = false, length = 200)
    private String nombreCliente;

    @Column(nullable = false, length = 255)
    private String direccionCliente;

    //contenido que redacta el funcionario
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    // Trazabilidad interna: NO se imprimen en el documento
    // La firma es manuscrita sobre el papel; el .docx solo lleva la línea
    // en blanco y el pie del notario titular.
    @Column(nullable = false, length = 12)
    private String rutAdministrador;

    @Column(nullable = false, length = 200)
    private String nombreAdministrador;

    @Column(nullable = false, length = 12)
    private String rutFirmante;

    @Column(nullable = false, length = 200)
    private String nombreFirmante;

    // Notario titular al momento de emitir: este SÍ va en el pie
    @Column(nullable = false, length = 12)
    private String rutNotario;

    @Column(nullable = false, length = 200)
    private String nombreNotario;

    //Estado y fechas
    // No hay DELETE: un documento notarial se anula, no se borra.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Estado estado;

    //Día en que el declarante comparece a firmar: es la fecha impresa
    @Column(nullable = false)
    private LocalDateTime fechaComparecencia;

    // Instante en que se creó el registro: auditoría, no aparece en el documento
    @Column(nullable = false)
    private LocalDateTime fechaEmision;
}
