package com.example.scheduledevelop.common;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;
import java.io.IOException;
import java.rmi.RemoteException;

@Slf4j
public class LoginFilter implements Filter {

    private static final  String[] WHITE_LIST = {"/", "/user/signup", "/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");
        // WHITE LIST에 포함 된 경우 true -> !true -> false
        if(!isWhiteList(requestURI)){

            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute(Const.LOGIN_USER) == null){
                throw new RemoteException("로그인 해주세요");
            }

            log.info("로그인에 성공했습니다.");
        }
        //1번 경우 : WHITE LIST에 등록된 URL 요청이라면 chain.doFilter()호출
        //2번 경우 : WHITE LIST가 아닌 경우 위 필터로직을 통과 후에 chain.doFilter() 다음필터나 Servlet 호출
        //다음필터가 없으면 Servlet -> Controller, 다음 필터가 있으면 다음 Filter 호출

        chain.doFilter(request, response);
    }

    private boolean isWhiteList (String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
