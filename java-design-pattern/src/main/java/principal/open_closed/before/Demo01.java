package principal.open_closed.before;

/**
 * @Author tobing
 * @Date 2021/7/30 14:16
 * @Description 开闭原则
 * 一个软件实体如类，模块和函数应该对扩展开放(对提供方)，
 * 对修改关闭(对使用方)。用抽象构建框架，用实现扩展细节。
 */
public class Demo01 {
    /**
     * 每当添加一个新的图形的时候，都需要定义一个新的类，
     * 同时需要在GraphEditor中添加新的绘图方法，
     * 还需要改变drawShape的实现
     */
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphEditor graphicEditor = new GraphEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}


class GraphEditor {

    //接收Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        else if (s.m_type == 3)
            drawTriangle(s);
    }

    //绘制矩形
    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形 ");
    }

    //绘制圆形
    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形 ");
    }

    //绘制三角形
    public void drawTriangle(Shape r) {
        System.out.println(" 绘制三角形 ");
    }
}


//Shape类，基类
class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}
