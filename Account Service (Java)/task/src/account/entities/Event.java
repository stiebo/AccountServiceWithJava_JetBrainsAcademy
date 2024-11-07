package account.entities;

import account.business.EventName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "\"EVENT\"")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Instant date;

    @Column(nullable = false)
    private EventName action;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String object;

    @Column(nullable = false)
    private String path;
}
