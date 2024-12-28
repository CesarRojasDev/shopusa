package com.shopusa.server.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelService {

    ByteArrayInputStream exportProductosToExcel() throws IOException;
}
