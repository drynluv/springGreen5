package today;

//import java.awt.Component;
//import javax.swing.DefaultListCellRenderer;
//import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
@SuppressWarnings({"serial", "rawtypes", "unchecked", "unused", "static-access"})
public class TodaySearch extends JFrame {
	private JComboBox comboYear, comboMonth, comboDay;
	private JTextArea txtaContent;
	private JCheckBox cbSunny, cbCloud, cbRain, cbWind, cbSnow;
	private JCheckBox cbVeryGood, cbGood, cbNormal, cbBad, cbVeryBad;
	private JButton btnSearch, btnUpdate, btnDelete, btnPhoto, btnBack;
	
	private String filePath = "", fileName = "";
	TodayDAO dao = new TodayDAO();
	TodayVO vo = null;
	
	public TodaySearch() {
		super("오늘님 하루는 어땠나요?");
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn0 = new JPanel();
		pn0.setBounds(0, 0, 484, 761);
		getContentPane().add(pn0);
		pn0.setLayout(null);
		
		pn0.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 460, 388);
		pn0.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("날짜");
		lblNewLabel_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1.setBounds(12, 10, 39, 34);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("날씨");
		lblNewLabel_1_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_1.setBounds(12, 50, 39, 34);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("기분");
		lblNewLabel_1_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_2.setBounds(12, 90, 39, 34);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("내용");
		lblNewLabel_1_3.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_3.setBounds(12, 130, 39, 34);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_3);
		
		// 년도/월/일 초기값 생성
		String[] yy = new String[27];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 0;
		for(int i=0; i<yy.length; i++) {
			imsi = 2026 - i;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		
		comboYear = new JComboBox(yy);
		comboYear.setBounds(63, 10, 77, 30);
		pn1.add(comboYear);
//		comboYear.setBackground(new Color(0, 0, 0, 0));
//		comboYear.setBorder(null);
		
		comboMonth = new JComboBox(mm);
		comboMonth.setBounds(168, 10, 77, 30);
		pn1.add(comboMonth);
		
		comboDay = new JComboBox(dd);
		comboDay.setBounds(279, 10, 68, 30);
		pn1.add(comboDay);
		
//		setComboTransparent(comboYear);
//		setComboTransparent(comboMonth);
//		setComboTransparent(comboDay);
		
		JLabel lblNewLabel_1_4 = new JLabel("년");
		lblNewLabel_1_4.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4.setBounds(134, 10, 39, 34);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("월");
		lblNewLabel_1_4_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4_1.setBounds(248, 10, 25, 34);
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("일");
		lblNewLabel_1_4_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4_2.setBounds(340, 10, 39, 34);
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_2);
		
		cbSunny = new JCheckBox("맑음");
		cbSunny.setSelected(true);
		cbSunny.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSunny.setForeground(new Color(64, 0, 0));
		cbSunny.setBounds(65, 50, 55, 30);
		pn1.add(cbSunny);
		
		cbCloud = new JCheckBox("흐림");
		cbCloud.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbCloud.setForeground(new Color(64, 0, 0));
		cbCloud.setBounds(126, 50, 55, 30);
		pn1.add(cbCloud);
		
		cbSnow = new JCheckBox("눈");
		cbSnow.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSnow.setForeground(new Color(64, 0, 0));
		cbSnow.setBounds(187, 50, 55, 30);
		pn1.add(cbSnow);
		
		cbRain = new JCheckBox("비");
		cbRain.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbRain.setForeground(new Color(64, 0, 0));
		cbRain.setBounds(248, 50, 55, 30);
		pn1.add(cbRain);
		
		cbWind = new JCheckBox("바람");
		cbWind.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbWind.setForeground(new Color(64, 0, 0));
		cbWind.setBounds(309, 50, 55, 30);
		pn1.add(cbWind);
		
		cbVeryGood = new JCheckBox("매우 좋음");
		cbVeryGood.setSelected(true);
		cbVeryGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryGood.setForeground(new Color(64, 0, 0));
		cbVeryGood.setBounds(65, 91, 88, 30);
		pn1.add(cbVeryGood);
		
		cbGood = new JCheckBox("좋음");
		cbGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbGood.setForeground(new Color(64, 0, 0));
		cbGood.setBounds(157, 91, 55, 30);
		pn1.add(cbGood);
		
		cbNormal = new JCheckBox("보통");
		cbNormal.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbNormal.setForeground(new Color(64, 0, 0));
		cbNormal.setBounds(218, 91, 55, 30);
		pn1.add(cbNormal);
		
		cbBad = new JCheckBox("나쁨");
		cbBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbBad.setForeground(new Color(64, 0, 0));
		cbBad.setBounds(279, 91, 55, 30);
		pn1.add(cbBad);
		
		cbVeryBad = new JCheckBox("매우 나쁨");
		cbVeryBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryBad.setForeground(new Color(64, 0, 0));
		cbVeryBad.setBounds(340, 91, 90, 30);
		pn1.add(cbVeryBad);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 408, 460, 343);
		pn0.add(pn2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 168, 436, 210);
		pn1.add(scrollPane);
		
		txtaContent = new JTextArea();
		txtaContent.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		scrollPane.setViewportView(txtaContent);
		txtaContent.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 484, 761);
