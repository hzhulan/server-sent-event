package com.fiberhome.base.model;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/10/26 19:42
 */
public class IndexUser {

    private Integer id;

    private String name;

    private String desc;

    private Integer age;

    private Integer sort;

    public IndexUser(Integer id, String name, String desc, Integer age, Integer sort) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.age = age;
        this.sort = sort;
    }

    //region setter and getter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    //endregion
}
