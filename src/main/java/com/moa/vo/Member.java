package com.moa.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Member {
    @NotEmpty
    @Email
    private String id;
    @Size(min = 6,max=20, message = "error.password")
    private String pwd;
    private String name;
    private String reg_date;
    private String mem_type;
    private String[] ids;

    public Member() {
        this(null,null,null,null);
    }
    public Member(String id, String pwd, String name) {
       this(id,pwd,name,null);
    }
    public Member(String id, String pwd, String name, String reg_date) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.reg_date = reg_date;
    }
}
