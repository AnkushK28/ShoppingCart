package com.example.shoppingcart.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
@Service
public class ShoppingCartService
{


    public void fileupload(MultipartFile file) throws IOException {
        Path tempDir = Files.createTempDirectory("");
        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
        file.transferTo(tempFile);
        Workbook workbook = WorkbookFactory.create(tempFile);
        Sheet sheet = workbook.getSheetAt(0);
        Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(), false);
        rowStream.forEach(row -> {
            Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(), false);
            List<String> cellVals = cellStream.map(cell -> {
                String cellVal=null;
                if(cell.getCellType()== CellType.STRING) {
                     cellVal = cell.getStringCellValue();
                }
                else{
                    cellVal=String.valueOf(cell.getNumericCellValue());
                }

                return cellVal;
            }).collect(Collectors.toList());
            System.out.println(cellVals);
        });
    }
}
