import org.apache.commons.io.FileUtils;
import space.whm.open.ReportPosBillInfo;
import space.whm.open.ReportPosBillInfo1;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
//        writeToFile();
        readToByte();
    }

    public static void readToByte() {
        System.out.println("======读取字段少的文件--转换到字段多的实体=======");
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
        System.out.println("======读取字段多的文件--转换到字段少的实体=======");
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
}
