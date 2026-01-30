package today;

//import java.awt.Component;
//import javax.swing.DefaultListCellRenderer;
//import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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

@SuppressWarnings({"serial", "static-access", "rawtypes", "unchecked", "unused"})
public class TodayInput2 extends JFrame {
	private JComboBox comboYear, comboMonth, comboDay;
	private JTextArea txtaContent;
	private JCheckBox cbSunny, cbCloud, cbRain, cbWind, cbSnow;
	private JCheckBox cbVeryGood, cbGood, cbNormal, cbBad, cbVeryBad;
	
	private String filePath = "";
	TodayDAO dao = new TodayDAO();
	TodayVO vo = null;
	String ymd = LocalDate.now().toString();
	
	public TodayInput2() {
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
		lblNewLabel_1_1.setBounds(12, 48, 39, 34);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("기분");
		lblNewLabel_1_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_2.setBounds(12, 85, 39, 34);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("내용");
		lblNewLabel_1_3.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_3.setBounds(12, 121, 39, 34);
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

		
		comboMonth = new JComboBox(mm);
		comboMonth.setBounds(186, 10, 77, 30);
		pn1.add(comboMonth);
		
		comboDay = new JComboBox(dd);
		comboDay.setBounds(305, 10, 77, 30);
		pn1.add(comboDay);
		
//		setComboTransparent(comboYear);
//		setComboTransparent(comboMonth);
//		setComboTransparent(comboDay);
		
		JLabel lblNewLabel_1_4 = new JLabel("년");
		lblNewLabel_1_4.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4.setBounds(139, 10, 39, 34);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("월");
		lblNewLabel_1_4_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4_1.setBounds(259, 10, 39, 34);
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("일");
		lblNewLabel_1_4_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_1_4_2.setBounds(378, 10, 39, 34);
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		pn1.add(lblNewLabel_1_4_2);
		
		cbSunny = new JCheckBox("맑음");
		cbSunny.setSelected(true);
		cbSunny.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSunny.setForeground(new Color(64, 0, 0));
		cbSunny.setBounds(65, 48, 55, 30);
		pn1.add(cbSunny);
		
		cbCloud = new JCheckBox("흐림");
		cbCloud.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbCloud.setForeground(new Color(64, 0, 0));
		cbCloud.setBounds(126, 48, 55, 30);
		pn1.add(cbCloud);
		
		cbSnow = new JCheckBox("눈");
		cbSnow.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbSnow.setForeground(new Color(64, 0, 0));
		cbSnow.setBounds(187, 48, 55, 30);
		pn1.add(cbSnow);
		
		cbRain = new JCheckBox("비");
		cbRain.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbRain.setForeground(new Color(64, 0, 0));
		cbRain.setBounds(248, 48, 55, 30);
		pn1.add(cbRain);
		
		cbWind = new JCheckBox("바람");
		cbWind.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbWind.setForeground(new Color(64, 0, 0));
		cbWind.setBounds(309, 48, 55, 30);
		pn1.add(cbWind);
		
		cbVeryGood = new JCheckBox("매우 좋음");
		cbVeryGood.setSelected(true);
		cbVeryGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryGood.setForeground(new Color(64, 0, 0));
		cbVeryGood.setBounds(65, 85, 88, 30);
		pn1.add(cbVeryGood);
		
		cbGood = new JCheckBox("좋음");
		cbGood.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbGood.setForeground(new Color(64, 0, 0));
		cbGood.setBounds(157, 85, 55, 30);
		pn1.add(cbGood);
		
		cbNormal = new JCheckBox("보통");
		cbNormal.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbNormal.setForeground(new Color(64, 0, 0));
		cbNormal.setBounds(218, 85, 55, 30);
		pn1.add(cbNormal);
		
		cbBad = new JCheckBox("나쁨");
		cbBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbBad.setForeground(new Color(64, 0, 0));
		cbBad.setBounds(279, 85, 55, 30);
		pn1.add(cbBad);
		
		cbVeryBad = new JCheckBox("매우 나쁨");
		cbVeryBad.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		cbVeryBad.setForeground(new Color(64, 0, 0));
		cbVeryBad.setBounds(340, 85, 90, 30);
		pn1.add(cbVeryBad);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 408, 460, 343);
		pn0.add(pn2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 385, 210);
		pn1.add(scrollPane);
		
		txtaContent = new JTextArea();
		txtaContent.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		scrollPane.setViewportView(txtaContent);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 484, 761);
		lblBackground.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\0122_swing\\images\\000_00.jpg"));
		pn0.add(lblBackground);
		
		pn1.setOpaque(false);
		pn2.setOpaque(false);
