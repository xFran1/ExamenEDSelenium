/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import examenentornodesarrollo.bancoPrestamo;

/**
 *
 * @author Fran
 */
@RunWith(value = Parameterized.class)
public class TestBanco {

    private int capital;
    private int anios;
    private double interes;

    public TestBanco(int capital, int anios, double interes) {
        this.capital = capital;
        this.anios = anios;
        this.interes = interes;
    }


    private WebDriver navegador;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
            {60000, 12, 3},
           {100000, 17, 4},
           {80000, 15, 5},
            {120000, 16, 4},
            {130000, 11, 6}
        };
        return Arrays.asList(data);
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCapital() throws InterruptedException {
//Sitio 1

        navegador = new ChromeDriver();

        navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        navegador.manage().window().maximize();

        navegador.get("https://app.bde.es/asb_www/es/cuota.html#/principalCuota");

        WebElement anuncio = navegador.findElement(By.xpath("/html/body/div[1]/div/p[1]/a[2]")); //Clickamos en el anuncio
        anuncio.click();

        WebElement insertarCapital = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div[1]/form/div[1]/div/div[1]/div[1]/input")); //Buscamos la casilla para introducir la capital
        insertarCapital.click(); //Clickamos en el capital

        insertarCapital.sendKeys(Integer.toString(this.capital)); //Mandamos el capital de este test parametrizado 

        WebElement insertarInteres = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div[1]/form/div[2]/div/div[1]/div[1]/input")); //Buscamos la casilla para introducir el interes
        insertarInteres.click();
        insertarInteres.sendKeys(Double.toString(this.interes)); //Mandamos el interes de este test parametrizado

        WebElement insertarDuracion = navegador.findElement(By.xpath("  /html/body/div[2]/div[2]/div/div/section/div/div[1]/form/div[3]/div/div[1]/div[1]/input")); //Buscamos la casilla para introducir los años
        insertarDuracion.click();
        insertarDuracion.sendKeys(Integer.toString(this.anios)); //Mandamos los años de este test parametrizado

        WebElement boton = navegador.findElement(By.xpath(" /html/body/div[2]/div[2]/div/div/section/div/div[1]/form/div[7]/div/button")); //Buscamos en el boton para calcular la hipoteca
        boton.click();

        WebElement mensualidad = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div[2]/div[1]/div/div[1]/div/div[2]/input")); //Seleccionamos la mensualidad

        Thread.sleep(2000);
        String textoMensualidad = mensualidad.getAttribute("value");
        navegador.quit();

//Sitio 2
        navegador = new ChromeDriver();

        navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        navegador.manage().window().maximize();

        navegador.get("https://www.euribordiario.es/simulador-hipotecas");

        WebElement anuncio1 = navegador.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]"));//Clickamos en el anuncio

        anuncio1.click();

        WebElement insertarCapital1 = navegador.findElement(By.xpath(" /html/body/main/div/div/div[1]/section/div/form/div[1]/div/div/input"));  //Buscamos la casilla para introducir la capital
        insertarCapital1.click();
        insertarCapital1.sendKeys(Integer.toString(this.capital));  //Mandamos el capital de este test parametrizado 

        WebElement insertarDuracion1 = navegador.findElement(By.xpath(" /html/body/main/div/div/div[1]/section/div/form/div[2]/div/div/input"));  //Buscamos la casilla para introducir los años
        insertarDuracion1.click();
        insertarDuracion1.sendKeys(Integer.toString(this.anios)); //Mandamos los años de este test parametrizado

        WebElement insertarInteres1 = navegador.findElement(By.xpath("/html/body/main/div/div/div[1]/section/div/form/div[3]/div/div[1]/div/div/input"));  //Buscamos la casilla para introducir el interes
        insertarInteres1.click();
        insertarInteres1.sendKeys(Double.toString(this.interes)); //Mandamos el interes de este test parametrizado

        WebElement boton1 = navegador.findElement(By.xpath("/html/body/main/div/div/div[1]/section/div/form/div[4]/button")); //Buscamos en el boton para calcular la hipoteca
        boton1.click();

        WebElement mensualidad1 = navegador.findElement(By.xpath("/html/body/main/div/div/div[1]/section/div[2]/p[3]/strong")); //Seleccionamos la mensualidad
        String textoMensualidad1 = mensualidad1.getText();

        Thread.sleep(2000);
        navegador.quit();
        
        textoMensualidad=textoMensualidad.replace('€',' ');//Quitamos los caracteres del euro
                textoMensualidad1=textoMensualidad.replace('€',' ');
                
                        textoMensualidad=textoMensualidad.replace('.',' ');//Quitamos el .
                        textoMensualidad=textoMensualidad.replace(',','.');//Sustituimos la ',' por el '.'
                
                        textoMensualidad1=textoMensualidad1.replace('.',' ');
                        textoMensualidad1=textoMensualidad1.replace(',','.');

                                                textoMensualidad=textoMensualidad.replaceAll(" ", "");//Quitamos los espacios
                                                textoMensualidad1=textoMensualidad1.replaceAll(" ", "");

                
                textoMensualidad=textoMensualidad.trim(); //Quitamos espacios restantes
                textoMensualidad1=textoMensualidad1.trim();

        
        double mensualidadPag1 = Double.parseDouble(textoMensualidad); //Pasamos el string a double
        double mensualidadPag2 = Double.parseDouble(textoMensualidad1);
        System.out.println(textoMensualidad);
        System.out.println(textoMensualidad1);

        assertEquals(mensualidadPag1, mensualidadPag2, 0.01);//Comparamos la mensualidad de ambos

    }

}
