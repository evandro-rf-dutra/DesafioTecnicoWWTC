package com.wwtc.teapi.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wwtc.teapi.Model.Estatistica;
import com.wwtc.teapi.Service.EstatisticaService;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    @GetMapping
    public ResponseEntity<Estatistica> retornaEstatistica(){

        Estatistica estatistica = service.retornaEstatistica();
        return new ResponseEntity<Estatistica>(estatistica,HttpStatus.OK); // 200
        
    }
    
}
