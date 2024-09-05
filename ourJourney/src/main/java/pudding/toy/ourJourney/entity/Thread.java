package pudding.toy.ourJourney.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Thread extends BaseTimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;
    String imgUrl;
    @ManyToOne @JoinColumn(name = "profile_id")
    Profile profile;
    @OneToMany @JoinColumn(name = "tag_id")
    List<ThreadTag> threadTags;
    @ManyToOne @JoinColumn(name = "post_id")
    Post post;

}
