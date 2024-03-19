package com.johnny.nio.book;

import java.awt.*;
import java.io.Serializable;

public class BookMarker implements Serializable {
//    private Image i = new Image();
    private transient Image I = new Image(); // fix 2
}

//class Image{} // java.io.NotSerializableException - does not implement serializable
//class Image implements Serializable{} // fix 1
class Image {} // fix 2
