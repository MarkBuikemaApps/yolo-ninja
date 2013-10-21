package com.marktim.kutspel2.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GLGameView extends GLSurfaceView {

	public GLGameView(Context context) {
		super(context);
		this.setKeepScreenOn(true);
	}
}
