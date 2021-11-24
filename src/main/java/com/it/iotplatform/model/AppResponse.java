package com.it.iotplatform.model;

import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * 接口响应类，在返回响应给前端页面时使用。
 * @author luojiajia
 * @since 1.0
 * @date 2021/11/17 22:42
 */
public class AppResponse<T> {

    public enum CodeEnum{
        /**
         * 0:操作成功
         */
        SUCCESS(0,"操作成功"),
        /**
         * 1:缺少参数
         */
        MISSING_PARAM(1,"缺少参数"),
        /**
         * 2:未知错误
         */
        UNKNOWN_ERROR(2,"未知错误"),
        /**
         * 3:非法参数
         */
        INVALID_PARAM(3,"非法参数"),
        /**
         * 4:数据库错误
         */
        DB_ERROR(4,"数据库错误"),
        /**
         * 5:字段重复
         */
        FIELD_REPETITION(5,"字段重复"),
        /**
         * 6:授权失败
         */
        AUTHORIZE_FAILURE(6,"授权失败"),
        /**
         * 7:接口不存在
         */
        INTERFACE_NON_EXISTENT(7,"接口不存在"),
        /**
         * 8:权限不足
         */
        AUTHORITY_DEFICIENCY(8,"权限不足"),
        /**
         * 9:操作失败
         */
        FAILURE(9,"操作失败"),
        /**
         * 10:数据已绑定，如需操作请先解除绑定
         */
        DATA_BINDING(10,"数据已绑定，如需操作请先解除绑定"),
        /**
         * 11:文件类型错误
         */
        FILE_TYPE_ERR(11,"文件类型错误"),
        /**
         * 12:重复操作
         */
        REPEAT_ACTION(12,"重复操作"),
        /**
         * 15:查询失败
         */
        QUERY_FAILURE(12,"查询失败"),
        /**
         * 111:ip已被禁用
         */
        IP_BANNED(111,"ip已被禁用"),
        /**
         * 112:ip访问频繁
         */
        IP_FREQUENT_ACCESS(112,"ip访问频繁"),
        /**
         * 988:token无效
         */
        TOKEN_INVALID(988,"token无效"),
        /**
         * 999:token过期
         */
        TOKEN_OVERDUE(999,"token过期"),
        /**
         * 400：password错误
         */
        PASSWORD_WRONG(400,"password错误"),
        /**
         * 401：password错误
         */
        PASSWORD_CORRECT(401,"password正确"),
        /**
         * 402：account不存在
         */
        ACCOUNT_NOT_EXIST(402,"account不存在");
        private int code;
        private String message;

        CodeEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public static class AppResponseBuilder{

        public static <T> AppResponse<T> build(CodeEnum codeEnum, PageInfo<T> pageInfo){
            return new AppResponse<>(codeEnum.code, codeEnum.message, pageInfo.getList(),
                    pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize());
        }
        public static AppResponse build(CodeEnum codeEnum){
            return new AppResponse(codeEnum.code, codeEnum.message);
        }
    }


    /**
     * 自定义响应码
     */
    private int code;
    /**
     * 自定义响应消息
     */
    private String message;
    /**
     * 响应体数据
     */
    private List<T> data;
    /**
     * 数据总条数
     */
    private long total;
    /**
     * 当前页码
     */
    private int page;
    /**
     * 一页数据量
     */
    private int pageSize;

    public AppResponse() {
    }

    public AppResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AppResponse(int code, String message, List<T> data, long total, int page, int pageSize) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
