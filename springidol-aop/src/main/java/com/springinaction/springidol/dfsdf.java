//package com.springinaction.springidol;
//
//public class ForumService {
//    private TransactionManager transManager;
//    private PerformanceMonitor pmonitor;
//    private TopicDao topicDao;
//    private ForumDao forumDao;
//
//    public void removeTopic(int topicId) {
//        pmonitor.start();                 //性能监视
//        transManager.beginTransaction();  //事务管理
//        topicDao.removeTopic(topicId);    //业务逻辑
//        transManager.endTransaction();    //事务管理
//        pmonitor.end();                   //性能监视
//    }
//
//    public void CreateForum(Forum forum) {
//        pmonitor.start();                 //性能监视
//        transManager.beginTransaction();  //事务管理
//        forumDao.create(forum);           //业务逻辑
//        transManager.endTransaction();    //事务管理
//        pmonitor.end();                   //性能监视
//    }
//}
