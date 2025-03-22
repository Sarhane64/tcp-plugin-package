package com.sealocker.plugins.tcp;

import android.util.Log;

public class TcpSocketPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
