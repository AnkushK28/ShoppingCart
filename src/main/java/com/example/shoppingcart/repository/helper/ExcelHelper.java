package com.example.shoppingcart.repository.helper;

import com.example.shoppingcart.model.Customer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    private ExcelHelper(){}
    public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "customer";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Customer> excelToCustomer(InputStream is) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Customer> customers = new ArrayList<Customer>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0)
                {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Customer customer = new Customer();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx)
                    {

                        case 1:
                            customer.setName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            customer.setPhone((long) currentCell.getNumericCellValue());
                            break;
                        case 3:
                            customer.setEmail(currentCell.getStringCellValue());
                            break;
                        case 4:
                            customer.setAddress(currentCell.getStringCellValue());
                            break;
                        default:


                    }
                    cellIdx++;
                }
                customers.add(customer);
            }
            workbook.close();

            return customers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: ");
        }

    }



}
