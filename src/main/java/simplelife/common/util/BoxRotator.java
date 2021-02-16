package simplelife.common.util;

import net.minecraft.util.math.Box;

public class BoxRotator {

    public static Box rotateHorizontal(Box template, float amount) {
        //These first two are enough for orthogonal rotations
        MutableVec2d a = new MutableVec2d(template.minX, template.minZ).rotate(amount);
        MutableVec2d b = new MutableVec2d(template.maxX, template.maxZ).rotate(amount);
        //These cover odd angles
        MutableVec2d c = new MutableVec2d(template.minX, template.maxZ).rotate(amount);
        MutableVec2d d = new MutableVec2d(template.maxX, template.minZ).rotate(amount);

        double x1 = Math.min(Math.min(a.x, b.x), Math.min(c.x, d.x));
        double z1 = Math.min(Math.min(a.y, b.y), Math.min(c.y, d.y));
        double x2 = Math.max(Math.max(a.x, b.x), Math.max(c.x, d.x));
        double z2 = Math.max(Math.max(a.y, b.y), Math.max(c.y, d.y));

        return new Box(x1, template.minY, z1, x2, template.maxY, z2);
    }

    public static class MutableVec2d {
        public double x;
        public double y;

        public MutableVec2d(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /** Rotates around the Y axis at (0.5, 0, 0.5) */
        public MutableVec2d rotate(double amount) {
            amount *= Math.PI/180.0; //Convert amount to radians because it's definitely in degrees
            double tx = x-0.5;
            double ty = y-0.5;

            double theta = Math.atan2(ty, tx);
            double r = Math.sqrt(tx*tx+ty*ty);

            x = r * Math.cos(theta-amount); x+=0.5;
            y = r * Math.sin(theta-amount); y+=0.5;

            return this;
        }
    }
}
