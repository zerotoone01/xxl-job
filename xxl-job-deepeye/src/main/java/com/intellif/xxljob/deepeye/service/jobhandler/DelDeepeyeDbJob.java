package com.intellif.xxljob.deepeye.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *  主要是针对深目的动态抓拍数据库数据的删除
 *
 *  XxlJob开发示例（Bean模式）
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * deleteDynamicCaptureImageDbHandler
 * {
 *   dbUser
 *   dbPassword
 *  dbHost
 *  dbPort
 *  condition:”2.0,3.0”
 * }
 *
 */
@Component
public class DelDeepeyeDbJob {
    private static Logger logger = LoggerFactory.getLogger(DelDeepeyeDbJob.class);
    // delDciDbHandler
    @XxlJob("delDciDbHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        return ReturnT.SUCCESS;
    }
}
