package today;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TodayList2 extends JFrame {
	private JTable table;
	private TodayDAO dao = new TodayDAO();
	private Vector<TodayVO> vec = dao.getTodayList();
	
	public TodayList2() {
		super("");
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 460, 72);
		getContentPane().add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 460, 145);
		panel.add(scrollPane);
		
		table = new JTable();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 581, 460, 170);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setOpaque(false);
		btnDelete.setForeground(new Color(64, 0, 0));
		btnDelete.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(98, 127, 83, 33);
		panel_1.add(btnDelete);
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.setOpaque(false);
		btnBack.setForeground(new Color(64, 0, 0));
		btnBack.setFont(new Font("휴먼아미체", Font.BOLD, 21));
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(279, 127, 83, 33);
		panel_1.add(btnBack);
		
		JLabel lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon("D:\\springGreen\\java\\works\\0122_swing\\images\\000_00.jpg"));
		lblBack.setBounds(0, 0, 484, 761);
		getContentPane().add(lblBack);
		
		
		
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		for(TodayVO vo : vec) {
			dtm.addRow(new Object[] {vo.getwDate(), vo.getWeather(), vo.getFeel(), vo.getContent()});
		}
		
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(dtcr);
		
		setVisible(true);
	
	//--------------------------

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
			
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
			

//			table.getColumnModel().getColumn(0).setPreferredWidth(90);  // 날짜
//			table.getColumnModel().getColumn(1).setPreferredWidth(90);  // 날씨
//			table.getColumnModel().getColumn(2).setPreferredWidth(120); // 기분
//			table.getColumnModel().getColumn(3).setPreferredWidth(250); // 내용
			}
		});
		
	} //생성자 끝
	



	public static void main(String[] args) {
		new TodayList2();
	}
}
