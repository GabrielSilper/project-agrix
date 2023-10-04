package com.betrybe.agrix.dtos.response;

/**
 * Body da resposta padrão da API REST Agrix para quando acontecer alguma exceção.
 *
 * @param message - String - mensagem para situar o cliente do que aconteceu.
 */
public record ErrorMessageResponse(String message) {
}
