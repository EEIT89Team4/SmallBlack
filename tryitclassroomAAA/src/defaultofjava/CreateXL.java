package defaultofjava;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateXL {
	 //Excel �ɭn�s�񪺦�m
	public static String outputFile="C:/testofxml/gongye.xls";

	public static void main(String argv[]){

	try{
	// �Ыطs��Excel ����ï
	HSSFWorkbook workbook = new HSSFWorkbook();
	
	// �bExcel����ï���ؤ@�u�@��A��W���ʬ٭�
	// �p�n�s�ؤ@�W��"�įq����"���u�@��A��y�y���G
	// HSSFSheet sheet = workbook.createSheet("�įq����");
	HSSFSheet sheet = workbook.createSheet("123456");
	
	// �b����0����m�Ыئ�]�̳��ݪ���^(�������)
	HSSFRow row00 = sheet.createRow(0);
	HSSFRow row11 = sheet.createRow(1);

	//�b����0����m�Ы��x�s��]���W�ݡ^(�W�����)
	HSSFCell cell00 = row00.createCell(0);
	HSSFCell cell01 = row00.createCell(1);
	HSSFCell cell11 = row11.createCell(1);
	
	// �w�q�x�s�欰�r������
	cell00.setCellType(HSSFCell.CELL_TYPE_STRING);
	cell01.setCellType(HSSFCell.CELL_TYPE_STRING);
	cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
	
	// �b�x�s�椤��J�@�Ǥ��e
	cell00.setCellValue("����00");
	cell01.setCellValue("����01");
	cell11.setCellValue("����11");
	
	// �s�ؤ@��X�ɮ׬y
	FileOutputStream fOut = new FileOutputStream(outputFile);
	
	// �������Excel ����ï�s��
	workbook.write(fOut);
	fOut.flush();
	
	// �ާ@�����A������
	fOut.close();
	System.out.println("�ɥͦ�OK~~~");

	}catch(Exception e) {
		System.out.println("�w�B�� xlCreate() : " + e );
	}
	}
}