//		lblNewLabel.setIcon(new ImageIcon("images/000_00.jpg"));
		lblNewLabel.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\springGreen5\\images/000_00.jpg"));
		pn0.add(lblNewLabel);
		
		pn1.setOpaque(false);
		pn2.setOpaque(false);
		comboYear.setOpaque(false);
		comboMonth.setOpaque(false);
		comboDay.setOpaque(false);
		
		cbSunny.setOpaque(false);
		cbCloud.setOpaque(false);
		cbSnow.setOpaque(false);
		cbRain.setOpaque(false);
		cbWind.setOpaque(false);
		cbVeryGood.setOpaque(false);
		cbGood.setOpaque(false);
		cbNormal.setOpaque(false);
		cbBad.setOpaque(false);
		cbVeryBad.setOpaque(false);
		
		
		txtaContent.setOpaque(false);
		txtaContent.setBackground(new Color(0, 0, 0, 0));
		txtaContent.setForeground(new Color(64, 0, 0)); // 배경 이미지면 가독성용
		
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
//		btnPhoto.setBorderPainted(false);     // 테두리 제거
//		btnPhoto.setFocusPainted(false);      // 포커스 테두리 제거
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(12, 10, 436, 223);
		pn2.add(lblPhoto);
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		
		btnUpdate = new JButton("수정");
		btnUpdate.setForeground(new Color(64, 0, 0));
		btnUpdate.setOpaque(false);
		btnUpdate.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnUpdate.setContentAreaFilled(false); 
		btnUpdate.setBounds(133, 279, 83, 33);
		pn2.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setForeground(new Color(64, 0, 0));
		btnDelete.setOpaque(false);
		btnDelete.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(241, 279, 83, 33);
		pn2.add(btnDelete);
		
		btnPhoto = new JButton("사진추가");
		btnPhoto.setForeground(new Color(64, 0, 0));
		btnPhoto.setOpaque(false);
		btnPhoto.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnPhoto.setContentAreaFilled(false);
		btnPhoto.setBounds(25, 279, 83, 33);
		pn2.add(btnPhoto);
		
		btnBack = new JButton("뒤로가기");
		btnBack.setForeground(new Color(64, 0, 0));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(349, 279, 83, 33);
		pn2.add(btnBack);
		scrollPane.setOpaque(false);
		txtaContent.setOpaque(false);
		
		btnSearch = new JButton("조회");
		btnSearch.setForeground(new Color(64, 0, 0));
//		btnSearch.setOpaque(false);
		btnSearch.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBounds(380, 11, 68, 30);
		pn1.add(btnSearch);
