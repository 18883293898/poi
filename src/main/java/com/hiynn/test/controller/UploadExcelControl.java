package com.hiynn.test.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hiynn.test.dao.PoiTestDao;
import com.hiynn.test.service.PoiTestService;


@Controller
@RequestMapping("/uploadExcel")
public class UploadExcelControl {

    @Autowired
    private PoiTestService poiTestService;
    @Autowired
    private PoiTestDao poiTestDao;

    /**
     * 导入操作
     * <p>Title: uploadExcel </p>
     * <p>Description: TODO </p>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "upload", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView uploadExcel(HttpServletRequest request) throws Exception {
        System.err.println("开始导入excel文件！");

        //获取上传的文件  
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        InputStream in = file.getInputStream();
        //数据导入  
        poiTestService.importExcelInfo(in, file);
        in.close();
        ModelAndView mo = new ModelAndView("index");
        List<Object> list = poiTestDao.selectApartInfo();
        mo.addObject("list", list);
        return mo;
    }

    /**
     * <p>Title: 导出部分 </p>
     * <p>Description: TODO </p>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "exportId", method = {RequestMethod.GET, RequestMethod.POST})
    public void ajaxUploadExcelId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.err.println("导出poi开始！");
        response.reset(); //清除buffer缓存
        // 指定下载的文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
        String da = sdf.format(new Date());
        response.setHeader("Content-Disposition", "attachment;filename=" + da + ".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;
        //导出Excel对象
        String ids = request.getParameter("taskIds");
        List<String> id = Arrays.asList(ids.split(","));
        workbook = poiTestService.exportExcelInfoId(id);
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            //bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            //bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 导出操作
     * <p>Title: export </p>
     * <p>Description: TODO </p>
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "export", method = {RequestMethod.GET, RequestMethod.POST})
    public void ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.err.println("导出poi开始！");
        response.reset(); //清除buffer缓存
        // 指定下载的文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
        String da = sdf.format(new Date());
        response.setHeader("Content-Disposition", "attachment;filename=" + da + ".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;
        //导出Excel对象
            /*String id1 = "1";
            String id2 = "2";
            List<String> id = new ArrayList<>();
            id.add(id1);
            id.add(id2);*/
        workbook = poiTestService.exportExcelInfo();
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
