package designPatterns.builder;

/**
 * builder建造者模式
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-24 13:27
 */

public class BuilderPat {
    //全部设置成final，也就是说只能赋值一次，线程安全
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public BuilderPat(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        //前两个设置成final，就是说一开始就要设置值，其他的想要哪个就设置哪个
        private final int servingSize;
        private final int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        //提供几个赋值的方法
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        //最后再给个返回原来的类的方法，最后要用到这个方法，这个this就是原类构造函数里面的Builder
        public BuilderPat build() {
            return new BuilderPat(this);
        }
    }
}
