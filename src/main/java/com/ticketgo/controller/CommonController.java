package com.ticketgo.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.ticketgo.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    /**
     * 显示图片
     * @return
     */


    @PostMapping(value = "/upload")
    @Operation(description = "上传图片")
    public Result<String> fileUpload(@RequestParam(value = "file") MultipartFile file) {
        log.info("上传图片：{}", file);

        if (file.isEmpty()) {

            System.out.println("file is empty");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://ticketgo//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {

            dest.getParentFile().mkdirs();
        }
        try {

            file.transferTo(dest);
        } catch (IOException e) {

            e.printStackTrace();
        }
        String filename = "/ticketgo/" + fileName;
        log.info("upload successfully");

        return Result.success(fileName);
    }
}
