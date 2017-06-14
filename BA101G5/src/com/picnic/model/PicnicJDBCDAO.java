package com.picnic.model;

import java.sql.*;
import java.util.*;

public class PicnicJDBCDAO implements Picnic_interface {
	String driver = "Oracle.driver.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin@localhost:1521:XE";
	String userid = "ba101";
	String passwd = "ba101";

	private static final String INSERT_STMT = "insert into Picnic (PICNIC_NO,PICNIC_NAME,PICNIC_DESC,PICNICDATE,PICNIC_STARTUP,PICNIC_SETUP,PICNIC_CHK,PICNIC_DATE,PICNIC_PL,PICNIC_STA,ORD_TOTAL,ORD_DATE_ORD_DM,ORD_STA) VALUES('PG'||LPAD(PICNIC_NO_SQ.NEXTVAL,8,0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "select PICNIC_NO,PICNIC_NAME,PICNIC_DESC,to_char(PICKUPDATE,'yyyy-mm-dd'),to_char(PICNIC_STARTUP,'yyyy-mm-dd'),to_char(PICNIC_SETUP,'yyyy-mm-dd'),PICNIC_CHK,to_char(PICNIC_DATE,'yyyy-mm-dd'),PICNIC_PL,PICNIC_STA,ORD_TOTAL,to_char(ORD_DATE,'yyyy-mm-dd'),ORD_DM,ORD_STA FROM PICNIC Order by PICNIC_NO";
	private static final String GET_ONE_STMT = "select PICNIC_NO,PICNIC_NAME,PICNIC_DESC,to_char(PICKUPDATE,'yyyy-mm-dd'),to_char(PICNIC_STARTUP,'yyyy-mm-dd'),to_char(PICNIC_SETUP,'yyyy-mm-dd'),PICNIC_CHK,to_char(PICNIC_DATE,'yyyy-mm-dd'),PICNIC_PL,PICNIC_STA,ORD_TOTAL,to_char(ORD_DATE,'yyyy-mm-dd'),ORD_DM,ORD_STA FROM PICNIC WHERE PICNIC_NO = ?";
	private static final String DELETE_STMT = "delete from PICNIC where PICNIC = ?";
	private static final String UPDATE_STMT = "update PICNIC set PICNIC_NAME=?,PICNIC_DESC=?,PICKUPDATE=?,PICNIC_STARTUP=?,PICNIC_SETUP=?,PICNIC_CHK=?,PICNIC_DATE=?,PICNIC_PL=?,PICNIC_STA=?,ORD_TOTAL=?,ORD_DATE=?,ORD_DM=?,ORD_STA=? where PICNICNO=?";

	@Override
	public void insert(PicnicVO picnicVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(userid, passwd, url);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, picnicVO.getPicnic_name());
			pstmt.setString(2, picnicVO.getPicnic_desc());
			pstmt.setTimestamp(3, picnicVO.getPicupdate());
			pstmt.setTimestamp(4, picnicVO.getPicnic_startup());
			pstmt.setTimestamp(5, picnicVO.getPicnic_setup());
			pstmt.setString(6, picnicVO.getPicnic_chk());
			pstmt.setTimestamp(7, picnicVO.getPicnic_date());
			pstmt.setInt(8, picnicVO.getPicnic_pl());
			pstmt.setString(9, picnicVO.getPicnic_sta());
			pstmt.setDouble(10, picnicVO.getOrd_total());
			pstmt.setTimestamp(11, picnicVO.getOrd_date());
			pstmt.setString(12, picnicVO.getOrd_dm());
			pstmt.setString(13, picnicVO.getOrd_sta());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(PicnicVO picnicVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			DriverManager.getConnection(userid, passwd, url);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, picnicVO.getPicnic_name());
			pstmt.setString(2, picnicVO.getPicnic_desc());
			pstmt.setTimestamp(3, picnicVO.getPicupdate());
			pstmt.setTimestamp(4, picnicVO.getPicnic_startup());
			pstmt.setTimestamp(5, picnicVO.getPicnic_setup());
			pstmt.setString(6, picnicVO.getPicnic_chk());
			pstmt.setTimestamp(7, picnicVO.getPicnic_date());
			pstmt.setInt(8, picnicVO.getPicnic_pl());
			pstmt.setString(9, picnicVO.getPicnic_sta());
			pstmt.setDouble(10, picnicVO.getOrd_total());
			pstmt.setTimestamp(11, picnicVO.getOrd_date());
			pstmt.setString(12, picnicVO.getOrd_dm());
			pstmt.setString(13, picnicVO.getOrd_sta());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(String picnic_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(userid, passwd, url);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, picnic_no);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public PicnicVO findByPrimaryKey(String picnic_no) {

		PicnicVO picnicVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(userid, passwd, url);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, picnic_no);
			pstmt.executeUpdate();

