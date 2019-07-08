package br.edu.utfpr.chemistsincontrol.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static br.edu.utfpr.chemistsincontrol.config.JpaAuditingConfiguration._user;

public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Long idUsuario = 0L; //Pegar do cabeçalho da requisição
        _user.set(idUsuario);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        _user.set( 0L );
        super.postHandle(request, response, handler, modelAndView);
    }
}
