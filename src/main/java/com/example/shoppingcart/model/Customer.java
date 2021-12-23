package com.example.shoppingcart.model;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;
    @NotBlank(message = "name can not be null")
    private String name;
    @Pattern(regexp = "(0|91)?[7-9][0-9]{9}")
    private long phone;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "address can not be null")
    private String address;

}
