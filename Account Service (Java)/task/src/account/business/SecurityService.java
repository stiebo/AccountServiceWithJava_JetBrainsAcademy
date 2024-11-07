package account.business;

import account.controller.dto.EventDto;
import account.entities.Event;

import java.util.List;

public interface SecurityService {
    List<Event> getAllEvents();
    void logEvent(EventName action, String subject, String object, String path);
}
