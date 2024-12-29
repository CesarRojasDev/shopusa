package com.shopusa.server.service.impl;

import com.shopusa.server.entity.*;
import com.shopusa.server.repository.*;
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
    @Autowired
    private SubCategoriaRepository subCategoriaRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private ComisionRepository comisionRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired PlataformaRepository plataformaRepository;

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

    @Override
    public ByteArrayInputStream exportSubCategoriasToExcel() throws IOException {
        List<SubCategoria> subCategorias = subCategoriaRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("SubCategorias");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Nombre", "Categoria", "Codigo", "Peso", "Ancho", "Alto", "Largo", "Garantia"};

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
            for (SubCategoria subCategoria : subCategorias) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(subCategoria.getId());
                row.createCell(1).setCellValue(subCategoria.getNombre());
                row.createCell(2).setCellValue(subCategoria.getCategoria().getNombre());
                row.createCell(3).setCellValue(subCategoria.getCodigo());
                row.createCell(4).setCellValue(subCategoria.getPesoGramos());
                row.createCell(5).setCellValue(subCategoria.getAncho());
                row.createCell(6).setCellValue(subCategoria.getAlto());
                row.createCell(7).setCellValue(subCategoria.getLargo());
                row.createCell(8).setCellValue(subCategoria.getGarantia());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }

    }

    @Override
    public ByteArrayInputStream exportPublicacionesToExcel() throws IOException {
        List<Publicacion> publicaciones = publicacionRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Publicaciones");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "FechaPublicacion", "Plataforma", "Precio", "SkuPlataforma","SkuShopusa", "Producto", "Usuario"};

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
            for (Publicacion publicacion : publicaciones) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(publicacion.getId());
                row.createCell(1).setCellValue(publicacion.getFechaPublicacion().toString());
                row.createCell(2).setCellValue(publicacion.getPlataforma().getNombre());
                row.createCell(3).setCellValue(publicacion.getPrecio());
                row.createCell(4).setCellValue(publicacion.getSkuPlataforma());
                row.createCell(5).setCellValue(publicacion.getProducto().getSku());
                row.createCell(6).setCellValue(publicacion.getProducto().getNombre());
                row.createCell(7).setCellValue(publicacion.getUsuario().getUsername());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override
    public ByteArrayInputStream exportComisionesToExcel() throws IOException {
        List<Comision> comisiones = comisionRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Comisiones");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Valor", "Categoria", "Plataforma"};

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
            for (Comision comision : comisiones) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(comision.getId());
                row.createCell(1).setCellValue(comision.getValor());
                row.createCell(2).setCellValue(comision.getCategoria().getNombre());
                row.createCell(3).setCellValue(comision.getPlataforma().getNombre());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }

    }

    @Override
    public ByteArrayInputStream exportPlataformasToExcel() throws IOException {
        List<Plataforma> plataformas = plataformaRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Plataformas");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Nombre"};

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
            for (Plataforma plataforma : plataformas) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(plataforma.getId());
                row.createCell(1).setCellValue(plataforma.getNombre());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }

    }

    @Override
    public ByteArrayInputStream exportCategoriasToExcel() throws IOException {
        List<Categoria> categorias = categoriaRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Categorias");

            // Crear el encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Nombre"};

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
            for (Categoria categoria : categorias) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(categoria.getId());
                row.createCell(1).setCellValue(categoria.getNombre());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
