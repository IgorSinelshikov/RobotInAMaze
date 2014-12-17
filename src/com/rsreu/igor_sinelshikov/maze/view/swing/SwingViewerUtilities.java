/**
 * SwingViewerUtilities
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.rsreu.igor_sinelshikov.maze.controller.Controller;

/**
 * �����-������� ��� Swing �������������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public final class SwingViewerUtilities {
	/** �������� ������ ��������� ���������. */
	private static final String GENERATE_BUTTON = "��������� ���������";
	/** �������� ������ ������ � �������. */
	private static final String DEPTH_METHOD_BUTTON = "����� � �������";
	/** �������� ������ ������ � ������. */
	private static final String BREADTH_METHOD_BUTTON = "����� � ������";
	/** �������� ������ ������ �� ������� ���������� ����������. */
	private static final String GREEDY_BEST_FIRST_METHOD_BUTTON = "����� \"������-�����\"";
	/** �������� ������ ������ ������� ������ ���. */
	private static final String UNIFORM_METHOD_BUTTON = "����� ������� ������ ���";
	/** �������� ������ �����. */
	private static final String LEFT_BUTTON = "�����";
	/** �������� ������ ������. */
	private static final String RIGHT_BUTTON = "������";
	/** �������� ������ �����. */
	private static final String UP_BUTTON = "�����";
	/** �������� ������ ����. */
	private static final String DOWN_BUTTON = "����";
	/** ��������� ���� ����������. */
	private static final String FRAME_TITLE = "����� � ���������";

	/**
	 * ����������� ������ Swing �������������.
	 */
	private SwingViewerUtilities() {
	}

	/**
	 * ������� ���� Swing �������������.
	 * 
	 * @param viewer Swing �������������
	 * @return ����� ���� ����������
	 */
	public static JFrame createFrame(final SwingViewer viewer) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle(FRAME_TITLE);
		Integer frameHeight = 0;
		Integer frameWidth = 0;	
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
		frameHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - (insets.top + insets.bottom));
		frameWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - (insets.left + insets.right));
		Dimension frameSize = new Dimension(frameWidth, frameHeight);
		frame.setSize(frameSize);
		frame.setResizable(true);
		MazePanel mazePanel = createMazePanel(viewer);
		JPanel menuPanel = createMenuPanel(viewer);
		JTextArea solverPanel = createSolverPanel(viewer); 
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(menuPanel, BorderLayout.NORTH);
		contentPane.add(mazePanel, BorderLayout.CENTER);
		contentPane.add(solverPanel, BorderLayout.SOUTH);
		viewer.setMenuPanel(menuPanel);
		viewer.setMazePanel(mazePanel);
		viewer.setSolverPanel(solverPanel);
		return frame;
	}

	/**
	 * ������� ������ ��� ����������� ���������� � ���������.
	 * 
	 * @param viewer �������������
	 * @return ������ ���������� � ���������
	 */
	private static JTextArea createSolverPanel(SwingViewer viewer) {
		JTextArea solverPanel = new JTextArea();
		solverPanel.setVisible(true);
		solverPanel.setEditable(false);
		return solverPanel;
	}

	/**
	 * ������� ������ ���� ����������.
	 * 
	 * @param viewer �������������
	 * @return ������ ����
	 */
	private static JPanel createMenuPanel(SwingViewer viewer) {
		JPanel menuPanel = new JPanel();	
		menuPanel.setVisible(true);
		addButton(menuPanel, GENERATE_BUTTON, viewer.getController());
		addButton(menuPanel, DEPTH_METHOD_BUTTON, viewer.getController());
		addButton(menuPanel, BREADTH_METHOD_BUTTON, viewer.getController());
		addButton(menuPanel, GREEDY_BEST_FIRST_METHOD_BUTTON, viewer.getController());
		addButton(menuPanel, UNIFORM_METHOD_BUTTON, viewer.getController());
		addButton(menuPanel, LEFT_BUTTON, viewer.getController());
		addButton(menuPanel, RIGHT_BUTTON, viewer.getController());
		addButton(menuPanel, UP_BUTTON, viewer.getController());
		addButton(menuPanel, DOWN_BUTTON, viewer.getController());
		return menuPanel;
	}

	/**
	 * ��������� ������ � ��������� ������.
	 * 
	 * @param panel ������, �� ������� ����� �������� ������
	 * @param title �������� ������ ��� ����������
	 * @param controller ���������� �������������
	 */
	private static void addButton(JPanel panel, String title, Controller controller) {
		JButton button = new JButton();
		button.setVisible(true);
		button.setText(title);
		button.addActionListener(new ButtonListener(controller));
		panel.add(button);
	}

	/**
	 * ������� ������ ��������� ��������������
	 * 
	 * @param viewer �������������
	 * @return ������ ���������
	 */
	private static MazePanel createMazePanel(SwingViewer viewer) {
		MazePanel mazePanel = new MazePanel();
		mazePanel.setVisible(true);
		mazePanel.setSize(600, 600);
		return mazePanel;
	}
}
