package com.app.mulba;

import com.app.mulba.global.jwt.dto.JwtToken;
import com.app.mulba.global.jwt.service.TokenManager;
import com.app.mulba.member.domain.type.SocialType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/oauth")
@RestController
public class OauthLoginController {

    private final OauthValidator oauthValidator;
    private final OauthLoginService oauthLoginService;
   
    @GetMapping("/login")
    public ResponseEntity<OauthLogin.Response> oauthLogin(@RequestBody OauthLogin.Request request,
                                                          @RequestHeader(name="Authorization") String authorizationHeader) throws IllegalAccessException {
        oauthValidator.validationAuthorization(authorizationHeader);
        oauthValidator.validateSocialType(request.getSocialType());
        String accessToken = authorizationHeader.split(" ")[1];
        OauthLogin.Response response = oauthLoginService.oauthLogin(accessToken, SocialType.form(request.getSocialType()));
        return ResponseEntity.ok().body(response);
    }
}
