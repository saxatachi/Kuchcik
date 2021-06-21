package pl.saxatachi.kuchcik.registration.token;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.saxatachi.kuchcik.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @SequenceGenerator(name = "confirmation_token_sequence"
            ,sequenceName = "confirmation_token_sequence"
            ,allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "confirmation_token_sequence")
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = false,name="user_id")
    private User user;
    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiredAt;
        this.user = user;
    }
}
