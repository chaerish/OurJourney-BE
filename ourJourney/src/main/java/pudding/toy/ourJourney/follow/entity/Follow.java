package pudding.toy.ourJourney.follow.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import pudding.toy.ourJourney.profile.entity.Profile;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_user_id")
    Profile follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_user_id")
    Profile following;

    public Follow(Profile follower, Profile following) {
        this.follower = follower;
        this.following = following;
    }

    public Profile getFollower() {
        return this.follower;
    }

    public Profile getFollowing() {
        return this.following;
    }

}
