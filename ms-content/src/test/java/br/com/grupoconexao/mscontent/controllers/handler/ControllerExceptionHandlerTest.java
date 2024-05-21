package br.com.grupoconexao.mscontent.controllers.handler;

import br.com.grupoconexao.mscontent.services.exceptions.CannotAttachFileWithDifferentRegistrationException;
import br.com.grupoconexao.mscontent.services.exceptions.ResourceNotFoundException;
import feign.FeignException;
import feign.Request;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

    @InjectMocks
    private ControllerExceptionHandler controllerExceptionHandler;

    @DisplayName("deve testar illegalArgumentException")
    @Test
    void shouldTestIllegalArgumentException() {
        IllegalArgumentException exception = new IllegalArgumentException();
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        ResponseEntity<StandardError> result = controllerExceptionHandler.illegalArgumentException(exception, request);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @DisplayName("deve testar resourceNotFoundException")
    @Test
    void shouldTestResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("resource not found!");
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        ResponseEntity<StandardError> result = controllerExceptionHandler.resourceNotFoundException(exception, request);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @DisplayName("deve testar CannotAttachFileWithDifferentRegistrationException")
    @Test
    void shouldTestCannotAttachFileWithDifferentRegistrationException() {
        CannotAttachFileWithDifferentRegistrationException exception = new CannotAttachFileWithDifferentRegistrationException("check your registration");
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        ResponseEntity<StandardError> result = controllerExceptionHandler.CannotAttachFileWithDifferentRegistrationException(exception, request);

        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @DisplayName("deve testar handleFeignException")
    @Test
    void shouldTestHandleFeignException() {
        HttpServletRequest servletRequest = Mockito.mock(HttpServletRequest.class);
        Request request = Mockito.mock(Request.class);
        FeignException.FeignClientException exception = new FeignException.NotFound(null, request, null, new HashMap<>());

        ResponseEntity<StandardError> result = controllerExceptionHandler.handleFeignException(exception, servletRequest);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

}
