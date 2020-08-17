package test;

import dao.BaseDao;
import dao.FollowDao;
import dao.impl.FollowDaoImpl;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import pojo.Follower;
import service.UserService;

import javax.servlet.ServletInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @ClassName excelTest
 * @Description TODO
 * @Author 89255
 */
public class excelTest {
    @Test
    public void test(){
        BaseDao followDao = new FollowDaoImpl();
        String sql="select id,followId from W_Follower where followId = ?";
        Follower follower1 = followDao.queryForOne(Follower.class,sql,2);
        System.out.println(follower1);
//        List<Follower> followers =  followDao.queryForList(Follower.class,sql,2);
//        for (Follower follower:followers){
//            System.out.println(follower);
//        }
    }
}



