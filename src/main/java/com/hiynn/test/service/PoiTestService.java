package com.hiynn.test.service;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface PoiTestService {

    void importExcelInfo(InputStream in, MultipartFile file) throws Exception;

    XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

    XSSFWorkbook exportExcelInfoId(List<String> id) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;
}
