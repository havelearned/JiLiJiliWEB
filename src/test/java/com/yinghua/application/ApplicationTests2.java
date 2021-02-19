package com.yinghua.application;

import com.yinghua.application.mapper.MoviesMapper;
import com.yinghua.application.pojo.Movies;
import com.yinghua.application.pojo.Photo;
import com.yinghua.application.service.PhotoService;
import com.yinghua.application.util.EmailUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.List;


@SpringBootTest
@MapperScan("com.yinghua.application.mapper")
public class ApplicationTests2 {

    @Autowired
    MoviesMapper moviesMapper;

    @Autowired
    PhotoService photoService;

    @Autowired
    EmailUtil emailUtil;



    /**
     * 测试 邮箱

    @Test
    public void Test04(){
       emailUtil=new EmailUtil();
        int i = emailUtil.SimpleEmail("1939571437@qq.com");

    }
     * */

    /**
     * 测试 图片和电影
     * */
    @Test
    public void Test03(){
        List<Movies> movies = moviesMapper.QueryMovieAndPhoto();
        for(Movies movies1: movies){
            System.out.println(movies1.photo.getP_name());
        }
    }

    @Test
    public void Test02() {

       /* List<Photo> allPhoto = photoService.getAllPhoto();
        for(Photo photo:allPhoto){
            Byte[] p_photo = photo.getP_photo();
            p_photo.
        }*/

        System.out.println("===========================");
        String strImg = getImageStr("C:\\Users\\admin\\Pictures\\Saved Pictures\\罗家炬_报学信网照片.jpg");
        System.out.println(strImg);
        generateImage(strImg, "C:\\Users\\admin\\Pictures\\Saved Pictures\\罗家炬_报学信网照片.jpg");
        System.out.println("===========================");

    }

    /**
     * @param imgStr base64编码字符串
     * @param path   图片路径-具体到文件
     * @return
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     */

    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null) return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
// 解密
            byte[] b = decoder.decodeBuffer(imgStr);
// 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * @return
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);


    }

    @Test
    public void Test01 () {
        List<Photo> allPhoto = photoService.getAllPhoto();


        System.out.println("+=============================================");
        System.out.println("+=============================================");
        System.out.println("+=============================================");
    }

}
