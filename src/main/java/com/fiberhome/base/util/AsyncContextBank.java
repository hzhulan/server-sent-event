package com.fiberhome.base.util;

import javax.servlet.AsyncContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: pp_lan
 * @date: 2022/1/20 16:31
 */
public class AsyncContextBank {

    /**
     * 存储servlet，用于异步推送结果
     */
    private static final Map<String, AsyncContext> MAP = new ConcurrentHashMap<>();

    private AsyncContextBank() {
    }

    public static void put(String requestId, AsyncContext content) {
        MAP.put(requestId, content);
    }

    public static AsyncContext get(String requestId) {
        return MAP.get(requestId);
    }

    /**
     * 清空
     */
    public static void clear() {
        MAP.clear();
    }

    /**
     * 获取实例
     * @return
     */
    public static AsyncContextBank getInstance() {
        return Holder.INSTANCE.getInstance();
    }


    public enum Holder {
        /**
         * 实例对象
         */
        INSTANCE;

        private AsyncContextBank servletBank;

        Holder() {
            this.servletBank = new AsyncContextBank();
        }

        public AsyncContextBank getInstance() {
            return servletBank;
        }
    }
}
