package com.liu.tender_info.bean;

import java.util.Date;

public class Supplier {

    private Integer supplier_id;
    private String supplier_name;
    private String supplier_location;
    private Date create_time;
    private String type;
    private String brand;
    private String description;
    private Integer blacklist;
    private String cooperation_type;
    private String comment_content;
    private Integer supplier_iphone;

    public Integer getSupplier_iphone() {
        return supplier_iphone;
    }

    public void setSupplier_iphone(Integer supplier_iphone) {
        this.supplier_iphone = supplier_iphone;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_location() {
        return supplier_location;
    }

    public void setSupplier_location(String supplier_location) {
        this.supplier_location = supplier_location;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
    }

    public String getCooperation_type() {
        return cooperation_type;
    }

    public void setCooperation_type(String cooperation_type) {
        this.cooperation_type = cooperation_type;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
}
