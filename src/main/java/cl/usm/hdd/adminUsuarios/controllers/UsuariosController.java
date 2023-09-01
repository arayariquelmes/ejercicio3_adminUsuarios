package cl.usm.hdd.adminUsuarios.controllers;

import cl.usm.hdd.adminUsuarios.entities.Usuario;
import cl.usm.hdd.adminUsuarios.services.UsuariosService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(){
        try{
            List<Usuario> lista = usuariosService.getAll();
            return ResponseEntity.ok(lista);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
       try{
           Usuario usuarioNuevo  = usuariosService.create(usuario);
           return ResponseEntity.ok(usuarioNuevo);
       }catch(Exception ex){
           return ResponseEntity.internalServerError().body(null);
       }
    }

    @GetMapping("/usuarios/{email}")
    public ResponseEntity<Usuario> find(@PathVariable String email){
        try{
            Usuario usuario = usuariosService.find(email);
            return ResponseEntity.ok(usuario);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }


}
