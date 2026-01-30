package today;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TodayMain extends JFrame {
	private JTextField txtId;
	private JPasswordField txtPwd;

	@SuppressWarnings("deprecation")
	public TodayMain() {
		super("오늘일기");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 460, 140);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lbl = new JLabel("오늘의\r \n일기장");
		lbl.setBackground(Color.WHITE);
		lbl.setForeground(new Color(64, 0, 0));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("휴먼아미체", Font.BOLD, 36));
		lbl.setBounds(0, 0, 460, 153);
		pn1.add(lbl);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 160, 460, 507);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(148, 420, 123, 24);
		pn2.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setBounds(73, 420, 97, 24);
		pn2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("휴먼아미체", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(new Color(64, 0, 0));
		lblPw.setBounds(73, 454, 97, 24);
		pn2.add(lblPw);
		lblPw.setFont(new Font("휴먼아미체", Font.BOLD, 20));
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setForeground(new Color(64, 0, 0));
		btnLogin.setBackground(new Color(252, 247, 203));
		btnLogin.setFont(new Font("휴먼아미체", Font.BOLD, 20));
		btnLogin.setBounds(283, 420, 68, 59);
		pn2.add(btnLogin);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 666, 484, 85);
		getContentPane().add(pn3);
		pn3.setLayout(null);
	
		txtPwd = new JPasswordField();
		txtPwd.setBounds(148, 454, 123, 24);
		pn2.add(txtPwd);
	
		setVisible(true);
		
		txtId.setNextFocusableComponent(txtPwd);
		txtPwd.setNextFocusableComponent(btnLogin);
		btnLogin.setNextFocusableComponent(txtId);
		
		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon("images\\123.jpg"));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\springGreen5\\images\\123.jpg"));
		lblNewLabel_1.setBounds(0, 0, 484, 761);
		getContentPane().add(lblNewLabel_1);
		
		pn1.setOpaque(false);
		pn2.setOpaque(false);
		pn3.setOpaque(false);
		
		JLabel lblMent = new JLabel("오늘님 오늘도 환영합니다 :))");
		lblMent.setForeground(Color.BLACK);
		lblMent.setFont(new Font("휴먼아미체", Font.BOLD, 26));
		lblMent.setBounds(0, 0, 484, 38);
		pn3.add(lblMent);
		TodayTimer.getInstance().setLabel(lblMent); //타이머 문구에 적용
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 484, 38);
		pn3.add(lblNewLabel_2);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 255, 120)); // RGBA
		
		txtId.setText("오늘");
		txtPwd.setText("1234");
		
		// -------------------------------------------
		
		
		txtPwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean sw = loginCheck();
					if(sw) {
						dispose();
						new TodayTodoList();
					}
				}
			}
		});
		
		
		// 로그인 버튼 엔터키 입력시 수행
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean sw = loginCheck();
					if(sw) {
						dispose();
						new TodayTodoList();
					}
				}
			}
		});
		
		// 로그인 버튼 클릭시 수행
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sw = loginCheck();
				if(sw) {
					dispose();
					new TodayTodoList();
				}
			}
		});
	}
	
	// 로그인시 비밀번호를 체크한다.
	@SuppressWarnings("deprecation")
	protected boolean loginCheck() {
		boolean run = true;
		String mid = txtId.getText();
		String pwd = txtPwd.getText();
		if(!mid.equals("오늘") || !pwd.equals("1234")) {
			JOptionPane.showMessageDialog(null, "일기장 주인이 아닙니다.");
			run = false;
		}
		return run;
	}

	public static void main(String[] args) {
		
		new TodayMain();
	}
}
