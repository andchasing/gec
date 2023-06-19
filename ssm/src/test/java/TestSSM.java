import com.ssm.mapper.StaffMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSSM {
    @Autowired
    StaffMapper staffMapper;
    @Test
    public void testUser(){
//        List<Staff> list = staffMapper.getStaffs();
//        list.forEach(System.out::println);
        System.out.println("--------------");
    }
}
