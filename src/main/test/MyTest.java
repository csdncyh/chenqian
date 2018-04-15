import com.chenqian.Utils.StringUtils;

import com.chenqian.dao.SigninTodayMapper;
import com.chenqian.entity.SigninToday;
import com.chenqian.entity.User;
import com.chenqian.exception.CustomException;
import com.chenqian.service.ArticleService;
import com.chenqian.service.RelationService;
import com.chenqian.service.SigninTodayService;
import com.chenqian.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {
    @Autowired
    ArticleService articleService;

    @Autowired
    SigninTodayService signinTodayService;

    @Autowired
    UserService userService;

    @Autowired
    RelationService relationService;


    @Test
    public void test() throws IOException, CustomException {
        //System.out.println(signinTodayService.selectSigninTodayByUid(17));
        //System.out.println(articleService.selectArticleByUid(17));
        //System.out.println(relationService.selectByIdol(17));
        System.out.println(new Date().getTime());
    }
}