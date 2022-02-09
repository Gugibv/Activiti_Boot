package com.grey.workflow.test;
// 包名需要与 WorkFlowApplication.java 的位置一致，否则 @Autowired 会报错
// 测试类和启动类要同级别


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BootStartTest {

    @Autowired
    ProcessEngine processEngine;

    @Autowired
    RepositoryService repositoryService;

    @Test
    public void getProcessEngine(){
        System.out.println("processEngine:" + processEngine);
    }

    @Test
    public void deployByFile(){
        // 1. 创建部署对象进行流程的部署，定义一个流程的名字，把 .bpmn 和 .png 部署到数据库中
        Deployment deployment = repositoryService.createDeployment()
                .name("额度申请流程")
                .addClasspathResource("process/approval.bpmn20.bpmn")
                .addClasspathResource("process/approval.bpmn20.png")
                .deploy();

        // 2. 输出部署信息
        System.out.println("部署ID：" + deployment.getId() );

        System.out.println("部署名称：" + deployment.getName() );
    }

}
