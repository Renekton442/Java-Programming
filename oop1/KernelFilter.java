/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    public static Picture gaussian(Picture picture) {
        Picture pic = new Picture(picture);
        int width = pic.width();
        int height = pic.height();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top, bottom, right, left;
                if (i - 1 < 0)
                    top = height - 1;
                else
                    top = i - 1;

                if (j - 1 < 0)
                    left = width - 1;
                else
                    left = j - 1;

                if (i + 1 == height)
                    bottom = 0;
                else
                    bottom = i + 1;

                if (j + 1 == width)
                    right = 0;
                else
                    right = j + 1;

                Color c00 = picture.get(top, left);
                Color c01 = picture.get(top, j);
                Color c02 = picture.get(top, right);
                Color c10 = picture.get(i, left);
                Color c11 = picture.get(i, j);
                Color c12 = picture.get(i, right);
                Color c20 = picture.get(bottom, left);
                Color c21 = picture.get(bottom, j);
                Color c22 = picture.get(bottom, right);

                int r = (c00.getRed() + 2 * c01.getRed() + c02.getRed() +
                        2 * c10.getRed() + 4 * c11.getRed() + 2 * c12.getRed() +
                        c20.getRed() + 2 * c21.getRed() + c22.getRed()) / 16;
                int g = (c00.getGreen() + 2 * c01.getGreen() + c02.getGreen() +
                        2 * c10.getGreen() + 4 * c11.getGreen() + 2 * c12.getGreen() +
                        c20.getGreen() + 2 * c21.getGreen() + c22.getGreen()) / 16;
                int b = (c00.getBlue() + 2 * c01.getBlue() + c02.getBlue() +
                        2 * c10.getBlue() + 4 * c11.getBlue() + 2 * c12.getBlue() +
                        c20.getBlue() + 2 * c21.getBlue() + c22.getBlue()) / 16;
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                pic.set(i, j, color);
            }
        }
        return pic;
    }

    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top, bottom, right, left;
                if (i - 1 < 0)
                    top = height - 1;
                else
                    top = i - 1;

                if (j - 1 < 0)
                    left = width - 1;
                else
                    left = j - 1;

                if (i + 1 == height)
                    bottom = 0;
                else
                    bottom = i + 1;

                if (j + 1 == width)
                    right = 0;
                else
                    right = j + 1;

                Color c00 = picture.get(top, left);
                Color c01 = picture.get(top, j);
                Color c02 = picture.get(top, right);
                Color c10 = picture.get(i, left);
                Color c11 = picture.get(i, j);
                Color c12 = picture.get(i, right);
                Color c20 = picture.get(bottom, left);
                Color c21 = picture.get(bottom, j);
                Color c22 = picture.get(bottom, right);

                int r = Math
                        .round(-c01.getRed() - c10.getRed() + 5 * c11.getRed() - c12.getRed() - c21
                                .getRed());
                int g = Math.round(-c01.getGreen() - c10.getGreen() + 5 * c11.getGreen() - c12
                        .getGreen()
                                           - c21
                        .getGreen());
                int b = Math
                        .round(-c01.getBlue() - c10.getBlue() + 5 * c11.getBlue() - c12.getBlue()
                                       - c21
                                .getBlue());

                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                picture.set(i, j, color);
            }
        }
        return picture;
    }

    public static Picture laplacian(Picture picture) {
        int width = picture.width();
        int height = picture.height();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top, bottom, right, left;
                if (i - 1 < 0)
                    top = height - 1;
                else
                    top = i - 1;

                if (j - 1 < 0)
                    left = width - 1;
                else
                    left = j - 1;

                if (i + 1 == height)
                    bottom = 0;
                else
                    bottom = i + 1;

                if (j + 1 == width)
                    right = 0;
                else
                    right = j + 1;

                Color c00 = picture.get(top, left);
                Color c01 = picture.get(top, j);
                Color c02 = picture.get(top, right);
                Color c10 = picture.get(i, left);
                Color c11 = picture.get(i, j);
                Color c12 = picture.get(i, right);
                Color c20 = picture.get(bottom, left);
                Color c21 = picture.get(bottom, j);
                Color c22 = picture.get(bottom, right);

                int r = (-1) * c00.getRed() - c01.getRed() - c02.getRed()
                        - c10.getRed() + 8 * c11.getRed() - c12.getRed()
                        - c20.getRed() - c21.getRed() - c22.getRed();
                int g = (-1) * c00.getGreen() - c01.getGreen() - c02.getGreen()
                        - c10.getGreen() + 8 * c11.getGreen() - c12.getGreen()
                        - c20.getGreen() - c21.getGreen() - c22.getGreen();
                int b = (-1) * c00.getBlue() - c01.getBlue() - c02.getBlue()
                        - c10.getBlue() + 8 * c11.getBlue() - c12.getBlue()
                        - c20.getBlue() - c21.getBlue() - c22.getBlue();

                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                picture.set(i, j, color);
            }
        }
        return picture;
    }

    public static Picture emboss(Picture picture) {
        Picture pic = new Picture(picture);
        int width = pic.width();
        int height = pic.height();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top, bottom, right, left;
                if (i - 1 < 0)
                    top = height - 1;
                else
                    top = i - 1;

                if (j - 1 < 0)
                    left = width - 1;
                else
                    left = j - 1;

                if (i + 1 == height)
                    bottom = 0;
                else
                    bottom = i + 1;

                if (j + 1 == width)
                    right = 0;
                else
                    right = j + 1;

                Color c00 = picture.get(top, left);
                Color c01 = picture.get(top, j);
                Color c02 = picture.get(top, right);
                Color c10 = picture.get(i, left);
                Color c11 = picture.get(i, j);
                Color c12 = picture.get(i, right);
                Color c20 = picture.get(bottom, left);
                Color c21 = picture.get(bottom, j);
                Color c22 = picture.get(bottom, right);

                int r = -2 * c00.getRed() - c01.getRed() - c10.getRed() + c11.getRed() + c12
                        .getRed() + c21.getRed() + 2 * c22.getRed();
                int g = -2 * c00.getGreen() - c01.getGreen() - c10.getGreen() + c11.getGreen() + c12
                        .getGreen() + c21.getGreen() + 2 * c22.getGreen();
                int b = -2 * c00.getBlue() - c01.getBlue() - c10.getBlue() + c11.getBlue() + c12
                        .getBlue() + c21.getBlue() + 2 * c22.getBlue();
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                pic.set(i, j, color);
            }
        }
        return pic;
    }

    public static Picture motionBlur(Picture picture) {
        Picture pic = new Picture(picture);
        int width = pic.width();
        int height = pic.height();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                Color center = picture.get(i, j);
                r += center.getRed();
                g += center.getGreen();
                b += center.getBlue();
                for (int num = 1; num <= 4; num++) {
                    int diag1x, diag1y, diag2x, diag2y;
                    if (i - num < 0)
                        diag1x = height + (i - num);
                    else
                        diag1x = i - num;

                    if (j - num < 0)
                        diag1y = width + (j - num);
                    else
                        diag1y = j - num;

                    if (i + num > height - 1)
                        diag2x = i + num - height;
                    else
                        diag2x = i + num;

                    if (j + num > width - 1)
                        diag2y = j + num - width;
                    else
                        diag2y = j + num;

                    Color c1 = picture.get(diag1x, diag1y);
                    Color c2 = picture.get(diag2x, diag2y);
                    r = r + c1.getRed() + c2.getRed();
                    g = g + c1.getGreen() + c2.getGreen();
                    b = b + c1.getBlue() + c2.getBlue();
                }
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color color = new Color(r, g, b);
                pic.set(i, j, color);
            }
        }
        return pic;
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        //Picture postPic = gaussian(picture);
        //Picture postPic = sharpen(picture);
        //Picture postPic = laplacian(picture);
        //Picture postPic = emboss(picture);
        Picture postPic = motionBlur(picture);
        postPic.show();
    }
}
