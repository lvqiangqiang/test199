package utils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * csv导入导出工具类
 * @author kpzc
 * @date 2018年12月29日 下午3:45:00
 * @desc
 */
public class CSVUtils {
//     private static final Logger logger = LoggerFactory.getLogger(CSVUtils.class);

    /**
     * 导入
     * @author kpzc
     * @date 2018年12月29日 下午3:48:11
     * @param file  csv文件(路径+文件)
     * @return 返回List<String>列表
     */
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        BufferedReader br=null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
            br = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
    }

    /**
     * apache commons-csv导出
     * 注意jdk要在1.7及以上使用
     * map的数据个数要与header的个数相等 并且一一对应，可参照main方法
     * @author kpzc
     * @date 2019年1月4日 上午10:12:20
     * @param filePath 文件存储路径
     * @param list 数据列表
     * @param header 表头
     */
    public static void write(String filePath,List<LinkedHashMap<String, String>> list,String[] header) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
            CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(header);
            CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
            //跟上面两行代码是一样的
            //CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader(header).print(osw);
            for (Map<String, String> map : list) {
                csvPrinter.printRecord(map.values());
            }
            csvPrinter.flush();
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//
//        String filePath = "C:\\Users\\KKGS\\Desktop\\aaa.csv";
//        String header1 = "姓名";
//        String header2 = "性别";
//        String header3 = "编号";
//        String header4 = "描述";
//        String [] str = new String[4];
//        str[0] = header1;
//        str[1] = header2;
//        str[2] = header3;
//        str[3] = header4;
//
//        List<LinkedHashMap<String, String>> recordList = new ArrayList<LinkedHashMap<String, String>>();
//        for (int i = 0; i < 5; i++) {
//            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//            map.put("name", "zhangsan");
//            map.put("sex", "男");
//            map.put("code", "001");
//            map.put("aa", "aaa");
//            recordList.add(map);
//        }
////        write(filePath, recordList,header1,header2,header3,header4);
//        write(filePath, recordList,str);

        List<String> strings = importCsv(new File("C:\\Users\\KKGS\\Desktop\\aaa.csv"));

        System.out.println(JSON.toJSON(strings));
    }
}