import space.whm.open.CommonDemo;
import space.whm.open.ProtoDemo;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.List;

/**
 * https://developers.google.com/protocol-buffers/docs/overview?hl=zh-cn 
 * Protobuf在IDEA中的使用 https://blog.csdn.net/qq_39940205/article/details/80095302
 * Protobuf与JSON互相转换 https://blog.csdn.net/chen_fly2011/article/details/56488043
 * @author whm
 * @date 2018/4/26 14:44
 * protobuf是一种数据交换的格式，以二进制的格式进行数据交换，主要用于网络传输、配置文件、数据存储等诸多领域
 */
public class DDemo {
    public static void main(String[] args) {
        //获取Student对象
        //这里的Student对象构造器被私有化,我们通过Student的内部类Builder来构建builder
        ProtoDemo.Student.Builder builder = ProtoDemo.Student.newBuilder();
        //通过Student的内部类builder提供了构建Student相关属性的set方法
        builder.setId(1);
        builder.setName("凌晨0点0分");
        builder.setEmail("886886886@qq.com");
        builder.setSex(CommonDemo.Sex.MAN);
        //获取PhoneNumber对象
        ProtoDemo.Student.PhoneNumber.Builder builder1 = ProtoDemo.Student.PhoneNumber.newBuilder();
        builder1.setNumber("13611221234");
        builder1.setType(ProtoDemo.Student.PhoneType.MOBILE);
        ProtoDemo.Student.PhoneNumber pn = builder1.build();
        builder.addPhone(pn);
        //再创建1个PhoneNumber对象
        pn = ProtoDemo.Student.PhoneNumber.newBuilder().setNumber("13611221235").setType(ProtoDemo.Student.PhoneType.HOME).build();
        builder.addPhone(pn);
        //序列化
        ProtoDemo.Student stu = builder.build();
        System.out.println("protobuf数据大小: " + stu.toByteString().size());
        //再将封装有数据的对象实例，转换为字节数组，用于数据传输、存储等
        byte[] stuByte = stu.toByteArray();
        //这里得到了stuBte字节数组后，我们可以将该数据进行数据传输或存储，这里至于用什么技术传输就根据具体情况而定
        //假如这里stuByt通过传输，下面的代码接到了该数据
        //接收方 ,这里为了方便我们就写在一个类里面
        //将字节数据反序列化为对应的对象实例
        ProtoDemo.Student student = null;
        try {
            student = ProtoDemo.Student.parseFrom(stuByte);
            //这里得到了Student实例了，就可以根据需要来操作里面的数据了
            System.out.println("学生ID:" + student.getId());
            System.out.println("姓名：" + student.getName());
            System.out.println("性别：" + (student.getSex().getNumber() == 0 ? "男" : "女"));
            System.out.println("邮箱：" + student.getEmail());
            //遍历phoneNumber字段
            List<ProtoDemo.Student.PhoneNumber> phList = student.getPhoneList();
            for (ProtoDemo.Student.PhoneNumber p : phList) {
                System.out.println(p.getType() + "电话:" + p.getNumber());
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        /*如何快速的进行json格式化*/
        String jsonObject = "";
        try {
            jsonObject = JsonFormat.printer().print(student);
        } catch (InvalidProtocolBufferException e) {
            e.getMessage();
        }
        System.out.println(jsonObject.toString());
        System.out.println("json数据大小: " + jsonObject.getBytes().length);
        
        
        //json to pb
        ProtoDemo.Student.Builder builder2 = ProtoDemo.Student.newBuilder();
        try {
			JsonFormat.parser().merge(jsonObject, builder2);
			System.out.println("getEmail:" + builder2.getEmail());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