			while (rs.next()) {
				picnicVO = new PicnicVO();
				picnicVO.setPicnic_no(rs.getString("PICNIC_NO"));
				picnicVO.setPicnic_name(rs.getString("PICNIC_NAME"));
				picnicVO.setPicnic_desc(rs.getString("PICNIC_DESC"));
				picnicVO.setPicupdate(rs.getTimestamp("PICKPUDATE"));
				picnicVO.setPicnic_startup(rs.getTimestamp("PICNIC_STARTUP"));
				picnicVO.setPicnic_setup(rs.getTimestamp("PICNIC_SETUP"));
				picnicVO.setPicnic_chk(rs.getString("PICNIC_CHK"));
				picnicVO.setPicnic_date(rs.getTimestamp("PICNIC_DATE"));
				picnicVO.setPicnic_pl(rs.getInt("PICNIC_PL"));
				picnicVO.setPicnic_sta(rs.getString("PICNIC_STA"));
				picnicVO.setOrd_total(rs.getDouble("ORD_TOTAL"));
				picnicVO.setOrd_date(rs.getTimestamp("ORD_DATE"));
				picnicVO.setOrd_dm(rs.getString("ORD_DM"));
				picnicVO.setOrd_sta(rs.getString("Ord_sta"));

				
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}

		}
		return picnicVO;

	}

	@Override
	public List<PicnicVO> getAll() {
		List<PicnicVO> list =new ArrayList<PicnicVO>();
		PicnicVO picnicVO =null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(userid, passwd, url);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			pstmt.executeUpdate();

			while (rs.next()) {
				picnicVO = new PicnicVO();
				picnicVO.setPicnic_no(rs.getString("PICNIC_NO"));
				picnicVO.setPicnic_name(rs.getString("PICNIC_NAME"));
				picnicVO.setPicnic_desc(rs.getString("PICNIC_DESC"));
				picnicVO.setPicupdate(rs.getTimestamp("PICKPUDATE"));
				picnicVO.setPicnic_startup(rs.getTimestamp("PICNIC_STARTUP"));
				picnicVO.setPicnic_setup(rs.getTimestamp("PICNIC_SETUP"));
				picnicVO.setPicnic_chk(rs.getString("PICNIC_CHK"));
				picnicVO.setPicnic_date(rs.getTimestamp("PICNIC_DATE"));
				picnicVO.setPicnic_pl(rs.getInt("PICNIC_PL"));
				picnicVO.setPicnic_sta(rs.getString("PICNIC_STA"));
				picnicVO.setOrd_total(rs.getDouble("ORD_TOTAL"));
				picnicVO.setOrd_date(rs.getTimestamp("ORD_DATE"));
				picnicVO.setOrd_dm(rs.getString("ORD_DM"));
				picnicVO.setOrd_sta(rs.getString("Ord_sta"));

				list.add(picnicVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace(System.err);
				}
			}

		}
		return list;
	}
	public static void main(String[] args) {
		PicnicJDBCDAO picnicjdbcdao = new PicnicJDBCDAO();
		//insert
//		PicnicVO picnicVO =new PicnicVO();
//		picnicVO.setPicnic_name("天線寶寶");
//		picnicVO.setPicnic_desc("在這裡在這裡");
//		picnicVO.setPicupdate(java.sql.Timestamp.valueOf("2055-01-01"));
//		picnicVO.setPicnic_startup(java.sql.Timestamp.valueOf("2056-01-04"));
//		picnicVO.setPicnic_setup(java.sql.Timestamp.valueOf("2055-01-02"));
//		picnicVO.setPicnic_chk("S");
//		picnicVO.setPicnic_date(java.sql.Timestamp.valueOf("2055-01-05"));
//		picnicVO.setPicnic_pl(10);
//		picnicVO.setPicnic_sta("L");
//		picnicVO.setOrd_total(400.0);
//		picnicVO.setOrd_date(null);
//		picnicVO.setOrd_dm("隨便送");
//		picnicVO.setOrd_sta("H");
//		
//		picnicjdbcdao.insert(picnicVO);
		
		//update
//		PicnicVO picnicVO =new PicnicVO();
//		picnicVO.setPicnic_no(PG00000001);
//		picnicVO.setPicnic_name("天線寶寶");
//		picnicVO.setPicnic_desc("在這裡在這裡");
//		picnicVO.setPicupdate(java.sql.Timestamp.valueOf("2055-01-01"));
//		picnicVO.setPicnic_startup(java.sql.Timestamp.valueOf("2056-01-04"));
//		picnicVO.setPicnic_setup(java.sql.Timestamp.valueOf("2055-01-02"));
//		picnicVO.setPicnic_chk("S");
//		picnicVO.setPicnic_date(java.sql.Timestamp.valueOf("2055-01-05"));
//		picnicVO.setPicnic_pl(10);
//		picnicVO.setPicnic_sta("D");
//		picnicVO.setOrd_total(400.0);
//		picnicVO.setOrd_date(null);
//		picnicVO.setOrd_dm("隨便送");
//		picnicVO.setOrd_sta("H");
//		
//		picnicjdbcdao.update(picnicVO);
		//delete
		picnicjdbcdao.delete("PG00000001");
		//select
//		PicnicVO picnicVO= picnicjdbcdao.findByPrimaryKey("PG00000001");
//		System.out.println(picnicVO.getPicnic_no());
//		System.out.println(picnicVO.getPicnic_name());
//		System.out.println(picnicVO.getPicnic_desc());
//		System.out.println(picnicVO.getPicupdate());
//		System.out.println(picnicVO.getPicnic_startup());
//		System.out.println(picnicVO.getPicnic_setup());
//		System.out.println(picnicVO.getPicnic_chk());
//		System.out.println(picnicVO.getPicnic_date());
//		System.out.println(picnicVO.getPicnic_pl());
//		System.out.println(picnicVO.getPicnic_sta());
//		System.out.println(picnicVO.getOrd_total());
//		System.out.println(picnicVO.getOrd_date());
//		System.out.println(picnicVO.getOrd_dm());
//		System.out.println(picnicVO.getOrd_sta());
//		System.out.println("---------------------");
		//getAll
		 List<PicnicVO> list =picnicjdbcdao.getAll();
		for(PicnicVO apicnic :list){
			System.out.println(apicnic.getPicnic_no());
			System.out.println(apicnic.getPicnic_name());
			System.out.println(apicnic.getPicnic_desc());
			System.out.println(apicnic.getPicupdate());
			System.out.println(apicnic.getPicnic_startup());
			System.out.println(apicnic.getPicnic_setup());
			System.out.println(apicnic.getPicnic_chk());
			System.out.println(apicnic.getPicnic_date());
			System.out.println(apicnic.getPicnic_pl());
			System.out.println(apicnic.getPicnic_sta());
			System.out.println(apicnic.getOrd_total());
			System.out.println(apicnic.getOrd_date());
			System.out.println(apicnic.getOrd_dm());
			System.out.println(apicnic.getOrd_sta());
			System.out.println("---------------------");
		}
		
	}
	}


