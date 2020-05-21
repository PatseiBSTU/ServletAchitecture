package by.patsei;

import by.patsei.controller.Controller;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.patsei.command.authorithation.contants.AuthConstants.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ControllerTest {

    private static  Controller controller;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static RequestDispatcher requestDispatcher;


    @Before
    public void setUp() throws Exception {
        controller = new Controller();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
        initMocks(this);
    }
@Ignore
    @Test
    public void loginServletWithOutParam() throws ServletException, IOException {
        // Arrange
        when(request.getParameter(LOGIN)).thenReturn(null);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        // Act
        controller.doPost(request, response);

        // Assert
        verify(request).setAttribute("errorMessage", "Неверный логин или пароль, заполните все поля");
        verify(requestDispatcher).forward(request, response);
    }
}
