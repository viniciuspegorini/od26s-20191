package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("formulario")
public class FormularioController extends CrudController<Formulario, Long> {

    private static final String EMAIL_FUNTEF = "cicerafrozza.cf@gmail.com";

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

    @GetMapping("/find/{id}")
    public List<Formulario> findByNotaId(Long Id) {
        return formularioService.findByNotaId(Id);
    }
    @Override
    public Formulario save(@RequestBody @Valid Formulario entity) {
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
        String valor = f.getValorTotal().toString();
        String tipoAnalise = f.getModelo().getNome();
        String razaoSocial = f.getUsuario().getNome();
        String cpfCnpj = f.getUsuario().getCpfCnpj();
        String endereco = f.getUsuario().getEndereco() + "," + f.getUsuario().getCidade() + "," + f.getUsuario().getUf() + "-" + f.getUsuario().getCep();
        String telefone = f.getUsuario().getTelefone();
        String email = f.getUsuario().getEmail();

        String corpoEmail = "Olá, <br>"  +
                "<br>" +
                "Para cobrança de R$ " + valor +  " referente a " + tipoAnalise + ", para depósito bancário.<br>" +
                "Dados:<br>" +
                "Razão social: " + razaoSocial + "<br>" +
                "CNPJ/CPF: " + cpfCnpj + "<br>" +
                "Endereço: " + endereco + "<br>" +
                "Telefone: "+  telefone + "<br>" +
                "E-mail: " + email ;

        return corpoEmail;
    }

    private String montaCorpoEmailResultado(Formulario f) {
        String razaoSocial = f.getUsuario().getNome();
        String tipoAnalise = f.getModelo().getNome();
        String email = "Olá," + razaoSocial +  "<br>" +
                "<br>" +
                "Sua análise " + tipoAnalise + " está pronto. Acesse sua conta para baixar os resultados.";
        return email;
    }

    private void enviaEmailFuntef(Formulario formulario) {

        MailSender ms = new MailSender();
        try {

            System.out.println(montaCorpoEmailFuntef(formulario));
            ms.sendEmail(EMAIL_FUNTEF, "Formulário para Faturamento", montaCorpoEmailFuntef(formulario), null );
        } catch (MessagingException | IOException e) {
            System.out.println("caiu no carth porra");

            e.printStackTrace();
        }


    }

    private void enviaEmailResultado(Formulario formulario) {
        Optional<Resultado> optResultado = resultadoRepository.findByFormularioId(formulario.getId());
        if (optResultado.isPresent()) {
            Resultado resultado = optResultado.get();
            MailSender ms = new MailSender();
            try {
                ms.sendEmail(formulario.getUsuario().getEmail(), "Resultado da Análise", montaCorpoEmailResultado(formulario), null);
            }catch ( MessagingException | IOException e ) {
                e.printStackTrace();
            }

        }
    }

}