import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import edu.eci.arsw.gof.chainofrep.loanapproval.model.ApplicationDetails;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.AutomatedLoanEvaluator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hcadavid
 */
public class LoanEvaluatorTest {
	
	private ApplicationDetails aplication;
	
	private void setupAplicacionAprobada1()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "1953-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 10001, 0, 7, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
	
	private void setupAplicacionAprobada2()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "1999-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 1, 0, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
	
	private void setupAplicacionDeclinadaEdad1()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "1952-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
	
	private void setupAplicacionDeclinadaEdad2()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "2000-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
	
	private void setupAplicacionDeclinadaExperiencia()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 0, 6, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
	
	private void setupAplicacionDeclinadaSalario()
	{
		aplication = new ApplicationDetails("John", "", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 10000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	}
    
    @Test
    public void isAplicationDeniedDeberiaDeclinarSiFueraDeFrontera()
    {
    	AutomatedLoanEvaluator al = new AutomatedLoanEvaluator();
    	setupAplicacionDeclinadaEdad1();
    	try {
			assertFalse(al.isApplicationDeclined(aplication, new String[]{}));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setupAplicacionDeclinadaEdad2();
    	setupAplicacionDeclinadaExperiencia();
    	setupAplicacionDeclinadaSalario();
    }
    
    @Test
    public void isAplicationDeniedDeberiaDarExplicacionesCorrectas()
    {
    	setupAplicacionDeclinadaEdad1();
    	setupAplicacionDeclinadaEdad2();
    	setupAplicacionDeclinadaExperiencia();
    	setupAplicacionDeclinadaSalario();
    }
    
    @Test public void isAplicationDeniedDeberiaAprobarSiDentroDeFrontera()
    {
    	setupAplicacionAprobada1();
    	setupAplicacionAprobada2();
    }
    @Test
    public void isAplicationDeniedNoDeberiaModificarOutcomeSiAprobado()
    {
    	setupAplicacionAprobada1();
    	setupAplicacionAprobada2();
    }
    
    public void isAplicationDeniedNoDeberiaModificarAplicationDetails()
    {
    	setupAplicacionAprobada1();
    	setupAplicacionAprobada2();
    	setupAplicacionDeclinadaExperiencia();
    }
}
