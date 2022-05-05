package com.grey.util.test;

import com.grey.util.CSVUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @description
 * @date 2022/5/5 17:24
 */
public class CSVUtilTest {
    /**
     * 测试数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testCsv(){
        List<Object> exportData = new ArrayList<Object>();
        exportData.add("第一列");
        exportData.add("第二列");
        exportData.add("第三列");
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object> data=new ArrayList<Object>();
        data.add("111");
        data.add("222");
        data.add("333");
        List<Object> data1=new ArrayList<Object>();
        data1.add("444");
        data1.add("555");
        data1.add("666");
        datalist.add(data);
        datalist.add(data1);
        String path = "D:\\Invoke\\";
        String fileName = "文件导出";
        File file = CSVUtil.createCSVFile(exportData, datalist, path, fileName);
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);
    }

}
