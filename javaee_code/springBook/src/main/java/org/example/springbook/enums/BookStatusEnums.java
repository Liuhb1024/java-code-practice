package org.example.springbook.enums;

/**
 * @author 刘浩彬
 * @date 2024/3/2
 */
public enum BookStatusEnums {
    DELETE(0,"无效书籍"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅"),
    ;
    private int code;
    private String desc;

    BookStatusEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 根据code 获取描述
    public static BookStatusEnums getDescByCode(int code){
        switch (code){
            case 2:return BookStatusEnums.FORBIDDEN;
            case 1:return BookStatusEnums.NORMAL;
            default:return BookStatusEnums.DELETE;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
