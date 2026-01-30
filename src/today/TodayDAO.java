package today;

import java.sql.SQLException;
import java.util.Vector;

public class TodayDAO extends DBConn {

	// 아이디 체크
	public TodayVO getNameSearch(String id, String pw) {
		TodayVO vo = new TodayVO();
		try {
			sql = "select * from today where name=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//					vo.setIdx(rs.getInt("idx"));
//					vo.setId(rs.getString("id");
//					vo.setPw(rs.getString("pw"));				}
			}						
		} catch (SQLException e) {
			System.out.println("SQL 오류(getNameSearch) : " + e.getMessage());	
		}	finally {
			rsClose();
		}
		return vo ;
	}

	// 일기 내용 DB에 저장하기
	public int setTodayInput(TodayVO vo) {
		System.out.println("vo(dao1) : " + vo);
		int res = 0;
		try {
			//sql = "insert into diary values (default,default,?,?,?,?)";
			sql = "insert into diary values (default,?,?,?,?,?)";
			System.out.println("vo(dao2) : " + vo);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getwDate());
			pstmt.setString(2, vo.getWeather());
			pstmt.setString(3, vo.getFeel());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getPhoto());
			System.out.println("vo(dao3) : " + vo);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setTodayInput) : " + e.getMessage());	
		}	finally {
			pstmtClose();
		}
		return res;
	}

	// 일기 연월일 조회
	public TodayVO getTodaySearch(String ymd) {
		TodayVO vo = new TodayVO();
		try {
			sql = "select * from diary where substring(wDate, 1, 10) = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ymd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setwDate(rs.getString("wDate"));
				vo.setWeather(rs.getString("weather"));
				vo.setFeel(rs.getString("feel"));
				vo.setContent(rs.getString("content"));
				vo.setPhoto(rs.getString("photo"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류(setTodayInput) : " + e.getMessage());	
		}	finally {
			rsClose();
		}
		return vo;
	}

	//DB에서 가져온 데이터 전체 조회하기
	public Vector<TodayVO> getTodayList() {
		Vector<TodayVO> vos = new Vector<>();
		try {
			sql = "select * from diary order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TodayVO vo = new TodayVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setwDate(rs.getString("wdate").substring(0, 10));
				vo.setWeather (rs.getString("weather"));
				vo.setFeel(rs.getString("feel"));
				vo.setContent(rs.getString("content"));
				vo.setPhoto(rs.getString("photo"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류(getTodayList) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	

	
	//수정하기
	public int setTodayUpdate(TodayVO vo) {
		System.out.println("vo(dao) : " + vo);
		int res = 0;
		try {
			sql = "update diary set weather=?, feel=?, content=?, photo=? where substring(wDate,1,10)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWeather());
			pstmt.setString(2, vo.getFeel());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPhoto());
			pstmt.setString(5, vo.getwDate());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setTodayInput) : " + e.getMessage());	
		}	finally {
			pstmtClose();
		}
		return res;
	}
	
	//삭제하기
	public int setTodayDelete(String ymd) {
		int res = 0;
		try {
			sql = "delete from diary where substring(wDate,1,10)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ymd);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setTodayInput) : " + e.getMessage());	
		}	finally {
			pstmtClose();
		}
		return res;
	}
		
	//삭제하기(프라이머리키로 검색)
	public int setTodayDelete(int primaryKey) {
		int res = 0;
		try {
			sql = "delete from diary where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setTodayInput) : " + e.getMessage());	
		}	finally {
			pstmtClose();
		}
		return res;
	}
	
	
}
