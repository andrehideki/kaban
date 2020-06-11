package br.com.kabanapi.exceptionhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@ControllerAdvice
public class KanbanApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		List<Erro> erros = new ArrayList<Erro>();
		
		result.getFieldErrors().forEach(fieldError -> {
			erros.add(new Erro(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()),
					fieldError.toString()));
		});

		return handleExceptionInternal(ex, erros, headers, status, request);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest req) {
		
		Erro erro = new Erro(messageSource.getMessage("recurso.nao-econtrado", null, LocaleContextHolder.getLocale()),
				Optional.ofNullable(ex.getCause()).orElse(ex).toString());
		
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, req);
	}
	
	
	@Data
	@AllArgsConstructor
	public static class Erro {
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;
	}
}
