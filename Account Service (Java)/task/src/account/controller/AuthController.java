package account.controller;

import account.controller.dto.EventDto;
import account.entities.User;
import account.business.AuthService;
import account.controller.dto.UserResponseDto;
import account.controller.dto.ChangePwdDto;
import account.controller.dto.AddUserDto;
import account.controller.mapper.UserMapper;
import account.business.EventName;
import account.business.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService service;
    private final UserMapper userMapper;
    private final SecurityService logger;


    @Autowired
    public AuthController(AuthService authService, UserMapper userMapper, SecurityService securityService) {
        this.service = authService;
        this.userMapper = userMapper;
        this.logger = securityService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto>registerUser (@Valid @RequestBody AddUserDto addUserDto) {
        User user = service.registerUser(userMapper.addUserDtoToEntity(addUserDto));
        logger.logEvent(EventName.CREATE_USER, "Anonymous", user.getUsername(), "/api/auth/signup");
        return ResponseEntity.ok(userMapper.toUserResponseDto(user));
    }

    @PostMapping("/changepass")
    public ResponseEntity<Map<String,String>> changePassword (@Valid @RequestBody ChangePwdDto changePwdDto,
                                                              @AuthenticationPrincipal User user) {
        service.changePassword(user, changePwdDto.new_password());
        logger.logEvent(EventName.CHANGE_PASSWORD, user.getUsername(), user.getUsername(), "/api/auth/signup");
        return ResponseEntity.ok(Map.of("email", user.getEmail(),
                "status", "The password has been updated successfully"));
    }


}
