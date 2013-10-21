package com.marktim.kutspel2.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;

public class GLGameRenderer implements Renderer{

	private Context context;
	
	public GLGameRenderer(Context context) {
		this.context = context;
	}

	@Override
	public void onDrawFrame(GL10 arg0) {
		
	}

	@Override
	public void onSurfaceChanged(GL10 arg0, int arg1, int arg2) {
		
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		
	}

}
