package capstone.openjob.oauth2.controller;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenDto implements Serializable {
    String token;

}