//		btnSave.setBorderPainted(false);     // 테두리 제거
//		btnSave.setFocusPainted(false);      // 포커스 테두리 제거
		
		//배경 맨 밑에 배치(gpt)
		ImageIcon bg = new ImageIcon("C:\\Users\\green\\Downloads\\789.jpg");
		
	  // 윈도우 종료버튼(X) 비활성화처리 
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		
		setVisible(true);
		
		// 오늘 날짜를 초기화면 콤보상자에 배치시켜준다.
		String[] nows = LocalDate.now().toString().split("-");
		comboYear.setSelectedItem(nows[0]);
		comboMonth.setSelectedItem(nows[1]);
		comboDay.setSelectedItem(nows[2]);
		
		//-----------------------------------------------------------------------
		
		// 일기 수정하기
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mm = comboMonth.getSelectedItem().toString();
				String dd = comboDay.getSelectedItem().toString();
				if(mm.length() == 1) mm = "0" + comboMonth.getSelectedItem().toString();
				if(dd.length() == 1) dd = "0" + comboDay.getSelectedItem().toString();
				String wDate = comboYear.getSelectedItem()+"-"+ mm +"-"+ dd;
				
				String weather = "";
				if(cbSunny.isSelected()) weather += cbSunny.getText() +"/";
				if(cbCloud.isSelected()) weather += cbCloud.getText() +"/";
				if(cbWind.isSelected()) weather += cbWind.getText() +"/";
				if(cbRain.isSelected()) weather += cbRain.getText() +"/";
				if(cbSnow.isSelected()) weather += cbSnow.getText() +"/";
				weather = weather.substring(0,weather.length()-1);
				
				String feel = "";
				if(cbVeryGood.isSelected()) feel += cbVeryGood.getText() +"/";
				if(cbGood.isSelected()) feel += cbGood.getText() +"/";
				if(cbNormal.isSelected()) feel += cbNormal.getText() +"/";
				if(cbBad.isSelected()) feel += cbBad.getText() +"/";
				if(cbVeryBad.isSelected()) feel += cbVeryBad.getText() +"/";
				feel = feel.substring(0,feel.length()-1);
				
				String content = txtaContent.getText();
				
			  // 사진 업로드 처리
				String photo = "noimage.jpg";
				if(!filePath.equals("")) photo = filePath.substring(filePath.lastIndexOf("\\")+1);
				
				// vo에 담은후 DAO로 보내기
				vo = new TodayVO();
				vo.setwDate(wDate);
				vo.setWeather(weather);
				vo.setFeel(feel);
				vo.setContent(content);
				vo.setPhoto(photo);
				
				int res = dao.setTodayUpdate(vo);
				
				if(res != 0) JOptionPane.showMessageDialog(null, "수정완료!");
				else JOptionPane.showMessageDialog(null, "수정실패!");
			}
		});
		
		//일기 조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mm = comboMonth.getSelectedItem().toString();
				String dd = comboDay.getSelectedItem().toString();
				if(mm.length() == 1) mm = "0" + comboMonth.getSelectedItem().toString();
				if(dd.length() == 1) dd = "0" + comboDay.getSelectedItem().toString();
				String ymd = comboYear.getSelectedItem()+"-"+ mm +"-"+ dd;
				
				// 날씨로 조회한 결과를 가져오기(vo에 담아준다)
				TodayVO vo = dao.getTodaySearch(ymd);
				
				if(vo.getContent() == null) JOptionPane.showMessageDialog(null, "검색된 자료가 없습니다.");
				else {
					todayReset();  // 날씨, 기분 초기화

					//날씨 조회
					if(vo.getWeather().contains(cbSunny.getText())) cbSunny.setSelected(true);
					if(vo.getWeather().contains(cbCloud.getText())) cbCloud.setSelected(true);
					if(vo.getWeather().contains(cbRain.getText())) cbRain.setSelected(true);
					if(vo.getWeather().contains(cbSnow.getText())) cbSnow.setSelected(true);
					if(vo.getWeather().contains(cbWind.getText())) cbWind.setSelected(true);
					
					//기분 조회
					if(vo.getFeel().contains(cbVeryGood.getText())) cbVeryGood.setSelected(true);
					if(vo.getFeel().contains(cbGood.getText())) cbGood.setSelected(true);
					if(vo.getFeel().contains(cbNormal.getText())) cbNormal.setSelected(true);
					if(vo.getFeel().contains(cbBad.getText())) cbBad.setSelected(true);
					if(vo.getFeel().contains(cbVeryBad.getText())) cbVeryBad.setSelected(true);
					
					txtaContent.setText(vo.getContent());
					
			    //사진 조회
					lblPhoto.setIcon(new ImageIcon("images/" + vo.getPhoto()));
					
				}
						
			}
		});
		
		//뒤로가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TodayTodoList();
			}
		});
		
		//내용 삭제
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mm = comboMonth.getSelectedItem().toString();
				String dd = comboDay.getSelectedItem().toString();
				if(mm.length() == 1) mm = "0" + comboMonth.getSelectedItem().toString();
				if(dd.length() == 1) dd = "0" + comboDay.getSelectedItem().toString();
				String ymd = comboYear.getSelectedItem()+"-"+ mm +"-"+ dd;
				
				int yn = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(yn == 0) {
					int res = dao.setTodayDelete(ymd);
				 
					if(res != 0) JOptionPane.showMessageDialog(null, "삭제완료!");
					else JOptionPane.showMessageDialog(null, "삭제실패!");
				}
			}
		});
		
		//사진 추가
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg","gif","png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요","확인",JOptionPane.WARNING_MESSAGE);
				}
				else {
					//String filePath = chooser.getSelectedFile().getPath();
					filePath = chooser.getSelectedFile().getPath();
					lblPhoto.setIcon(new ImageIcon(filePath));
				}
			}
		});
		
	}
	
	//날씨, 기분 선택 초기화
	protected void todayReset() {
		cbBad.setSelected(false);
		cbVeryBad.setSelected(false);
		cbNormal.setSelected(false);
		cbGood.setSelected(false);
		cbVeryGood.setSelected(false);
		cbSunny.setSelected(false);
		cbCloud.setSelected(false);
		cbRain.setSelected(false);
		cbSnow.setSelected(false);
		cbWind.setSelected(false);
	}
	
	
	
	public static void main(String[] args) {
		new TodaySearch();
	}
}	