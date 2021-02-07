package com.yinghua.application.util.utilController;

import com.yinghua.application.pojo.Movies;
import com.yinghua.application.pojo.Ticket;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.service.RespService;
import com.yinghua.application.service.TicketService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReportController 文件上传下载，Execl 导入 导出
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-21-14:49-01
 * @Version 1.0
 */
@Controller
public class ReportController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TicketService ticketService;

    @Autowired
    MovieService movieService;

    @Autowired
    RespService respService;


    String PATH_DOWNLLOAD = "/software/My/B-Download/";
    String PATH_EXCEL = "/software/My/A-Excel/";
    String PATH_LOG = "/software/My/SystemLog/DDSYSystem/log/";

    @GetMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.trace("文件下载");
        try {
            File scFileDir = new File(PATH_LOG);
            if (!scFileDir.exists()) {
                scFileDir.mkdirs();
            }
            File TrxFiles[] = scFileDir.listFiles();
            String fileName = TrxFiles[0].getName(); //下载的文件名
            if (fileName != null) {
                //设置文件路径
                File file = new File(PATH_LOG, fileName);
                if (file.exists()) {
                    response.setHeader("content-type", "application/octet-stream");
                    response.setContentType("application/octet-stream");
                    // 下载文件能正常显示中文
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                    // 实现文件下载
                    byte[] buffer = new byte[1024];
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
//                    PrintWriter os = response.getWriter();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    model.addAttribute("success", "下载成功");

                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            } else {
                scFileDir.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "report-day";

    }

    @GetMapping("/report")
    public String toReport() {
        logger.trace("ReportController.toReport 来到汇报页面");
        return "report-day";
    }

    /**
     * @return
     * @description: 导出影片Excel
     * @params
     * @data 2020/12/23 21:49
     * @author Luojiaju
     **/
    @GetMapping("/report/createexcel2")
    public String doCreateMoviesExcel(Model model) {
        logger.trace("ReportController.doCreateMoviesExcel 导出影片Excel");
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("影片信息");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("电影名称");
        row.createCell(1).setCellValue("导演");
        row.createCell(2).setCellValue("主演");
        row.createCell(3).setCellValue("配角");
        row.createCell(4).setCellValue("上映时间");
        List<Movies> movies = movieService.doMovies();


        for (int i = 1; i < movies.size() + 1; i++) {
            Row row1 = sheet.createRow(i);
            int j = i - 1;
            row1.createCell(0).setCellValue(movies.get(j).getmMovieName());
            row1.createCell(1).setCellValue(movies.get(j).getmDirector());
            row1.createCell(2).setCellValue(movies.get(j).getmProtagonist());
            row1.createCell(3).setCellValue(movies.get(j).getmSupport());
            Date date = movies.get(j).getmScreen();
            String s = new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
            row1.createCell(4).setCellValue(s);
        }
        try {
//            PATH = ResourceUtils.getURL("classpath:").getPath()+"A-Excel";
            File file1 = new File(PATH_EXCEL);
            if (!file1.exists()) file1.mkdirs();
            String s = new DateTime().toString("yyyy-MM-dd");

            String filename = file1 + "/电影列表-" + s + ".xlsx";
            System.out.println(filename);
            FileOutputStream file = new FileOutputStream(filename);

            workbook.write(file);
            model.addAttribute("success", filename);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "report-day";
    }

    /**
     * @return
     * @description:导出 购票者信息
     * @params
     * @data 2020/12/23 21:50
     * @author Luojiaju
     **/
    @GetMapping("/report/createexcel1")
    public String doCreateTicketExcel(Model model) {
        logger.trace("ReportController.doCreateTicketExcel 导出 购票者信息");
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("有效用户");
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("用户名");
        row0.createCell(1).setCellValue("性别");
        row0.createCell(2).setCellValue("手机号");
        row0.createCell(3).setCellValue("身份证");

        List<Ticket> tickets = ticketService.doQueryTickets();

        for (int i = 1; i < tickets.size() + 1; i++) {
            Row row = sheet.createRow(i);
            int j = i - 1;
            row.createCell(0).setCellValue(tickets.get(j).gettNickname());
            row.createCell(1).setCellValue(tickets.get(j).gettGender());
            row.createCell(2).setCellValue(tickets.get(j).gettPhone());
            row.createCell(3).setCellValue(tickets.get(j).gettCard());
        }
        try {

//            PATH = ResourceUtils.getURL("classpath:").getPath()+"A-Excel";
            File file1 = new File(PATH_EXCEL);
            if (!file1.exists()) file1.mkdirs();
            String s = new DateTime().toString("yyyy-MM-dd");
            String filename = file1 + "/购票者-" + s + ".xlsx";
            System.out.println(filename);
            FileOutputStream file = new FileOutputStream(filename);
            workbook.write(file);
            model.addAttribute("success", filename);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "report-day";
    }

    /**
     * @return Resp<String>
     * @description: 文件上传
     * 文件上传到服务器的专属文件夹，存放。
     * 为保证上传的文件与之前上传的文件出现 文件名相同的情况下使用 时间戳，保证文件名称不一致
     * @params file 上传的文件对象
     * @data 2020/12/23 14:21
     * @author Luojiaju
     **/
    @PostMapping(value = "/upload")
    public String upload(@RequestPart("file") MultipartFile file, Model model) {
        logger.info("上传的信息：file={}", file.getSize());

        try {
            if (!file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                File file1 = new File(PATH_DOWNLLOAD);
                if (file1.exists()) {
                    file.transferTo(Paths.get(file1+"/" + originalFilename));
                } else {
                    file1.mkdirs();
                }
            }
        } catch (Exception e) {
        }
        return "report-day";
    }

    @PostMapping("/importexcel")
    public String doImportExcel(@RequestParam("imExcel") MultipartFile imExcel, Model model) {
        String originalFilename = imExcel.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        if (!suffix.equals(".xlsx") && !suffix.equals(".xls") || imExcel.isEmpty()) {
            model.addAttribute("success", "文件不对劲");
        } else {
            model.addAttribute("success", "目前技术无法实现");
        }
        return "report-day";
    }


}
