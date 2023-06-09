package com.example.pet.domain.note;

import com.example.pet.domain.member.Member;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Window implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "window_id")
    private int windowId;

    @ManyToOne
    @JoinColumn(name="recev_id")
    private Member receiveUserId;

    @ManyToOne
    @JoinColumn(name="send_id")
    private Member sendUserId;
}