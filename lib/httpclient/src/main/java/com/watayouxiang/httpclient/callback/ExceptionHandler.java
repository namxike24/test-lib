package com.watayouxiang.httpclient.callback;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.lzy.okgo.exception.HttpException;
import com.lzy.okgo.model.Response;
import com.watayouxiang.httpclient.model.BaseResp;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/06/23
 *     desc   :
 * </pre>
 */
class ExceptionHandler {
    /**
     * 获取异常信息
     */
    public static <Data> String handleException(Response<BaseResp<Data>> response) {
        // 没有错误
        Throwable e = response.getException();
        if (e == null) return "没有错误";

        String msg = "未知错误";
        if (e instanceof HttpException) {
            int code = response.code();
            if (code != -1) {
                msg = code + "错误";
            } else {
                msg = "网络错误";
            }
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            msg = "无网络";
        } else if (e instanceof ConnectTimeoutException
                || e instanceof java.net.SocketTimeoutException) {
            msg = "连接超时";
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            msg = "证书验证异常";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            msg = "解析异常";
        }
        return msg;
    }
}
