package pe.edu.cibertec.app_security_backoffice.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomPassword {

    public String generar(int longitud){
        String cadena = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < longitud; i++){
            int index = random.nextInt(cadena.length());
            password.append(cadena.charAt(index));
        }
        return password.toString();
    }

}
