package br.com.zup.cardTransaction.security;

import br.com.zup.cardTransaction.common.apis.keycloak.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Value("${keycloak.resource}")
	private String clientId;
	
	@Value("${keycloak.credentials.secret}")
	private String clientSecret;

	@Autowired
	private AuthClient authClient;

	@PostMapping
    public LoginResponse auth(@RequestBody LoginRequest request) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add("grant_type", "password");
        formData.add("username", request.getUser());
        formData.add("password", request.getPassword());
        formData.add("client_id", clientId);
        formData.add("client_secret", clientSecret);
        return authClient.auth(formData);
    }
}
