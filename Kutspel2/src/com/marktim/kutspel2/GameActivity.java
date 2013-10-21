package com.marktim.kutspel2;

import android.app.Activity;
import android.os.Bundle;

import com.marktim.kutspel2.opengl.GLGameRenderer;
import com.marktim.kutspel2.opengl.GLGameView;

public class GameActivity extends Activity {

	private GLGameView view;
	private GLGameRenderer renderer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new GLGameView(this);
        renderer = new GLGameRenderer();
        view.setRenderer(renderer);
        
        view.setKeepScreenOn(BuildConfig.DEBUG);
        setContentView(view);
    }
    
}
