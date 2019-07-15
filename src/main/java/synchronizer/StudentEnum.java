package synchronizer;

public enum StudentEnum {

    //创建七个学生，用于CountDownLatch模拟
    one(1, "张"),
    two(2, "李"),
    three(3, "赵"),
    four(4, "钱"),
    five(5, "林"),
    six(6, "周"),
    seven(7, "安");

    private int num;
    private String name;

    StudentEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    //枚举是单例模式的，所以这里的构造函数要私有化
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
    //提供一个方法，根据num遍历查找到student
    public static StudentEnum getByNum(int index) {
        StudentEnum[] studentEnums = StudentEnum.values();
        for (StudentEnum student : studentEnums
        ) {
            if (student.getNum() == index) {
                return student;
            }
        }
        return null;

    }


}
