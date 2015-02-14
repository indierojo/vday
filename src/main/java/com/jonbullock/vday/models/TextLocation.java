package com.jonbullock.vday.models;

public enum TextLocation {
    TopLeft,
    TopCenter,
    TopRight,
    CenterLeft,
    CenterCenter,
    CenterRight,
    BottomLeft,
    BottomCenter,
    BottomRight;

    public static TextLocation getFromAbbreviation(String textLocation) {
        switch (textLocation) {
            case "tl":
                return TextLocation.TopLeft;
            case "tc":
                return TextLocation.TopCenter;
            case "tr":
                return TextLocation.TopRight;
            case "cl":
                return TextLocation.CenterLeft;
            case "cc":
                return TextLocation.CenterCenter;
            case "cr":
                return TextLocation.CenterRight;
            case "bl":
                return TextLocation.BottomLeft;
            case "bc":
                return TextLocation.BottomCenter;
            case "br":
                return TextLocation.BottomRight;
            default:
                throw new IllegalArgumentException("Invalid textLocation string, it should be one of: (tl, tc, tr, cl, cc, cr, bl, bc, br)");
        }
    }
}
