package by.patsei.command.grouppresons;

import by.patsei.command.Command;
import by.patsei.command.CommandResult;
import by.patsei.exception.IncorrectDataException;
import by.patsei.exception.ServiceException;
import by.patsei.model.Person;
import by.patsei.service.PersonService;
import by.patsei.util.pages.Page;
import static by.patsei.command.grouppresons.constant.GroupConstant.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {

        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

