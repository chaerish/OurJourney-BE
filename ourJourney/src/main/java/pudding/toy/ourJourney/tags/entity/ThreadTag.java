package pudding.toy.ourJourney.tags.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import pudding.toy.ourJourney.thread.entity.ContentsThread;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThreadTag { //Post and Tag connection middle table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thread_id")
    ContentsThread contentsThread;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    Tag tag;


    public ThreadTag(ContentsThread contentsThread, Tag tag) {
        this.contentsThread = contentsThread;
        this.tag = tag;
    }
}
