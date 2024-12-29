package com.shopusa.server.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelService {
    ByteArrayInputStream exportProductosToExcel() throws IOException;
    ByteArrayInputStream exportSubCategoriasToExcel() throws IOException;
    ByteArrayInputStream exportPublicacionesToExcel() throws IOException;
    ByteArrayInputStream exportComisionesToExcel() throws IOException;
    ByteArrayInputStream exportPlataformasToExcel() throws IOException;
    ByteArrayInputStream exportCategoriasToExcel() throws IOException;
}
