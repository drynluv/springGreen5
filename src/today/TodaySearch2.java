package today;

//import java.awt.Component;
//import javax.swing.DefaultListCellRenderer;
//import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;

@SuppressWarnings({"serial", "static-access", "rawtypes", "unchecked", "unused"})
public class TodaySearch2 extends JFrame {
	private JComboBox comboYear, comboMonth, comboDay;
	private JTextArea txtaContent;
	private JCheckBox cbSunny, cbCloud, cbRain, cbWind, cbSnow;
	private JCheckBox cbVeryGood, cbGood, cbNormal, cbBad, cbVeryBad;
	private JButton btnContent, btnPhoto, btnSave, btnSearch;
	
	private String filePath;
	private JTextField txtContent;
	
	TodayDAO dao = new TodayDAO();
	
	public TodaySearch2() {
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
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 10, 39, 34);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("날씨");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(12, 131, 39, 34);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("기분");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(12, 168, 39, 34);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("내용");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBounds(12, 208, 39, 34);
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
		comboYear.setBackground(new Color(0, 0, 0, 0));
		comboYear.setBorder(null);
		
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
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBounds(134, 10, 39, 34);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("월");
		lblNewLabel_1_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4_1.setBounds(248, 10, 25, 34);
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("일");
		lblNewLabel_1_4_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4_2.setBounds(340, 10, 39, 34);
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_2);
		
		cbSunny = new JCheckBox("맑음");
		cbSunny.setSelected(true);
		cbSunny.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSunny.setForeground(new Color(255, 255, 255));
		cbSunny.setBounds(65, 131, 55, 30);
		pn1.add(cbSunny);
		
		cbCloud = new JCheckBox("흐림");
		cbCloud.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbCloud.setForeground(new Color(255, 255, 255));
		cbCloud.setBounds(126, 131, 55, 30);
		pn1.add(cbCloud);
		
		cbSnow = new JCheckBox("눈");
		cbSnow.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSnow.setForeground(new Color(255, 255, 255));
		cbSnow.setBounds(187, 131, 55, 30);
		pn1.add(cbSnow);
		
		cbRain = new JCheckBox("비");
		cbRain.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbRain.setForeground(new Color(255, 255, 255));
		cbRain.setBounds(248, 131, 55, 30);
		pn1.add(cbRain);
		
		cbWind = new JCheckBox("바람");
		cbWind.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbWind.setForeground(new Color(255, 255, 255));
		cbWind.setBounds(309, 131, 55, 30);
		pn1.add(cbWind);
		
		cbVeryGood = new JCheckBox("매우 좋음");
		cbVeryGood.setSelected(true);
		cbVeryGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryGood.setForeground(new Color(255, 255, 255));
		cbVeryGood.setBounds(65, 168, 88, 30);
		pn1.add(cbVeryGood);
		
		cbGood = new JCheckBox("좋음");
		cbGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbGood.setForeground(new Color(255, 255, 255));
		cbGood.setBounds(157, 168, 55, 30);
		pn1.add(cbGood);
		
		cbNormal = new JCheckBox("보통");
		cbNormal.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbNormal.setForeground(new Color(255, 255, 255));
		cbNormal.setBounds(218, 168, 55, 30);
		pn1.add(cbNormal);
		
		cbBad = new JCheckBox("나쁨");
		cbBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbBad.setForeground(new Color(255, 255, 255));
		cbBad.setBounds(279, 168, 55, 30);
		pn1.add(cbBad);
		
		cbVeryBad = new JCheckBox("매우 나쁨");
		cbVeryBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryBad.setForeground(new Color(255, 255, 255));
		cbVeryBad.setBounds(340, 168, 90, 30);
		pn1.add(cbVeryBad);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 408, 460, 343);
		pn0.add(pn2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 211, 385, 130);
		pn1.add(scrollPane);
		
		txtaContent = new JTextArea();
		txtaContent.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		scrollPane.setViewportView(txtaContent);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 484, 761);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\green\\Desktop\\000_1.jpg"));
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
		txtaContent.setForeground(Color.WHITE); // 배경 이미지면 가독성용
		
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		
		btnPhoto = new JButton("사진");
		btnPhoto.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnPhoto.setBounds(380, 0, 68, 33);
		pn2.add(btnPhoto);
		btnPhoto.setOpaque(false);
		btnPhoto.setContentAreaFilled(false); // 배경 제거 (핵심)
		btnPhoto.setBorderPainted(false);     // 테두리 제거
		btnPhoto.setFocusPainted(false);      // 포커스 테두리 제거
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(12, 39, 436, 294);
		pn2.add(lblPhoto);
		scrollPane.setOpaque(false);
		txtaContent.setOpaque(false);
		
		btnSave = new JButton("저장");
		btnSave.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnSave.setBounds(380, 351, 68, 33);
		pn1.add(btnSave);
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false); // 배경 제거 (핵심)
		
		btnSearch = new JButton("날짜 조회");
		btnSearch.setOpaque(false);
		btnSearch.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBounds(371, 15, 89, 24);
		pn1.add(btnSearch);
		
		JLabel lblNewLabel_2 = new JLabel("검색할 내용");
		lblNewLabel_2.setBounds(12, 44, 77, 24);
		pn1.add(lblNewLabel_2);
		
		txtContent = new JTextField();
		txtContent.setBounds(110, 44, 254, 24);
		pn1.add(txtContent);
		txtContent.setColumns(10);
		
		btnContent = new JButton("내용조회");
		btnContent.setOpaque(false);
		btnContent.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		btnContent.setContentAreaFilled(false);
		btnContent.setBounds(371, 49, 77, 24);
		pn1.add(btnContent);
