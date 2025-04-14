package com.example.FranziManuTomVerena.ToDoList.Security;


import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class LoginRequest {
    private String username;
    private String password;
}
