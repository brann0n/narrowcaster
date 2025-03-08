package nl.ba99.narrowcaster.controllers.security;

import nl.ba99.narrowcaster.dto.ScreenDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.security.JWTProvider;
import nl.ba99.narrowcaster.services.ScreenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate_screen")
@CrossOrigin(exposedHeaders = "jwt-token")
public class AuthenticateScreenController {

    private final JWTProvider jwtProvider;
    private final ScreenService screenService;

    public AuthenticateScreenController(JWTProvider jwtProvider, ScreenService screenService) {
        this.jwtProvider = jwtProvider;
        this.screenService = screenService;
    }

    @ApiOperation(value = "Endpoint used for signing in as a screen")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Signed in, jwt is in header"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Account is disabled")
    })
    @GetMapping("/{authToken}")
    public ResponseEntity<Void> login(@PathVariable("authToken") String authToken) {
        ScreenDto screen;

        try {
            screen = screenService.getScreenByAuthKey(authToken);
        } catch (DataNotFoundException dnf) {
            return ResponseEntity.status(401).build();
        }

        //create the new JWT with static role ROLE_SCREEN
        String token = jwtProvider.createScreenToken(screen.getName(), "ROLE_SCREEN");

        return ResponseEntity.ok()
                .header("jwt-token", token)
                .build();
    }
}
