package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author m809745357
 */
@RestController
public class XlassController {

    /**
     * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
     * <a href="http://127.0.0.1:8080/hello?name=Hello&method=hello">测试地址</a>
     * @return 返回方法内容
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Object hello(@RequestParam(value = "name") String name, @RequestParam(value = "method") String method) throws Exception {
        XlassClassLoader xlassClassLoader = new XlassClassLoader();
        Class<?> aClass = xlassClassLoader.loadClass(name);
        Object newInstance = aClass.getDeclaredConstructor().newInstance();
        Method classMethod = aClass.getMethod(method);
        return classMethod.invoke(newInstance);
    }

    /**
     * 自定义加载器
     */
    public static class XlassClassLoader extends ClassLoader {

        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {

            String suffix = ".xlass";

            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(name + suffix);

            if (resourceAsStream == null) {
                throw new ClassNotFoundException("没有找到该文件: " + name);
            }

            try {
                int available = resourceAsStream.available();
                byte[] bytes = new byte[available];
                int read = resourceAsStream.read(bytes);

                byte[] bytesFile = new byte[bytes.length];

                for (int i = 0; i < bytes.length; i++) {
                    bytesFile[i] = (byte) (255 - bytes[i]);
                }

                return defineClass(name, bytesFile, 0, bytesFile.length);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException("文件内容异常: " + name);
            } finally {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
