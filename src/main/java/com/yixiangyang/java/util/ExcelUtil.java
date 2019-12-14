package com.yixiangyang.java.util;

import io.netty.handler.codec.CodecException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * 导出工具类
	 * 
	 * @param response
	 * @param lines    跟导入进来,返回出来的对象一致,行集合
	 * @param titles   为Excel 实体类属性集合一一对应的意思 比如我的实体类有 id,name,age,address
	 *                 那么这个集合就是List<String> list =new
	 *                 ArrayList<>(){"id","名称","年龄","地址"}
	 * @param title    为标题
	 * @throws Exception
	 */
//	public static void excelExport(HttpServletResponse response, List<Line> lines, List<String> titles, String title)
//			throws Exception {
//		response.setHeader("content-Type", "application/vnd.ms-excel");
//		// 下载文件的默认名称
//		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(title, "utf-8"));
//
//		exportExcel(titles, lines, title);
//	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("id");
		list.add("name");
		List<Line> lines = new ArrayList<>();
		List<Column> column1 = new ArrayList<>();
		column1.add(new Column("id", 1));
		column1.add(new Column("name", "向阳"));
		Line line1 = new Line();
		line1.setColumns(column1);
		lines.add(line1);
		Line line2 = new Line();
		line2.setColumns(column1);
		lines.add(line2);
		exportExcel(list, lines, "","这个是文件名字");
	}

	public static void exportExcel(List<String> headerList, List<Line> lines, String title,String excelName) {
		if (excelName == null) {
			throw new CodecException("文件名字不能为空");
		}
		// 创建Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet 默认是表名是sheet0
		HSSFSheet sheet = workbook.createSheet();
		HSSFCell cell = null;
		if (!StringUtils.isEmpty(title)) {
			// 创建表的第一行
			HSSFRow row = sheet.createRow(0);
			sheet.setDefaultColumnWidth(20);
			sheet.setDefaultRowHeightInPoints(20);
			// 创建第0行 也就是标题
			row.setHeightInPoints(30);// 设备标题的高度
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headerList.size()-1));
			// 创建单元格
			cell = row.createCell(0);
			cell.setCellStyle(titleStyle(workbook));
			cell.setCellValue(title);
		}
		int rown = 0;
		if (title != null && title.trim().length() > 0) {
			rown = 1;
		}
		HSSFRow rowRowName = sheet.createRow(rown);
		// 创建表头
		for (int n = 0; n < headerList.size(); n++) {
			// 循环为第一行插入标题
			for (int i = 0; i < headerList.size(); i++) {
				cell = rowRowName.createCell(i);
				cell.setCellStyle(style(workbook));
				cell.setCellValue(headerList.get(i));
			}
		}
		HSSFCellStyle style1=style1(workbook);
		// 创建excel数据
		for (int i = 0; i < lines.size(); i++) {
			int row = 1;
			if (!StringUtils.isEmpty(title) && !headerList.isEmpty()) {
				row = 2;
			}
			List<Column> columns =lines.get(i).getColumns();
			HSSFRow nextrow = sheet.createRow(i+row);
			for (int j = 0; j < columns.size(); j++) {
				HSSFCell cell2 = nextrow.createCell(j);
				cell2.setCellStyle(style1);
				if (columns.get(j).getValue() == null) {
					cell2.setCellValue("");
				} else {
					cell2.setCellValue(String.valueOf(columns.get(j).getValue()));
				}
			}
		}
		try {
			// .xls 是2003版本，excel2003、2007、2010都可以打开，兼容性最好
			if (workbook != null) {
				try {
					FileOutputStream fout = new FileOutputStream(excelName + ".xls");
					workbook.write(fout);
					fout.close();
					LOGGER.info("写入成功!!!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// 标题第一行样式
	public static HSSFCellStyle titleStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setBottomBorderColor((short) 8);
		style.setBorderBottom(BorderStyle.THIN); // HSSFCellStyle.BORDER_THIN
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
		headerFont.setFontName("黑体"); // 设置字体类型
		headerFont.setFontHeightInPoints((short) 15); // 设置字体大小
		style.setFont(headerFont); // 为标题样式设置字体样式
		return style;
	}

	// 第二行样式
	public static HSSFCellStyle style(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setBottomBorderColor((short) 8);
		style.setBorderBottom(BorderStyle.THIN); // HSSFCellStyle.BORDER_THIN
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
		headerFont.setFontName("黑体"); // 设置字体类型
		headerFont.setFontHeightInPoints((short) 12); // 设置字体大小
		style.setFont(headerFont); // 为标题样式设置字体样式
		return style;
	}

	// 数据行样式
	public static HSSFCellStyle style1(HSSFWorkbook wb) {
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);// 设置自动换行
		style1.setAlignment(HorizontalAlignment.CENTER); // HSSFCellStyle.ALIGN_CENTER
		style1.setVerticalAlignment(VerticalAlignment.CENTER); // HSSFCellStyle.VERTICAL_CENTER // 创建一个居中格式
		style1.setBottomBorderColor((short) 8);
		style1.setBorderBottom(BorderStyle.THIN); // HSSFCellStyle.BORDER_THIN
		style1.setBorderLeft(BorderStyle.THIN);
		style1.setBorderRight(BorderStyle.THIN);
		style1.setBorderTop(BorderStyle.THIN);
		HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式
		headerFont1.setFontName("黑体"); // 设置字体类型
		headerFont1.setFontHeightInPoints((short) 10); // 设置字体大小
		style1.setFont(headerFont1); // 为标题样式设置字体样式
		return style1;
	}

}