//		comboYear.setOpaque(false);
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
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(12, 10, 436, 273);
		pn2.add(lblPhoto);
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.setBounds(316, 300, 83, 33);
		pn2.add(btnBack);
		btnBack.setForeground(new Color(64, 0, 0));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnBack.setContentAreaFilled(false);
		
		
		JButton btnPhoto = new JButton("사진추가");
		btnPhoto.setBounds(60, 300, 83, 33);
		pn2.add(btnPhoto);
		btnPhoto.setForeground(new Color(64, 0, 0));
		btnPhoto.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnPhoto.setOpaque(false);
		btnPhoto.setContentAreaFilled(false); // 배경 제거 (핵심)
		btnPhoto.setBorderPainted(false);     // 테두리 제거
		btnPhoto.setFocusPainted(false);      // 포커스 테두리 제거
		
		JButton btnSave = new JButton("저장");
		btnSave.setBounds(188, 300, 68, 33);
		pn2.add(btnSave);
		btnSave.setForeground(new Color(64, 0, 0));
		btnSave.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false); // 배경 제거 (핵심)
		
		//내용 저장
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//0.날짜
				//String wDate = comboYear.getSelectedItem().toString() + "-" + comboMonth.getSelectedItem().toString() + "-" + comboDay.getSelectedItem().toString();
				String mm = comboMonth.getSelectedItem().toString();
				String dd = comboDay.getSelectedItem().toString();
				if(mm.length() == 1) mm = "0" + comboMonth.getSelectedItem().toString();
				if(dd.length() == 1) dd = "0" + comboDay.getSelectedItem().toString();
				String wDate = comboYear.getSelectedItem()+"-"+ mm +"-"+ dd;
				
				// 오늘날짜가 아니면 이미 등록된 일기장인지 확인후 등록되어 있는 일기장은 다시 재등록할수 없도록 처리한다.
				if(!ymd.equals(wDate)) {
					vo = dao.getTodaySearch(wDate);
					if(vo.getwDate() != null) {
						JOptionPane.showMessageDialog(null, "이미 등록된 날짜 입니다. 날짜를 변경해 주세요.");
						return;
					}
				}
				
				String weather = "";
				String feel = "";
				String content = txtaContent.getText().trim();
				String photo = "noimage.jpg";
				if(!filePath.equals("")) photo = filePath.substring(filePath.lastIndexOf("\\")+1);
				
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
					return;
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
					return;
				}
				
				// 내용 입력 하지 않을 시 오류
				if(content.equals("") ) {
					JOptionPane.showInternalMessageDialog(null, "내용을 입력하세요.");
					txtaContent.requestFocus();
					return;
				}
				
				// 내용 저장하기
				TodayVO vo = new TodayVO();
				vo.setwDate(wDate);
				vo.setWeather(weather);
				vo.setFeel(feel);
				vo.setContent(content);
				vo.setPhoto(photo);
				
				// 오늘날짜가 아니면 입력처리하고, 오늘날짜의 일기장은 업데이트 처리한다.
				int res = 0;
				if(!ymd.equals(wDate)) {
					res = dao.setTodayInput(vo);
					if(res != 0) JOptionPane.showMessageDialog(null, "저장 완료!");
					else JOptionPane.showMessageDialog(null, "저장 실패!");
				}
				else {
					int ans = JOptionPane.showConfirmDialog(null, "오늘 작성하신 일기장을 새롭게 수정 저장합니다.\n\n기존 내용들은 삭제처리됩니다. 작업을 계속 처리할까?", "일기장 업데이트 확인창", JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setTodayUpdate(vo);
						if(res != 0) JOptionPane.showMessageDialog(null, "오늘 일기장을 업데이트 했습니다.");
						else JOptionPane.showMessageDialog(null, "오늘 일기장 업데이트에 실패 했습니다.");
					}
					else JOptionPane.showMessageDialog(null, "지금 작성내용을 오늘 일기장에 업데이트 하지 않았습니다.");
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
		
//------------------------------------	
		
		//뒤로가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.connClose();
				dispose();
				new TodayTodoList();
			}
		});
		scrollPane.setOpaque(false);
		txtaContent.setOpaque(false);
//		btnSave.setBorderPainted(false);     // 테두리 제거
//		btnSave.setFocusPainted(false);      // 포커스 테두리 제거
		
		//배경 맨 밑에 배치(gpt)
		ImageIcon bg = new ImageIcon("C:\\Users\\green\\Downloads\\789.jpg");
		
		// 윈도우 종료버튼 비활성화처리
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setVisible(true);
	
		// 입력창 진입시에 오늘 작성된 일기장이 있는지 확인하고 오늘 기존에 작성된 일기장이 있다면 화면에 띄워준다.
		vo = dao.getTodaySearch(ymd);
		if(vo.getwDate() != null) {
			int ans = JOptionPane.showConfirmDialog(null, "오늘 작성하신 일기장이 있습니다. 가져올까요?", "일기장 확인창", JOptionPane.YES_NO_OPTION);
			if(ans == 0) {
				String[] ymds = ymd.split("-");
				comboYear.setSelectedItem(ymds[0]);
				comboMonth.setSelectedItem(ymds[1]);
				comboDay.setSelectedItem(ymds[2]);
				
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
			
	}
//	public static void main(String[] args) {
//		new TodayInput();
//	}


//private void setComboTransparent(JComboBox combo) {
//  combo.setOpaque(false);
//  combo.setBackground(new Color(0, 0, 0, 0));
//  combo.setForeground(Color.WHITE);
//  combo.setBorder(null); // 너 지금 null 쓰고 있어서 맞춤
//
//  combo.setRenderer(new DefaultListCellRenderer() {
//      @Override
//      public Component getListCellRendererComponent(
//              JList list, Object value, int index,
//              boolean isSelected, boolean cellHasFocus) {
//
//          JLabel lbl = (JLabel) super.getListCellRendererComponent(
//                  list, value, index, isSelected, cellHasFocus);
//
//          // ⭐ 숫자 안 깨지는 핵심
//          lbl.setOpaque(true);
//
//          if (isSelected) {
//              lbl.setBackground(new Color(255, 255, 255, 80)); // 선택시 반투명
//          } else {
//              lbl.setBackground(new Color(0, 0, 0, 0));        // 기본 투명
//          }
//
//          lbl.setForeground(Color.WHITE);
//          lbl.setFont(combo.getFont());
//          return lbl;
//      }
//  });
//}

}	