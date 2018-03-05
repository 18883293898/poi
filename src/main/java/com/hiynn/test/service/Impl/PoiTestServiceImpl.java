package com.hiynn.test.service.Impl;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hiynn.test.dao.PoiTestDao;
import com.hiynn.test.pojo.ExcelBean;
import com.hiynn.test.pojo.JzxManage;
import com.hiynn.test.service.PoiTestService;
import com.hiynn.test.utils.ExcelUtil;

@Service
public class PoiTestServiceImpl implements PoiTestService {

    @Autowired
    private PoiTestDao poiTestDao;

    /**
     * 导入操作
     */
    @Override
    public void importExcelInfo(InputStream in, MultipartFile file)
            throws Exception {
        List<List<Object>> listob = ExcelUtil.getBankListByExcel(in, file.getOriginalFilename());
        List<JzxManage> salaryList = new ArrayList<JzxManage>();
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            JzxManage JzxManage = new JzxManage();
            //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载
            JzxManage.setId(String.valueOf(ob.get(0)));
            JzxManage.setName(String.valueOf(ob.get(1)));
            JzxManage.setHeight(Integer.parseInt(String.valueOf(ob.get(2))));
            JzxManage.setAge(Integer.parseInt(String.valueOf(ob.get(3))));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = sdf.parse(String.valueOf(ob.get(4)));
            JzxManage.setBirth(date);

            salaryList.add(JzxManage);
        }
        //批量插入
        poiTestDao.insertInfoBatch(salaryList);

    }


    /**
     * 导出操作
     */
    @Override
    public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException,
            IntrospectionException, ParseException, IllegalAccessException {
        //根据条件查询数据，把数据装载到一个list中
        List<Object> list = poiTestDao.selectApartInfo();
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        //设置标题栏
        excel.add(new ExcelBean("序号", "id", 0));
        excel.add(new ExcelBean("姓名", "name", 0));
        excel.add(new ExcelBean("身高", "height", 0));
        excel.add(new ExcelBean("年龄", "age", 0));
        excel.add(new ExcelBean("日期", "birth", 0));
        map.put(0, excel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String da = sdf.format(new Date());
        String sheetName = da + "人员信息";
        //调用ExcelUtil的方法
        //xssfWorkbook = ExcelUtil.createExcelFile(Manage.class, list, map, sheetName);
        xssfWorkbook = ExcelUtil.createExcelFile(JzxManage.class, list, map, sheetName);
        return xssfWorkbook;
    }


    /**
     * 导出部分
     */
    @Override
    public XSSFWorkbook exportExcelInfoId(List<String> id) throws InvocationTargetException, ClassNotFoundException,
            IntrospectionException, ParseException, IllegalAccessException {
        List<Object> list = poiTestDao.selectApartInfoId(id);
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        //设置标题栏
        excel.add(new ExcelBean("序号", "id", 0));
        excel.add(new ExcelBean("姓名", "name", 0));
        excel.add(new ExcelBean("身高", "height", 0));
        excel.add(new ExcelBean("年龄", "age", 0));
        excel.add(new ExcelBean("日期", "birth", 0));
        map.put(0, excel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String da = sdf.format(new Date());
        String sheetName = da + "人员信息";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(JzxManage.class, list, map, sheetName);
        return xssfWorkbook;
    }


}
