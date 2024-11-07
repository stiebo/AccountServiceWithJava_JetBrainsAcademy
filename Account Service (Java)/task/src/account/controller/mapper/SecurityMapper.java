package account.controller.mapper;

import account.controller.dto.EventDto;
import account.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class SecurityMapper {
    public EventDto toDto (Event event) {
        return new EventDto(
                event.getDate(),
                event.getAction().toString(),
                event.getSubject(),
                event.getObject(),
                event.getPath());
    }
}
