package today;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TodayTodoList extends JFrame {
	
	public TodayTodoList() {
		super("수고했어 오늘도");
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 116, 460, 547);
		getContentPane().add(pn2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 662, 484, 89);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMent = new JLabel("오늘님 오늘도 환영합니다 :))");
		lblMent.setForeground(new Color(0, 0, 0));
		lblMent.setFont(new Font("휴먼아미체", Font.BOLD, 26));
		lblMent.setBounds(0, 0, 484, 38);
		pn3.add(lblMent);
		TodayTimer.getInstance().setLabel(lblMent); //타이머 문구에 적용
		
		JLabel lbl = new JLabel("오늘하루");
		lbl.setForeground(new Color(86, 57, 3));
		lbl.setBounds(340, 10, 132, 122);
		getContentPane().add(lbl);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("휴먼아미체", Font.BOLD, 33));
		pn2.setOpaque(false);
		pn2.setLayout(null);
		
		JButton btnInput = new JButton("작성");
		btnInput.setBackground(new Color(252, 247, 203));
		btnInput.setForeground(new Color(86, 57, 3));
		btnInput.setBounds(346, 10, 89, 35);
		btnInput.setFont(new Font("휴먼아미체", Font.BOLD, 22));
		pn2.add(btnInput);
		
		JButton btnSearch = new JButton("개별조회");
		btnSearch.setBackground(new Color(252, 247, 203));
		btnSearch.setForeground(new Color(86, 57, 3));
		btnSearch.setBounds(346, 65, 89, 35);
		btnSearch.setFont(new Font("휴먼아미체", Font.BOLD, 22));
		pn2.add(btnSearch);
		
		JButton btnExit = new JButton("종료");
		btnExit.setForeground(new Color(86, 57, 3));
		btnExit.setFont(new Font("휴먼아미체", Font.BOLD, 22));
		btnExit.setBackground(new Color(252, 247, 203));
		btnExit.setBounds(346, 190, 89, 35);
		pn2.add(btnExit);
		
		JButton btnList = new JButton("전체조회");
		btnList.setForeground(new Color(86, 57, 3));
		btnList.setFont(new Font("휴먼아미체", Font.BOLD, 22));
		btnList.setBackground(new Color(252, 247, 203));
		btnList.setBounds(346, 127, 89, 35);
		pn2.add(btnList);
		pn3.setOpaque(false);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 255, 120));
		lblNewLabel_2.setBounds(0, 0, 484, 38);
		pn3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 484, 761);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\springGreen5\\images/456.jpg"));
		//lblNewLabel_1.setIcon(new ImageIcon("images/456.jpg"));
		getContentPane().add(lblNewLabel_1);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		setVisible(true);
		
//-----------------------------------------------
		
		// 뒤로가기 버튼 클릭시 수행처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TodayMain();
			}
		});
		
		//오늘 기록 작성  
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TodayInput();				
			}
		});
		
		//오늘 기록 개별조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TodaySearch();
			}
		});
		
		//오늘 기록 전체조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new TodayList();		
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new TodayTodoList();
		
	}
}
