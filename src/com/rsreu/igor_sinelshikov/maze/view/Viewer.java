/**
 * Viewer
 */
package com.rsreu.igor_sinelshikov.maze.view;

import com.rsreu.igor_sinelshikov.maze.controller.Controller;
import com.rsreu.igor_sinelshikov.maze.model.ModelListener;

/**
 * ����������� ����� �������������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public abstract class Viewer implements ModelListener {
	/** ���������� �������������. */
	protected Controller controller;

	/**
	 * ������������� ���������� �������������.
	 * 
	 * @param controller ��������������� ����������
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * ���������� ���������� �������������.
	 * 
	 * @return ���������� �������������
	 */
	public Controller getController() {
		return this.controller;
	}
}
