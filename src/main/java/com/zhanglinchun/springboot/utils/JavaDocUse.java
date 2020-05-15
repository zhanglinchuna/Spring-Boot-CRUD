package com.zhanglinchun.springboot.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;


import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;



public class JavaDocUse {
    private static RootDoc rootDoc;
    public static  class Doclet {
        public static boolean start(RootDoc rootDoc) {
            JavaDocUse.rootDoc = rootDoc;
            return true;
        }
    }

    /**
     * 显示DocRoot中的基本信息
     */
    public static void show(){
        ClassDoc[] classes = rootDoc.classes();
        for(ClassDoc classDoc : classes){
            System.out.println(classDoc.name()+
                    "类的注释:"+classDoc.commentText());
            MethodDoc[] methodDocs = classDoc.methods(false);
            for(MethodDoc methodDoc : methodDocs){
                // 打印出方法上的注释
                System.out.println("类"
                        +classDoc.name()+","+
                        "方法："
                        +methodDoc.name()+","+
                        "方法注释:"
                        +methodDoc.commentText());
            }
            FieldDoc[] fields = classDoc.fields(false);

            for (FieldDoc fieldDoc : fields) {
                System.out.println("类"
                        +classDoc.name()+","+
                        "字段："
                        +fieldDoc.name()+","+
                        "字段注释:"
                        +fieldDoc.commentText());
            }
        }
    }

    public static void main(String[] args) {
        com.sun.tools.javadoc.Main.execute(new String[] {"-doclet",
                Doclet.class.getName(),
                "-encoding","utf-8","-classpath",
                "D:\\idea_workspace\\spring-boot-web-restfulcrud\\target\\classes",
                "D:\\idea_workspace\\spring-boot-web-restfulcrud\\src\\main\\java\\com\\zhanglinchun\\springboot\\entities\\AttrEntity.java"});
        show();
    }
}
