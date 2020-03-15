import org.apache.ibatis.session.SqlSession;
import org.kakarrot.dao.MemberDAO;
import org.kakarrot.dao.MemberDAOImpl;
import org.kakarrot.dao.TeamDAO;
import org.kakarrot.dao.TeamDAOImpl;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.util.SessionFactory;

public class TestPage {
	public static void main(String[] args) {

		int a = 1000;
		
		for(int i=0; i<1000; i++) {
			a += (a/10)+1000;
			System.out.println(i);
			if(a>=100000) {
				System.out.println("10¾ï"+i);
				
				break;
			}

		}
	}
}
