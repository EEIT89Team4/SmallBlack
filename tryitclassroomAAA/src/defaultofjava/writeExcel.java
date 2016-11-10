package defaultofjava;

import java.io.*;
import jxl.*;
import jxl.write.*;

public class writeExcel

{
        public static void main (String[] args) throws Exception
        {
        	writeExcel XT = new writeExcel();
                XT.writeFile();
        } 
        public void writeFile()
        {
                try
                {
                        WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/Users/egg/Documents/My Dropbox/Java/寫資料到excel檔/output.xls"));
                        WritableSheet sheet = workbook.createSheet("First Sheet", 0);  //工作表名稱
                        jxl.write.Number number = new jxl.write.Number(2,10,99);        //第幾列第幾行輸入什麼值
                        sheet.addCell(number);      //寫入到工作表去
                        for(int j=1;j<=2;j++)
                        {
                                for(int k=1;k<=10;k++)
                                {                               
                                        number.setValue(j*k);      //將數值做運算
                                        sheet.addCell(number.copyTo(j-1,k-1)); //將數值移到指定位置
                                }
                        }
                        workbook.write();   //寫入
                        workbook.close();   //關閉
                }
                catch(IOException e)
                {
                        System.out.println(e.toString());   
                }
                catch(Exception e)
                {
                        System.out.println(e.toString());   
                }

    }

}
