package utils;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import pojo.Article;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @ClassName excelUtils
 * @Description TODO
 * @Author 89255
 */
public class excelUtils {
    public void exportExcelArticle(Article article, ServletOutputStream sos) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 6);
        // 1.2创建标题样式
        CellStyle style1 = createStyle(workbook, 16);
        // 1.3创建列标题样式
        CellStyle style2 = createStyle(workbook, 12);
        Sheet sheet = workbook.createSheet("文章");
        sheet.setDefaultColumnWidth(15);
        // 2.1将合并单元格作用于sheet
        sheet.addMergedRegion(cra);
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("文章");
        cell.setCellStyle(style1);
        String[] title = {"标题","作者","文章","标签"};
        Row row1 = sheet.createRow(1);
        for(int i = 0;i<title.length;i++){
               Cell cell1 = row1.createCell(i);
               cell1.setCellValue(title[i]);
               cell1.setCellStyle(style2);
        }
        Row row2 = sheet.createRow(2);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue(article.getTitle());
        Cell cell3 = row2.createCell(1);
        cell3.setCellValue(article.getAuthor());
        Cell cell4 = row2.createCell(2);
        cell4.setCellValue(article.getContext());
        Cell cell5 = row2.createCell(3);
        cell5.setCellValue(article.getLabel());
        workbook.write(sos);
    }

    private CellStyle createStyle(HSSFWorkbook workbook, int fontSize) {
        //1.2设置单元格样式
        CellStyle style = workbook.createCellStyle();
        // 设置水平居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 1.3设置字体
        Font font = workbook.createFont();
        // 设置字体为ARIAL
        font.setFontName(HSSFFont.FONT_ARIAL);
        // 设置粗体
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // 设置字体颜色
        //font.setColor(HSSFColor.BLUE.index);
        // 设置字体大小
        font.setFontHeightInPoints((short) fontSize);
        // 将字体加入样式
        style.setFont(font);
        return style;

    }
}
