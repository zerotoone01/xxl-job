package com.intellif.xxljob.deepeye.service.jobhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *  主要是针对引擎的动态抓拍数据的删除
 *
 *  XxlJob开发示例（Bean模式）
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 *
 * 删除引擎的数据
 * deleteDynamicCaptureImageEngineHandler
 * {
 * version
 * condition
 * }
 */
@Component
public class DelEngineDataJob {
    private static Logger logger = LoggerFactory.getLogger(DelEngineDataJob.class);
}
