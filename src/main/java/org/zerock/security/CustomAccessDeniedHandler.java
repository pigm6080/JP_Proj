package org.zerock.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
<<<<<<< HEAD
=======
@Component
>>>>>>> features
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
<<<<<<< HEAD
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
=======
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
>>>>>>> features
		String requestUri = request.getRequestURI();

		System.out.println(requestUri);
		request.setAttribute("errmsg", accessDeniedException);
		request.setAttribute("errURI", requestUri);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			System.out.println(
					"User '" + auth.getName() + "' attempted to access the protected URL: " + request.getRequestURI());
		}
		System.out.println("Access Denied: " + accessDeniedException.getMessage());

		// 액세스 거부 메시지를 클라이언트에게 반환할 수도 있습니다.
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: " + accessDeniedException.getMessage());

//		System.out.println(accessDeniedException.getMessage());
		log.error("Access Denied Handler");
		log.error("Redirect...");
//		response.sendRedirect("/accessError");

//		request.getRequestDispatcher("/accessError").forward(request, response);
	}

}
