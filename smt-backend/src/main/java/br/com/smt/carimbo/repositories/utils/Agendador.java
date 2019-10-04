package br.com.smt.carimbo.repositories.utils;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.net.httpserver.Authenticator;

import br.com.smt.carimbo.model.TemperaturaModel;
  
  
public class Agendador extends TimerTask {
  
       Date instanteAtual;
       public static Integer CONSTANTE_TEMPERATURA_MAXIMA = 6;
       public static Integer CONSTANTE_TEMPERATURA_MINIMA = 2;
       public static String CONSTANTE_ASSUNTO = "[SMT] - Aviso de anormlidade de temperatura";
       public static String CONSTANTE_CORPO = "[SMT] - Prezados, houve uma anormalidade de temperatura. Favor verificar ";
       
       TemperaturaModel temperatura;
       List<TemperaturaModel> lista;
       
       @Override
       public void run() {
    	   
	     instanteAtual = new Date();
	     System.out.println(instanteAtual);
	     verifiarAlerta();
       }
       
       public void verifiarAlerta() {
	      if(lista != null && lista.size()>0) {       
		        
	    	  for (TemperaturaModel temperaturaModel : lista) {
	    		  // verifica se ja foi enviado algum aviso
	    		  if(!temperaturaModel.getJaAlertado()) {
	    			  // verifica se temperara esta acima do padrao ou abaixo do padrao minimo
	    			  if(temperaturaModel.getTemperaturaRegistrada() > CONSTANTE_TEMPERATURA_MAXIMA 
	    					   && temperaturaModel.getTemperaturaRegistrada() < CONSTANTE_TEMPERATURA_MINIMA) {
	    				// acao para alertar sobre mudanda de temperatura
    	    				  	
		    	    				  
		    			  }
		    		  }
		    	  }   
		      }
		}
        
         
         
}
