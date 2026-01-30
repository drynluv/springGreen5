package today;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TodayList extends JFrame {
	private JTable table;
	private TodayDAO dao = new TodayDAO();
	private Vector<TodayVO> vec = dao.getTodayList();
	private JTextArea txtaContent;
	
	public TodayList() {
		super("");
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 460, 238);
		getContentPane().add(pn1);
		pn1.setOpaque(false);
		pn1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 436, 228);
		pn1.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(64, 0, 0));
		table.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"날짜", "날씨", "기분", "내용"
			}
		));
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		table.setOpaque(false);
		
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(12, 706, 460, 45);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		pn4.setOpaque(false);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setOpaque(false);
		btnDelete.setForeground(new Color(64, 0, 0));
		btnDelete.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(25, 10, 83, 33);
		pn4.add(btnDelete);
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.setOpaque(false);
		btnBack.setForeground(new Color(64, 0, 0));
		btnBack.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(349, 10, 83, 33);
		pn4.add(btnBack);
		
		JButton btnAfter = new JButton("다음일기");
		btnAfter.setOpaque(false);
		btnAfter.setForeground(new Color(64, 0, 0));
		btnAfter.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnAfter.setContentAreaFilled(false);
		btnAfter.setBounds(241, 10, 83, 33);
		pn4.add(btnAfter);
		
		JButton btnBefore = new JButton("이전일기");
		btnBefore.setOpaque(false);
		btnBefore.setForeground(new Color(64, 0, 0));
		btnBefore.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnBefore.setContentAreaFilled(false);
		btnBefore.setBounds(133, 10, 83, 33);
		pn4.add(btnBefore);
		
		JLabel lblBack = new JLabel("");
		lblBack.setBounds(0, 0, 484, 761);
		//lblBack.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\0122_swing\\images\\000_00.jpg"));
		lblBack.setIcon(new ImageIcon("images/000_00.jpg"));
		getContentPane().add(lblBack);
		
		
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		for(TodayVO vo : vec) {
			dtm.addRow(new Object[] {vo.getwDate(), vo.getWeather(), vo.getFeel(), vo.getContent()});
		}
		
		table.getColumnModel().getColumn(0).setMaxWidth(110);
		table.getColumnModel().getColumn(1).setMaxWidth(110);
		table.getColumnModel().getColumn(2).setMaxWidth(110);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		table.setRowHeight(27); //테이블 높이 조절하기
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 258, 460, 243);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(12, 10, 436, 223);
		pn2.add(lblPhoto);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(12, 511, 460, 250);
		getContentPane().add(pn3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 0, 436, 167);
		pn3.add(scrollPane_1);
		
		txtaContent = new JTextArea();
		txtaContent.setForeground(new Color(64, 0, 0));
		txtaContent.setLineWrap(true);
		txtaContent.setFont(new Font("휴먼아미체", Font.BOLD, 20));
		scrollPane_1.setViewportView(txtaContent);
		
		setVisible(true);
		
	//--------------------------

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ymd = table.getValueAt(row, 0).toString();
				TodayVO vo = dao.getTodaySearch(ymd);
				
				lblPhoto.setIcon(new ImageIcon("images/"+vo.getPhoto()));
				txtaContent.setText(vo.getContent());
			}
		});
		
		//이전자료보기
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					if(row > 0) {
						String ymd = table.getValueAt(row-1, 0).toString();
						TodayVO vo = dao.getTodaySearch(ymd);
						lblPhoto.setIcon(new ImageIcon("images/"+vo.getPhoto()));
						txtaContent.setText(vo.getContent());
						
						table.setRowSelectionInterval(row-1, row-1);
				    table.scrollRectToVisible(table.getCellRect(row-1, 0, true));
					}
					else JOptionPane.showMessageDialog(null, "마지막 자료 입니다.");
				}
				else JOptionPane.showMessageDialog(null, "찾고자 하는 행을 선택해 주세요");
			}
		});
		
		//다음자료보기
		btnAfter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					if(row < table.getRowCount()-1) {
						String ymd = table.getValueAt(row+1, 0).toString();
						TodayVO vo = dao.getTodaySearch(ymd);
						lblPhoto.setIcon(new ImageIcon("images/"+vo.getPhoto()));
						txtaContent.setText(vo.getContent());
						
						table.setRowSelectionInterval(row+1, row+1);
				    table.scrollRectToVisible(table.getCellRect(row+1, 0, true));
					}
					else JOptionPane.showMessageDialog(null, "마지막 자료 입니다.");
				}
				else JOptionPane.showMessageDialog(null, "찾고자 하는 행을 선택해 주세요");
			}
		});
		
		//뒤로가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TodayTodoList();
			}
		});
		
		//삭제하기
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow();
//				if(index == -1) {
//					JOptionPane.showMessageDialog(null, "기록을 1개 이상 선택해 주세요.");
//				}
//				else {
//					int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제창", JOptionPane.YES_NO_OPTION);
//					if(res == JOptionPane.YES_OPTION) {
//						dao.setTodayDelete(vec.get(index).getIdx()); // DB에서 내용 삭제
//						vec.remove(index); // vec(목록)에서 vo 하나 삭제
//						DefaultTableModel dtm = (DefaultTableModel)table.getModel(); //J테이블에서 삭제
//						dtm.removeRow(index); //J테이블에서 삭제
//						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
//					}
//				}
				int[] indexes = table.getSelectedRows();
				if(indexes.length == 0) {
					JOptionPane.showMessageDialog(null, "기록을 1개 이상 선택해 주세요.");
				}
				else {
					int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제창", JOptionPane.YES_NO_OPTION);
					if(res == JOptionPane.YES_OPTION) {
						//for(int index : indexes) {  012
//						--i => { i -= 1; return i;} 나를 감소시키고 그 값을 남준다.
//						i-- => { int temp = i; i -= 1; return temp; } 값을 먼저 남한테 준 뒤 나는 감소된다.
						for(int i = indexes.length; --i >= 0; ) {
							int index = indexes[i];
							dao.setTodayDelete(vec.get(index).getIdx()); // DB에서 내용 삭제
							vec.remove(index); // vec(목록)에서 vo 하나 삭제
							DefaultTableModel dtm = (DefaultTableModel)table.getModel(); //J테이블에서 삭제
							dtm.removeRow(index); //J테이블에서 삭제
						}
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
					}
				}
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
			

//			table.getColumnModel().getColumn(0).setPreferredWidth(90);  // 날짜
//			table.getColumnModel().getColumn(1).setPreferredWidth(90);  // 날씨
//			table.getColumnModel().getColumn(2).setPreferredWidth(120); // 기분
//			table.getColumnModel().getColumn(3).setPreferredWidth(250); // 내용
			}
		});
		
	} //생성자 끝
	



	public static void main(String[] args) {
		new TodayList();
	}
}
