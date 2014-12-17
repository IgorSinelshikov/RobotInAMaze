/**
 * ViewerFactory
 */
package com.rsreu.igor_sinelshikov.maze.view;

import com.rsreu.igor_sinelshikov.maze.view.swing.SwingViewer;

/**
 * ����� ����������� ������� ������������� ����������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public abstract class ViewerFactory {
	/** ��������� � ������������ ���� �������������. */
	private static final String ILLEGAL_VIEWER_TYPE_MESSAGE = "Specified viewer type is undefined";

	/**
	 * ���������� ������������� ������������� ����.
	 * 
	 * @param type ��� �������������
	 * @return ������������� ������������� ����
	 */
	public static Viewer getInstance(ViewerType type) {
		switch (type) {
		case SWING:
			return new SwingViewer();
		default:
			throw new IllegalArgumentException(ILLEGAL_VIEWER_TYPE_MESSAGE);		
		}
	}
}
