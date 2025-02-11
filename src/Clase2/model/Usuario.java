package Clase2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario implements Serializable {
    private static long serialVersionUID = 1012L; // identificador
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;


}
