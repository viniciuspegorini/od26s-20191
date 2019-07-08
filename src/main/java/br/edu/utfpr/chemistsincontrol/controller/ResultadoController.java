package br.edu.utfpr.chemistsincontrol.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import br.edu.utfpr.chemistsincontrol.model.Arquivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("resultado")
public class ResultadoController extends CrudController<Resultado, Long> {

    @Autowired
    private ResultadoService resultadoService;

    @Override
    @Valid
    protected CrudService<Resultado, Long> getService() {
        return resultadoService;
    }

    @GetMapping(value = "download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) {
        Arquivo arquivo = null;//getService().getField( id, fieldName );
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

//    @PostMapping("upload/{id}")
//    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file, @PathVariable("id") Long id) {
//        Optional<Resultado> optional = Optional.ofNullable(null);//getRepository().findById( id );
//        if (optional.isPresent()) {
//            try {
//                Resultado obj = optional.get();
//                Arquivo arquivo = null;//getService().getField( id, fieldName );
//                if (arquivo == null) {
//                    arquivo = new Arquivo();
//                }
//                arquivo.setSize(file.getSize());
//                arquivo.setContent(file.getBytes());
//                arquivo.setFileName(file.getOriginalFilename());
//                arquivo.setContentType(Arquivo.EContentType.valueFromString(file.getContentType()));
//
//                return new ResponseEntity<>(HttpStatus.OK);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }


    // UPLOAD
    @PostMapping("upload/{id}")
    public void upload(@PathVariable Long id,
                       @RequestParam("arquivo") MultipartFile arquivo,
                       HttpServletRequest request)
            throws Exception {

        if (arquivo != null) {
            saveFile(id, arquivo, request);
        }
    }

    private void saveFile(Long id, MultipartFile arquivo,
                          HttpServletRequest request) throws Exception {
        File dir = new File(request.getServletContext().getRealPath("/arquivos/"));
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String caminhoAnexo = request.getServletContext().getRealPath("arquivos/");
        String extensao = arquivo.getOriginalFilename().substring(
                arquivo.getOriginalFilename().lastIndexOf("."),
                arquivo.getOriginalFilename().length());
        String nomeArquivo = id + extensao;
        try {
            // procurar disciplina OO 4 semestre
            // upload de imagem
            // FileOutputStream fileOut = new FileOutputStream(new File(caminhoAnexo + nomeArquivo));
            // BufferedOutputStream stream = new BufferedOutputStream(fileOut);
            // stream.write(imagem.getBytes());
            // stream.close();

            Resultado resultado = new Resultado();// getService().findOne(id);

//            Arquivo arquivo = null;//getService().getField( id, fieldName );
//                if (arquivo == null) {
//                    arquivo = new Arquivo();
//                }
//                arquivo.setSize(file.getSize());
//                arquivo.setContent(file.getBytes());
//                arquivo.setFileName(file.getOriginalFilename());
//                arquivo.setContentType(Arquivo.EContentType.valueFromString(file.getContentType()));
            resultado.setArquivo(arquivo);
            getService().save(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao fazer" + "upload da imagem. " + e.getMessage());
        }
    }
}
