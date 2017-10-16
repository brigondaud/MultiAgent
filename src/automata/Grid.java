package automata;

import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

/**
 * Represents a (n * m) circular grid.
 * 
 * This model contains cells depicted with their position. The grid is circular,
 * meaning that the (n, m) cell can interact with the (1, 1) cell.
 * 
 * The size of the grid is fixed at the instanciation.
 * 
 * @see Cell
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class Grid {

	/**
	 * The height of the grid (n). Should be > 0.
	 */
	private int height;

	/**
	 * The width of the grid (m). Should be > 0.
	 */
	private int width;

	/**
	 * The 2D array of cells.
	 */
	private final Cell[][] cells;

	/**
	 * Grid constructor {height, width}.
	 * 
	 * @param height
	 * @param width
	 */
	public Grid(int height, int width) {
		this.setHeight(height);
		this.setWidth(width);

		// Default content of array elements is <null>.
		this.cells = new Cell[this.height][this.width];
	}

	/**
	 * Draws the grid and the cells inside.
	 * 
	 * @param gui
	 *            The graphic user interface to draw in
	 * @param cellSize
	 *            The size of a cell, in pixels
	 * @param withSquares
	 *            If true, draws a grid pattern in the GUI
	 */
	public void draw(GUISimulator gui, int cellSize, boolean withSquares) {
		if (withSquares) {
			// Draw horizontal lines
			for (int i = 0; i <= height; ++i)
				this.drawLine(gui, cellSize, i, true);

			// Draw vertical lines
			for (int j = 0; j <= width; ++j)
				this.drawLine(gui, cellSize, j, false);
		}

		this.drawCells(gui, cellSize);
	}

	/**
	 * Draws the cells.
	 * 
	 * @param gui
	 *            The graphic user interface to draw in
	 * @param cellSize
	 *            The size of a cell, in pixels
	 */
	public void drawCells(GUISimulator gui, int cellSize) {
		for (int i = 0; i < this.height; ++i) {
			for (int j = 0; j < this.width; ++j) {

				// Each cell is a square at the position (i, j)
				this.drawCell(gui, cellSize, i, j);
			}
		}
	}

	/**
	 * Draw an unique cell.
	 * 
	 * @see Grid#drawCells
	 * 
	 * @param cellSize
	 *            The size of a cell, in pixels
	 * @param i
	 *            The x-position of the cell
	 * @param j
	 *            The y-position of the cell
	 */
	private void drawCell(GUISimulator gui, int cellSize, int i, int j) {
		int xPosition = i * cellSize;
		int yPosition = j * cellSize;
		Color cellColor;

		if (i < 0 || j < 0 || i >= height || j >= width || this.cells[i][j] == null)
			cellColor = new Color(0, 0, 0, 0f); // Transparent
		else
			cellColor = this.cells[i][j].getState().getColor();

		Rectangle square = new Rectangle(xPosition, yPosition, cellColor, cellColor, cellSize);

		gui.addGraphicalElement(square);
	}

	/**
	 * Draws a line to divide the 2D grid into squares.
	 * 
	 * @see Grid#draw
	 * @param gui
	 *            The graphic user interface to draw in
	 * @param cellSize
	 *            The size of a cell, in pixels
	 * @param i
	 *            The i^th line of the grid
	 * @param horizontal
	 *            True: horizontal line; false: vertical line
	 */
	private void drawLine(GUISimulator gui, int cellSize, int i, boolean horizontal) {
		int xPosition = (horizontal) ? i * cellSize : 0;
		int yPosition = (horizontal) ? 0 : i * cellSize;

		int line0x = (horizontal) ? 2 * this.width * cellSize : 0;
		int line0y = (horizontal) ? 0 : 2 * cellSize * this.height;

		// The line is created as a thin rectangle
		Rectangle line = new Rectangle(xPosition, yPosition, Color.LIGHT_GRAY, null, line0x, line0y);

		gui.addGraphicalElement(line);
	}

	/**
	 * Height setter.
	 * 
	 * @throws IllegalArgumentException
	 * @param height
	 */
	private void setHeight(int height) {
		if (height < 1)
			throw new IllegalArgumentException("Bad size for height");

		this.height = height;
	}

	/**
	 * Width setter.
	 * 
	 * @throws IllegalArgumentException
	 * @param width
	 */
	private void setWidth(int width) {
		if (width < 1)
			throw new IllegalArgumentException("Bad size for width");

		this.width = width;
	}

	/**
	 * Height getter.
	 * 
	 * @return The vertical number of cells
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Width getter.
	 * 
	 * @return The horizontal number of cells
	 */
	public int getWidth() {
		return this.width;
	}
}
