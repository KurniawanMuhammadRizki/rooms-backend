package com.rooms.rooms.users.controller;

import com.rooms.rooms.auth.entity.RoleName;
import com.rooms.rooms.auth.helpers.Claims;
import com.rooms.rooms.users.dto.RegisterRequestDto;
import com.rooms.rooms.users.dto.RegisterResponseDto;
import com.rooms.rooms.users.dto.ResetPasswordDto;
import com.rooms.rooms.users.dto.UpdateUserDto;
import com.rooms.rooms.users.entity.Users;
import com.rooms.rooms.users.service.UsersService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class UserResolver {
    private final UsersService usersService;

    public UserResolver(UsersService usersService) {
        this.usersService = usersService;
    }

    @MutationMapping(value = "userRegister")
    public String userRegister(@Argument("input") RegisterRequestDto registerRequestDto) {
        return usersService.register(registerRequestDto, RoleName.USER);
    }

    @MutationMapping(value = "tenantRegister")
    public String tenantRegister(@Argument("input") RegisterRequestDto registerRequestDto) {
        return usersService.register(registerRequestDto, RoleName.TENANT);
    }

    @MutationMapping(value = "deleteAccount")
    public String deleteAccount(@Argument String email, @Argument String password) {
        usersService.deleteUserByEmail(email, password);
        return "Your account has been deleted successfully.";
    }

    @QueryMapping(value = "findUserByEmail")
    public Users findUserByEmail(@Argument String email) {
        return usersService.findByEmail(email);
    }

    @QueryMapping(value = "findUserById")
    public Users findUserById(@Argument Long id) {
        return usersService.getUsersById(id);
    }

    @MutationMapping(value = "verifyEmail")
    public RegisterResponseDto verifyEmail(@Argument String email) {
        return usersService.verifyEmail(email);
    }

    @MutationMapping(value = "sendResetPasswordLink")
    public String sendResetPasswordLink(@Argument String email) {
        return usersService.sendResetPasswordLink(email);
    }

    @MutationMapping(value = "resetPassword")
    public String resetPassword(@Argument String email, @Argument("input") ResetPasswordDto dto) {
        return usersService.resetPassword(email, dto);
    }

    @MutationMapping(value = "sendForgetPasswordLink")
    public String sendForgetPasswordLink(@Argument String email) {
        return usersService.sendForgetPasswordLink(email);
    }

    @MutationMapping(value = "forgetPassword")
    public String forgetPassword(@Argument String email, @Argument String newPassword) {
        return usersService.forgetPassword(email, newPassword);
    }

    @MutationMapping(value = "uploadAvatar")
    public Users uploadAvatar(@Argument String email, @Argument String imgUrl) {
        return usersService.uploadAvatar(email, imgUrl);
    }

    @MutationMapping(value = "updateUserInformation")
    public Users updateUserInformation(@Argument("input") UpdateUserDto updateUserDto, @Argument String email) {
        return usersService.updateUserInformation(updateUserDto, email);
    }

}
