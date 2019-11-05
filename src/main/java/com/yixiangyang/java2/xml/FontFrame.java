//package com.yixiangyang.java2.xml;
//
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//public class FontFrame extends JFrame{
//	private GridBagPane gridbag;
//	private JComboBox face;
//	private JComboBox size;
//	private JCheckBox bold;
//	private JCheckBox italic;
//	private static final int DEFAULF_WITH = 400;
//	private static final int DEFAULF_HEIGHT = 400;
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public FontFrame(String fileName){
//		setSize(DEFAULF_WITH, DEFAULF_HEIGHT);
//		setTitle("GridBagTest");
//		gridbag = new GridBagPane(fileName);
//		add(gridbag);
//		face = (JComboBox) gridbag.get("face");
//		size = (JComboBox) gridbag.get("size");
//		bold = (JCheckBox) gridbag.get("bold");
//		italic = (JCheckBox) gridbag.get("italic");
//		face.setModel(new DefaultComboBoxModel(new Object[]{"Serif","SansSerif" }));
//		size.setModel(new DefaultComboBoxModel(new Object[]{"8","10","12","15" }));
//		ActionListener listener = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setSample();
//			}
//		};
//		face.addActionListener(listener);
//		size.addActionListener(listener);
//		bold.addActionListener(listener);
//		italic.addActionListener(listener);
//		setSample();
//	}
//	
//	public void setSample(){
//		String fontFace = (String) face.getSelectedItem();
//		int fontSize = (Integer.parseInt((String) size.getSelectedItem()));
//		JTextArea sample = (JTextArea) gridbag.get("sample");
//		int fontStyle  = (bold.isSelected()?Font.BOLD:0) + (italic.isSelected()?Font.ITALIC:0);
//		sample.setFont(new Font(fontFace, fontStyle, fontSize));
//		sample.repaint();
//	}
//}
