package sample2.service.comment;

import java.sql.Connection;
import java.util.List;

import sample2.bean.Comment;
import sample2.dao.CommentDao;
import sample2.util.DBConnection;

public class CommentService {
	
//	dao도 하나잇으면 여러번 쓸수 잇음. 여러개 필요없음. staticfield로 만들것. 어디서든 하나의 dao 사용 가능.
	
	private static CommentDao dao;
	
	static {
		dao = new CommentDao();
	}

	public void add(Comment commentBean) {
		Connection con = DBConnection.getConnection();
		
		dao.insert(commentBean, con);
		
		DBConnection.close(con);
		
	}

	public List<Comment> list(int boardId) {
		Connection con = DBConnection.getConnection();
		
		
		List<Comment> list = dao.list(boardId, con);
		DBConnection.close(con);
		return list;
	}

	public void modify(Comment comment) {
		Connection con = DBConnection.getConnection();
		
		dao.modify(comment, con); 
		//up <- service 가 하는 일. 서비스는 여러 다오에게 일을시킬 수 잇다.
		
		DBConnection.close(con);
	}

	public void remove(int id) {
		Connection con = DBConnection.getConnection();
		
		dao.remove(id, con);
		
		DBConnection.close(con);
		
	}

}
