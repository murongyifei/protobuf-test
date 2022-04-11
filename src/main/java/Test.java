import com.google.gson.GsonBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.FileUtils;
import space.whm.open.ReportPosBillGreater;
import space.whm.open.ReportPosBillInfo;
import space.whm.open.ReportPosBillInfo1;
import space.whm.open.ReportPosBillLess;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
//        writeToFile();
        readToByte();
        beanToPB();
        pbToBean();
    }

    public static void readToByte() {
        System.out.println("======读取字段少的PB文件--转换到字段多的PB实体=======不报错");
        try {
            // 读取字段少的文件
            byte[] bytes = FileUtils.readFileToByteArray(new File(System.getProperties().get("user.dir")
                    + "/pbdata/09Col.txt"));
            // 转换到字段多的实体
            ReportPosBillInfo.ReportPosBill reportPosBill = ReportPosBillInfo.ReportPosBill.parseFrom(bytes);
            System.out.println("--" + reportPosBill.getBillid());
            System.out.println("--" + reportPosBill.getPmname());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=============");
        System.out.println("======读取字段多的PB文件--转换到字段少的PB实体=======不报错");
        try {
            // 读取字段多的文件
            byte[] bytes = FileUtils.readFileToByteArray(new File(System.getProperties().get("user.dir")
                    + "/pbdata/11Col.txt"));
            // 转换到字段少的实体
            ReportPosBillInfo1.ReportPosBill reportPosBill1 = ReportPosBillInfo1.ReportPosBill.parseFrom(bytes);
            System.out.println("--" + reportPosBill1.getBillid());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=============");
    }
    
    public static void writeToFile() {
        // 字段多的实体
        ReportPosBillInfo.ReportPosBill.Builder builder = ReportPosBillInfo.ReportPosBill.newBuilder();
        builder.setOgnid(27)
                .setBillid("5735666199e7477abdb078a7133da8ba")
                .setBillno("1201022032617000028")
                .setBusinesstype(1)
                .setSource(1)
                .setTableno("12")
                .setTotalconsume(51.0)
                .setRealprice(41.0)
                .setPmname("现金")
                .setPaytime("2022-03-01 12:12:12")
                .setBillstatus(1);

        // 字段少的实体
        ReportPosBillInfo1.ReportPosBill.Builder builder1 = ReportPosBillInfo1.ReportPosBill.newBuilder();
        builder1.setOgnid(27)
                .setBillid("5735666199e7477abdb078a7133da8ba")
                .setBillno("1201022032617000028")
                .setBusinesstype(1)
                .setSource(1)
                .setTableno("12")
                .setTotalconsume(51.0)
                .setRealprice(41.0)
                .setBillstatus(1);
        try {
            FileUtils.writeByteArrayToFile(new File(System.getProperties().get("user.dir")
                    + "/pbdata/11Col.txt"), builder.build().toByteArray());
            FileUtils.writeByteArrayToFile(new File(System.getProperties().get("user.dir")
                    + "/pbdata/09Col.txt"), builder1.build().toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void beanToPB() {
        System.out.println("======字段少的bean--转换到字段多的PB实体=======不报错");
        ReportPosBillLess less = new ReportPosBillLess(27, "5735666199e7477abdb078a7133da8ba", "1201022032617000028", 1, 1, "12", 51.0, 41.0, 1);
        String json = new GsonBuilder().create().toJson(less);
        ReportPosBillInfo.ReportPosBill.Builder builder = ReportPosBillInfo.ReportPosBill.newBuilder();
        try {
            JsonFormat.parser().merge(json, builder);
            System.out.println("--" + builder.build().getBillno());
            System.out.println("--" + builder.build().getPmname());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println("=============");
        System.out.println("======字段多的Bean--转换到字段少的PB实体=======转换异常");
        System.out.println("======特殊情况：Bean多的这些字段值为null，序列化之后的字符串不包括这些null值的字段，正好匹配字段少的PB实体，转换正常=======");
        ReportPosBillGreater greater = new ReportPosBillGreater(27, "5735666199e7477abdb078a7133da8ba", "1201022032617000028", 1, 1, "12", 51.0, 41.0, "现金", "2022-03-01 12:12:12", 1);
        String json1 = new GsonBuilder().create().toJson(greater);
        ReportPosBillInfo1.ReportPosBill.Builder builder1 = ReportPosBillInfo1.ReportPosBill.newBuilder();
        try {
            JsonFormat.parser().merge(json1, builder1);
            System.out.println("--" + builder1.build().getBillno());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public static void pbToBean() {
        System.out.println("======字段少的PB实体--转换到字段多的bean=======不报错");
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(System.getProperties().get("user.dir")
                    + "/pbdata/09Col.txt"));
            ReportPosBillInfo1.ReportPosBill reportPosBill1 = ReportPosBillInfo1.ReportPosBill.parseFrom(bytes);
            String json = JsonFormat.printer().print(reportPosBill1);
            ReportPosBillGreater greater = new GsonBuilder().create().fromJson(json, ReportPosBillGreater.class);
            System.out.println("--" + greater.getBillno());
            System.out.println("--" + greater.getPmname());
        } catch (IOException e) {
//            e.printStackTrace();
            e.printStackTrace();
        }
        System.out.println("=============");
        System.out.println("======字段多的PB实体--转换到字段少的bean=======不报错");
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(System.getProperties().get("user.dir")
                    + "/pbdata/11Col.txt"));
            ReportPosBillInfo.ReportPosBill reportPosBill = ReportPosBillInfo.ReportPosBill.parseFrom(bytes);
            String json = JsonFormat.printer().print(reportPosBill);
            ReportPosBillLess less = new GsonBuilder().create().fromJson(json, ReportPosBillLess.class);
            System.out.println("--" + less.getBillno());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
