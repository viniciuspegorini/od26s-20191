package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Arquivo;
import br.edu.utfpr.chemistsincontrol.model.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.utfpr.chemistsincontrol.model.Nota;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.NotaService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("nota")
public class NotaController extends CrudController<Nota, Long> {


    private NotaService notaService;

    @Autowired
    public NotaController (NotaService service) {this.notaService = service;}

    @Override
    protected CrudService<Nota, Long> getService() {
        return notaService;
    }

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

            Nota nota =  getService().findOne(id);

            nota.setAnexo(arquivo.getBytes());
            nota.setSize(arquivo.getSize());
            nota.setFileName(arquivo.getOriginalFilename());
            nota.setContentType(Arquivo.EContentType.valueFromString(arquivo.getContentType()));

            getService().save(nota);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao fazer" + "upload da nota. " + e.getMessage());
        }
    }
}
