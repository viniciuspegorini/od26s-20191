package br.edu.utfpr.chemistsincontrol.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.utfpr.chemistsincontrol.model.Arquivo;
import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;


@RestController
@RequestMapping("resultado")
public class ResultadoController extends CrudController<Resultado, Long> {

    @Autowired
    private ResultadoService resultadoService;

    //@Autowired
    //private ArquivoService arquivoService;

    @Override
    @Valid
    protected CrudService<Resultado, Long> getService() {
        return resultadoService;
    }

    @GetMapping(value = "download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) {
        Arquivo arquivo = null; //= arquivoService.findById(id).orElse(null);
        if (arquivo != null) {
            Resource res = new ByteArrayResource(arquivo.getContent(), arquivo.getFileName());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + arquivo.getFileName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, arquivo.getContentType().getContentType())
                    .body(res);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    // UPLOAD
    @PostMapping("upload/{id}")
    public void upload(@PathVariable("id") Long id,
                       @RequestParam("arquivo") MultipartFile arquivo,
                       HttpServletRequest request)
            throws Exception {

        if (arquivo != null) {
            saveFile(id, arquivo, request);
        }
    }

    private void saveFile(@PathVariable("id") Long id, MultipartFile file,
                          HttpServletRequest request) throws Exception {
        try {
            Resultado resultado = new Resultado();
            resultado = getService().findOne(id);
            Arquivo arquivo = new Arquivo();

            arquivo.setSize(file.getSize());
            arquivo.setContent(file.getBytes());
            arquivo.setFileName(file.getOriginalFilename());
            arquivo.setContentType(Arquivo.EContentType.valueFromString(file.getContentType()));
            resultado.setArquivo(arquivo);

            getService().save(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao fazer" + "upload do aquivo. " + e.getMessage());
        }
    }
}
