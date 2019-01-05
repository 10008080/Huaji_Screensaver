package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

@SuppressWarnings("unused")
public class MyFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyPanel panel;
	public static final int width=1366;
	public static final int height=768;

	//����ͼƬ+++++add 2018-12-04
	ImageIcon Background;
	JLabel BackgroundLabel;
	
	public MyFrame(int x,int y,ArrayList<ball> b)
	{
		//���ñ���ͼƬ
//		Background=new ImageIcon("demo/Husky.jpg");
		Background=new ImageIcon("demo/src/demo/Husky.jpg");
		BackgroundLabel=new JLabel(Background);
		BackgroundLabel.setLayout(null);
		BackgroundLabel.setBounds(0, 0, Background.getIconWidth(),Background.getIconHeight());
		JLayeredPane BackgroundLayeredPane=this.getLayeredPane();
		BackgroundLayeredPane.add(BackgroundLabel);
		BackgroundLayeredPane.setLayer(BackgroundLabel,-1000);
		
		
//		this.setBackground(Color.green);
		this.setUndecorated(true);
		
		try 
		{
			this.setBounds(x, y, width, height);
			panel=new MyPanel(b);
			this.add(panel);
			panel.setLocation(0, 0);
			this.setVisible(true);
//			this.setOpacity(1000);
			this.setResizable(false);
			this.setLocation(0, 0);
//			this.setLocationRelativeTo(null);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);			
		} 
		catch (Exception e) 
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�����û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ���
		
//		this.getContentPane().setBackground(Color.green);
		this.getContentPane().add(BackgroundLabel);
//		this.getContentPane().setVisible(false);
		//ע1��ContentPane��LayeredPane�ϣ��ؼ�Ĭ�ϼ�����ContentPane��
		//ע2���ؼ������˳������ʾ����ڵ�
		//ע3��JFrame���Զ�����Ĭ�ϵ�ContentPane��LayerPane
		//ע4���������������Լ�д��͸��chessPanel�ؼ�setΪContentPane
		
		this.addMouseListener(panel);
		this.addMouseMotionListener(panel);
	}

}
