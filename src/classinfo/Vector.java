package classinfo;


public class Vector { //
    private int x;
    private int y;
    //private 멤버 변수들

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    } //생성자


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    } //getter

    public Vector add(Vector other) {
        int sumX = this.x + other.x;
        int sumY = this.y + other.y;

        return new Vector(sumX, sumY);
    } //벡터 더하기

    public Vector subtract(Vector other) {
        int diffX = this.x - other.x;
        int diffY = this.y - other.y;

        return new Vector(diffX, diffY);
    } //빼기

    public int dot(Vector other) {
        int dotProduct = this.x * other.x + this.y * other.y;
        return dotProduct;
    } //내적(dot product)
}
