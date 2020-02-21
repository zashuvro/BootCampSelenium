package homepage;

import common.WebAPI;
import databases.ConnectToSqlDB;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.DataSource;
import webelements.HomePageWebElements;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage extends HomePageWebElements {

    public static void setBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mdshu\\Downloads\\Bootcamp2020Selenium\\Generic\\BrowserDriver\\Windows\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
    }

@Test
    public static void search() throws Exception {
        //setBrowser();
        //System.out.println(ConnectToSqlDB.readDataBase("shuvro","search").get(0));
        for (int i=0;i<ConnectToSqlDB.readDataBase("shuvro","search").size();i++) {
        driver.findElement(By.xpath(searchBox)).sendKeys(ConnectToSqlDB.readDataBase("shuvro","search").get(i), Keys.ENTER);
        sleepFor(2);
        navigateBack();
        sleepFor(2);
        }


    }

    public static void main(String[] args)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\mdshu\\Downloads\\Bootcamp2020Selenium\\Google\\src\\File\\Book.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue()+"f" );
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() );
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }




}
