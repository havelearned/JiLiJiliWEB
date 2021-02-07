package com.yinghua.application.util.utilController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public  class FileUploadController {
    @Value("${user.file.path")
    private static String file ;

    @Value("${user.file.name")
    private static String filename;
}
