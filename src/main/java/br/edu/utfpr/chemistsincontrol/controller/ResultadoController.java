package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

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

    // UPLOAD
    @PostMapping("upload/{id}")
    public void upload(@PathVariable Long id,
                       @RequestParam("arquivo") MultipartFile imagem,
                       HttpServletRequest request)
            throws Exception {

        if (imagem != null) {
            saveFile(id, imagem, request);
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

            Resultado resultado  = new Resultado();// getService().findOne(id);
            resultado.setArquivo(arquivo.getBytes());
            getService().save(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao fazer" + "upload da imagem. " + e.getMessage());
        }
    }
}
