package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.repository.CustomerRepositoy;
import com.example.shoppingcart.repository.helper.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class CustomerService
{

        @Autowired
        CustomerRepositoy customerrepositoy;

        public  void save(MultipartFile file)
        {
            try
            {
                List<Customer> customers= ExcelHelper.excelToCustomer(file.getInputStream());
                customerrepositoy.saveAll(customers);
            }
            catch(IOException e)
            {
                throw new RuntimeException("fail to store excel data: " + e.getMessage());
            }
        }
        public  List<Customer> getAllCustomers()
        {
            return customerrepositoy.findAll();
        }
        public  Customer CreateCustomer(Customer customer)
        {
            return customerrepositoy.save(customer) ;
        }
    }







//    public void fileupload(MultipartFile file) throws IOException {
//        Path tempDir = Files.createTempDirectory("");
//        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
//        file.transferTo(tempFile);
//        Workbook workbook = WorkbookFactory.create(tempFile);
//        Sheet sheet = workbook.getSheetAt(0);
//        Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(), false);
//        rowStream.forEach(row -> {
//            Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(), false);
//            List<String> cellVals = cellStream.map(cell -> {
//                String cellVal=null;
//                if(cell.getCellType()== CellType.STRING) {
//                     cellVal = cell.getStringCellValue();
//                }
//                else{
//                    cellVal=String.valueOf(cell.getNumericCellValue());
//                }
//
//                return cellVal;
//            }).collect(Collectors.toList());
//            System.out.println(cellVals);
//        });
//    }



