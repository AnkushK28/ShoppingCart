package com.example.shoppingcart.repository.helper;

import com.example.shoppingcart.model.Topping;
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

public class ToppingHelper
{
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        static String SHEET = "Topping";

        public static boolean hasExcelFormat(MultipartFile file) {
            return TYPE.equals(file.getContentType());
        }


            public static List<Topping> excelToToppings(InputStream inputStream) {

            try {
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
                XSSFSheet sheet = workbook.getSheet(SHEET);
                Iterator<Row> rows = sheet.iterator();

                List<Topping> ToppingList = new ArrayList<Topping>();

                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    if (rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cellsInRow = currentRow.iterator();

                    Topping toppings= new Topping();

                    int cellIdx = 0;
                    while (cellsInRow.hasNext())
                    {
                        Cell currentCell = cellsInRow.next();
                        switch (cellIdx) {
                            case 1:
                                toppings.setToppingName(currentCell.getStringCellValue());
                                break;

                            case 2:
                              toppings.setPrice((float) currentCell.getNumericCellValue());
                                break;

                            default:
                                break;
                        }

                        cellIdx++;
                    }

                   ToppingList.add(toppings);
                }

                workbook.close();

                return ToppingList;
            } catch (IOException e) {
                throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
            }

        }

    }
