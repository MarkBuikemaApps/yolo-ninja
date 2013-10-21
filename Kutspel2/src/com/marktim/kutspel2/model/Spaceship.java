package com.marktim.kutspel2.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class Spaceship {

	private static final byte COLOR_MAX = (byte) 255;
	private static final byte COLOR_MIN = 0;

	private FloatBuffer vertexBuffer;
	private ByteBuffer colorBuffer;
	private ByteBuffer indexBuffer;

	public Spaceship() {
		float[] vertices = {
			-1f, -1f,
			1f, -1f,
			-1f, 1f,
			1f, 1f
		};

		byte[] colors = {
			COLOR_MIN, COLOR_MAX, COLOR_MIN, COLOR_MAX,
			COLOR_MIN, COLOR_MAX, COLOR_MAX, COLOR_MAX,
			COLOR_MAX, COLOR_MIN, COLOR_MAX, COLOR_MAX,
			COLOR_MAX, COLOR_MAX, COLOR_MIN, COLOR_MAX
		};

		byte[] indices = {
			0, 3, 1,
			0, 2, 3
		};

		ByteBuffer bbuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bbuff.order(ByteOrder.nativeOrder());
		vertexBuffer = bbuff.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);

		colorBuffer = ByteBuffer.allocateDirect(colors.length);
		colorBuffer.put(colors);
		colorBuffer.position(0);

		indexBuffer = ByteBuffer.allocateDirect(indices.length);
		indexBuffer.put(indices);
		indexBuffer.position(0);

	}

	public void draw(GL10 gl) {
		gl.glFrontFace(GL11.GL_CW);
		gl.glVertexPointer(2, GL11.GL_FLOAT, 0, vertexBuffer);
		gl.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 0, colorBuffer);
		gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, indexBuffer);
		gl.glFrontFace(GL11.GL_CCW);
	}

}
