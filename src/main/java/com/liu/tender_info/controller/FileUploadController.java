package com.liu.tender_info.controller;

import com.liu.tender_info.untils.JaveUsePython;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/uploadProduct")
    public String uploadProduct(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            System.out.println("上传文件不能为空");
        }
        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();
        //log.info("服务器文件名：" + fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        file.transferTo(new File("f://Python//tender//ProductTable.xlsx"));

        String a=String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType,fileSize);
        System.out.println(a);

        JaveUsePython.runPy("f:/Python/tender/readExcel.py");

        return "<script>alert(\"上传成功\");setInterval(function(){location.href=\"\\html/product.html\"},300)</script>";

    }

    @PostMapping("/uploadExpert")
    public String uploadExpert(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            System.out.println("上传文件不能为空");
        }
        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();
        //log.info("服务器文件名：" + fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        file.transferTo(new File("f://Python//tender//ExpertTable.xlsx"));

        String a=String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType,fileSize);
        System.out.println(a);

        JaveUsePython.runPy("f:/Python/tender/readExcelExpert.py");

        return "<script>alert(\"上传成功\");setInterval(function(){location.href=\"\\html/expert.html\"},300)</script>";

    }

    @PostMapping("/uploadSupplier")
    public String uploadSupplier(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            System.out.println("上传文件不能为空");
        }
        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();
        //log.info("服务器文件名：" + fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        file.transferTo(new File("f://Python//tender//SupplierTable.xlsx"));

        String a=String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType,fileSize);
        System.out.println(a);

        JaveUsePython.runPy("f:/Python/tender/readExcelSupplier.py");

        return "<script>alert(\"上传成功\");setInterval(function(){location.href=\"\\html/supplier.html\"},300)</script>";

    }
}