//		btnSave.setBorderPainted(false);     // 테두리 제거
//		btnSave.setFocusPainted(false);      // 포커스 테두리 제거
		
		//배경 맨 밑에 배치(gpt)
		ImageIcon bg = new ImageIcon("C:\\Users\\green\\Downloads\\789.jpg");
		
	
		
		
		
		setVisible(true);
	
//------------------------------------	
	  //내용 조회
		btnContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = txtContent.getText();
				//dao.getTodaySearchContent(content);
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
		
		
		//내용 저장
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//0.날짜
				String wDate = comboYear.getSelectedItem().toString() + "-" + comboMonth.getSelectedItem().toString() + "-" + comboDay.getSelectedItem().toString();
				String weather = "";
				String feel = "";
				String content = txtaContent.getText().trim();
				String photo = filePath.substring(filePath.lastIndexOf("\\")+1);
				
				while(true) {
				//1. 날씨
					try {
						if(cbSunny.isSelected()) weather += cbSunny.getText() + "/"; 
						if(cbCloud.isSelected()) weather += cbCloud.getText() + "/";
						if(cbWind.isSelected()) weather += cbWind.getText() + "/";
						if(cbRain.isSelected()) weather += cbRain.getText() + "/";
						if(cbSnow.isSelected()) weather += cbSnow.getText() + "/";
						weather = weather.substring(0, weather.length()-1);
						
						
					} catch (StringIndexOutOfBoundsException e2) {				
						JOptionPane.showMessageDialog(null, "날씨를 1개 이상 선택하세요.");
						break;
					}
					
					//2. 기분
					try {
						if(cbVeryGood.isSelected()) feel += cbVeryGood.getText() + "/";
						if(cbGood.isSelected()) feel += cbGood.getText() + "/";
						if(cbNormal.isSelected()) feel += cbNormal.getText() + "/";
						if(cbBad.isSelected()) feel += cbBad.getText() + "/";
						if(cbVeryBad.isSelected()) feel += cbVeryBad.getText() + "/";
						feel = feel.substring(0, feel.length()-1);
						
					} catch (StringIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "기분을 1개 이상 선택하세요.");
						break;
					}
					
					// 내용 입력 하지 않을 시 오류
					if(content.equals("") ) {
						JOptionPane.showInternalMessageDialog(null, "내용을 입력하세요.");
						txtaContent.requestFocus();
						break;
					}
					
					// 내용 저장하기
					TodayVO vo = new TodayVO();
					vo.setwDate(wDate);
					vo.setWeather(weather);
					vo.setFeel(feel);
					vo.setContent(content);
					vo.setPhoto(photo);
					
					TodayDAO dao = new TodayDAO();
					
					int res = dao.setTodayInput(vo);
					
					if(res != 0) JOptionPane.showMessageDialog(null, "저장완료!");
					else JOptionPane.showMessageDialog(null, "저장실패~~");
					break;
				}
				
				
			}
		});
				
		
		//5. 사진 등록
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg","gif","png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요","경고",JOptionPane.WARNING_MESSAGE);
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
		new TodaySearch2();
	}
}	