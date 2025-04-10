package com.example.FranziManuTomVerena.ToDoList.Security;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
public class LoginRequest {
    private String username;
    private String password;
}
