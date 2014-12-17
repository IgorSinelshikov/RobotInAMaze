/**
 * MazePanel
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JPanel;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;

/**
 * ������ ��������� Swing �������������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class MazePanel extends JPanel {
	/** ��������������� ID ����������. */
	private static final long serialVersionUID = 1L;
	/** ��������� � �������� ���� ������. */
	private static final String ILLEGAL_CELL_TYPE_MESSAGE = "Illegal cell type.";
	/** ����� �������� �� �����������. */
	private HashMap<Rectangle, Integer> repaintActions;

	/**
	 * ����������� ������ ������ ���������.
	 */
	public MazePanel() {
		this.repaintActions = new HashMap<Rectangle, Integer>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;	
		Maze maze = SwingViewer.getMaze();	
		if (maze != null) {
			if (maze.getField() != null) {
				for (Entry<Rectangle, Integer> action:repaintActions.entrySet()) {
					Integer pointType = action.getValue();	
					Rectangle rect = action.getKey();
					switch (pointType) {
					case 0:	
						g2.setColor(Color.BLACK);
						g2.fill(rect);
						g2.draw(rect);
						break;
					case 1:
						g2.setColor(Color.WHITE);
						g2.fill(rect);
						g2.draw(rect);
						break;
					case 2:
						g2.setColor(Color.YELLOW);
						g2.fill(rect);
						g2.draw(rect);
						break;
					case 3:
						g2.setColor(Color.RED);
						g2.fill(rect);
						g2.draw(rect);
						break;
					case 4:
						g2.setColor(Color.GREEN);
						g2.fill(rect);
						g2.draw(rect);
						break;
					case 5:
						g2.setColor(Color.BLACK);
						g2.fill(rect);
						g2.draw(rect);
						break;
					default:
						throw new IllegalArgumentException(ILLEGAL_CELL_TYPE_MESSAGE);
					}
				}
				repaintActions.clear();
				g2.dispose();
			}
		}
	}

	/**
	 *  ���������� ����� �������� �� �����������.
	 * 
	 * @return ����� �������� �� �����������
	 */
	public HashMap<Rectangle, Integer> getRepaintActions() {
		return this.repaintActions;
	}
}
