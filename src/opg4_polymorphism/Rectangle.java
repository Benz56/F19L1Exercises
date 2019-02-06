/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg4_polymorphism;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Rectangle extends AbstractShape {

    private final double l1;
    private final double l2;

    public Rectangle(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double getArea() {
        return l1 * l2;
    }

    @Override
    public double getCircumference() {
        return 2 * (l1 + l2);
    }
}
