package com.springboot.demo.util.count;

/**
 * 常量
 */
public interface Constant {
    interface Result {
        /**
         * 成功常量
         */
        public static final String SUCCESS_BACK = "操作成功";
        /**
         * 失败常量
         */

        public static final String DEFORT_BACK = "账号或密码错误";
        /**
         * 电话号码错误
         */

        public static final String NUMBER_BACK = "请输入正确格式的账号";
    }

    interface ResultCode {
        /**
         * 成功返回
         */
        public static final String SUCCESS_CODE = "0000";
        /**
         * 失败返回
         */
        public static final String DEFORT_CODE = "8888";
    }

    interface LandUserConstant {
        /**
         * 用户名
         */
        public static final String USERNAME = "username";
        /**
         * 用户密码
         */
        public static final String PASSWORD = "landPassword";
        /**
         * 用户主键
         */
        public static final String ID = "landId";
    }

    interface QuartzConstant {
        /**
         * job
         */
        public static final String JOB_GROUP = "event_job_group";
        /**
         * 定时
         */
        public static final String TRIGGER_GROUP = "event_trigger_group";
    }

    interface ServiceImpl {
        /**
         * 定时
         */
        public static final String serviceImplName = "LandServiceTwo";

    }

}
