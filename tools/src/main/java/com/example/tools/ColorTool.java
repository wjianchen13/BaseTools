package com.example.tools;

public class ColorTool {

    public static void main(String[] args) {
        int result = compositeColors(0x99E6E7E8, 0xFFFFFFFF);
        System.out.println("=================> " + String.format("#%08X", result));
    }

    private static int compositeColors(int foreground, int background) {
        float alpha = ((foreground >>> 24) & 0xff) / 255f;

        int fr = (foreground >> 16) & 0xff;
        int fg = (foreground >> 8) & 0xff;
        int fb = foreground & 0xff;

        int br = (background >> 16) & 0xff;
        int bg = (background >> 8) & 0xff;
        int bb = background & 0xff;

        int r = Math.round(fr * alpha + br * (1 - alpha));
        int g = Math.round(fg * alpha + bg * (1 - alpha));
        int b = Math.round(fb * alpha + bb * (1 - alpha));

        return 0xff000000 | (r << 16) | (g << 8) | b;
    }


}