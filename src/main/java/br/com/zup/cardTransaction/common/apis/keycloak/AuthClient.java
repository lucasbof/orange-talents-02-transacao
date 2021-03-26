package br.com.zup.cardTransaction.common.apis.keycloak;

import br.com.zup.cardTransaction.security.LoginResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.cardTransaction.common.apis.keycloak.AuthClient.AuthClientFallbackFactory;

@FeignClient(name = "authClient", url = "${apis.keycloak.auth}", fallbackFactory = AuthClientFallbackFactory.class)
public interface AuthClient {

    @PostMapping
	LoginResponse auth(MultiValueMap<String, String> request);
    
    @Component
    class AuthClientFallbackFactory implements FallbackFactory<AuthClient> {
    	
    	private Logger logger = LoggerFactory.getLogger(AuthClientFallbackFactory.class);
    	
		@Override
		public AuthClient create(Throwable cause) {
			if(cause instanceof FeignException.Unauthorized) {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login ou senha incorretos!");
			}
			logger.error(cause.getLocalizedMessage(), cause);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na autenticação!");
		}
    }
	
}
