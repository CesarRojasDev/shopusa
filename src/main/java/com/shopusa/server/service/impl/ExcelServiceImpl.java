package com.shopusa.server.service.impl;

import com.shopusa.server.entity.Producto;
import com.shopusa.server.repository.ProductoRepository;
import com.shopusa.server.service.ExcelService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ByteArrayInputStream exportProductosToExcel() throws IOException {
        List<Producto> productos = productoRepository.findAll();

        // Crear el libro de Excel
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Productos");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "SKU", "Marca", "Modelo", "Nombre", "Color", "Descripcion", "Link", "SubCategoria", "PrecioUSD", "PrecioSoles", "Stock"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            // Llenar los datos
            int rowIdx = 1;
            for (Producto producto : productos) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(producto.getId());
                row.createCell(1).setCellValue(producto.getSku());
                row.createCell(2).setCellValue(producto.getMarca());
                row.createCell(3).setCellValue(producto.getModelo());
                row.createCell(4).setCellValue(producto.getNombre());
                row.createCell(5).setCellValue(producto.getColor());
                row.createCell(6).setCellValue(producto.getDescripcion());
                row.createCell(7).setCellValue(producto.getLink());
                row.createCell(8).setCellValue(producto.getSubCategoria().getNombre());
                row.createCell(9).setCellValue(producto.getPrecioUSD());
                row.createCell(10).setCellValue(producto.getPrecioSoles());
                row.createCell(11).setCellValue(producto.getStock());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
