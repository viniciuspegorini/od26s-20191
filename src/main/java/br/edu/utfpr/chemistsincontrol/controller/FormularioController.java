package br.edu.utfpr.chemistsincontrol.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.repository.ResultadoRepository;
import br.edu.utfpr.chemistsincontrol.util.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;

@RestController
@RequestMapping("formulario")
public class FormularioController extends CrudController<Formulario, Long> {

    private static final String EMAIL_FUNTEF = "email@funtef.com.br";

    @Autowired
    private FormularioService formularioService;
    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    @Valid
    protected CrudService<Formulario, Long> getService() {
        return formularioService;
    }

    @GetMapping("/forms")
    public List<Formulario> getForm() {
        return formularioService.getForm();
    }

    @Override
    public Formulario save(@Valid Formulario entity) {
        Formulario saved = super.save(entity);
        if (saved.getStatus().equalsIgnoreCase("Em faturamento")) {
            enviaEmailFuntef(saved);
            enviaEmailResultado(saved);
        }
        if( saved.getStatus().equalsIgnoreCase( "Finalizado" )){
            enviaEmailResultado(saved);
        }
        return saved;
    }

    private String montaCorpoEmailFuntef(Formulario f) {
        return null;
    }

    private String montaCorpoEmailResultado(Formulario f, Resultado r) {
        return null;
    }

    private void enviaEmailFuntef(Formulario formulario) {

        MailSender ms = new MailSender();
        try {
            ms.sendEmail(EMAIL_FUNTEF, "Formulário para Faturamento", montaCorpoEmailFuntef(formulario), null );
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }


    }

    private void enviaEmailResultado(Formulario formulario) {
        Optional<Resultado> optResultado = resultadoRepository.findByFormularioId(formulario.getId());
        if (optResultado.isPresent()) {
            Resultado resultado = optResultado.get();
            MailSender ms = new MailSender();
            try {
                ms.sendEmail(formulario.getUsuario().getEmail(), "Resultado da Análise", montaCorpoEmailResultado(formulario, resultado), null);
            }catch ( MessagingException | IOException e ) {
                e.printStackTrace();
            }

        }
    }

}