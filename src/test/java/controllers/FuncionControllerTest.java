package controllers;

import controllers.FuncionController;
import dto.AltaFuncionDTO;
import models.Funcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionControllerTest {

    private FuncionController funcionController;

    @BeforeEach
    public void setUp() {
        funcionController = new FuncionController();
    }

    @Test
    public void testAltaDeUnaFuncion_Exito() throws Exception {
        AltaFuncionDTO altaFuncionDTO = new AltaFuncionDTO();
        altaFuncionDTO.setHorario("22:00");
        altaFuncionDTO.setSucursal("Sucursal 1");
        altaFuncionDTO.setSala("Sala 1");
        altaFuncionDTO.setNombrePelicula("La La Land");

        funcionController.AltaDeUnaFuncion(altaFuncionDTO);

        Funcion nuevaFuncion = funcionController.getListaFunciones().get(funcionController.getListaFunciones().size() - 1);

        assertEquals("22:00", nuevaFuncion.getFecha());
        assertEquals("La La Land", nuevaFuncion.getPelicula().getNombrePelicula());
        assertEquals("Sala 1", nuevaFuncion.getSucursalID());
        assertNotNull(nuevaFuncion.getFecha());
        assertTrue(nuevaFuncion.getFuncionID() >= 1000 && nuevaFuncion.getFuncionID() <= 9999);
    }

    @Test
    public void testAltaDeUnaFuncion_FallaSucursalNoExiste() {
        AltaFuncionDTO altaFuncionDTO = new AltaFuncionDTO();
        altaFuncionDTO.setHorario("22:00");
        altaFuncionDTO.setSucursal("Sucursal No Existe");
        altaFuncionDTO.setSala("Sala 1");
        altaFuncionDTO.setNombrePelicula("La La Land");

        Exception exception = assertThrows(Exception.class, () -> {
            funcionController.AltaDeUnaFuncion(altaFuncionDTO);
        });

        assertEquals("No se encontró la sucursal ingresada", exception.getMessage());
    }

    @Test
    public void testAltaDeUnaFuncion_FallaSalaNoExiste() {
        AltaFuncionDTO altaFuncionDTO = new AltaFuncionDTO();
        altaFuncionDTO.setHorario("22:00");
        altaFuncionDTO.setSucursal("Sucursal 1");
        altaFuncionDTO.setSala("Sala No Existe");
        altaFuncionDTO.setNombrePelicula("La La Land");

        Exception exception = assertThrows(Exception.class, () -> {
            funcionController.AltaDeUnaFuncion(altaFuncionDTO);
        });

        assertEquals("No se encontró la sala ingresada", exception.getMessage());
    }
}
