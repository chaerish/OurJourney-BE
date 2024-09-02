package pudding.toy.ourJourney.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pudding.toy.ourJourney.dto.django.ProfileAuthResponseDto;
import pudding.toy.ourJourney.entity.Profile;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProfileResponseDto {
    int userId; //user pk
    //todo: 로직 짜기
    /*
    클라이언트에게 프로필 생성된 응답 내려주기.
    1. 닉네임 -> null
    2. 사진 -> null (아직 수정 전이므로)
    3. 자기소개 -> Null ..etc
     */

}
